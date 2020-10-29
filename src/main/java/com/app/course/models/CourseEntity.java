package com.app.course.models;

import com.app.common.ToProxy;

public class CourseEntity implements ToProxy<CourseProxy> {
    private int id;
    private String name;

    public CourseEntity(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    @Override
    public CourseProxy toProxy() {
        return new CourseProxy(name);
    }
}
