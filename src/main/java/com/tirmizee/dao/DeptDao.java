package com.tirmizee.dao;

import java.util.List;

import com.tirmizee.dto.DeptDTO;
import com.tirmizee.jpa.entities.DemoDept;

public interface DeptDao {

	List<DemoDept> findByCriteria(DeptDTO search);
	
	List<DemoDept> findByCriteriaQuery(DeptDTO search);
	
}
