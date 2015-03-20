package fr.dauphine.mail.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;

public interface GenericDAO<T extends Serializable, PK extends Serializable>{
	/**
     * Create entity
     * @param entity
     */
    void create(T entity);
    
    /**
     * Update entity
     * @param entity
     */
    void update(T entity);
    
    /**
     * Create or Update entity
     * @param entity POJO
     */
    void saveOrUpdate(T entity);
    
    /**
     * Delete entity
     * @param entity
     */
    void delete(T entity);
    
    /**
     * Find entity by id
     * @param id ID
     * @return Entity
     */
    T findById(PK id);
    
    /**
     * Find all entities
     * @return
     */
    List<T> getAll();
    
    
    /**
     * All row count
     * @return
     */
    long count();
    
    T findByProperty(Class<T> entityClass, String propertyName,
			Object value);
    
    void setSession(Session session);

}
