package com.project.school.services;

import java.util.List;

import com.project.school.payloads.StudentDto;


public interface StudentService {
	StudentDto createStudent(StudentDto studentDto);

	StudentDto updateStudent(StudentDto studentDto, Integer studentId);

	StudentDto getStudentById(Integer studentId);

	List<StudentDto> getAllStudents();

	void deleteStudent(Integer studentId);
}
