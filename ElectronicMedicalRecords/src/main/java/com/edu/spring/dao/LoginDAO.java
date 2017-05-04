package com.edu.spring.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.edu.spring.exception.LoginException;
import com.edu.spring.pojo.LoginDetails;

public class LoginDAO extends DAO {

	public LoginDAO() {
	}

	public LoginDetails get(String username, String password) throws LoginException {
		try {
			begin();
			Query q = getSession().createQuery("from LoginDetails where username = :username and pwd = :pwd");
			q.setString("username", username);
			q.setString("pwd", password);

			LoginDetails user = (LoginDetails) q.uniqueResult();
			commit();
			close();
			return user;
		} catch (HibernateException e) {
			rollback();
			throw new LoginException("Could not get user " + username, e);
		}
	}

	public void add(String username, String password, String role) throws LoginException {
		try {
			begin();
			LoginDetails l = new LoginDetails();
			l.setUsername(username);
			l.setPassword(password);
			l.setRole(role);
			getSession().save(l);
			commit();
			close();
		} catch (HibernateException e) {
			rollback();
			throw new LoginException("could not add user" + username, e);
		}
	}

}