package com.tirmizee.domain.repository;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;

import com.tirmizee.domain.entities.DemoMember;

/**
 * @author Pratya Yeekhaday
 *
 */
public interface DemoMembersRepository extends ExtendedJpaRepository<DemoMember, Integer> {
	
	DemoMember findByMemberCode(String memberCode);
	
	DemoMember findByMemberCodeIs(String memberCode);
	
	DemoMember findByMemberCodeEquals(String memberCode);
	
	DemoMember findByMemberCodeAndMemberName(String memberCode, String memberName);
	
	List<DemoMember> findByActiveTrue();
	
	List<DemoMember> findByActiveFalse();
	
	List<DemoMember> findByScoreIsNull();
	
	List<DemoMember> findByScoreIsNotNull();
	
	List<DemoMember> findByScoreLessThan(Integer score);
	
	List<DemoMember> findByScoreGreaterThan(Integer score);
	
	List<DemoMember> findByScoreIn(Collection<Integer> scores);
	
	List<DemoMember> findByScoreNotIn(Collection<Integer> scores);
	
	List<DemoMember> findByMemberNameLike(String memberName);
	
	List<DemoMember> findByMemberNameIgnoreCase(String memberName);
	
	List<DemoMember> findByMemberCodeNot(String memberCode);
	
	List<DemoMember> findByMemberCodeContaining(String memberCode);
	
	List<DemoMember> findByMemberNameEndingWith(String memberName);
	
	List<DemoMember> findByMemberNameStartingWith(String memberName);
	
	List<DemoMember> findByCreateDateAfter(Timestamp date);
	
	List<DemoMember> findByCreateDateBefore(Timestamp date);
	
	List<DemoMember> findByCreateDateBetween(Timestamp startDate, Timestamp endDate);
	
	List<DemoMember> findByMemberCodeOrMemberName(String memberCode, String memberName);
	
	List<DemoMember> findByMemberCodeContainingOrderByMemberCodeAsc(String memberCode);
	
	List<DemoMember> findByMemberCodeContainingOrderByMemberCodeDesc(String memberCode);
	
	List<DemoMember> findByMemberCodeContainingAndScoreIsNotNullOrderByMemberCodeDesc(String memberCode);
	
	List<DemoMember> findByUserUserName(String username);
	
}
