package com.edu.spring.controller;

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
import org.springframework.web.servlet.ModelAndView;

import com.edu.spring.dao.PhysicianDAO;
import com.edu.spring.pojo.Physician;
import com.edu.spring.validator.PatientValidator;
import com.edu.spring.validator.PhysicianValidator;

@Controller
public class PhysicianController {
	@Autowired
	PhysicianDAO physicianDAO;

	@Autowired
	@Qualifier("physicianValidator")
	PhysicianValidator validator;

	@Autowired
	@Qualifier("patientValidator")
	PatientValidator PatientValidator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}

	@RequestMapping(value = "/physician/add_physician", method = RequestMethod.GET)
	protected ModelAndView registerUser() throws Exception {
		return new ModelAndView("add_physician", "physician", new Physician());
	}

	@RequestMapping(value = "/physician/add_physician", method = RequestMethod.POST)
	protected ModelAndView registerNewUser(HttpServletRequest request, @ModelAttribute("physician") Physician physician,
			BindingResult result) throws Exception {
		validator.validate(physician, result);
		if (result.hasErrors()) {
			return new ModelAndView("admin_home", "physician", physician);
		}
		try {
			
			Physician p = physicianDAO.registerPhysician(physician);
			request.getSession().setAttribute("physician", p);
			return new ModelAndView("add_success", "physician", p);
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			return new ModelAndView("error", "errorMessage", "Username already exists");
		}
	}

}
