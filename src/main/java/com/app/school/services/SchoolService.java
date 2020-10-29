package com.app.school.services;

import java.util.ArrayList;

import com.app.course.models.CourseEntity;
import com.app.course.services.CourseService;
import com.app.school.models.SchoolEntity;
import com.app.school.models.SchoolPayload;
import com.app.school.repositories.SchoolRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SchoolService {

    @Autowired
    private SchoolRepository schoolRepository;

    @Autowired
    private CourseService courseService;

    public SchoolEntity createSchool(SchoolPayload schoolPayload) {
        return this.schoolRepository.save(schoolPayload);
    }

    public ArrayList<SchoolEntity> getSchools() {
        return this.schoolRepository.getAll();
    }

    public SchoolEntity getSchool(int id) {
        return this.schoolRepository.findOne(id);
    }

    public ArrayList<CourseEntity> getCourses(int id) {
        return this.courseService.getCourses();
    }

    public void deleteSchool(int id) {
        this.schoolRepository.delete(id);
    }

    public void updateSchool(int id, SchoolPayload schoolPayload) {
        this.schoolRepository.update(id, schoolPayload);
    }

}
