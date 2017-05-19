package com.edu.spring.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class AppointmentDetails {
	@Id
	@GeneratedValue
	@Column(name = "AppointmentId", unique = true, nullable = false)
	private int appointmentId;
	private String appointmentDate;
	private String reasonForVisit;
	private String appointmentDesc;
	@ManyToOne(cascade = CascadeType.MERGE)
	private Patient patient;
	@ManyToOne(cascade = CascadeType.MERGE)
	private Physician physician;

	public AppointmentDetails() {
		super();
	}

	public AppointmentDetails(int appointmentId, String appointmentDate, String reasonForVisit, String appointmentDesc,
			Patient patient, Physician physician) {
		this.physician = physician;
		this.appointmentId = appointmentId;
		this.appointmentDate = appointmentDate;
		this.reasonForVisit = reasonForVisit;
		this.appointmentDesc = appointmentDesc;
		this.patient = patient;
	}

	public Physician getPhysician() {
		return physician;
	}

	public void setPhysician(Physician physician) {
		this.physician = physician;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public int getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}

	public String getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(String appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public String getReasonForVisit() {
		return reasonForVisit;
	}

	public void setReasonForVisit(String reasonForVisit) {
		this.reasonForVisit = reasonForVisit;
	}

	public String getAppointmentDesc() {
		return appointmentDesc;
	}

	public void setAppointmentDesc(String appointmentDesc) {
		this.appointmentDesc = appointmentDesc;
	}

}
