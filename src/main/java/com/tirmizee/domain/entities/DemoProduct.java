package com.tirmizee.domain.entities;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "DEMO_PRODUCT")
public class DemoProduct {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PRODUCT_ID")
	private Long productId;
	
	@Column(name = "PRODUCT_NAME")
	private String productName;
	
	@Column(name = "PRODUCT_DESCRIPTION")
	private String productDescription;
	
	@Column(name = "CATEGORY")
	private String category;
	
	@Column(name = "PRODUCT_AVAIL")
	private String productAvail;
	
	@Column(name = "LIST_PRICE")
	private BigDecimal listPrice;
	
	@Column(name = "PRODUCT_IMAGE")
	private Byte[] productImage;
	
	@Column(name = "MIMETYPE")
	private String mimetype;

	@Column(name = "FILENAME")
	private String filename;
	
	@Column(name = "IMAGE_LAST_UPDATE")
	private Date imageLastUpdate;

}
