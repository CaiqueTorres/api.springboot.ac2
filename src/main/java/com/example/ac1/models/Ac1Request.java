package com.example.ac1.models;

import java.util.Date;

public class Ac1Request{

    public int id;
    public float value;
    public String description;
    public String client;
    public Date date;

    public Ac1Request () {}

    public Ac1Request (int id, float value, String description, String client, Date date) {
        this.id = id;
        this.value = value;
        this.description = description;
        this.client = client;
        this.date = date;
    }

}
