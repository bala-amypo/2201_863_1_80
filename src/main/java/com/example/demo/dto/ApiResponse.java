package com.example.demo.dto;

public class ApiResponse {

    private boolean success;
    private String message;
    private Object data;

    public ApiResponse() {}

    // 🔴 REQUIRED BY TESTS
    public ApiResponse(boolean success, String message, Object data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    // 🔴 REQUIRED BY TESTS
    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    // 🔴 REQUIRED BY TESTS
    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    // 🔴 REQUIRED BY TESTS
    public void setData(Object data) {
        this.data = data;
    }
}
