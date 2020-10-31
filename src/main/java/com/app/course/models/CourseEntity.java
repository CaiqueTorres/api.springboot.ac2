package com.app.course.models;

import com.app.common.BaseEntity;
import com.app.common.ToProxy;
import com.app.school.models.SchoolEntity;

public class CourseEntity 
    extends BaseEntity implements ToProxy<CourseProxy> {

    private String name;
    private boolean needsLab;
    private int maxStudentsAmount;
    private String responsibleTeacher;
    private float duration;
    private SchoolEntity schoolEntity;

    public void setResponsibleTeacher(String responsibleTeacher) {
        this.responsibleTeacher = responsibleTeacher;
    }

    public void setSchoolEntity(SchoolEntity schoolEntity) {
        this.schoolEntity = schoolEntity;
    }

    public SchoolEntity getSchoolEntity() {
        return schoolEntity;
    }

    public CourseEntity(
        String name,
        boolean needsLab,
        int maxStudentsAmount,
        String responsibleTeacher,
        float duration
    ) {
        this.name = name;
        this.needsLab = needsLab;
        this.maxStudentsAmount = maxStudentsAmount;
        this.responsibleTeacher = responsibleTeacher;
        this.duration = duration;
    }

    @Override
    public CourseProxy toProxy() {
        return new CourseProxy(
            id,
            name,
            needsLab,
            maxStudentsAmount,
            responsibleTeacher,
            duration,
            schoolEntity.toProxy()
        );
    }

}
