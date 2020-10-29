package com.app.school.controllers;

import com.app.common.ArrayProxy;
import com.app.course.models.CourseProxy;
import com.app.school.models.SchoolEntity;
import com.app.school.models.SchoolProxy;
import com.app.school.services.SchoolService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "schools")
public class SchoolController {

    @Autowired
    private SchoolService schoolService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<SchoolProxy> createSchool(@RequestBody SchoolEntity school) {
        return null;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ArrayProxy<SchoolProxy>> getSchools() {
        return null;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<SchoolProxy> getSchool(@PathVariable int id) {
        return null;
    }

    @GetMapping("/{id}/courses")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ArrayProxy<CourseProxy>> getCourses(@PathVariable int id) {
        return null;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Void> deleteSchool(@PathVariable int id) {
        return null;
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Void> updateSchool(@PathVariable int id) {
        return null;
    }

}
