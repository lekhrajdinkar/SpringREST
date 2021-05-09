package com.lekhraj.sb.repository.customRepo;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public  abstract class AbstractDAO<T extends Serializable> implements IGenericDAO<T>
{
	    private Class<T> clazz;
	 
	    @Autowired
	    SessionFactory sessionFactory;
	 
	    public void setClazz(Class< T > clazzToSet){
	       this.clazz = clazzToSet;
	    }
	    
	    protected Session getCurrentSession() {
	        return sessionFactory.getCurrentSession();
	    }
	 
	    @Override
	    public T findOne(long id){
	      return (T) getCurrentSession().get(clazz, id);
	    }

	    @Override
	    public List findAll() {
	        return getCurrentSession().createQuery("from " + clazz.getName()).list();
	    }

	    @Override
		public T create(T entity) {
	        getCurrentSession().saveOrUpdate(entity);
	        return entity;
	    }

	    @Override
	    public T update(T entity) {
	        return (T) getCurrentSession().merge(entity);
	    }

	    @Override
	    public T delete(T entity) {
	        getCurrentSession().delete(entity);
	        return entity;
	    }

	    @Override
	    public void deleteById(long entityId) {
	        T entity = findOne(entityId);
	        delete(entity);
	    }

		

	    
	}