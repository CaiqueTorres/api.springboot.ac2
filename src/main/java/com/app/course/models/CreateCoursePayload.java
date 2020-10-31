package com.app.course.models;

import com.app.common.ToEntity;

public class CreateCoursePayload implements ToEntity<CourseEntity> {

    public String name;
    public boolean needsLab;
    public int maxStudentsAmount;
    public String responsibleTeacher;
    public float duration;
    public String schoolId;

    @Override
    public CourseEntity toEntity() {
        return new CourseEntity(name,
            needsLab,
            maxStudentsAmount,
            responsibleTeacher,
            duration
        );
    }

}
