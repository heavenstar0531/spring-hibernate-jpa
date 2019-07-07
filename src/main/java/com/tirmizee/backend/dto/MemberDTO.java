package com.tirmizee.backend.dto;

import lombok.Data;

@Data
public class MemberDTO {

	private Integer memberId;
	private String memberCode;
	private String memberName;
	private Integer recruitUserId;
	
	
	private MemberDetailDTO memberDatail;
	
}
