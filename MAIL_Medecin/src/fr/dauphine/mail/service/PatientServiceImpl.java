package fr.dauphine.mail.service;

import fr.dauphine.mail.dao.PatientDAOImpl;
import fr.dauphine.mail.entities.Patient;

public class PatientServiceImpl extends BaseService<Patient, Long>{
	
	public PatientServiceImpl() {
		super(new PatientDAOImpl());
	}

}
