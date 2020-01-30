package com.amber.relationship.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class PetOwnerException extends Exception {
    public PetOwnerException(String message) {
        super(message);
    }
}
