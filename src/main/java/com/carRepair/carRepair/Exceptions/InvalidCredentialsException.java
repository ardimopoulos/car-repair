package com.carRepair.carRepair.Exceptions;

import org.springframework.security.core.AuthenticationException;

//Here we create custom exceptions to handle authentication Errors.
public class InvalidCredentialsException extends AuthenticationException {

    public InvalidCredentialsException(String msg, Throwable t) {
        super(msg, t);
    }

    public InvalidCredentialsException(String msg) {
        super(msg);
    }

}
