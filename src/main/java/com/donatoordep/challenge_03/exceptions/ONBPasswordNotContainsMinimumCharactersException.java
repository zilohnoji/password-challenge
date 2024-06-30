package com.donatoordep.challenge_03.exceptions;

import com.donatoordep.challenge_03.services.validations.password.PasswordValidator;
import org.springframework.stereotype.Component;

@Component
public class ONBPasswordNotContainsMinimumCharactersException extends RuntimeException implements SpecificationException, PasswordValidator {

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

    @Override
    public void validate(String password) throws RuntimeException {
        if (password.length() < 8) {
            throw new ONBPasswordNotContainsMinimumCharactersException();
        }
    }
}