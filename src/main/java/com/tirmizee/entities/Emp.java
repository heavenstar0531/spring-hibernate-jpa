package com.tirmizee.entities;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Emp {
	
	@Setter @Getter 
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer empno;
	
	@Setter @Getter 
	private String ename;
	
	@Setter @Getter 
	private String job;
	
	@Setter @Getter 
	private Integer mgr;
	
	@Setter @Getter 
	private Date hiredate;
	
	@Setter @Getter 
	private BigDecimal sal;
	
	@Setter @Getter 
	private BigDecimal comm;
	
	@Setter @Getter 
	private Integer deptno;
	
}
