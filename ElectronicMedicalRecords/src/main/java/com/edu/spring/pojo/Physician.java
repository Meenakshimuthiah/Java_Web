package com.edu.spring.pojo;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@PrimaryKeyJoinColumn(name = "UId")
@OnDelete(action = OnDeleteAction.CASCADE)
public class Physician extends LoginDetails {

	private String name;
	private String location;
	private String practiceType;
	@OneToMany(mappedBy = "physician")
	private Set<AppointmentDetails> appointmentDetails;

	public Physician() {

	}

	public Set<AppointmentDetails> getAppointmentDetails() {
		return appointmentDetails;
	}

	public void setAppointmentDetails(Set<AppointmentDetails> appointmentDetails) {
		this.appointmentDetails = appointmentDetails;
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

	public String getPracticeType() {
		return practiceType;
	}

	public void setPracticeType(String practiceType) {
		this.practiceType = practiceType;
	}

}
