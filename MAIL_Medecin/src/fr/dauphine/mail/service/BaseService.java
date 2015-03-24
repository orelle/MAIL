package fr.dauphine.mail.service;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import fr.dauphine.mail.dao.GenericDAO;
import fr.dauphine.mail.util.HibernateUtil;

public class BaseService<T extends Serializable, PK extends Serializable> {

	protected Session session;
	protected GenericDAO<T, PK> dao;

	public BaseService(GenericDAO<T, PK> dao) {
		session = HibernateUtil.getSessionFactory().openSession();
		this.dao = dao;
		this.dao.setSession(session);
	}

	public Session getSession() {
		if (session == null || !session.isOpen()) {
			session = HibernateUtil.getSessionFactory().openSession();
			dao.setSession(session);
		}
		return session;
	}

	public void create(T entity) {
		Transaction tx = null;
		Session session = getSession();
		try {
			tx = session.beginTransaction();
			this.dao.create(entity);
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

	}

	public void update(T entity) {
		Transaction tx = null;
		Session session = getSession();
		try {
			tx = session.beginTransaction();
			this.dao.update(entity);
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
	}

	public void saveOrUpdate(T entity) {
		Transaction tx = null;
		Session session = getSession();
		try {
			tx = session.beginTransaction();
			this.dao.saveOrUpdate(entity);
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

	}

	public long count() {
		Transaction tx = null;
		long c = 0;
		Session session = getSession();
		try {
			tx = session.beginTransaction();
			c = this.dao.count();
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
		return c;

	}

	public List<T> getAll() {
		List<T> ls = null;
		Transaction tx = null;
		Session session = getSession();
		try {
			tx = session.beginTransaction();
			ls = dao.getAll();
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

	public T findById(PK id) {
		T ret = null;
		Transaction tx = null;
		Session session = getSession();
		try {
			tx = session.beginTransaction();
			ret = dao.findById(id);
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
		return ret;

	}

	public T findByProperty(Class<T> entityClass, String propertyName,
			Object value) {
		T ret = null;
		Transaction tx = null;
		Session session = getSession();
		try {
			tx = session.beginTransaction();
			ret = dao.findByProperty(entityClass, propertyName, value);
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
		return ret;
		
	}

	public void deleteById(PK id) {
		Transaction tx = null;
		Session session = getSession();
		try {
			tx = session.beginTransaction();
			dao.delete(dao.findById(id));
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

	}

	public void delete(T entity) {
		Transaction tx = null;
		Session session = getSession();
		try {
			tx = session.beginTransaction();
			dao.delete(entity);
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

	}
	

}
