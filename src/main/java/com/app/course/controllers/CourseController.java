package com.app.course.controllers;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import com.app.common.ArrayProxy;
import com.app.course.models.Course;
import com.app.course.models.CreateCourseDTO;
import com.app.course.models.UpdateCourseDTO;
import com.app.course.models.CourseDTO;
import com.app.course.services.CourseService;
import com.app.exceptions.EntityNotFoundException;

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
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping(value = "courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    public CourseController() { }

    @PostMapping
    public ResponseEntity<CourseDTO> createCourse(
        @RequestBody final CreateCourseDTO createCourseDto,
        final HttpServletRequest request,
        final UriComponentsBuilder builder
    ) {
        try {
            Course entity = this.courseService.createCourse(createCourseDto);
            UriComponents uriComponents = builder.path(
            request.getRequestURI()
            + "/"
            + entity.getId()
        ).build();
        return ResponseEntity.created(uriComponents.toUri()).build();
        } catch (EntityNotFoundException exception) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<ArrayProxy<CourseDTO>> getCourses() {
        List<Course> entities = this.courseService.getCourses();
        return ResponseEntity.ok(
            new ArrayProxy<CourseDTO>(
                entities.size(),
                entities
                    .stream()
                    .map(entity -> entity.toDTO())
                    .collect(Collectors.toList())
            )
        );
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<CourseDTO> getCourse(
        @PathVariable final String id
    ) {
        try {
            Course entity = this.courseService.getCourse(id);
            return ResponseEntity.ok(entity.toDTO());
        } catch(EntityNotFoundException exception) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(
        @PathVariable final String id
    ) {
        try {
            this.courseService.deleteCourse(id);
            return ResponseEntity.ok().build();
        } catch (EntityNotFoundException exception) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateCourse(
        @PathVariable final String id,
        @RequestBody final UpdateCourseDTO updateCourseDto
    ) {
        try {
            this.courseService.updateCourse(id, updateCourseDto);
            return ResponseEntity.ok().build();
        } catch (EntityNotFoundException exception) {
            return ResponseEntity.notFound().build();
        }
        
    }

}
