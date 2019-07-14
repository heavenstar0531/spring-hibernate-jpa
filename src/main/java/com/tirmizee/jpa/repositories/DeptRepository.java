package com.tirmizee.jpa.repositories;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tirmizee.jpa.entities.DemoDept;

@Repository
public interface DeptRepository extends BaseRepository<DemoDept, Integer> {

	@Query("FROM DemoDept")
	Stream<DemoDept> findAllAsStream();
	
	@Query("FROM DemoDept WHERE loc = ?1")
	List<DemoDept> findByLoc(String loc);
	
	@Query("SELECT d FROM DemoDept d WHERE d.dname = ?1")
	List<DemoDept> findByName(String dname);
	
	@Query(value = "SELECT d FROM DemoDept d ORDER BY d.deptno")
	Page<DemoDept> findAllWithPagination(Pageable pageable);
	
	@Query(
		nativeQuery = true,
		value = " SELECT * FROM DEMO_DEPT ORDER BY ?#{#pageable}",
		countQuery = "SELECT count(*) FROM DEMO_DEPT  ORDER BY ?#{#pageable}")
	Page<DemoDept> findNativeWithPagination(Pageable pageable);
	
}
