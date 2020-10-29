package com.app.common;

import java.util.ArrayList;

public class ArrayProxy<TValue> {

    int length;
    ArrayList<TValue> elements;

    public ArrayProxy(int length, ArrayList<TValue> elements) {
        this.length = length;
        this.elements = elements;
    }
}
