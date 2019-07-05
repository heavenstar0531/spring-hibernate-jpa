package com.tirmizee.domain.entities;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Data
@Entity
public class DemoOrders {

	@Id
	@SequenceGenerator(name="seqOrder", sequenceName="DEMO_ORD_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqOrder")
	private Integer orderId;
	private Integer customerId;
	private BigDecimal orderTotal;
	private Date orderTimestamp;
	private Integer userId;
	
}
