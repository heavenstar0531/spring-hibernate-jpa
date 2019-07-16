package com.tirmizee.backend.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class StoredProcedureDaoImpl implements StoredProcedureDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void callStoredProcedure(String procedureName) {
		entityManager.createStoredProcedureQuery("STORE_HELLO_WORLD").execute();
	}
	
}
