package fr.dauphine.mail.dao;

import java.util.List;

import org.hibernate.Query;

import fr.dauphine.mail.entities.Contrat;
import fr.dauphine.mail.entities.Labo;
import fr.dauphine.mail.entities.Medecin;

public class ContratDAOImpl extends GenericDAOImpl<Contrat, Long> {

	public List<Contrat> getAllContratByMedecin(Medecin m) {
		String hql = "from Contrat as model where model.medecin=?";
		Query query = session.createQuery(hql);
		query.setParameter(0, m);
		return query.list();

	}

	public List<Contrat> getAllContratByLabo(Labo labo) {

		String hql = "from Contrat as model where model.labo=?";
		Query query = session.createQuery(hql);
		query.setParameter(0, labo);
		return query.list();

	}

}
