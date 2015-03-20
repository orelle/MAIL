package fr.dauphine.mail.service;

import fr.dauphine.mail.dao.SymptomeDAOImpl;
import fr.dauphine.mail.entities.Symptome;

public class SymptomeServiceImpl extends BaseService<Symptome, Long>{
	
	public SymptomeServiceImpl() {
		super(new SymptomeDAOImpl());
	}

}
