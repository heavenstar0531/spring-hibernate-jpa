package com.tirmizee.domain.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.tirmizee.domain.entities.DemoCustomer;

public interface DemoCustomerRepository extends BaseRepository<DemoCustomer,Integer>{

	@Query("SELECT c FROM DemoCustomer c WHERE c.custEmail LIKE ?1")
	List<DemoCustomer> findByCustEmail(String custEmail);
	
}
