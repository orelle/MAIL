package fr.dauphine.mail.service;

import fr.dauphine.mail.dao.TraitementDAOImpl;
import fr.dauphine.mail.entities.Traitement;

public class TraitementServiceImpl extends BaseService<Traitement, Long>{
	public TraitementServiceImpl() {
		super(new TraitementDAOImpl());
	}

}
