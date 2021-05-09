package com.lekhraj.sb.repository.customRepo;

import java.io.Serializable;
import java.util.List;

public interface IGenericDAO<T> {

	   T findOne(final long id);
	   List<T> findAll();

	   T create(final T entity);
	   T update(final T entity);
	   
	   T delete(final T entity);
	   void deleteById(final long entityId);
	}

