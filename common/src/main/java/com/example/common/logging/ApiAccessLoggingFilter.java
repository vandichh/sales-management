package com.example.common.logging;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ReadListener;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.AbstractRequestLoggingFilter;
import org.springframework.web.util.ContentCachingResponseWrapper;
import org.springframework.web.util.WebUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Set;

@Slf4j
public class ApiAccessLoggingFilter extends AbstractRequestLoggingFilter {

    private static final Set<String> MASK_HEADERS = Set.of("authorization");
    private static final Set<String> MASK_PARAMETERS = Set.of();

    private static final ObjectMapper JSON_MAPPER = new ObjectMapper();

    public ApiAccessLoggingFilter() {
        this.setBeforeMessagePrefix("Request [");
        this.setIncludeClientInfo(true);
        this.setIncludeQueryString(true);
        this.setIncludeHeaders(true);
        this.setIncludePayload(true);
        this.setHeaderPredicate(header -> (!MASK_HEADERS.contains(header)));
    }

    @Override
    protected boolean shouldLog(HttpServletRequest request) {
        String url = request.getRequestURI();
        if (url == null) {
            return false;
        }

        if (url.startsWith("/actuator")) {
            return false;
        }

        return log.isInfoEnabled();
    }

    @Override
    protected void beforeRequest(HttpServletRequest request, String message) {
        log.info(message);
    }

    @Override
    protected void afterRequest(HttpServletRequest request, String message) {
        // Do nothing
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        long startTime = System.currentTimeMillis();

        boolean isFirstRequest = !isAsyncDispatch(request);
        if ((!isFirstRequest) || (!this.shouldLog(request))) {
            filterChain.doFilter(request, response);
            return;
        }

        HttpServletRequest requestToUse = request;
        String contentType = request.getContentType();
        if ((this.isIncludePayload()) && (contentType != null)
            && (contentType.toLowerCase().contains("application/json"))) {
            byte[] body = request.getInputStream().readAllBytes();
            requestToUse = new CachedHttpServletRequestWrapper(request, body);
        }

        ContentCachingResponseWrapper responseToUse = new ContentCachingResponseWrapper(response);
        try {
            String message = this.createMessage(requestToUse, "Request [", "]");
            this.beforeRequest(requestToUse, message);

            filterChain.doFilter(requestToUse, responseToUse);
        } finally {
            try {
                this.completeResponse(requestToUse, responseToUse, startTime);
            } finally {
                responseToUse.copyBodyToResponse();
            }
        }
    }

    protected void completeResponse(HttpServletRequest request, HttpServletResponse response, long startTime) {
        long duration = System.currentTimeMillis() - startTime;
        String message = this.initCompleteMessage(request, response, duration);
        log.info(message);
    }

    protected String initCompleteMessage(HttpServletRequest request, HttpServletResponse response, long duration) {
        StringBuilder msg = new StringBuilder();
        msg.append("Response [");
        msg.append(request.getMethod()).append(' ').append(request.getRequestURI());

        msg.append(", status=").append(response.getStatus());

        if (this.isIncludePayload()) {
            String payload = this.initResponseMessagePayload(response);
            if (payload != null) {
                msg.append(", payload=").append(payload);
            }
        }

        msg.append(", duration=").append(duration).append("ms");
        msg.append("]");
        return msg.toString();
    }

    @Override
    protected String getMessagePayload(HttpServletRequest request) {
        if (!(request instanceof CachedHttpServletRequestWrapper wrapper)) {
            return "[**NOT SUPPORT**]";
        }

        if (wrapper.body.length == 0) {
            return null;
        }

        String payload = this.toMaskedValue(wrapper.body);
        return StringUtils.hasText(payload) ? payload : null;
    }

    protected String initResponseMessagePayload(HttpServletResponse response) {
        ContentCachingResponseWrapper wrapper = WebUtils.getNativeResponse(
                response, ContentCachingResponseWrapper.class);
        if (wrapper == null) {
            return null;
        }

        byte[] buf = wrapper.getContentAsByteArray();
        String payload = this.toMaskedValue(buf);

        return StringUtils.hasText(payload) ? payload : null;
    }

    private String toMaskedValue(byte[] buf) {
        String payload = new String(buf, StandardCharsets.UTF_8);

        JsonNode jsonNode;
        try {
            jsonNode = JSON_MAPPER.readTree(payload);
        } catch (IOException ioExc) {
            log.debug("Failed to parse body to json. {}", ioExc.getMessage());
            return payload;
        }

        this.maskValues(jsonNode);

        String maskedPayload;
        try {
            maskedPayload = JSON_MAPPER.writeValueAsString(jsonNode);
        } catch (JsonProcessingException jsonExc) {
            log.debug("Failed to decode json. {}", jsonExc.getMessage());
            return payload;
        }

        return maskedPayload;
    }

    private void maskValues(JsonNode jsonNode) {
        if (!jsonNode.isObject()) {
            return;
        }

        jsonNode.fields().forEachRemaining(entry -> {
            String parameterName = entry.getKey();
            if (MASK_PARAMETERS.contains(parameterName)) {
                // `jsonNode.isObject() == true` が成り立っているので、以下のキャストは成功する
                ((ObjectNode) jsonNode).put(parameterName, "[**MASKED**]");
                return;
            }

            JsonNode subNode = entry.getValue();
            if (subNode.isObject()) {
                this.maskValues(subNode);
            }
            if (subNode.isArray()) {
                subNode.elements().forEachRemaining(this::maskValues);
            }
        });
    }

    private static class CachedHttpServletRequestWrapper extends HttpServletRequestWrapper {

        private final byte[] body;

        CachedHttpServletRequestWrapper(HttpServletRequest request, byte[] body) {
            super(request);
            this.body = body;
        }

        @Override
        public ServletInputStream getInputStream() {
            return new CachedServletInputStream(this.body);
        }

        @Override
        public BufferedReader getReader() throws IOException {
            return new BufferedReader(new InputStreamReader(this.getInputStream(), this.getCharacterEncoding()));
        }
    }

    private static class CachedServletInputStream extends ServletInputStream {

        private final byte[] body;

        private int cursor;

        private CachedServletInputStream(byte[] body) {
            this.body = body;
            this.cursor = 0;
        }

        @Override
        public boolean isFinished() {
            return (this.body.length <= this.cursor);
        }

        @Override
        public boolean isReady() {
            return true;
        }

        @Override
        public void setReadListener(ReadListener listener) {
            // Do nothing.
        }

        @Override
        public int read() {
            if (this.isFinished()) {
                return -1;
            }

            return this.body[this.cursor++] & 0xFF;
        }
    }
}
