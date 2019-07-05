package com.tirmizee.domain.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class DemoUsers {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer userId;
	private String userName;
	private String password;
	private Date createdOn;
	private Integer quota;
	private Character products;
	private Date expiresOn;
	private Character adminUser;

}
