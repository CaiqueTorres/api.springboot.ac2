package com.app.school.controllers;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import com.app.common.ArrayProxy;
import com.app.course.models.CourseEntity;
import com.app.course.models.CourseProxy;
import com.app.exceptions.DepedencyConflictException;
import com.app.exceptions.EntityNotFoundException;
import com.app.school.models.SchoolEntity;
import com.app.school.models.CreateSchoolPayload;
import com.app.school.models.SchoolProxy;
import com.app.school.models.UpdateSchoolPayload;
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
    public ResponseEntity<SchoolProxy> createSchool(
        @RequestBody final CreateSchoolPayload schoolPayload,
        final HttpServletRequest request,
        final UriComponentsBuilder builder
    ) {
        SchoolEntity entity = this.schoolService.createSchool(schoolPayload);
        UriComponents uriComponents = builder.path(
            request.getRequestURI()
            + "/"
            + entity.getId()
        ).build();
        return ResponseEntity.created(uriComponents.toUri()).build();
    }

    @GetMapping
    public ResponseEntity<ArrayProxy<SchoolProxy>> getSchools() {
        List<SchoolEntity> entities = this.schoolService.getSchools();
        return ResponseEntity.ok(
            new ArrayProxy<SchoolProxy>(
                entities.size(),
                entities
                    .stream()
                    .map(entity -> entity.toProxy())
                    .collect(Collectors.toList())
            )
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<SchoolProxy> getSchool(
        @PathVariable final String id
    ) {
        try {
            SchoolEntity entity = this.schoolService.getSchool(id);
            return ResponseEntity.ok(entity.toProxy());
        } catch (EntityNotFoundException exception) {
            return ResponseEntity.notFound().build();
        }
        
    }

    @GetMapping("/{id}/courses")
    public ResponseEntity<ArrayProxy<CourseProxy>> getCourses(
        @PathVariable final String id
    ) {
        try {
            List<CourseEntity> entities = this.schoolService.getCourses(id);
            return ResponseEntity.ok(
                new ArrayProxy<CourseProxy>(
                    entities.size(),
                    entities
                        .stream()
                        .map(entity -> entity.toProxy())
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
        @RequestBody final UpdateSchoolPayload updateSchoolPayload
    ) {
        try {
            this.schoolService.updateSchool(id, updateSchoolPayload);
            return ResponseEntity.ok().build();
        } catch (EntityNotFoundException exception) {
            return ResponseEntity.notFound().build();
        }
    }

}
