package com.tirmizee.domain.entities;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

/**
 * @author Pratya Yeekhaday
 *
 */
@Data
@Entity
public class DemoOrderItem {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderItemId;
	private Integer orderId;
	private Integer productId;
	private BigDecimal unitPrice;
	private Integer quantity;

}
