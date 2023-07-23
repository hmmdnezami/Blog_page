package com.project.school.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Discussion {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int id ; 
	
	private String subject; 
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Teacher teacher ;
	
//	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	private List<Student> students = new ArrayList<>();

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

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

//	public List<Student> getStudents() {
//		return students;
//	}
//
//	public void setStudents(List<Student> students) {
//		this.students = students;
//	}

	public Discussion(int id, String subject, Teacher teacher, List<Student> students) {
		super();
		this.id = id;
		this.subject = subject;
		this.teacher = teacher;
//		this.students = students;
	}

	public Discussion() {
		super();
		// TODO Auto-generated constructor stub
	} 
	
	
}
