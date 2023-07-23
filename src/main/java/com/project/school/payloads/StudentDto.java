package com.project.school.payloads;

public class StudentDto {
private int id ; 
	
	private String name ; 
	private String email ;
	private String address ; 
	private int mobile_number ;
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
	public StudentDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StudentDto(int id, String name, String email, String address, int mobile_number) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.address = address;
		this.mobile_number = mobile_number;
	}
}
