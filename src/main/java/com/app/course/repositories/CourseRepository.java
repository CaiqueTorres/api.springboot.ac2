package com.app.course.repositories;

import com.app.common.BaseRepository;
import com.app.course.models.Course;
import com.app.course.models.CreateCourseDTO;
import com.app.course.models.UpdateCourseDTO;

import org.springframework.stereotype.Component;

@Component
public class CourseRepository
    extends BaseRepository<
        Course,
        CreateCourseDTO,
        UpdateCourseDTO
> { }
