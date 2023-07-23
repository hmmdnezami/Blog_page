package com.project.school.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Teacher {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int id ; 
	
	private String name ; 
	private String email ;
	private String address ; 
	private int mobile_number ;
	
	@OneToMany(mappedBy="teacher" , cascade = CascadeType.ALL , fetch = FetchType.LAZY)
	private List<Discussion> discussions = new ArrayList<>() ; 
	
	@OneToMany(mappedBy="teacher" , cascade = CascadeType.ALL , fetch = FetchType.LAZY)
	private List<Test> tests = new ArrayList<>() ;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getMobile_number() {
		return mobile_number;
	}
	public void setMobile_number(int mobile_number) {
		this.mobile_number = mobile_number;
	}
	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Teacher(int id, String name, String email, String address, int mobile_number) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.address = address;
		this.mobile_number = mobile_number;
	}
}
