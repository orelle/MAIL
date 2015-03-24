package fr.dauphine.mail.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;

public interface GenericDAO<T extends Serializable, PK extends Serializable>{
	
    void create(T entity);
    
    void update(T entity);
    
    void saveOrUpdate(T entity);
    
    void delete(T entity);
   
    T findById(PK id);
    
    List<T> getAll();
    
    long count();
    
    T findByProperty(Class<T> entityClass, String propertyName,
			Object value);
    
    void setSession(Session session);

}
