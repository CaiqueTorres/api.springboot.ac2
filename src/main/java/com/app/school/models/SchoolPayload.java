package com.app.school.models;

import com.app.common.ToEntity;

public class SchoolPayload implements ToEntity<SchoolEntity> {

    public String name;
    public String address;

    @Override
    public SchoolEntity toEntity() {
        return new SchoolEntity(name, address);
    }

}
