package com.tirmizee.jpa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.tirmizee.jpa.entities.DemoCustomer;

public interface DemoCustomerRepository extends BaseRepository<DemoCustomer,Integer>{

	@Query(name="HQL_ALL_CUSTOMER")
	public List<DemoCustomer> allCustomerHql();
	
	@Query(name="SQL_ALL_CUSTOMER")
	public List<DemoCustomer> allCustomerSql();
	
}
