package com.donatoordep.challenge_03.exceptions;

public class ONBPasswordNotContainsMinimumCharactersException extends RuntimeException implements SpecificationException {

    private static final long serialVersionUID = 4177183134776875425L;
    private static final String ERROR = "the password does not contain a minimum of 8 characters";
    private static final Integer STATUS = 404;

    public ONBPasswordNotContainsMinimumCharactersException() {
        super(ERROR);
    }

    public Integer getStatus() {
        return STATUS;
    }

    public String getError() {
        return ERROR;
    }
}