package com.tirmizee.backend.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	private Map<String, String> springQuery;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void ssssssss() {
		System.out.println(springQuery.get("key1"));
	}
	
}