package com.example.ramenApplication.controller.response;

public class RamenCreateResponse {

    private final String message;

    public RamenCreateResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
