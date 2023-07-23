package com.project.school.services;

import java.util.List;

import com.project.school.payloads.TeacherDto;


public interface TeacherService {
	
	TeacherDto createTeacher(TeacherDto teacher);

	TeacherDto updateTeacher(TeacherDto teacher, Integer teacherId);

	TeacherDto getTeacherById(Integer teacherId);

	List<TeacherDto> getAllTeachers();

	void deleteTeacher(Integer teacherId);
}
