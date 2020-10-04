package com.example.ac1.models;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class IdConflictException extends RuntimeException {
    @Override
    public String getMessage () {
        return "O código informado já existe!";
    }
}
