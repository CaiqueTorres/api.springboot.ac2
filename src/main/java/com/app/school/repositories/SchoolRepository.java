package com.app.school.repositories;

import com.app.common.Ac2Repository;
import com.app.school.models.SchoolEntity;
import com.app.school.models.CreateSchoolPayload;
import com.app.school.models.UpdateSchoolPayload;

import org.springframework.stereotype.Component;

@Component
public class SchoolRepository 
    extends Ac2Repository<
        SchoolEntity,
        CreateSchoolPayload,
        UpdateSchoolPayload
> { }
