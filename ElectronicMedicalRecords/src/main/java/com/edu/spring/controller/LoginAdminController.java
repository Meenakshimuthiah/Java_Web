package com.edu.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.edu.spring.dao.LoginDAO;
import com.edu.spring.exception.LoginException;
import com.edu.spring.pojo.LoginDetails;
import com.edu.spring.pojo.Patient;
import com.edu.spring.pojo.Physician;

@Controller
public class LoginAdminController {
	@Autowired
	LoginDAO loginDAO;

	@RequestMapping(value = "/user/login", method = RequestMethod.GET)
	protected String login(HttpServletRequest request) throws Exception {
		return "index";
	}

	@RequestMapping(value = "/user/login", method = RequestMethod.POST)
	protected String loginUser(HttpServletRequest request) throws Exception {
		HttpSession session = (HttpSession) request.getSession();
		if (request.getParameter("username").equalsIgnoreCase("admin")
				&& request.getParameter("password").equalsIgnoreCase("admin")) {
			List<Physician> list = loginDAO.getPhysician();
			List<Patient> plist = loginDAO.getPatient();
			session.setAttribute("list", list);
			session.setAttribute("plist", plist);
			LoginDetails u = new LoginDetails();
			u.setUsername("admin");
			u.setPassword("admin");
			u.setRole("admin");
			session.setAttribute("user", u);
			return "admin_home";
		} else {
			try {
				LoginDetails u = loginDAO.get(request.getParameter("username"), request.getParameter("password"));
				if (u == null) {
					System.out.println("UserName/Password does not exist");
					session.setAttribute("errorMessage", "UserName/Password does not exist");
					return "error";
				}
				if (u.getRole().equalsIgnoreCase("Physician")) {
					session.setAttribute("user", u);
					return "physician_home";
				}
				if (u.getRole().equalsIgnoreCase("Patient")) {
					session.setAttribute("user", u);
					List<Patient> pList = loginDAO.getFamily(u);
					session.setAttribute("pList", pList);
					return "patient_home";
				}
			} catch (LoginException e) {
				System.out.println("Exception: " + e.getMessage());
				session.setAttribute("errorMessage", "error while login");
				return "error";
			}
		}
		return "error";

	}

	@RequestMapping(value = "/user/logout", method = RequestMethod.GET)
	public String logoutUser(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		session.setAttribute("user", null);
		return "index";
	}

	@RequestMapping(value = "/admin/delete_physician", method = RequestMethod.POST)
	public String deletePhysician(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		String UId = request.getParameter("physician");
		loginDAO.deletePhysician(UId);
		List<Physician> list = loginDAO.getPhysician();
		List<Patient> plist = loginDAO.getPatient();
		session.setAttribute("list", list);
		session.setAttribute("plist", plist);
		return "admin_home";
	}

	@RequestMapping(value = "/admin/delete_patient", method = RequestMethod.POST)
	public String deletePatient(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		String UId = request.getParameter("patient");
		loginDAO.deletePatient(UId);
		List<Physician> list = loginDAO.getPhysician();
		List<Patient> plist = loginDAO.getPatient();
		session.setAttribute("list", list);
		session.setAttribute("plist", plist);
		return "admin_home";
	}

	@RequestMapping(value = "/admin/home", method = RequestMethod.GET)
	public String adminHome(HttpServletRequest request) {
		HttpSession session = (HttpSession) request.getSession();
		List<Physician> list = loginDAO.getPhysician();
		List<Patient> plist = loginDAO.getPatient();
		session.setAttribute("list", list);
		session.setAttribute("plist", plist);
		return "admin_home";
	}
}
