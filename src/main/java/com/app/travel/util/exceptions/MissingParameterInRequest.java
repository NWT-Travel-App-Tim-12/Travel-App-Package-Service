package com.app.travel.util.exceptions;

public class MissingParameterInRequest extends FieldNameBaseException{
    public MissingParameterInRequest(String message, String fieldName) {
        super(message, fieldName);
    }
}
