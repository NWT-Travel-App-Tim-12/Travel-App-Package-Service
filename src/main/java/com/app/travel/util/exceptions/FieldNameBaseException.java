package com.app.travel.util.exceptions;

import lombok.Getter;

public abstract class FieldNameBaseException extends RuntimeException{
    @Getter
    private String fieldName;

    public FieldNameBaseException(String exception, String fieldName){
        super(exception);
        this.fieldName = fieldName;
    }
}
