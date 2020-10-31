package com.app.course.repositories;

import com.app.common.Ac2Repository;
import com.app.course.models.CourseEntity;
import com.app.course.models.CreateCoursePayload;
import com.app.course.models.UpdateCoursePayload;

import org.springframework.stereotype.Component;

@Component
public class CourseRepository
    extends Ac2Repository<
        CourseEntity,
        CreateCoursePayload,
        UpdateCoursePayload
> { }
