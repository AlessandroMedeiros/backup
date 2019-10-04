package com.all.locadora.service.exceptions;

public class DataException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public DataException(String msg) {
        super(msg);
    }

    public DataException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
