package com.tirmizee.core.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.tirmizee.backend.dto.MemberDTO;
import com.tirmizee.core.entities.DemoMember;

@Mapper
public interface MemberMapper extends GenericMapper<MemberDTO, DemoMember> {
	
	static final MemberMapper INSTANCE = Mappers.getMapper(MemberMapper.class);

}
