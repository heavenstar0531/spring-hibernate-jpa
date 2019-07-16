package com.tirmizee.backend.dao;

import java.util.List;

import com.tirmizee.backend.dto.DeptDTO;
import com.tirmizee.core.entities.DemoDept;

public interface DeptDao {

	List<DemoDept> findByCriteria(DeptDTO search);
	
	List<DemoDept> findByCriteriaQuery(DeptDTO search);
	
}
