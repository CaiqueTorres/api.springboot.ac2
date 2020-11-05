package com.app.course.models;

import com.app.school.models.SchoolDTO;

public class CourseDTO {

    public String id;
    public String name;
    public boolean needsLab;
    public int maxStudentsAmount;
    public String responsibleTeacher;
    public float duration;
    public SchoolDTO school;

    public CourseDTO(
        String id,
        String name,
        boolean needsLab,
        int maxStudentsAmount,
        String responsibleTeacher,
        float duration,
        SchoolDTO school
    ) {
        this.id = id;
        this.name = name;
        this.needsLab = needsLab;
        this.maxStudentsAmount = maxStudentsAmount;
        this.responsibleTeacher = responsibleTeacher;
        this.duration = duration;
        this.school = school;
    }

}
