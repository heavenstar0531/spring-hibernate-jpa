package com.tirmizee.domain.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface ExtendedJapRepository<T, ID extends Serializable> extends JpaRepository<T, ID> {

}
