package com.tirmizee.backend.dao;

import java.util.Map;

public interface ProcedureDao {

	void callStoredProcedureName();
	
	Map<String,Object> callStoredProcedureAllCustomerAndMember();
	
	Map<String,Object> callStoredProcedureAllCustomerAndMemberWithParameter(Integer customerId, String memberCode);
	
}
