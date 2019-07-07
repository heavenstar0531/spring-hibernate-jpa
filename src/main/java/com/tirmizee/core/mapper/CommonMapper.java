package com.tirmizee.core.mapper;

import java.util.List;

/**
 * @author Pratya Yeekhaday
 *
 * @param <D> Data Transfer Object
 * @param <T> Entity
 */
public interface CommonMapper<D,T> {
	
	D toDTO(T entity);
	
	T toEntity(D dto);
	
	List<D> toListDTO(List<T> entities);
	
	List<T> toListEntity(List<D> dtos);
	
}
