package com.tirmizee.core.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.tirmizee.core.entities.DemoDept;

@Repository
public class CustomDemoDeptRepositoryImpl implements CustomDemoDeptRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	 
	public List<DemoDept> dname(String dname) {
		return null;
	}

}
