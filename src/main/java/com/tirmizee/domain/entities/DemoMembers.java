package com.tirmizee.domain.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class DemoMembers {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer memberId;
	private String memberCode;
	private String memberName;
	private Integer userId;
	
}
