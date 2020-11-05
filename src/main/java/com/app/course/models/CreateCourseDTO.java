package com.app.course.models;

import com.app.common.ToEntity;

public class CreateCourseDTO implements ToEntity<Course> {

    public String name;
    public boolean needsLab;
    public int maxStudentsAmount;
    public String responsibleTeacher;
    public float duration;
    public String schoolId;

    @Override
    public Course toEntity() {
        return new Course(name,
            needsLab,
            maxStudentsAmount,
            responsibleTeacher,
            duration
        );
    }

}
