package com.app.school.controllers;

import java.util.List;
import java.util.stream.Collectors;

import com.app.common.ArrayProxy;
import com.app.course.models.CourseProxy;
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

@RestController
@RequestMapping(value = "schools")
public class SchoolController {

    @Autowired
    private SchoolService schoolService;

    public SchoolController() { }

    @PostMapping
    public ResponseEntity<SchoolProxy> createSchool(
        @RequestBody CreateSchoolPayload schoolPayload
    ) {
        SchoolEntity entity = this.schoolService.createSchool(schoolPayload);
        return ResponseEntity.ok(entity.toProxy());
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
        @PathVariable String id
    ) {
        SchoolEntity entity = this.schoolService.getSchool(id);
        if (entity == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(entity.toProxy());
    }

    // still not implemented
    @GetMapping("/{id}/courses")
    public ResponseEntity<ArrayProxy<CourseProxy>> getCourses(
        @PathVariable String id
    ) {
        SchoolEntity entity = this.schoolService.getSchool(id);
        if (entity == null)
            return ResponseEntity.notFound().build();
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSchool(@PathVariable String id) {
        if (!this.schoolService.contains(id))
            return ResponseEntity.notFound().build();

        this.schoolService.deleteSchool(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateSchool(
        @PathVariable String id, 
        @RequestBody UpdateSchoolPayload updateSchoolPayload
    ) {
        if (!this.schoolService.contains(id))
            return ResponseEntity.notFound().build();

        this.schoolService.updateSchool(id, updateSchoolPayload);
        return ResponseEntity.ok().build();
    }

}
