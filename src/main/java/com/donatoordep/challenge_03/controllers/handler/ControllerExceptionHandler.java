package com.donatoordep.challenge_03.controllers.handler;

import com.donatoordep.challenge_03.exceptions.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ONBPasswordNotContainsLowerCaseCharactersException.class)
    public ResponseEntity<StandardError> handleBadRequestException(ONBPasswordNotContainsLowerCaseCharactersException exception, HttpServletRequest request) {
        return handleExceptionFactory(exception, request.getRequestURI());
    }

    @ExceptionHandler(ONBPasswordNotContainsMinimumCharactersException.class)
    public ResponseEntity<StandardError> handleBadRequestException(ONBPasswordNotContainsMinimumCharactersException exception, HttpServletRequest request) {
        return handleExceptionFactory(exception, request.getRequestURI());
    }

    @ExceptionHandler(ONBPasswordNotContainsNumericCharacterException.class)
    public ResponseEntity<StandardError> handleBadRequestException(ONBPasswordNotContainsNumericCharacterException exception, HttpServletRequest request) {
        return handleExceptionFactory(exception, request.getRequestURI());
    }

    @ExceptionHandler(ONBPasswordNotContainsSpecialCharactersException.class)
    public ResponseEntity<StandardError> handleBadRequestException(ONBPasswordNotContainsSpecialCharactersException exception, HttpServletRequest request) {
        return handleExceptionFactory(exception, request.getRequestURI());
    }

    @ExceptionHandler(ONBPasswordNotContainsUpperCaseCharactersException.class)
    public ResponseEntity<StandardError> handleBadRequestException(ONBPasswordNotContainsUpperCaseCharactersException exception, HttpServletRequest request) {
        return handleExceptionFactory(exception, request.getRequestURI());
    }

    private ResponseEntity<StandardError> handleExceptionFactory(SpecificationException exception, String path) {
        return ResponseEntity.status(exception.getStatus()).body(
                new StandardError(Instant.now(), exception.getStatus(), exception.getError(), path));
    }
}