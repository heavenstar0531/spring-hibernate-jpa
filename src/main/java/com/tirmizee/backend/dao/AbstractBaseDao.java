package com.tirmizee.backend.dao;

import javax.persistence.Query;

public abstract class AbstractBaseDao {
	
	@SuppressWarnings("unchecked")
	<T> T getResultList(Query query){
		return (T) query.getResultList();
	}
	
}
