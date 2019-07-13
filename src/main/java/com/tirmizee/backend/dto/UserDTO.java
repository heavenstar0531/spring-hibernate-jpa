package com.tirmizee.backend.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class UserDTO {
	
	private Integer userId;
	private String userName;
	private String password;
	private Date createdOn;
	private Integer quota;
	private Character products;
	private Date expiresOn;
	private Character adminUser;

}
