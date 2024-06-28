package com.donatoordep.challenge_03.builders.entities;

import com.donatoordep.challenge_03.builders.Builder;
import com.donatoordep.challenge_03.entities.Password;

import java.util.UUID;

public interface PasswordAbstractBuilder extends Builder<Password> {

    PasswordAbstractBuilder id(UUID id);

    PasswordAbstractBuilder password(String password);
}