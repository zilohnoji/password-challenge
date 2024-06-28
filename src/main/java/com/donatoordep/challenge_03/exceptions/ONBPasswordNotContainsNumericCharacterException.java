package com.donatoordep.challenge_03.exceptions;

public class ONBPasswordNotContainsNumericCharacterException extends RuntimeException implements SpecificationException{

    private static final long serialVersionUID = 7345699715294145769L;
    private static final String ERROR = "the password does not contain numeric character";
    private static final Integer STATUS = 400;

    public ONBPasswordNotContainsNumericCharacterException() {
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