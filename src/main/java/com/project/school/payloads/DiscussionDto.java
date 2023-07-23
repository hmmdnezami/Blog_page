package com.project.school.payloads;

import java.util.ArrayList;
import java.util.List;

public class DiscussionDto {
	
	private int id ; 
	
	private String subject ; 
	
	private TeacherDto teacher ;
	
	private List<StudentDto> studentsDto = new ArrayList<>() ;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public TeacherDto getTeacher() {
		return teacher;
	}

	public void setTeacher(TeacherDto teacher) {
		this.teacher = teacher;
	}

	public List<StudentDto> getStudentsDto() {
		return studentsDto;
	}

	public void setStudentsDto(List<StudentDto> studentsDto) {
		this.studentsDto = studentsDto;
	}

	public DiscussionDto(int id, String subject, TeacherDto teacher, List<StudentDto> studentsDto) {
		super();
		this.id = id;
		this.subject = subject;
		this.teacher = teacher;
		this.studentsDto = studentsDto;
	}

	public DiscussionDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
