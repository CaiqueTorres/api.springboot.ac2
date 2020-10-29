package com.app.course.controllers;

import com.app.common.ArrayProxy;
import com.app.course.models.CoursePayload;
import com.app.course.models.CourseProxy;
import com.app.course.services.CourseService;

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
@RequestMapping(value = "courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<CourseProxy> createCourse(@RequestBody CoursePayload coursePayload) {
        return null;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ArrayProxy<CourseProxy>> getCourses() {
        return null;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<CourseProxy> getCourse(@PathVariable int id) {
        return null;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Void> deleteCourse(@PathVariable int id) {
        return null;
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Void> updateCourse(@PathVariable int id, @RequestBody CoursePayload coursePayload) {
        return null;
    }

}
