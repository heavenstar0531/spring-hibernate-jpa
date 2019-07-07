package com.tirmizee.core.mapper;

import java.util.List;

/**
 * @author Pratya Yeekhaday
 *
 * @param <D> Data Transfer Object
 * @param <E> Entity
 */
public interface CommonMapper<D,E> {
	
	D toDTO(E entity);
	
	E toEntity(D dto);
	
	List<D> toListDTO(List<E> entities);
	
	List<E> toListEntity(List<D> dtos);
	
}
