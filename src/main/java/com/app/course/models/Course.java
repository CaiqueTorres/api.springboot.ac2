package com.app.course.models;

import com.app.common.BaseEntity;
import com.app.common.ToDTO;
import com.app.school.models.School;

public class Course 
    extends BaseEntity implements ToDTO<CourseDTO> {

    private String name;
    private boolean needsLab;
    private int maxStudentsAmount;
    private String responsibleTeacher;
    private float duration;
    private School schoolEntity;

    public void setResponsibleTeacher(String responsibleTeacher) {
        this.responsibleTeacher = responsibleTeacher;
    }

    public void setSchoolEntity(School schoolEntity) {
        this.schoolEntity = schoolEntity;
    }

    public School getSchoolEntity() {
        return schoolEntity;
    }

    public Course(
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
    public CourseDTO toDTO() {
        return new CourseDTO(
            id,
            name,
            needsLab,
            maxStudentsAmount,
            responsibleTeacher,
            duration,
            schoolEntity.toDTO()
        );
    }

}
