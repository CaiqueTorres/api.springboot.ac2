package com.app.school.models;

import java.util.List;

import com.app.common.BaseEntity;
import com.app.common.ToProxy;
import com.app.course.models.CourseEntity;

public class SchoolEntity
    extends BaseEntity implements ToProxy<SchoolProxy> {

    private String name;
    private String address;
    private String cnpj;
    private double area;
    private int studentsAmount;

    private List<CourseEntity> courses;

    public void setArea(double area) {
        this.area = area;
    }

    public void setStudentsAmount(int studentsAmount) {
        this.studentsAmount = studentsAmount;
    }

    public SchoolEntity(
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
    public SchoolProxy toProxy() {
        return new SchoolProxy(
            id,
            name,
            address,
            cnpj,
            area,
            studentsAmount
        );
    }

}
