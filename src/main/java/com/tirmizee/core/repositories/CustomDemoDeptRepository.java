package com.tirmizee.core.repositories;

import java.util.List;

import com.tirmizee.core.entities.DemoDept;

public interface CustomDemoDeptRepository {
	
	List<DemoDept> dname(String dname);

}
