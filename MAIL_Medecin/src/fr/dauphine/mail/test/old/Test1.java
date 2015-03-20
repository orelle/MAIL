package fr.dauphine.mail.test.old;

import org.hibernate.Session;
import org.hibernate.Transaction;

import fr.dauphine.mail.entities.Labo;
import fr.dauphine.mail.util.HibernateUtil;

public class Test1 {
	
	public static void main(String[] args) {
		Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            Labo labo = new Labo();
            labo.setNom("nomLabo");
            //labo.setIdLabo(2L);
            session.save(labo);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
	}

}
