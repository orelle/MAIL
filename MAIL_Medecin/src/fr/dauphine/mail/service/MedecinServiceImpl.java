package fr.dauphine.mail.service;

import java.util.List;

import fr.dauphine.mail.dao.MedecinDAOImpl;
import fr.dauphine.mail.entities.Contrat;
import fr.dauphine.mail.entities.Medecin;

public class MedecinServiceImpl extends BaseService<Medecin, Long>{

	public MedecinServiceImpl() {
		super( new MedecinDAOImpl());
	}
	
	public List<Contrat> getContrats(Medecin m){
		ContratServiceImpl cService = new ContratServiceImpl();
		List<Contrat> ls = cService.getAllContratByMedecin(m);
		return ls;
	}
	

}
