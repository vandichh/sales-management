package com.example.common.config;

import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.common.AttributeType;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.internal.InternalAttributeKeyImpl;
import io.opentelemetry.context.propagation.ContextPropagators;
import io.opentelemetry.exporter.otlp.logs.OtlpGrpcLogRecordExporter;
import io.opentelemetry.exporter.otlp.trace.OtlpGrpcSpanExporter;
import io.opentelemetry.instrumentation.logback.appender.v1_0.OpenTelemetryAppender;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.logs.LogRecordProcessor;
import io.opentelemetry.sdk.logs.SdkLoggerProvider;
import io.opentelemetry.sdk.logs.SdkLoggerProviderBuilder;
import io.opentelemetry.sdk.logs.export.BatchLogRecordProcessor;
import io.opentelemetry.sdk.resources.Resource;
import io.opentelemetry.sdk.trace.SdkTracerProvider;
import io.opentelemetry.sdk.trace.export.SimpleSpanProcessor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class OpenTelemetryConfig {
    @Value("${logging.export.endpoint}")
    public String loggingEndpoint;

    @Value("${spring.application.name}")
    public String applicationName;

    @Bean
    OpenTelemetry openTelemetry(SdkLoggerProvider sdkLoggerProvider, SdkTracerProvider sdkTracerProvider, ContextPropagators contextPropagators) {
        OpenTelemetrySdk openTelemetrySdk = OpenTelemetrySdk.builder()
                .setLoggerProvider(sdkLoggerProvider)
                .setTracerProvider(sdkTracerProvider)
                .setPropagators(contextPropagators)
                .buildAndRegisterGlobal();
        OpenTelemetryAppender.install(openTelemetrySdk);
        return openTelemetrySdk;
    }

    @Bean
    SdkLoggerProvider otelSdkLoggerProvider(Resource resource, ObjectProvider<LogRecordProcessor> logRecordProcessors) {
        SdkLoggerProviderBuilder builder = SdkLoggerProvider.builder()
                .setResource(resource);
        logRecordProcessors.orderedStream().forEach(builder::addLogRecordProcessor);
        return builder.build();
    }

    @Bean
    SdkTracerProvider sdkTracerProvider(Resource resource) {
        return SdkTracerProvider.builder()
                .addSpanProcessor(SimpleSpanProcessor.create(OtlpGrpcSpanExporter.builder()
                        .setEndpoint(loggingEndpoint)
                        .build()))
                .setResource(resource)
                .build();
    }

    @Bean
    Resource otelResource() {
        return Resource.create(Attributes.of(InternalAttributeKeyImpl
                .create("service.name", AttributeType.STRING), applicationName));
    }

    @Bean
    LogRecordProcessor otelLogRecordProcessor(Environment environment) {
        return BatchLogRecordProcessor
                .builder(
                        OtlpGrpcLogRecordExporter.builder()
                                .setEndpoint(loggingEndpoint)
                                .build())
                .build();
    }
}
