package com.cur.apps.handler;

public enum ErrorCode {

    GEN_WIK_01("Can not connect to WIKI");

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
