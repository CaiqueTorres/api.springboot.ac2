package com.app.school.models;

import com.app.common.ToEntity;

public class CreateSchoolDTO implements ToEntity<School> {

    public String name;
    public String address;
    public String cnpj;
    public double area;
    public int studentsAmount;

    @Override
    public School toEntity() {
        return new School(
            name,
            address,
            cnpj,
            area,
            studentsAmount
        );
    }

}
