package fr.dauphine.mail.service;

import java.util.List;

import org.hibernate.Query;

import fr.dauphine.mail.dao.ContratDAOImpl;
import fr.dauphine.mail.entities.Contrat;
import fr.dauphine.mail.entities.Labo;
import fr.dauphine.mail.entities.Medecin;

public class ContratServiceImpl extends BaseService<Contrat, Long>{
	
	public ContratServiceImpl() {
		super(new ContratDAOImpl());
	}
	
	public List<Contrat> getAllContratByMedecin(Medecin m){
		
		String hql = "from Contrat as model where model.medecin=?";
		Query query = session.createQuery(hql);
		query.setParameter(0, m);
		return query.list();
		
	}
	public List<Contrat> getAllContratByLabo(Labo labo){
		
		String hql = "from Contrat as model where model.labo=?";
		Query query = session.createQuery(hql);
		query.setParameter(0, labo);
		return query.list();
		
	}
	
	
//	public void deleteById(Long id) {
//		Transaction tx = null;
//		Session session = getSession();
//		try {
//			tx = session.beginTransaction();
//			Contrat c = dao.findById(id);
////			c.setMedicaments(null);
////			dao.update(c);
//			dao.delete(c);
//			session.getTransaction().commit();
//		} catch (RuntimeException e) {
//			if (tx != null) {
//				tx.rollback();
//			}
//			e.printStackTrace();
//		} finally {
//			session.flush();
//			session.close();
//		}
//
//	}

}
