package com.app.course.services;

import java.util.List;
import java.util.function.Predicate;

import com.app.course.models.CourseEntity;
import com.app.course.models.CreateCoursePayload;
import com.app.course.models.UpdateCoursePayload;
import com.app.course.repositories.CourseRepository;
import com.app.exceptions.EntityNotFoundException;
import com.app.school.models.SchoolEntity;
import com.app.school.services.SchoolService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private SchoolService schoolService;

    public CourseService() { }

    public CourseEntity createCourse(CreateCoursePayload createCoursePayload) {
        SchoolEntity schoolEntity = 
            this.schoolService.getSchool(createCoursePayload.schoolId);

        CourseEntity entity = this.courseRepository.save(createCoursePayload);
        entity.setSchoolEntity(schoolEntity);

        return entity;
    }

    public List<CourseEntity> getCourses() {
        return this.courseRepository.getAll();
    }

    public List<CourseEntity> getCoursesBy(Predicate<CourseEntity> predicate) {
        return this.courseRepository.find(predicate);
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
