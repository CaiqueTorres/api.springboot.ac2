package com.app.course.models;

import com.app.common.ToEntity;

public class CoursePayload implements ToEntity<CourseEntity> {

    public int id;
    public String name;

    @Override
    public CourseEntity toEntity() {
        return new CourseEntity(id, name);
    }

}
