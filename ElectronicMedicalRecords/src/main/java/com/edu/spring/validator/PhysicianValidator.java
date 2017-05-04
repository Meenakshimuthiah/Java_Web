package com.edu.spring.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.edu.spring.pojo.Patient;
import com.edu.spring.pojo.Physician;

public class PhysicianValidator implements Validator{
	public boolean supports(Class aClass) {
		return aClass.equals(Physician.class);
	}

	public void validate(Object obj, Errors errors) {
		Physician newPhysician = (Physician) obj;
		
		
	}
}
