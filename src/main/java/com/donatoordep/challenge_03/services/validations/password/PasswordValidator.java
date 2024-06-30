package com.donatoordep.challenge_03.services.validations.password;

import java.util.regex.Pattern;

public interface PasswordValidator {

    void validate(String password) throws RuntimeException;

    default boolean isNumeric(String string) {
        return Pattern.compile("-?\\d+(\\.\\d+)?").matcher(string).matches();
    }

    default boolean isSpecial(String string) {
        return Pattern.compile("[.,#@&*%^()$!?\\[\\]{}<>~`|\\\\/]").matcher(string).matches();
    }

    default boolean containUpperCaseChar(String string) {
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

    default boolean containLowerCaseChar(String string) {
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

    default boolean containNumericChar(String string) {
        boolean contains = false;

        for (int i = 0; i < string.length(); i++) {
            String indexChar = String.valueOf(string.charAt(i));

            if (isNumeric(indexChar)) {
                contains = true;
            }
        }
        return contains;
    }

    default boolean containSpecialChar(String string) {
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
