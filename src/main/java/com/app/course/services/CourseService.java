package com.app.course.services;

import java.util.List;

import javax.naming.NameNotFoundException;

import com.app.course.models.CourseEntity;
import com.app.course.models.CreateCoursePayload;
import com.app.course.models.UpdateCoursePayload;
import com.app.course.repositories.CourseRepository;
import com.app.exceptions.EntityNotFoundException;

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
        CourseEntity entity = this.courseRepository.findOne(id);
        if (entity == null)
            throw new EntityNotFoundException();
        return entity;
    }

    public void deleteCourse(String id) {
        if (!this.contains(id))
            throw new EntityNotFoundException();
        this.courseRepository.delete(id);
    }

    public void updateCourse(String id, UpdateCoursePayload updateCoursePayload) {
        if (!this.contains(id))
            throw new EntityNotFoundException();
        this.courseRepository.update(id, updateCoursePayload);
    }

    //#region Utils

    public boolean contains(String id) {
        return this.courseRepository.contains(id);
    }

    //#endregion

}
