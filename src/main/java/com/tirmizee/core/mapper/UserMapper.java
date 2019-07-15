package com.tirmizee.core.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.tirmizee.dto.UserDTO;
import com.tirmizee.jpa.entities.DemoUser;

@Mapper
public interface UserMapper extends CommonMapper<UserDTO, DemoUser>{

	static final UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
	
}
