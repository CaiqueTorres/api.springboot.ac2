package com.app.course.models;

public class CourseProxy {

    public String id;
    public String name;
    public boolean needsLab;
    public int maxStudentsAmount;
    public String responsibleTeacher;
    public float duration;

    public CourseProxy(
        String id,
        String name,
        boolean needsLab,
        int maxStudentsAmount,
        String responsibleTeacher,
        float duration
    ) {
        this.id = id;
        this.name = name;
        this.needsLab = needsLab;
        this.maxStudentsAmount = maxStudentsAmount;
        this.responsibleTeacher = responsibleTeacher;
        this.duration = duration;
    }

}
