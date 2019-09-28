package com.doughhack.doughnotList.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = UserAlreadyExistsException.REASON)
public class UserAlreadyExistsException extends Exception {
    public static final String REASON = "The user already exists!";

    public UserAlreadyExistsException() {
        super(REASON);
    }

    public UserAlreadyExistsException(String message) {
        super(message);
    }
}
