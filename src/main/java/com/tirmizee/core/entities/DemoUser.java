package com.tirmizee.core.entities;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "DEMO_USER")
public class DemoUser {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer userId;
	private String userName;
	private String password;
	private Date createdOn;
	private Integer quota;
	private Character products;
	private Date expiresOn;
	private Character adminUser;
	
	@OneToMany( mappedBy = "user")
	private List<DemoMember> members;

}
