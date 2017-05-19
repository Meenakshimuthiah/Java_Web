package com.edu.spring.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.edu.spring.dao.PatientDAO;
import com.edu.spring.exception.AdminException;
import com.edu.spring.pojo.AppointmentDetails;
import com.edu.spring.pojo.Patient;
import com.edu.spring.pojo.Physician;
import com.edu.spring.pojo.VitalHistory;

@Controller
public class ViewDetailsController {
	@Autowired
	PatientDAO patientDAO;

	@RequestMapping(value = "/patient/search_appointment", method = RequestMethod.POST)
	public ModelAndView searchPatient(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String query = request.getParameter("date");
		Physician p;
		try {
			p = patientDAO.searchPhysician(query);
			session.setAttribute("date", query);
			return new ModelAndView("view_details", "physician", p);
		} catch (AdminException e) {
			System.out.println("Exception: " + e.getMessage());
			session.setAttribute("errorMessage", "Appointment Does not exists");
			return new ModelAndView("error", "error", null);
		}

	}

	@RequestMapping(value = "/patient/search_appointment", method = RequestMethod.GET)
	public ModelAndView searchOldPatient(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String query = (String) session.getAttribute("date");
		Physician p;
		try {
			p = patientDAO.searchPhysician(query);
			return new ModelAndView("view_details", "physician", p);
		} catch (AdminException e) {
			System.out.println("Exception: " + e.getMessage());
			session.setAttribute("errorMessage", "Appointment Does not exists");
			return new ModelAndView("error", "error", null);
		}

	}

	@RequestMapping(value = "/patient/view_apptdetails", method = RequestMethod.GET)
	public ModelAndView addapptDetails(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Patient u = (Patient) session.getAttribute("p");
		String date = (String) session.getAttribute("date");
		long query = u.getUId();
		AppointmentDetails a = patientDAO.searchAppointment(query, date);
		return new ModelAndView("view_apptdetails", "a", a);
	}

	@RequestMapping(value = "/patient/view_vitals", method = RequestMethod.GET)
	public ModelAndView viewVitals(HttpServletRequest request) {
		List<VitalHistory> list = new ArrayList<VitalHistory>();
		HttpSession session = request.getSession();
		Patient u = (Patient) session.getAttribute("p");
		list = patientDAO.getVitals(u);
		session.setAttribute("size", list.size());
		return new ModelAndView("view_vitals", "list", list);
	}
	

}
