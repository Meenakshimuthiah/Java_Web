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

import com.edu.spring.dao.PhysicianDAO;
import com.edu.spring.exception.AdminException;
import com.edu.spring.pojo.AppointmentDetails;
import com.edu.spring.pojo.Patient;
import com.edu.spring.pojo.Physician;
import com.edu.spring.pojo.VitalHistory;

@Controller
public class AddDetailsController {
	@Autowired
	PhysicianDAO physicianDAO;

	@RequestMapping(value = "/physician/search_patient", method = RequestMethod.GET)
	public ModelAndView searchPatient(HttpServletRequest request) {
		List<Patient> patients = new ArrayList<Patient>();
		String query = request.getParameter("query");
		patients = physicianDAO.searchPatient(query);
		return new ModelAndView("patient_results", "patients", patients);
	}

	@RequestMapping(value = "/physician/add_details", method = RequestMethod.POST)
	public ModelAndView addDetails(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String patient = request.getParameter("patients");
		Patient u = physicianDAO.getPatient(patient);
		session.setAttribute("patient", u);
		return new ModelAndView("add_details", "patient", u);
	}

	@RequestMapping(value = "/physician/add_details", method = RequestMethod.GET)
	public ModelAndView addOldDetails(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Patient patient = (Patient) session.getAttribute("patient");
		String id = String.valueOf(patient.getUId());
		Patient u = physicianDAO.getPatient(id);
		return new ModelAndView("add_details", "patient", u);
	}

	@RequestMapping(value = "/physician/add_apptdetails", method = RequestMethod.GET)
	public ModelAndView addapptDetails(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Patient u = (Patient) session.getAttribute("patient");
		return new ModelAndView("appt_details", "patient", u);
	}

	@RequestMapping(value = "/physician/add_apptdetails", method = RequestMethod.POST)
	public ModelAndView addnewapptDetails(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Patient u = (Patient) session.getAttribute("patient");
		AppointmentDetails aDetails = new AppointmentDetails();
		aDetails.setReasonForVisit(request.getParameter("reason"));
		aDetails.setAppointmentDate(request.getParameter("date"));
		aDetails.setAppointmentDesc(request.getParameter("desc"));
		Physician p = (Physician) session.getAttribute("user");
		aDetails.setPatient(u);
		aDetails.setPhysician(p);
		AppointmentDetails a;
		try {
			a = physicianDAO.addApptDetails(aDetails);
		} catch (AdminException e) {
			System.out.println("Exception: " + e.getMessage());
			session.setAttribute("errorMessage", "Appointment Alreay exists");
			return new ModelAndView("error", "error", null);
		}
		return new ModelAndView("add_success", "a", a);
	}

	@RequestMapping(value = "/physician/add_vitals", method = RequestMethod.GET)
	public ModelAndView addVitals(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Patient u = (Patient) session.getAttribute("patient");
		return new ModelAndView("add_vitals", "patient", u);
	}

	@RequestMapping(value = "/physician/add_vitals", method = RequestMethod.POST)
	public ModelAndView addnewVitals(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Patient u = (Patient) session.getAttribute("patient");
		VitalHistory v = new VitalHistory();
		v.setBmi(Double.parseDouble(request.getParameter("bmi")));
		v.setChohdl(Integer.parseInt(request.getParameter("chohdl")));
		v.setCholdl(Integer.parseInt(request.getParameter("choldl")));
		v.setDiastolicBp(Integer.parseInt(request.getParameter("diastolicBp")));
		v.setHeight(Integer.parseInt(request.getParameter("height")));
		v.setPulse(Integer.parseInt(request.getParameter("pulse")));
		v.setSystolicBp(Integer.parseInt(request.getParameter("systolicBp")));
		v.setWeight(Integer.parseInt(request.getParameter("weight")));
		v.setPatient(u);
		VitalHistory vi = physicianDAO.addVitals(v);
		return new ModelAndView("add_success", "vi", vi);
	}
	
}
