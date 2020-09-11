package com.cur.apps.handler;

public enum ErrorCode {


    GEN_ERR_01("Can not find data");

    private String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
