package com.tirmizee.dao;

import java.util.List;

import com.tirmizee.jpa.entities.DemoCustomer;

public interface CustomerDao {
	
	List<DemoCustomer> allCustomerSql();

}
