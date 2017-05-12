package com.edu.spring.pojo;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.edu.spring.pojo.Patient;

@Entity
public class Family {
	@Id
	@Column(unique=false)
	private long familyid;

	@OneToMany
	private Set<Patient> patient;

	public Family() {

	}

	public Set<Patient> getPatient() {
		return patient;
	}

	public void setPatient(Set<Patient> patient) {
		this.patient = patient;
	}

	public long getFamilyid() {
		return familyid;
	}

	public void setFamilyid(long familyid) {
		this.familyid = familyid;
	}

}
