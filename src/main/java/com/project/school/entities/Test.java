package com.project.school.entities;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Test {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int id ; 
	
	private String subject ;
	
	private int duration ;
	
	private Date date ; 
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Teacher teacher ;
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
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public Test(int id, String subject, int duration, Date date, Teacher teacher) {
		super();
		this.id = id;
		this.subject = subject;
		this.duration = duration;
		this.date = date;
		this.teacher = teacher;
	}
	public Test() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
