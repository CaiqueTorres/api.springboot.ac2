package com.app.school.models;

import com.app.common.BaseEntity;
import com.app.common.ToProxy;

public class SchoolEntity extends BaseEntity implements ToProxy<SchoolProxy> {

    private String name;
    private String address;

    public SchoolEntity(String name, String address) {
        this.name = name;
        this.address = address;
    }

    @Override
    public SchoolProxy toProxy() {
        return new SchoolProxy(name, address);
    }

}
