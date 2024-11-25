package com.example.sales_application.domain.value;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatusCode;

import java.util.function.Function;

public class Either<T> {

    private final T success;

    private final Failure failure;

    private Either(T success) {
        this.success = success;
        this.failure = null;
    }

    private Either(Failure failure) {
        this.success = null;
        this.failure = failure;
    }

    public static <T> Either<T> success(T success) {
        return new Either<>(success);
    }

    public static <T> Either<T> failure(Failure failure) {
        return new Either<>(failure);
    }

    public static <T> Either<T> failure(
            HttpStatusCode httpStatusCode, String errorCode, String errorMessage) {
        return new Either<>(
                Failure.builder()
                        .httpStatusCode(httpStatusCode)
                        .errorCode(errorCode)
                        .errorMessage(errorMessage)
                        .build()
        );
    }

    public static <T> Either<T> failure(
            HttpStatusCode httpStatusCode, String errorCode, String errorMessage, Exception exception) {
        return new Either<>(
                Failure.builder()
                        .httpStatusCode(httpStatusCode)
                        .errorCode(errorCode)
                        .errorMessage(errorMessage)
                        .exception(exception)
                        .build()
        );
    }

    public boolean isSuccess() {
        return (this.failure == null);
    }

    public T success() {
        if (!this.isSuccess()) {
            throw new IllegalStateException("This Either is failure.");
        }

        return this.success;
    }

    public Failure failure() {
        if (this.isSuccess()) {
            throw new IllegalStateException("This Either is success.");
        }

        return this.failure;
    }

    public <R> Either<R> map(Function<T, R> mapper) {
        if (!this.isSuccess()) {
            return Either.failure(this.failure);
        }

        return Either.success(mapper.apply(this.success));
    }

    public String errorCode() {
        if (this.failure == null) {
            throw new IllegalStateException("This Either is success.");
        }

        return this.failure.getErrorCode();
    }

    public String errorMessage() {
        if (this.failure == null) {
            throw new IllegalStateException("This Either is success.");
        }

        return this.failure.getErrorMessage();
    }

    public Exception cause() {
        if (this.failure == null) {
            throw new IllegalStateException("This Either is success.");
        }

        return this.failure.exception;
    }

    public RuntimeException toUnexpectedException() {
        if (this.failure == null) {
            throw new IllegalStateException("This Either is success.");
        }

        return this.failure.toUnexpectedException();
    }

    @ToString
    @EqualsAndHashCode
    @Builder(access = lombok.AccessLevel.PRIVATE)
    public static class Failure {

        private final HttpStatusCode httpStatusCode;

        private final String errorCode;

        @Getter
        private final String errorMessage;

        private final Exception exception;

        public String getErrorCode() {
            if (this.errorCode == null) {
                throw this.toUnexpectedException();
            }

            return this.errorCode;
        }

        public RuntimeException toUnexpectedException() {
            return new RuntimeException("[" + this.errorCode + "]" + this.errorMessage, this.exception);
        }

    }
}
