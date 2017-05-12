package com.edu.spring.pojo;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Transient;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Entity
@PrimaryKeyJoinColumn(name = "UId")
@OnDelete(action = OnDeleteAction.CASCADE)
public class Patient extends LoginDetails {

	private String name;
	private String location;
	private int contact;
	private int age;
	private String gender;
	@OneToMany(mappedBy = "patient")
	private Set<AppointmentDetails> appointmentDetails;
	@OneToMany(mappedBy = "patient")
	private Set<VitalHistory> vitalHistory;
	@ManyToOne(cascade = CascadeType.ALL)
	private Family family;
	 @Transient
	    private CommonsMultipartFile photo; 
	 @Column(name = "image")
	    private String image;
	    
	public Patient() {

	}

    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    
	public CommonsMultipartFile getPhoto() {
		return photo;
	}

	public void setPhoto(CommonsMultipartFile photo) {
		this.photo = photo;
	}

	public Family getFamily() {
		return family;
	}

	public void setFamily(Family family) {
		this.family = family;
	}

	public Set<AppointmentDetails> getAppointmentDetails() {
		return appointmentDetails;
	}

	public void setAppointmentDetails(Set<AppointmentDetails> appointmentDetails) {
		this.appointmentDetails = appointmentDetails;
	}

	public Set<VitalHistory> getVitalHistory() {
		return vitalHistory;
	}

	public void setVitalHistory(Set<VitalHistory> vitalHistory) {
		this.vitalHistory = vitalHistory;
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
