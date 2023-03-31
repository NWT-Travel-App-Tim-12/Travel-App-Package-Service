package com.app.travel.util.exceptions;

public class MissingParameterInRequest extends RuntimeException{
    public MissingParameterInRequest(String message) {
        super(message);
    }
}
