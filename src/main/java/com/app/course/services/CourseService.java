package com.app.course.services;

import java.util.List;

import com.app.course.models.CourseEntity;
import com.app.course.models.CreateCoursePayload;
import com.app.course.models.UpdateCoursePayload;
import com.app.course.repositories.CourseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public CourseService() { }

    public CourseEntity createCourse(CreateCoursePayload coursePayload) {
        return this.courseRepository.save(coursePayload);
    }

    public List<CourseEntity> getCourses() {
        return this.courseRepository.getAll();
    }

    public CourseEntity getCourse(String id) {
        return this.courseRepository.findOne(id);
    }

    public void deleteCourse(String id) {
        this.courseRepository.delete(id);
    }

    public void updateCourse(String id, UpdateCoursePayload coursePayload) {
        this.courseRepository.update(id, coursePayload);
    }

    public boolean contains(String id) {
        return this.courseRepository.contains(id);
    }

}
