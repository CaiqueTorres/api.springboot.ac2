package com.example.ac1.models;

import java.util.List;

public class DefaultListResponse<TValue> {
    public int length;
    public List<TValue> list;

    public DefaultListResponse(int length, List<TValue> list) {
        this.length = length;
        this.list = list;
    }
}
