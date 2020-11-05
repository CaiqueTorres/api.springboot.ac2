package com.app.school.models;


import com.app.common.BaseEntity;
import com.app.common.ToDTO;

public class School
    extends BaseEntity implements ToDTO<SchoolDTO> {

    private String name;
    private String address;
    private String cnpj;
    private double area;
    private int studentsAmount;

    public void setArea(double area) {
        this.area = area;
    }

    public void setStudentsAmount(int studentsAmount) {
        this.studentsAmount = studentsAmount;
    }

    public School(
        String name,
        String address,
        String cnpj,
        double area,
        int studentsAmount
    ) {
        this.name = name;
        this.address = address;
        this.cnpj = cnpj;
        this.area = area;
        this.studentsAmount = studentsAmount;
    }

    @Override
    public SchoolDTO toDTO() {
        return new SchoolDTO(
            id,
            name,
            address,
            cnpj,
            area,
            studentsAmount
        );
    }

}
