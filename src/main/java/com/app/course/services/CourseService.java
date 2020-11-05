package com.app.course.services;

import java.util.List;
import java.util.function.Predicate;

import com.app.course.models.Course;
import com.app.course.models.CreateCourseDTO;
import com.app.course.models.UpdateCourseDTO;
import com.app.course.repositories.CourseRepository;
import com.app.exceptions.EntityNotFoundException;
import com.app.school.models.School;
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

    public Course createCourse(CreateCourseDTO createCourseDto) {
        School schoolEntity = 
            this.schoolService.getSchool(createCourseDto.schoolId);

        Course entity = this.courseRepository.save(createCourseDto);
        entity.setSchoolEntity(schoolEntity);

        return entity;
    }

    public List<Course> getCourses() {
        return this.courseRepository.find();
    }

    public List<Course> getCoursesBy(Predicate<Course> predicate) {
        return this.courseRepository.find(predicate);
    }

    public Course getCourse(String id) {
        Course entity = this.courseRepository.findOne(id);
        if (entity == null)
            throw new EntityNotFoundException();
        return entity;
    }

    public void deleteCourse(String id) {
        if (!this.contains(id))
            throw new EntityNotFoundException();
        this.courseRepository.delete(id);
    }

    public void updateCourse(String id, UpdateCourseDTO updateCourseDto) {
        if (!this.contains(id))
            throw new EntityNotFoundException();
        this.courseRepository.update(id, updateCourseDto);
    }

    //#region Utils

    public boolean contains(String id) {
        return this.courseRepository.contains(id);
    }

    //#endregion

}
