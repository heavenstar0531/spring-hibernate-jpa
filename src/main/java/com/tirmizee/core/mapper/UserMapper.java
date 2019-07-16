package com.tirmizee.core.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.tirmizee.backend.dto.UserDTO;
import com.tirmizee.core.entities.DemoUser;

@Mapper
public interface UserMapper extends CommonMapper<UserDTO, DemoUser>{

	static final UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
	
}
