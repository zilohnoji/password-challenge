package com.donatoordep.challenge_03.exceptions;

import com.donatoordep.challenge_03.services.validations.password.PasswordValidator;
import org.springframework.stereotype.Component;

@Component
public class ONBPasswordNotContainsSpecialCharactersException extends RuntimeException implements SpecificationException, PasswordValidator {

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

    @Override
    public void validate(String password) throws RuntimeException {
        if (!containSpecialChar(password)) {
            throw new ONBPasswordNotContainsSpecialCharactersException();
        }
    }
}