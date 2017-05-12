package com.edu.spring.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.edu.spring.pojo.Patient;
import com.edu.spring.pojo.Physician;

public class PatientValidator implements Validator {
	public boolean supports(Class aClass) {
		return aClass.equals(Patient.class);
	}

	public void validate(Object obj, Errors errors) {
		Patient newPatient = (Patient) obj;

	}
}
