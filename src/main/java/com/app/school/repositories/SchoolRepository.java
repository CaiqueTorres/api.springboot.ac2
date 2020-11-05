package com.app.school.repositories;

import com.app.common.BaseRepository;
import com.app.school.models.School;
import com.app.school.models.CreateSchoolDTO;
import com.app.school.models.UpdateSchoolDTO;

import org.springframework.stereotype.Component;

@Component
public class SchoolRepository 
    extends BaseRepository<
        School,
        CreateSchoolDTO,
        UpdateSchoolDTO
> { }
