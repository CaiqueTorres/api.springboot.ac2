package com.app.school.services;

import java.util.List;

import com.app.course.models.Course;
import com.app.course.services.CourseService;
import com.app.exceptions.DepedencyConflictException;
import com.app.exceptions.EntityNotFoundException;
import com.app.school.models.School;
import com.app.school.models.CreateSchoolDTO;
import com.app.school.models.UpdateSchoolDTO;
import com.app.school.repositories.SchoolRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SchoolService {

    @Autowired
    private SchoolRepository schoolRepository;

    @Autowired
    private CourseService courseService;

    public SchoolService() { }

    public School createSchool(CreateSchoolDTO createSchoolDto) {
        return this.schoolRepository.save(createSchoolDto);
    }

    public List<School> getSchools() {
        return this.schoolRepository.find();
    }

    public School getSchool(String id) {
        School entity = this.schoolRepository.findOne(id);
        if (entity == null)
            throw new EntityNotFoundException();
        return entity;
    }

    public List<Course> getCourses(String schoolId) {
        School entity = this.schoolRepository.findOne(schoolId);
        if (entity == null)
            throw new EntityNotFoundException();
        
        return this.courseService.getCoursesBy(
            coureEntity -> coureEntity.getSchoolEntity().equals(entity));
    }

    public void deleteSchool(String id) {
        List<Course> courses = getCourses(id);

        if (courses.size() > 0)
            throw new DepedencyConflictException();

        this.schoolRepository.delete(id);
    }

    public void updateSchool(String id, UpdateSchoolDTO updateSchoolDto) {
        if (!this.contains(id))
            throw new EntityNotFoundException();
        this.schoolRepository.update(id, updateSchoolDto);
    }

    //#region Utils

    public boolean contains(String id) {
        return this.schoolRepository.contains(id);
    }

    //#endregion

}
