package com.tirmizee.backend.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.tirmizee.core.entities.DemoCustomer;
import com.tirmizee.core.entities.DemoMember;

@Repository
public class ProcedureDaoImpl implements ProcedureDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void callStoredProcedureName() {
		jdbcTemplate.update("CALL STORE_HELLO_WORLD()");
	}

	@Override
	public Map<String, Object> callStoredProcedureAllCustomerAndMember() {
		jdbcTemplate.setResultsMapCaseInsensitive(true);
		SimpleJdbcCall callStored = new SimpleJdbcCall(jdbcTemplate)
			.withProcedureName("STORED_ALL_CUSTOMER")
			.returningResultSet("members", BeanPropertyRowMapper.newInstance(DemoMember.class))
			.returningResultSet("customers", BeanPropertyRowMapper.newInstance(DemoCustomer.class));
//		return callStored.execute(new HashMap<String, Object>(0));
		return callStored.execute(new MapSqlParameterSource());
	}

	@Override
	public Map<String, Object> callStoredProcedureAllCustomerAndMemberWithParameter(Integer customerId, String memberCode) {
		jdbcTemplate.setResultsMapCaseInsensitive(true);
		
		MapSqlParameterSource parameterSource = new MapSqlParameterSource()
			.addValue("cusId", customerId)
			.addValue("MemCode", memberCode);
	
		SimpleJdbcCall callStored = new SimpleJdbcCall(jdbcTemplate)
			.withProcedureName("ALL_CUSTOMER_AND_MEMBER")
			.returningResultSet("members", BeanPropertyRowMapper.newInstance(DemoMember.class))
			.returningResultSet("customers", BeanPropertyRowMapper.newInstance(DemoCustomer.class));
		
		return callStored.execute(parameterSource);
	}

}
