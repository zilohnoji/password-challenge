package com.donatoordep.challenge_03.services.validations.password.aspects;

import com.donatoordep.challenge_03.dto.PasswordRegisterRequestDTO;
import com.donatoordep.challenge_03.services.validations.password.PasswordValidator;
import com.donatoordep.challenge_03.services.validations.password.PointcutDefinitions;
import com.donatoordep.challenge_03.services.validations.password.annotations.RegisterPasswordValidate;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

@Aspect
@Component
public class PasswordRegisterValidationAspect extends PointcutDefinitions {

    private final Set<PasswordValidator> passwordValidators;

    @Autowired
    public PasswordRegisterValidationAspect(Set<PasswordValidator> passwordValidators) {
        this.passwordValidators = passwordValidators;
    }

    @Before("inServiceLayer() && @annotation(validation)")
    public void passwordRegisterValidate(JoinPoint joinPoint, RegisterPasswordValidate validation) {
        PasswordRegisterRequestDTO requestDto = (PasswordRegisterRequestDTO) joinPoint.getArgs()[0];
        passwordValidators.forEach(validate -> validate.validate(requestDto.password()));
    }
}