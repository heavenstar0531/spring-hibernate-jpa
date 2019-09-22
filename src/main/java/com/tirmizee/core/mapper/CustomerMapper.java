package com.tirmizee.core.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.tirmizee.backend.dto.CustomerDTO;
import com.tirmizee.core.entities.DemoCustomer;

@Mapper
public interface CustomerMapper extends GenericMapper<CustomerDTO, DemoCustomer> {
	
	static final CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);
	
}
