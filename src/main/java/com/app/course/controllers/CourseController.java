package com.app.course.controllers;

import com.app.common.ArrayProxy;
import com.app.course.models.CourseEntity;
import com.app.course.services.CourseService;

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
@RequestMapping(value = "courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CourseEntity createCourse(@RequestBody CourseEntity course) {
        return null;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ArrayProxy<CourseEntity> getCourses() {
        return null;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CourseEntity getCourse(@PathVariable int id) {
        return null;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCourse(@PathVariable int id) {

    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateCourse(@PathVariable int id) {

    }

}
