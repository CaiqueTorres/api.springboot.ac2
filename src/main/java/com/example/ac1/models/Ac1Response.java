package com.example.ac1.models;

public class Ac1Response<TValue> {

    public int status;
    public String message;
    public TValue content;

    public Ac1Response (int status, String message, TValue content) {
        this.status = status;
        this.message = message;
        this.content = content;
    }

}
