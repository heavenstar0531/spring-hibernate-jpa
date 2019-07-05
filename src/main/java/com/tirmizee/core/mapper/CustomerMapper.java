package com.tirmizee.core.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.tirmizee.backend.dto.CustomerDTO;
import com.tirmizee.domain.entities.DemoCustomer;

@Mapper
public interface CustomerMapper {
	
	static final CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);
	
	CustomerDTO toDto(DemoCustomer entity);
	
	DemoCustomer toEntity(CustomerDTO dto);

}
