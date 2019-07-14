package com.tirmizee.core.mapper;

import java.util.List;

/**
 * @author Pratya Yeekhaday
 *
 * @param <D> Data Transfer Object
 * @param <E> Entity
 */
public interface CommonMapper<D, E> {
	
	E toEntity(D dto);
	
	D toDTO(E entity);
	
	List<E> toListEntity(List<D> dtos);
	
	List<D> toListDTO(List<E> entities);
	
}
