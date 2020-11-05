package com.app.school.controllers;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import com.app.common.ArrayProxy;
import com.app.course.models.Course;
import com.app.course.models.CourseDTO;
import com.app.exceptions.DepedencyConflictException;
import com.app.exceptions.EntityNotFoundException;
import com.app.school.models.School;
import com.app.school.models.CreateSchoolDTO;
import com.app.school.models.SchoolDTO;
import com.app.school.models.UpdateSchoolDTO;
import com.app.school.services.SchoolService;

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
@RequestMapping(value = "schools")
public class SchoolController {

    @Autowired
    private SchoolService schoolService;

    public SchoolController() { }

    @PostMapping
    public ResponseEntity<SchoolDTO> createSchool(
        @RequestBody final CreateSchoolDTO createSchoolDto,
        final HttpServletRequest request,
        final UriComponentsBuilder builder
    ) {
        School entity = this.schoolService.createSchool(createSchoolDto);
        UriComponents uriComponents = builder.path(
            request.getRequestURI()
            + "/"
            + entity.getId()
        ).build();
        return ResponseEntity.created(uriComponents.toUri()).build();
    }

    @GetMapping
    public ResponseEntity<ArrayProxy<SchoolDTO>> getSchools() {
        List<School> entities = this.schoolService.getSchools();
        return ResponseEntity.ok(
            new ArrayProxy<SchoolDTO>(
                entities.size(),
                entities
                    .stream()
                    .map(entity -> entity.toDTO())
                    .collect(Collectors.toList())
            )
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<SchoolDTO> getSchool(
        @PathVariable final String id
    ) {
        try {
            School entity = this.schoolService.getSchool(id);
            return ResponseEntity.ok(entity.toDTO());
        } catch (EntityNotFoundException exception) {
            return ResponseEntity.notFound().build();
        }
        
    }

    @GetMapping("/{id}/courses")
    public ResponseEntity<ArrayProxy<CourseDTO>> getCourses(
        @PathVariable final String id
    ) {
        try {
            List<Course> entities = this.schoolService.getCourses(id);
            return ResponseEntity.ok(
                new ArrayProxy<CourseDTO>(
                    entities.size(),
                    entities
                        .stream()
                        .map(entity -> entity.toDTO())
                        .collect(Collectors.toList())
                )
            );
        } catch (EntityNotFoundException exception) {
            return ResponseEntity.notFound().build();
        } 
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSchool(
        @PathVariable final String id
    ) {
        try {
            this.schoolService.deleteSchool(id);
            return ResponseEntity.ok().build();
        } catch (EntityNotFoundException exception) {
            return ResponseEntity.notFound().build();
        } catch (DepedencyConflictException exception) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateSchool(
        @PathVariable final String id, 
        @RequestBody final UpdateSchoolDTO updateSchoolDto
    ) {
        try {
            this.schoolService.updateSchool(id, updateSchoolDto);
            return ResponseEntity.ok().build();
        } catch (EntityNotFoundException exception) {
            return ResponseEntity.notFound().build();
        }
    }

}
