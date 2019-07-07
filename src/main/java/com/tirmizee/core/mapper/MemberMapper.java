package com.tirmizee.core.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.tirmizee.backend.dto.MemberDTO;
import com.tirmizee.domain.entities.DemoMember;

@Mapper
public interface MemberMapper extends CommonMapper<MemberDTO, DemoMember> {
	
	static final MemberMapper INSTANCE = Mappers.getMapper(MemberMapper.class);

}
