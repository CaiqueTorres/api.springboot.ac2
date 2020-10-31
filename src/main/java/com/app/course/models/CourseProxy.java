package com.app.course.models;

import com.app.school.models.SchoolProxy;

public class CourseProxy {

    public String id;
    public String name;
    public boolean needsLab;
    public int maxStudentsAmount;
    public String responsibleTeacher;
    public float duration;
    public SchoolProxy school;

    public CourseProxy(
        String id,
        String name,
        boolean needsLab,
        int maxStudentsAmount,
        String responsibleTeacher,
        float duration,
        SchoolProxy school
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
