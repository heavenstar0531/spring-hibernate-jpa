package com.tirmizee.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.tirmizee.dto.CustomerDTO;
import com.tirmizee.jpa.entities.DemoCustomer;

@Repository
public class CustomerDaoImpl extends AbstractBaseDao implements CustomerDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<DemoCustomer> allCustomerSql() {
		Session session = entityManager.unwrap(Session.class);
		@SuppressWarnings("unchecked")
		List<DemoCustomer> results = session.getNamedQuery("SQL_ALL_CUSTOMER")
			       .setResultTransformer(Transformers.aliasToBean(DemoCustomer.class))
			       .list();
		return results;
	}
	
}