package com.tirmizee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tirmizee.entities.Dept;

@Repository
public interface DeptRepository extends JpaRepository<Dept, Integer> {

}
