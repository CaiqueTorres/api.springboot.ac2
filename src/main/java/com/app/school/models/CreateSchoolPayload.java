package com.app.school.models;

import com.app.common.ToEntity;

public class CreateSchoolPayload implements ToEntity<SchoolEntity> {

    public String name;
    public String address;
    public String cnpj;
    public double area;
    public int studentsAmount;

    @Override
    public SchoolEntity toEntity() {
        return new SchoolEntity(
            name,
            address,
            cnpj,
            area,
            studentsAmount
        );
    }

}
