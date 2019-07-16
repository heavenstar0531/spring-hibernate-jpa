package com.tirmizee.backend.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class CustomerDTO implements Serializable {

	private static transient final long serialVersionUID = -1098867388275451451L;

	private Integer customerId;
	
	private String custFirstName;
	
	private String custLastName;
	
	private String custStreetAddress1;
	
	private String custStreetAddress2;
	
	private String custCity;
	
	private String custState;
	
	private String custPostalCode;
	
	private String phoneNumber1;
	
	private String phoneNumber2;
	
	private Double creditLimit;
	
	private String custEmail;

}
