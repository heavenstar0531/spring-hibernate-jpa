package com.tirmizee.core.entities;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="DEMO_MEMBER_DETAIL")
public class DemoMemberDetail {

	@Id 
	@SequenceGenerator(name="seqMemberDetail", sequenceName="DEMO_MEMBER_DETAIL_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqMemberDetail")
	private Long id;
	private String email;
	private String fname;
	private String lname;
	private Date createDate;
	private Timestamp updateDate;
	
	@OneToOne( mappedBy="memberDatail", cascade=CascadeType.ALL)
	private DemoMember member;
	
}
