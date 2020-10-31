package com.app.course.controllers;

import java.util.List;
import java.util.stream.Collectors;

import com.app.common.ArrayProxy;
import com.app.course.models.CourseEntity;
import com.app.course.models.CreateCoursePayload;
import com.app.course.models.UpdateCoursePayload;
import com.app.course.models.CourseProxy;
import com.app.course.services.CourseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    public CourseController() { }

    @PostMapping
    public ResponseEntity<CourseProxy> createCourse(
        @RequestBody CreateCoursePayload coursePayload
    ) {
        CourseEntity entity = this.courseService.createCourse(coursePayload);
        return ResponseEntity.ok(entity.toProxy());
    }

    @GetMapping
    public ResponseEntity<ArrayProxy<CourseProxy>> getCourses() {
        List<CourseEntity> entities = this.courseService.getCourses();
        return ResponseEntity.ok(
            new ArrayProxy<CourseProxy>(
                entities.size(),
                entities
                    .stream()
                    .map(entity -> entity.toProxy())
                    .collect(Collectors.toList())
            )
        );
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<CourseProxy> getCourse(
        @PathVariable String id
    ) {
        CourseEntity entity = this.courseService.getCourse(id);
        if (entity == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(entity.toProxy());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateCourse(
        @PathVariable String id,
        @RequestBody UpdateCoursePayload coursePayload
    ) {
        if (!this.courseService.contains(id))
            return ResponseEntity.notFound().build();
        
        this.courseService.updateCourse(id, coursePayload);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(
        @PathVariable String id
    ) {
        if (!this.courseService.contains(id))
            return ResponseEntity.notFound().build();
        
        this.courseService.deleteCourse(id);
        return ResponseEntity.ok().build();
    }

}
