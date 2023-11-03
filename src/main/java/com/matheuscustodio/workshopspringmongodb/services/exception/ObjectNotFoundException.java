package com.matheuscustodio.workshopspringmongodb.services.exception;

public class ObjectNotFoundException extends RuntimeException{
    public ObjectNotFoundException(String message) {
        super(message);
    }
}
