package com.app.school.services;

import java.util.ArrayList;
import java.util.List;

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

    public List<SchoolEntity> getSchools() {
        return this.schoolRepository.getAll();
    }

    public SchoolEntity getSchool(String id) {
        return this.schoolRepository.findOne(id);
    }

    public ArrayList<CourseEntity> getCourses(String schoolId) {
        return this.courseService.getCourses();
    }

    public void deleteSchool(String id) {
        this.schoolRepository.delete(id);
    }

    public void updateSchool(String id, SchoolPayload schoolPayload) {
        this.schoolRepository.update(id, schoolPayload);
    }

    public boolean contains(String id) {
        return this.schoolRepository.contains(id);
    }

}
