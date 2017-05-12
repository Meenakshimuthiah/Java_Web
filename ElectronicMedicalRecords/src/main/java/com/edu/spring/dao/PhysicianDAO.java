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

public class PhysicianDAO extends DAO {
	public Physician registerPhysician(Physician physician) throws AdminException {
		// TODO Auto-generated method stub
		try {
			begin();
			System.out.println("inside DAO");
			getSession().save(physician);
			commit();
			return physician;
		} catch (HibernateException e) {
			rollback();
			throw new AdminException("Exception while creating user: " + e.getMessage());
		}
	}

	public List<Patient> searchPatient(String query) {
		List<Patient> patients = new ArrayList<Patient>();
		begin();
		Query q = getSession().createQuery("from Patient where name like :name");
		q.setString("name", '%' + query + '%');
		patients = q.list();
		return patients;
	}

	public Patient getPatient(String query) {
		begin();
		Query q = getSession().createQuery("from Patient where UId = :UId");
		q.setString("UId", query);
		Patient u = (Patient) q.uniqueResult();
		commit();
		close();
		return u;
	}

	public AppointmentDetails addApptDetails(AppointmentDetails aDetails) throws AdminException {
		begin();
		
		Query query = getSession()
				.createQuery("from AppointmentDetails where appointmentDate = :date and patient_UId = :Id");
		query.setString("date", aDetails.getAppointmentDate());
		query.setLong("Id", aDetails.getPatient().getUId());
		if (query.uniqueResult() != null) {
			throw new AdminException("Appointment already exists", new Exception());
		} else {
			getSession().save(aDetails);
		}
		getSession().flush();
		commit();
		getSession().clear();
		return aDetails;

	}

	public VitalHistory addVitals(VitalHistory vitalHistory) {
		begin();
		getSession().save(vitalHistory);
		commit();
		close();
		return vitalHistory;

	}
}
