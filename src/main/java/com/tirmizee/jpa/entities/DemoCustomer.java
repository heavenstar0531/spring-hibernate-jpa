package com.tirmizee.jpa.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
public class DemoCustomer {
	
	@Setter @Getter
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer customerId;
	
	@Setter @Getter
	private String custFirstName;
	
	@Setter @Getter
	private String custLastName;
	
	@Setter @Getter
	private String custStreetAddress1;
	
	@Setter @Getter
	private String custStreetAddress2;
	
	@Setter @Getter
	private String custCity;
	
	@Setter @Getter
	private String custState;
	
	@Setter @Getter
	private String custPostalCode;
	
	@Setter @Getter
	private String phoneNumber1;
	
	@Setter @Getter
	private String phoneNumber2;
	
	@Setter @Getter
	private Double creditLimit;
	
	@Setter @Getter
	private String custEmail;
	
	@Setter @Getter
	@OneToMany(mappedBy="customer")
	private List<DemoOrder> orders;

}
