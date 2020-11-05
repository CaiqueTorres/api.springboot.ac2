package com.app.course.models;

import com.app.common.ModifyEntity;

public class UpdateCourseDTO implements ModifyEntity<Course> {

	public String responsibleTeacher;

	@Override
	public void modifyEntity(Course entity) {
		entity.setResponsibleTeacher(responsibleTeacher);
	}
    
}
