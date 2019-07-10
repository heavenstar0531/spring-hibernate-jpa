package com.tirmizee.domain.repository;

import java.util.List;

import com.tirmizee.domain.entities.DemoMember;

public interface DemoMembersRepository extends ExtendedJpaRepository<DemoMember, Integer> {
	
	DemoMember findByMemberCode(String memberCode);
	
	List<DemoMember> findByMemberCodeContaining(String memberCode);

}
