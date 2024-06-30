package com.donatoordep.challenge_03.exceptions;

import com.donatoordep.challenge_03.services.validations.password.PasswordValidator;
import org.springframework.stereotype.Component;

@Component
public class ONBPasswordNotContainsNumericCharacterException extends RuntimeException implements SpecificationException, PasswordValidator {

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

    @Override
    public void validate(String password) throws RuntimeException {
        if (!containNumericChar(password)) {
            throw new ONBPasswordNotContainsNumericCharacterException();
        }
    }
}