package com.edu.spring.pojo;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "UId")
public class Patient extends LoginDetails {

	private String name;
	private String location;
	private int contact;
	private int age;
	private String gender;
	

	public Patient() {

	}

	public Patient(String location, int contact, int age, String gender, String name) {
		
		this.location = location;
		this.contact = contact;
		this.age = age;
		this.gender = gender;
		this.name = name;
	}

	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getContact() {
		return contact;
	}

	public void setContact(int contact) {
		this.contact = contact;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}
