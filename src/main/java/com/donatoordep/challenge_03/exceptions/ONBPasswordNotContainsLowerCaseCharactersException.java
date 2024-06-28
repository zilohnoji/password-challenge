package com.donatoordep.challenge_03.exceptions;

public class ONBPasswordNotContainsLowerCaseCharactersException extends RuntimeException implements SpecificationException{

    private static final long serialVersionUID = -4103657582788331304L;
    private static final String ERROR = "the password does not contain lower case characters";
    private static final Integer STATUS = 400;

    public ONBPasswordNotContainsLowerCaseCharactersException() {
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