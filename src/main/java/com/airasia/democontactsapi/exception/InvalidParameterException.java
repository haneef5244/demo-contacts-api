package com.airasia.democontactsapi.exception;

public class InvalidParameterException extends RuntimeException {

    public InvalidParameterException(String parameter) {
        super(String.format("'%s' is not a valid parameter", parameter));
    }
}
