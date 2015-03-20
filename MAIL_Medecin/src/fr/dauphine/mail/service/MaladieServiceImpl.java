package fr.dauphine.mail.service;

import fr.dauphine.mail.dao.MaladieDAOImpl;
import fr.dauphine.mail.entities.Maladie;

public class MaladieServiceImpl extends BaseService<Maladie, Long> {
	
	public MaladieServiceImpl() {
		super(new MaladieDAOImpl());
	}

}
