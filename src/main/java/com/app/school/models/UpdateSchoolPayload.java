package com.app.school.models;

import com.app.common.ModifyEntity;

public class UpdateSchoolPayload implements ModifyEntity<SchoolEntity> {
    
    public double area;
    public int studentsAmount;

    @Override
    public void modifyEntity(SchoolEntity entity) {
        entity.setArea(area);
        entity.setStudentsAmount(studentsAmount);
    }

}
