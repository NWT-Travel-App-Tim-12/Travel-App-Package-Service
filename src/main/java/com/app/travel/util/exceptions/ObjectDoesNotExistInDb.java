package com.app.travel.util.exceptions;

public class ObjectDoesNotExistInDb extends FieldNameBaseException{
    public ObjectDoesNotExistInDb(String message, String className) {
        super(message, className);
    }
}
