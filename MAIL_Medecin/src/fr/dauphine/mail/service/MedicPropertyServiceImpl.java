package fr.dauphine.mail.service;

import fr.dauphine.mail.dao.MedicamentPropertyDOAImpl;
import fr.dauphine.mail.entities.MedicamentProperty;

public class MedicPropertyServiceImpl extends BaseService<MedicamentProperty, Long> {

	public MedicPropertyServiceImpl() {
		super(new MedicamentPropertyDOAImpl());
	}

}
