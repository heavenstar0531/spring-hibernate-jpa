package com.tirmizee.dto;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class MemberDetailDTO {
	
	private Long id;
	private String email;
	private String fname;
	private String lname;
	
	@JsonFormat(pattern="dd-MM-yyyy HH:mm:ss")
	private Timestamp updateDate;

}
