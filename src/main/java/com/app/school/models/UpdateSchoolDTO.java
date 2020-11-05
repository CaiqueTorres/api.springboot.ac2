package com.app.school.models;

import com.app.common.ModifyEntity;

public class UpdateSchoolDTO implements ModifyEntity<School> {
    
    public double area;
    public int studentsAmount;

    @Override
    public void modifyEntity(School entity) {
        entity.setArea(area);
        entity.setStudentsAmount(studentsAmount);
    }

}
