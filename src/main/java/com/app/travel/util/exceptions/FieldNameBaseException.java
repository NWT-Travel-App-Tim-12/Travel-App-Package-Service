package com.app.travel.util.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

public abstract class FieldNameBaseException extends RuntimeException{
    @Getter
    private String fieldName;

    @Getter
    private HttpStatus code;

    public FieldNameBaseException(String exception, String fieldName){
        super(exception);
        this.fieldName = fieldName;
    }

    public FieldNameBaseException(String exception, String fieldName, HttpStatus code){
        super(exception);
        this.fieldName = fieldName;
        this.code = code;
    }
}
