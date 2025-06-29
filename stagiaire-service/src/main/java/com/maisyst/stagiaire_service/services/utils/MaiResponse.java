package com.maisyst.stagiaire_service.services.utils;

import org.springframework.http.HttpStatus;

public sealed class MaiResponse<T> {
    private final T data;
    private final String message;
    private final HttpStatus status;

    public MaiResponse(T data, String message,HttpStatus status) {
        this.message = message;
        this.data = data;
        this.status=status;
    }

    public T data() {
        return data;
    }

    public String message() {
        return message;
    }

    public HttpStatus status() {
        return status;
    }

    public static final class MaiError<T> extends MaiResponse<T> {
        public MaiError(String message, HttpStatus status) {
            super(null, message,status);
        }
    }
    public static final class MaiSuccess<T> extends MaiResponse<T> {
        public MaiSuccess(T data,HttpStatus status) {
            super(data, null,status);
        }
    }
}