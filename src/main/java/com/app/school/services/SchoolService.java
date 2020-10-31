package com.app.school.services;

import java.util.List;

import com.app.course.models.CourseEntity;
import com.app.course.services.CourseService;
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
        return this.schoolRepository.getAll();
    }

    public SchoolEntity getSchool(String id) {
        SchoolEntity entity = this.schoolRepository.findOne(id);
        if (entity == null)
            throw new EntityNotFoundException();
        return entity;
    }

    public List<CourseEntity> getCourses(String schoolId) {
        return this.courseService.getCourses();
    }

    public void deleteSchool(String id) {
        if (!this.contains(id))
            throw new EntityNotFoundException();
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
