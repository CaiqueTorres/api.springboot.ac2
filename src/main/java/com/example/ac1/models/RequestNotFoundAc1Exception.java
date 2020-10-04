package com.example.ac1.models;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RequestNotFoundAc1Exception extends RuntimeException{

    @Override
    public String getMessage() {
        return "O código informado não existe!";
    }

}
