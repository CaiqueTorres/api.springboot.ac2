package com.app.common;

import java.util.List;

public class ArrayProxy<TValue> {

    private int length;
    private List<TValue> elements;

    public int getLength() {
        return length;
    }

    public List<TValue> getElements() {
        return elements;
    }

    public ArrayProxy(int length, List<TValue> elements) {
        this.length = length;
        this.elements = elements;
    }

}
