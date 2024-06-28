package com.donatoordep.challenge_03.exceptions;

public class ONBPasswordNotContainsSpecialCharactersException extends RuntimeException implements SpecificationException {

    private static final long serialVersionUID = 332398068253486121L;
    private static final String ERROR = "the password does not contain special characters";
    private static final Integer STATUS = 400;

    public ONBPasswordNotContainsSpecialCharactersException() {
        super(ERROR);
    }

    @Override
    public Integer getStatus() {
        return STATUS;
    }

    @Override
    public String getError() {
        return ERROR;
    }
}