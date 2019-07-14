package com.tirmizee.core.dao;

import java.util.List;

import com.tirmizee.backend.dto.DeptDTO;
import com.tirmizee.domain.entities.DemoDept;

public interface DeptDao {

	List<DemoDept> findByCriteria(DeptDTO search);
	
}
