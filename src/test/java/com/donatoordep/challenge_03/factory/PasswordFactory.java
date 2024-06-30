package com.donatoordep.challenge_03.factory;

import com.donatoordep.challenge_03.entities.Password;

import java.util.UUID;

public class PasswordFactory {

    private static final UUID id = UUID.randomUUID();
    private static final String password = "12345678Aa.";

    public static Password createPassword() {
        return Password.PasswordBuilder.builder()
                .id(id)
                .password(password)
                .build();
    }

    public static Password createPassword(String password) {
        return Password.PasswordBuilder.builder()
                .id(id)
                .password(password)
                .build();
    }
}
