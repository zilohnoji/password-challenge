package com.donatoordep.challenge_03.services.validations.password.aspects;

import com.donatoordep.challenge_03.dto.PasswordRegisterRequestDTO;
import com.donatoordep.challenge_03.exceptions.*;
import com.donatoordep.challenge_03.services.validations.password.PointcutDefinitions;
import com.donatoordep.challenge_03.services.validations.password.annotations.RegisterPasswordValidate;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Aspect
@Component
public class PasswordRegisterValidationAspect extends PointcutDefinitions {

    @Before("inServiceLayer() && @annotation(validation)")
    public void passwordRegisterValidate(JoinPoint joinPoint, RegisterPasswordValidate validation) {
        PasswordRegisterRequestDTO requestDto = (PasswordRegisterRequestDTO) joinPoint.getArgs()[0];

        if (requestDto.password().length() < 8) {
            throw new ONBPasswordNotContainsMinimumCharactersException();
        } else if (!containUpperCaseChar(requestDto.password())) {
            throw new ONBPasswordNotContainsUpperCaseCharactersException();
        } else if (!containLowerCaseChar(requestDto.password())) {
            throw new ONBPasswordNotContainsLowerCaseCharactersException();
        } else if (!containNumericChar(requestDto.password())) {
            throw new ONBPasswordNotContainsNumericCharacterException();
        } else if (!containSpecialChar(requestDto.password())) {
            throw new ONBPasswordNotContainsSpecialCharactersException();
        }
    }

    private boolean isNumeric(String string) {
        return Pattern.compile("-?\\d+(\\.\\d+)?").matcher(string).matches();
    }

    public boolean isSpecial(String string) {
        return Pattern.compile("[.,#@&*%^()$!?\\[\\]{}<>~`|\\\\/]").matcher(string).matches();
    }

    private boolean containUpperCaseChar(String string) {
        boolean contains = false;

        for (int i = 0; i < string.length(); i++) {
            String indexChar = String.valueOf(string.charAt(i));

            if (!isNumeric(indexChar)) {
                if (indexChar.toUpperCase().equals(indexChar)) {
                    contains = true;
                }
            }
        }
        return contains;
    }

    private boolean containLowerCaseChar(String string) {
        boolean contains = false;

        for (int i = 0; i < string.length(); i++) {
            String indexChar = String.valueOf(string.charAt(i));

            if (!isNumeric(indexChar)) {
                if (indexChar.toLowerCase().equals(indexChar)) {
                    contains = true;
                }
            }
        }
        return contains;
    }

    private boolean containNumericChar(String string) {
        boolean contains = false;

        for (int i = 0; i < string.length(); i++) {
            String indexChar = String.valueOf(string.charAt(i));

            if (isNumeric(indexChar)) {
                contains = true;
            }
        }
        return contains;
    }

    private boolean containSpecialChar(String string) {
        boolean contains = false;

        for (int i = 0; i < string.length(); i++) {
            String indexChar = String.valueOf(string.charAt(i));

            if (isSpecial(indexChar)) {
                contains = true;
                System.out.println(indexChar);
            }
        }
        return contains;
    }
}