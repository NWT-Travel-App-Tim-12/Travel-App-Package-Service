package com.app.travel.util.exceptions;

public class InvalidAdditionalDataCast extends FieldNameBaseException{
    public InvalidAdditionalDataCast(String message) {
        super(message, "additional_data");
    }
}
