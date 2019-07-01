package com.tirmizee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tirmizee.entities.Emp;

@Repository
public interface EmpRepository extends JpaRepository<Emp, Integer> {

}
