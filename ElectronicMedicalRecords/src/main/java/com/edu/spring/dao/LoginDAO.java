package com.edu.spring.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.edu.spring.exception.LoginException;
import com.edu.spring.pojo.LoginDetails;
import com.edu.spring.pojo.Patient;
import com.edu.spring.pojo.Physician;

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

	public List<Physician> getPhysician() {
		begin();
		Query q = getSession().createQuery("from Physician");
		List<Physician> list = new ArrayList<Physician>();
		list = q.list();
		commit();
		close();
		return list;
	}

	public List<Patient> getPatient() {
		begin();
		Query q = getSession().createQuery("from Patient");
		List<Patient> list = new ArrayList<Patient>();
		list = q.list();
		commit();
		close();
		return list;
	}

	public void deletePhysician(String uId) {
		begin();
		Physician p = new Physician();

		p.setUId(Long.parseLong(uId));
		getSession().delete(p);
		commit();
		close();
	}

	public void deletePatient(String uId) {
		begin();
		Patient p = new Patient();
		p.setUId(Long.parseLong(uId));
		getSession().delete(p);
		commit();
		close();

	}

	public List<Patient> getFamily(LoginDetails u) {
		begin();
		Query q = getSession().createQuery("from Patient where UId = :UId");
		q.setLong("UId", u.getUId());
		Patient p = (Patient) q.uniqueResult();
		long id = p.getFamily().getFamilyid();
		Query q1 = getSession().createQuery("from Patient where family_familyid = :id");
		q1.setLong("id",id);
		List<Patient> pList= q1.list();
		return pList;
	}

}