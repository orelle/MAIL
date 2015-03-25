package fr.dauphine.mail.service;

import fr.dauphine.mail.dao.MedicamentDAOImpl;
import fr.dauphine.mail.entities.Medicament;

public class MedicamentServiceImpl extends BaseService<Medicament, Long> {
	public MedicamentServiceImpl() {
		super(new MedicamentDAOImpl());
	}
	
	
}
