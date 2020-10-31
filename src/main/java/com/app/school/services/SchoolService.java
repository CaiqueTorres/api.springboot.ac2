package com.app.school.services;

import java.util.List;

import com.app.course.models.CourseEntity;
import com.app.course.services.CourseService;
import com.app.exceptions.DepedencyConflictException;
import com.app.exceptions.EntityNotFoundException;
import com.app.school.models.SchoolEntity;
import com.app.school.models.CreateSchoolPayload;
import com.app.school.models.UpdateSchoolPayload;
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

    public SchoolEntity createSchool(CreateSchoolPayload schoolPayload) {
        return this.schoolRepository.save(schoolPayload);
    }

    public List<SchoolEntity> getSchools() {
        return this.schoolRepository.find();
    }

    public SchoolEntity getSchool(String id) {
        SchoolEntity entity = this.schoolRepository.findOne(id);
        if (entity == null)
            throw new EntityNotFoundException();
        return entity;
    }

    public List<CourseEntity> getCourses(String schoolId) {
        SchoolEntity entity = this.schoolRepository.findOne(schoolId);
        if (entity == null)
            throw new EntityNotFoundException();
        
        return this.courseService.getCoursesBy(
            coureEntity -> coureEntity.getSchoolEntity().equals(entity));
    }

    public void deleteSchool(String id) {
        List<CourseEntity> courses = getCourses(id);

        if (courses.size() > 0)
            throw new DepedencyConflictException();

        this.schoolRepository.delete(id);
    }

    public void updateSchool(String id, UpdateSchoolPayload updateSchoolPayload) {
        if (!this.contains(id))
            throw new EntityNotFoundException();
        this.schoolRepository.update(id, updateSchoolPayload);
    }

    //#region Utils

    public boolean contains(String id) {
        return this.schoolRepository.contains(id);
    }

    //#endregion

}
