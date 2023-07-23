package com.project.school.payloads;

import java.util.Date;


public class TestDto {
	
	private int id ;
	
	private String subject ;
	
	private int duration ; 
	
	private Date date ; 
	
	private TeacherDto teacher ;

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

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public TeacherDto getTeacher() {
		return teacher;
	}

	public void setTeacher(TeacherDto teacher) {
		this.teacher = teacher;
	}

	public TestDto(int id, String subject, int duration, Date date, TeacherDto teacher) {
		super();
		this.id = id;
		this.subject = subject;
		this.duration = duration;
		this.date = date;
		this.teacher = teacher;
	}

	public TestDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
