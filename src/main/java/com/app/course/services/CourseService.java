package com.app.course.services;

import java.util.ArrayList;

import com.app.course.models.CourseEntity;
import com.app.course.models.CoursePayload;
import com.app.course.repositories.CourseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public CourseEntity createCourse(CoursePayload coursePayload) {
        return this.courseRepository.save(coursePayload);
    }

    public ArrayList<CourseEntity> getCourses() {
        return this.courseRepository.getAll();
    }

    public CourseEntity getCourse(int id) {
        return this.courseRepository.findOne(id);
    }

    public void deleteCourse(int id) {
        this.courseRepository.delete(id);
    }

    public void updateCourse(int id, CoursePayload coursePayload) {
        this.courseRepository.update(id, coursePayload);
    }

}
