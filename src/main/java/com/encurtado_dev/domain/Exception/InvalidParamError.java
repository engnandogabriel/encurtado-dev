package com.encurtado_dev.domain.Exception;

public class InvalidParamError extends Exception {
    private String type;
    public InvalidParamError(String message){
        super(message);
        this.type = "InvalidParamError";
    }
}