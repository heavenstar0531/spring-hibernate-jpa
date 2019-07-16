package com.tirmizee.core.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tirmizee.core.entities.DemoCustomer;

public interface DemoCustomerRepository extends BaseRepository<DemoCustomer,Integer>{

	@Query(name="HQL_ALL_CUSTOMER")
	public List<DemoCustomer> allCustomerHql();
	
	@Query(name="SQL_ALL_CUSTOMER")
	public List<DemoCustomer> allCustomerSql();
	
	@Query(name="SQL_ALL_CUSTOMER_BY_EMAIL")
	public List<DemoCustomer> allCustomerSql(@Param("EMAIL") String email);
	
}