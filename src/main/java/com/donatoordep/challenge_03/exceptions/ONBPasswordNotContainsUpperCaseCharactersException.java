package com.donatoordep.challenge_03.exceptions;

public class ONBPasswordNotContainsUpperCaseCharactersException extends RuntimeException implements SpecificationException {

    private static final long serialVersionUID = -5796161444883837156L;
    private static final String ERROR = "the password does not contain upper case characters";
    private static final Integer STATUS = 400;

    public ONBPasswordNotContainsUpperCaseCharactersException() {
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