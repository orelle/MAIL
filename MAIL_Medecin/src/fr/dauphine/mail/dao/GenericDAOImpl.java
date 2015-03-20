package fr.dauphine.mail.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;



import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;

import fr.dauphine.mail.util.HibernateUtil;

public class GenericDAOImpl<T extends Serializable, PK extends Serializable> implements GenericDAO<T, PK> {
	// Entity class
    private Class<T> entityClass;
    Session session;

    /**
     * Constructor
     */
    public GenericDAOImpl() {
        this.entityClass = (Class<T>) ((ParameterizedType) this.getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }
    
    /**
     * Create entity
     * @param entity
     */
    @Override
    public void create(T entity) {
        session.save(entity);
    }

    /**
     * Update entity
     * @param entity
     */
    @Override
    public void update(T entity) {
        session.update(entity);
    }

    /**
     * Create or Update entity
     * @param entity
     */
    @Override
    public void saveOrUpdate(T entity) {
        session.saveOrUpdate(entity);
    }
    
    /**
     * Delete entity
     * @param entity
     */
    public void delete(T entity){
        session.delete(entity);
    }

    /**
     * Find entity by id
     * @param id
     * @return Entity
     */
    @Override
    public T findById(PK id) {
        return (T) session.get(entityClass, id);
    }

    /**
     * Find all entities
     * @return
     */
    @Override
    public List<T> getAll() {
        return session.createCriteria(entityClass).list();
    }
    
    /**
     * Find all entities by paging
     * @param pageNumber
     * @param pageSize
     * @return
     */
    
    /**
     * All row count
     * @return
     */
    @Override
    public long count() {
        Long count = (Long)session.createCriteria(entityClass)
                .setProjection(Projections.rowCount())
                .uniqueResult();
        if(count == null) {
            return (long)0;
        }
        else {
            return count;
        }
    }

	public Session getSession() {
		return session;
	}
	
	@Override
	public T findByProperty(Class<T> entityClass, String propertyName,
			Object value) {
		String hql = "from " + entityClass.getName() + " as model where model."
				+ propertyName + "=?";
		Query query = session.createQuery(hql);
		query.setParameter(0, value);
		List<T> list = query.list();
		if (null != list) {
			return list.get(0);
		} else {
			return null;
		}
	}

	public void setSession(Session session) {
		this.session = session;
	}
    
   

}
