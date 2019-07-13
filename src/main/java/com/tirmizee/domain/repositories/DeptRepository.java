package com.tirmizee.domain.repositories;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.Query;

import com.tirmizee.domain.entities.DemoDept;
import com.tirmizee.domain.repositories.custom.CustomDeptRepository;

public interface DeptRepository extends BaseRepository<DemoDept, Integer>, CustomDeptRepository {

	@Query("select d from DemoDept d")
	Stream<DemoDept> findAllAsStream();
	
	@Query("select d from DemoDept d where d.dname = ?1")
	List<DemoDept> findByName(String dname);
	
}
