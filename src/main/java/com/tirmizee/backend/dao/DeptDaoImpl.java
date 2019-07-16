package com.tirmizee.backend.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.tirmizee.backend.dto.DeptDTO;
import com.tirmizee.core.entities.DemoDept;


@Repository
public class DeptDaoImpl extends AbstractBaseDao implements DeptDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<DemoDept> findByCriteria(DeptDTO search) {
		
		StringBuilder nativeQuery = new StringBuilder(" SELECT * FROM DEMO_DEPT WHERE DEPTNO IS NOT NULL ");
		
		if (search.getDname() != null) {
			nativeQuery.append(" AND DNAME =:DNAME ");
		}
		
		if (search.getLoc() != null) {
			nativeQuery.append(" AND LOC =:LOC ");
		}
		
		Query query = entityManager.createNativeQuery(nativeQuery.toString(), DemoDept.class);
		
		if (search.getLoc() != null) {
			query.setParameter("LOC", search.getLoc());
		}
		
		if (search.getDname() != null) {
			query.setParameter("DNAME", search.getDname());
		}

		return getResultList(query);
	}
	
	@Override
	public List<DemoDept> findByCriteriaQuery(DeptDTO search) {
		
		CriteriaBuilder criteria = entityManager.getCriteriaBuilder();
		CriteriaQuery<DemoDept> criteriaQuery = criteria.createQuery(DemoDept.class);
		Root<DemoDept> rootQuery = criteriaQuery.from(DemoDept.class);
		
		List<Predicate> predicates = new ArrayList<>();
		
		if (search.getLoc() != null) {
			 predicates.add(criteria.equal(rootQuery.get("loc"), search.getLoc()));
		}
		
		if (search.getDname() != null) {
			 predicates.add(criteria.equal(rootQuery.get("dname"), search.getDname()));
		}
		
		criteriaQuery.where(predicates.toArray(new Predicate[0]));
		
		return entityManager.createQuery(criteriaQuery).getResultList();
	}
	
}
