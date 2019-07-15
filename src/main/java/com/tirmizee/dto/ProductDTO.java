package com.tirmizee.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

import lombok.Data;

@Data
public class ProductDTO implements Serializable {

	private static final long serialVersionUID = -7113851269594490526L;

	private Long productId;
	
	private String productName;
	
	private String productDescription;
	
	private String category;
	
	private String productAvail;
	
	private BigDecimal listPrice;
	
	private Byte[] productImage;
	
	private String mimetype;

	private String filename;
	
	private Date imageLastUpdate;
	
}
