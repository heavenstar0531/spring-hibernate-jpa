package com.tirmizee.core.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tirmizee.core.mapper.PageMapper;
import com.tirmizee.core.mapper.PageMapperImpl;


@Configuration
public class DozerMapperConfig {
	
	@Bean	
	public PageMapper getCustomMapper(){
		return new PageMapperImpl(Arrays.asList("dozer-config.xml"));
	}

}