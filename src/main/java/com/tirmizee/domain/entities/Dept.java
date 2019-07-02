package com.tirmizee.domain.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Dept {

	@Setter @Getter 
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer deptno;
	
	@Setter @Getter 
	private String dname;
	
	@Setter @Getter 
	private String loc;
	
}
