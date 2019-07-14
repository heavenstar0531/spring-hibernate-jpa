package com.tirmizee.core.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.tirmizee.backend.dto.DeptDTO;
import com.tirmizee.domain.entities.DemoDept;

@Repository
public class DeptDaoImpl implements DeptDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<DemoDept> findByCriteria(DeptDTO search) {
		StringBuilder nativeQuery = new StringBuilder()
			.append(" SELECT * FROM DEMO_DEPT WHERE DEPTNO IS NOT NULL AND DNAME =:DNAME ");
		Query query = entityManager.createNativeQuery(nativeQuery.toString(), DemoDept.class);
		query.setParameter("DNAME", search.getDname());
		return query.getResultList();
	}
	
	
	
}
