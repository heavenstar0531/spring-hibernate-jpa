package com.tirmizee.domain.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.tirmizee.domain.entities.DemoDept;

public interface DeptRepository extends ExtendedJpaRepository<DemoDept, Integer>{

	Page<DemoDept> findByDnameContaining(String dname, Pageable pageable);
	
}
