package com.cbfacademy.restapiexercise.core;


public class ApiErrorResponse {
    private String message;

    ApiErrorResponse() {

    }

    public ApiErrorResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
