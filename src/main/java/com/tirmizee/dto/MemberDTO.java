package com.tirmizee.dto;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class MemberDTO {

	private Integer memberId;
	private String memberCode;
	private String memberName;
	private Integer recruitUserId;
	private Integer score;
	private Boolean active;
	
	@JsonFormat(pattern="dd-MM-yyyy HH:mm:ss")
	private Timestamp createDate;
	
	private MemberDetailDTO memberDatail;
	
}
