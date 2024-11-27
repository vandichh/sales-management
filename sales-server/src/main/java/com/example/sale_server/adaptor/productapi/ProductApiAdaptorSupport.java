package com.example.sale_server.adaptor.productapi;

import com.example.sale_server.adaptor.RestTemplateSupport;
import com.example.sale_server.config.ProductServiceApiProperties;
import com.example.sale_server.domain.value.Either;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Component
@Slf4j
public class ProductApiAdaptorSupport {
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public ProductApiAdaptorSupport(RestTemplateSupport restTemplateSupport, ProductServiceApiProperties properties, ObjectMapper objectMapper) {
        this.restTemplate = restTemplateSupport.builder()
                .rootUri(properties.baseUrl).build();
        this.objectMapper = objectMapper;
    }

    public RequestEntity.HeadersBuilder<?> initGet(String path) {
        return RequestEntity.get(path)
                .header("Authorization", "token...");
    }

    public RequestEntity.BodyBuilder initPost(URI uri) {
        return RequestEntity.post(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .header("Authorization", "token...");
    }

    public <T, U> Either<U> execute(RequestEntity<T> request, Class<U> responseClass) {
        ResponseEntity<String> response = this.restTemplate.exchange(request, String.class);
        HttpStatusCode httpStatus = response.getStatusCode();

        if (!httpStatus.is2xxSuccessful()) {
            try {
                ProductApiErrorResponse errorResponse = this.objectMapper.readValue(
                        response.getBody(), ProductApiErrorResponse.class);


                return Either.failure(httpStatus, errorResponse.errorCode, errorResponse.message);
            } catch (JsonProcessingException jsonExc) {
                log.error("Failed to parse error response from product api. response :" + response, jsonExc);
                throw new RuntimeException(jsonExc);
            }
        }

        try {
            if (response.getBody() == null) {
                return Either.success(null);
            }

            U responseBody = this.objectMapper.readValue(response.getBody(), responseClass);
            return Either.success(responseBody);
        } catch (JsonProcessingException jsonExc) {
            log.error("Failed to parse response from product api. response :" + response, jsonExc);
            throw new RuntimeException(jsonExc);
        }
    }

    @ToString
    private static class ProductApiErrorResponse {

        public String message;

        public String detail;

        public String errorCode;
    }
}
