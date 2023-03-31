package com.app.travel.util.exceptions;

public class ObjectDoesNotExistInDb extends RuntimeException{
    public ObjectDoesNotExistInDb(String message) {
        super(message);
    }
}
