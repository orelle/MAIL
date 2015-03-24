package fr.dauphine.mail.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import fr.dauphine.mail.dao.ContratDAOImpl;
import fr.dauphine.mail.entities.Contrat;
import fr.dauphine.mail.entities.Labo;
import fr.dauphine.mail.entities.Medecin;

public class ContratServiceImpl extends BaseService<Contrat, Long> {

	public ContratServiceImpl() {
		super(new ContratDAOImpl());
	}

	public List<Contrat> getAllContratByMedecin(Medecin m) {
		Transaction tx = null;
		List<Contrat> ls = null;
		Session session = getSession();
		try {
			tx = session.beginTransaction();
			ls = ((ContratDAOImpl)dao).getAllContratByMedecin(m);
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
		return ls;
	}
	
	public List<Contrat> getAllContratByLabo(Labo labo){
		Transaction tx = null;
		List<Contrat> ls = null;
		Session session = getSession();
		try {
			tx = session.beginTransaction();
			ls = ((ContratDAOImpl)dao).getAllContratByLabo(labo);
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
		return ls;
	}

}
