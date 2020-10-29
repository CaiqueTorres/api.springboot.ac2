package com.app.controllers;

import com.app.models.ArrayProxy;
import com.app.models.Course;
import com.app.models.School;
import com.app.services.SchoolService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public School createSchool(@RequestBody School school) {
        return null;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ArrayProxy<School> getSchools() {
        return null;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public School getSchool(@PathVariable int id) {
        return null;
    }

    @GetMapping("/{id}/courses")
    @ResponseStatus(HttpStatus.OK)
    public ArrayProxy<Course> getCourses(@PathVariable int id) {
        return null;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteSchool(@PathVariable int id) {

    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateSchool(@PathVariable int id) {

    }

}
