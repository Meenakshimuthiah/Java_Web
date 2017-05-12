package com.edu.spring.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.edu.spring.dao.PatientDAO;
import com.edu.spring.pojo.Patient;
import com.edu.spring.validator.PatientValidator;

@Controller
public class PatientController {
	@Autowired
	PatientDAO patientDAO;

	@Autowired
	@Qualifier("patientValidator")
	PatientValidator validator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}

	@RequestMapping(value = "/patient/add_patient", method = RequestMethod.GET)
	protected ModelAndView registerUser() throws Exception {
		return new ModelAndView("add_patient", "patient", new Patient());
	}

	@RequestMapping(value = "/patient/add_patient", method = RequestMethod.POST)
	protected ModelAndView registerNewUser(HttpServletRequest request, @ModelAttribute("patient") Patient patient,
			BindingResult result) throws Exception {
		validator.validate(patient, result);
//		if (result.hasErrors()) {
//			return new ModelAndView("admin_home", "patient", patient);
//		}
		try {
			File directory;
            CommonsMultipartFile photoInMemory = null;
            File localFile = null;
            String path = "D:\\Images\\";
            directory = new File(path);
            boolean temp = directory.exists();
            if (!temp) {
                temp = directory.mkdir();
            }
            if (temp) {
                photoInMemory = patient.getPhoto();
                localFile = new File(directory.getPath(), patient.getName()+"_".toString() + ".jpg");
                patient.setImage(localFile.getPath());
                photoInMemory.transferTo(localFile);
            } else {
                System.out.println("Failed to create directory!");
            }
			System.out.println("register New User");
			Patient p = patientDAO.registerPhysician(patient);
			request.getSession().setAttribute("patient", p);
			return new ModelAndView("add_success", "patient", p);
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			return new ModelAndView("error", "errorMessage", "Username Already exists");
		}
	}
}
