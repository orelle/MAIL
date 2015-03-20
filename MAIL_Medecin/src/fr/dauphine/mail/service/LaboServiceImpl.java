package fr.dauphine.mail.service;

import fr.dauphine.mail.dao.LaboDAOImpl;
import fr.dauphine.mail.entities.Labo;

public class LaboServiceImpl extends BaseService<Labo, Long> {

	public LaboServiceImpl() {
		super(new LaboDAOImpl());
	}	

}
