package com.app.course.models;

import com.app.common.ModifyEntity;

public class UpdateCoursePayload implements ModifyEntity<CourseEntity> {

	public String responsibleTeacher;

	@Override
	public void modifyEntity(CourseEntity entity) {
		entity.setResponsibleTeacher(responsibleTeacher);
	}
    
}
