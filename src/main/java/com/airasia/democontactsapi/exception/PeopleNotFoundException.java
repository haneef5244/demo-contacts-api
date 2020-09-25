package com.airasia.democontactsapi.exception;

public class PeopleNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;


    public PeopleNotFoundException(String id) {
        super(String.format("People ID '%s' not found", id));
    }

    public PeopleNotFoundException() {
        super("People not found");
    }
}
