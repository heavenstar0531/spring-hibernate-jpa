package com.tirmizee.domain.entities;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="DEMO_ORDER")
public class DemoOrder {

	@Id
	@Column(name="ORDER_ID")
	@SequenceGenerator(name="seqOrder", sequenceName="DEMO_ORD_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqOrder")
	private Integer orderId;
	
	@Column(name="CUSTOMER_ID")
	private Integer customerId;
	
	@Column(name="ORDER_TOTAL")
	private BigDecimal orderTotal;
	
	@Column(name="ORDER_TIMESTAMP")
	private Date orderTimestamp;
	
	@Column(name="USER_ID")
	private Integer userId;
	
	@ManyToOne
	@JoinColumn(name="CUSTOMER_ID", insertable=false, updatable=false)
	private DemoCustomer customer;
	
	@ManyToOne
	@JoinColumn(name="USER_ID", insertable=false, updatable=false)
	private DemoUser user;
	
}
