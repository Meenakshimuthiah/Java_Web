package com.edu.spring.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class VitalHistory {
	@Id
	@GeneratedValue
	private int vitalId;
	private int height;
	private int weight;
	private int systolicBp;
	private int diastolicBp;
	private int choldl;
	private int chohdl;
	private int pulse;
	private double bmi;
	private String date;
	@ManyToOne
	private Patient patient;

	public VitalHistory() {
		super();
	}

	public VitalHistory(int height, int weight, int systolicBp, int diastolicBp, int choldl, int chohdl, int pulse,
			double bmi, Patient patient,String date) {
		super();
		this.height = height;
		this.weight = weight;
		this.systolicBp = systolicBp;
		this.diastolicBp = diastolicBp;
		this.choldl = choldl;
		this.chohdl = chohdl;
		this.pulse = pulse;
		this.bmi = bmi;
		this.patient = patient;
		this.date = date;
	}

	public int getVitalId() {
		return vitalId;
	}

	public void setVitalId(int vitalId) {
		this.vitalId = vitalId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getSystolicBp() {
		return systolicBp;
	}

	public void setSystolicBp(int systolicBp) {
		this.systolicBp = systolicBp;
	}

	public int getDiastolicBp() {
		return diastolicBp;
	}

	public void setDiastolicBp(int diastolicBp) {
		this.diastolicBp = diastolicBp;
	}

	public int getCholdl() {
		return choldl;
	}

	public void setCholdl(int choldl) {
		this.choldl = choldl;
	}

	public int getChohdl() {
		return chohdl;
	}

	public void setChohdl(int chohdl) {
		this.chohdl = chohdl;
	}

	public int getPulse() {
		return pulse;
	}

	public void setPulse(int pulse) {
		this.pulse = pulse;
	}

	public double getBmi() {
		return bmi;
	}

	public void setBmi(double bmi) {
		this.bmi = bmi;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

}
