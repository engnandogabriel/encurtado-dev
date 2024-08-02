package com.encurtado_dev.domain.Exception;

public class NotFoundError extends Exception{
    private String type;
    public NotFoundError(String message) {
        super(message);
        this.type = "NotFoundError";
    }
}
