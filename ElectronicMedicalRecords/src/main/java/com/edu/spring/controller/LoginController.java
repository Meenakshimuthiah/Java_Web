package com.edu.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.edu.spring.dao.LoginDAO;
import com.edu.spring.exception.LoginException;
import com.edu.spring.pojo.LoginDetails;

@Controller
public class LoginController {
	@Autowired
	LoginDAO loginDAO;
	
	@RequestMapping(value="/user/login", method = RequestMethod.GET)
	protected String login(HttpServletRequest request) throws Exception {
		return "index";
	}
	@RequestMapping(value = "/user/login", method = RequestMethod.POST)
	protected String loginUser(HttpServletRequest request) throws Exception {
		HttpSession session = (HttpSession) request.getSession();
		if (request.getParameter("username").equalsIgnoreCase("admin")
				&& request.getParameter("password").equalsIgnoreCase("admin")) {
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
				if(u.getRole().equalsIgnoreCase("Patient")) {
					session.setAttribute("user", u);
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
	
	@RequestMapping(value="/user/logout", method = RequestMethod.GET)
	public String logoutUser(HttpServletRequest request) throws Exception{
		HttpSession session = request.getSession();
		session.setAttribute("user", null);
		return "index";
	}
}
