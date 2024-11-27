package com.example.sale_server.adaptor;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.util.StreamUtils;

import java.io.*;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

@Slf4j
public class RestTemplateLoggingInterceptor implements ClientHttpRequestInterceptor {

    private static final Set<String> MASK_HEADERS = Set.of("authorization");

    private static final Set<String> MASK_PARAMETERS = Set.of();

    private static final ObjectMapper JSON_MAPPER = new ObjectMapper();

    private final int loggingMaxSize;

    public RestTemplateLoggingInterceptor(int loggingMaxSize) {
        this.loggingMaxSize = loggingMaxSize;
    }

    private static HttpHeaders maskHeaders(HttpHeaders headers) {
        if ((headers == null) || headers.isEmpty()) {
            return headers;
        }

        HttpHeaders maskedHeaders = new HttpHeaders();
        for (Map.Entry<String, List<String>> entry : headers.entrySet()) {
            String headerName = entry.getKey();
            if (MASK_HEADERS.contains(headerName.toLowerCase())) {
                maskedHeaders.add(headerName, "[**MASKED**]");
                continue;
            }

            maskedHeaders.put(headerName, entry.getValue());
        }

        return maskedHeaders;
    }

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
            throws IOException {

        if (!log.isInfoEnabled()) {
            return execution.execute(request, body);
        }

        HttpMethod httpMethod = request.getMethod();
        URI requestUri = request.getURI();

        log.info("Send request: [{} {}, headers={}, payload={}]",
                httpMethod.name(),
                requestUri,
                maskHeaders(request.getHeaders()),
                this.slimPayload(new String(body))
        );

        ClientHttpResponse baseResponse = execution.execute(request, body);
        ClientHttpResponse wrapper = new BufferingClientHttpResponseWrapper(baseResponse);

        HttpStatus status = HttpStatus.resolve(wrapper.getStatusCode().value());
        String responsePayload = this.readResponseBody(wrapper);

        log.info("Receive response: [{} {}, status={}({}), payload={}]",
                httpMethod.name(),
                requestUri,
                (status != null) ? status.value() : wrapper.getStatusCode().value(),
                (status != null) ? status.getReasonPhrase() : "????",
                (responsePayload != null) ? this.slimPayload(responsePayload) : "null"
        );

        return wrapper;
    }

    private String slimPayload(String payload) {
        String maskedPayload = this.toMaskedValue(payload);

        if (this.loggingMaxSize <= 0) {
            return maskedPayload;
        }

        if (maskedPayload.length() <= this.loggingMaxSize) {
            return maskedPayload;
        }

        return maskedPayload.substring(0, this.loggingMaxSize) + " ... }";
    }

    private String readResponseBody(ClientHttpResponse wrapper) {
        StringBuilder builder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(wrapper.getBody(), StandardCharsets.UTF_8)
        )) {
            for (String readLine = reader.readLine(); readLine != null; readLine = reader.readLine()) {
                builder.append(readLine);
            }
        } catch (IOException ioExc) {
            return null;
        }

        return builder.toString();
    }

    private String toMaskedValue(String payload) {
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

    /**
     * Same maskValues function as in BpmAccessLoggingFilter.java
     *
     * @param jsonNode JsonNode
     */
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

    private static class BufferingClientHttpResponseWrapper implements ClientHttpResponse {

        private final ClientHttpResponse response;

        private byte[] body;

        BufferingClientHttpResponseWrapper(ClientHttpResponse response) {
            this.response = response;
        }

        @Override
        public HttpStatusCode getStatusCode() throws IOException {
            return this.response.getStatusCode();
        }

        @Override
        public String getStatusText() throws IOException {
            return this.response.getStatusText();
        }

        @Override
        public HttpHeaders getHeaders() {
            return this.response.getHeaders();
        }

        @Override
        public InputStream getBody() throws IOException {
            if (this.body == null) {
                this.body = StreamUtils.copyToByteArray(this.response.getBody());
            }

            return new ByteArrayInputStream(this.body);
        }

        @Override
        public void close() {
            this.response.close();
        }

        @Override
        public String toString() {
            return this.response.toString();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            BufferingClientHttpResponseWrapper that = (BufferingClientHttpResponseWrapper) o;
            return Objects.equals(response, that.response);
        }

        @Override
        public int hashCode() {
            return Objects.hash(response);
        }
    }
}
