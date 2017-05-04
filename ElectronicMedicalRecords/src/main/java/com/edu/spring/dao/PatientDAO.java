package com.edu.spring.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.edu.spring.exception.AdminException;
import com.edu.spring.pojo.AppointmentDetails;
import com.edu.spring.pojo.Patient;
import com.edu.spring.pojo.Physician;
import com.edu.spring.pojo.VitalHistory;

public class PatientDAO extends DAO {

	public Patient registerPhysician(Patient patient) throws AdminException {
		// TODO Auto-generated method stub
		try {
			begin();
			System.out.println("inside DAO");

			getSession().save(patient);
			commit();
			return patient;

		} catch (HibernateException e) {
			rollback();
			throw new AdminException("Exception while creating user: " + e.getMessage());
		}
	}

	public Physician searchPhysician(String query) throws AdminException {
		// TODO Auto-generated method stub
		begin();
		Query q = getSession().createQuery("from AppointmentDetails where appointmentDate = :date");
		q.setString("date", query);
		AppointmentDetails a = (AppointmentDetails) q.uniqueResult();
		if(a==null){
			throw new AdminException("Appointment does not exists",new Exception());
		}
		Physician u = a.getPhysician();
		
		commit();
		close();
		return u;
	}
	
	public AppointmentDetails searchAppointment(long query,String date) {
		// TODO Auto-generated method stub
		begin();
		Query q = getSession().createQuery("from AppointmentDetails where patient_UId = :UId and appointmentDate = :date");
		q.setLong("UId", query);
		q.setString("date", date);
		AppointmentDetails a = (AppointmentDetails) q.uniqueResult();
		
		commit();
		close();
		return a;
	}

	public List<VitalHistory> getVitals(Patient u) {
		begin();
		Query q = getSession().createQuery("from VitalHistory where patient_UId = :UId");
		q.setLong("UId", u.getUId());
		List<VitalHistory> list = new ArrayList<VitalHistory>();
		list = q.list();
		commit();
		close();
		return list;
	}
}
