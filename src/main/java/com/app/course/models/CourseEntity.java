package com.app.course.models;

import com.app.common.BaseEntity;
import com.app.common.ToProxy;

public class CourseEntity extends BaseEntity implements ToProxy<CourseProxy> {

    private String name;

    public CourseEntity(String name) {
        this.name = name;
    }

    @Override
    public CourseProxy toProxy() {
        return new CourseProxy(name);
    }

}
