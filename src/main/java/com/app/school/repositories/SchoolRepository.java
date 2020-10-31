package com.app.school.repositories;

import com.app.common.BaseRepository;
import com.app.school.models.SchoolEntity;
import com.app.school.models.CreateSchoolPayload;
import com.app.school.models.UpdateSchoolPayload;

import org.springframework.stereotype.Component;

@Component
public class SchoolRepository 
    extends BaseRepository<
        SchoolEntity,
        CreateSchoolPayload,
        UpdateSchoolPayload
> { }
