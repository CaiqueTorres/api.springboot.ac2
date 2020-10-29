package com.app.course.repositories;

import java.util.ArrayList;

import javax.annotation.PostConstruct;

import com.app.course.models.CourseEntity;
import com.app.course.models.CoursePayload;

import org.springframework.stereotype.Component;

@Component
public class CourseRepository {
    private ArrayList<CourseEntity> courses;

    @PostConstruct
    public void initialize() {
        courses = new ArrayList<CourseEntity>();
    }

    public CourseEntity save(CoursePayload coursePayload) {
        CourseEntity entity = coursePayload.toEntity();
        courses.add(entity);
        return entity;
    }

    public CourseEntity findOne(int id) {
        for (int i = 0; i < courses.size(); i++)
            if (courses.get(i).getId() == id)
                return courses.get(i);
        return null;
    }

    public ArrayList<CourseEntity> getAll() {
        return courses;
    }

    public void delete(int id) {
        courses.remove(findOne(id));
    }

    public void update(int id, CoursePayload coursePayload) {
        delete(id);
        CourseEntity entity = coursePayload.toEntity();
        courses.add(entity);
    }
}
