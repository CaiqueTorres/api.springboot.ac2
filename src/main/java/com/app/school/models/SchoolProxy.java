package com.app.school.models;

public class SchoolProxy {

    public String id;
    public String name;
    public String address;
    public String cnpj;
    public double area;
    public int studentsAmount;

    public SchoolProxy(
        String id,
        String name,
        String address,
        String cnpj,
        double area,
        int studentsAmount
    ) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.cnpj = cnpj;
        this.area = area;
        this.studentsAmount = studentsAmount;
    }

}
