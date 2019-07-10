package com.tirmizee.domain.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class DemoMember {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer memberId;
	private String memberCode;
	private String memberName;
	private Integer recruitUserId;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="memberDetailId")
	private DemoMemberDetail memberDatail;
	
	@ManyToOne
	@JoinColumn(name="recruitUserId", insertable=false, updatable=false)
	private DemoUser user;
	
}
