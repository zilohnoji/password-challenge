package com.donatoordep.challenge_03.services.validations.password;

import org.aspectj.lang.annotation.Pointcut;

public class PointcutDefinitions implements SpecificationPointcut {

    @Pointcut("within(com.donatoordep.challenge_03.services.*)")
    public void inServiceLayer() {

    }
}
