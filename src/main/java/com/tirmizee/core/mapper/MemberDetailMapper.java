package com.tirmizee.core.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.tirmizee.dto.MemberDetailDTO;
import com.tirmizee.jpa.entities.DemoMemberDetail;

@Mapper
public interface MemberDetailMapper extends CommonMapper<MemberDetailDTO, DemoMemberDetail >{

	static final MemberDetailMapper INSTANCE = Mappers.getMapper(MemberDetailMapper.class);
	
}
