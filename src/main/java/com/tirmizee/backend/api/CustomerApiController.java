package com.tirmizee.backend.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tirmizee.backend.dto.CustomerDTO;
import com.tirmizee.domain.entities.DemoCustomer;
import com.tirmizee.domain.repository.DemoCustomerRepository;

@RestController
@RequestMapping(path = "/custormer")
public class CustomerApiController {

	@Autowired
	private DemoCustomerRepository demoCustomerRepository;
	
	@GetMapping(value = "/find/all")
	public List<DemoCustomer> findAll() {
		return demoCustomerRepository.findAll();
	}
	
	@GetMapping(value = "/delete/{customerId}")
	public CustomerDTO update(@PathVariable Integer customerId) {
		demoCustomerRepository.delete(customerId);
		return new CustomerDTO();
	}
	
	@PostMapping(value = "/update")
	public CustomerDTO update(@RequestBody CustomerDTO customerDTO) {
		DemoCustomer entity = demoCustomerRepository.findOne(customerDTO.getCustomerId());
		entity.setCustCity(customerDTO.getCustCity());
		entity.setCustState(customerDTO.getCustState());
		entity.setCustFirstName(customerDTO.getCustFirstName());
		entity.setCustLastName(customerDTO.getCustLastName());
		entity.setCreditLimit(customerDTO.getCreditLimit());
		entity.setCustPostalCode(customerDTO.getCustPostalCode());
		entity.setPhoneNumber1(customerDTO.getPhoneNumber1());
		entity.setPhoneNumber2(customerDTO.getPhoneNumber2());
		entity.setCustStreetAddress1(customerDTO.getCustStreetAddress1());
		entity.setCustStreetAddress2(customerDTO.getCustStreetAddress2());
		entity = demoCustomerRepository.save(entity);
		return customerDTO;
	}
	
	@PostMapping(value = "/create")
	public CustomerDTO create(@RequestBody CustomerDTO customerDTO) {
		DemoCustomer entity = new DemoCustomer();
		entity.setCustCity(customerDTO.getCustCity());
		entity.setCustState(customerDTO.getCustState());
		entity.setCustFirstName(customerDTO.getCustFirstName());
		entity.setCustLastName(customerDTO.getCustLastName());
		entity.setCreditLimit(customerDTO.getCreditLimit());
		entity.setCustPostalCode(customerDTO.getCustPostalCode());
		entity.setPhoneNumber1(customerDTO.getPhoneNumber1());
		entity.setPhoneNumber2(customerDTO.getPhoneNumber2());
		entity.setCustStreetAddress1(customerDTO.getCustStreetAddress1());
		entity.setCustStreetAddress2(customerDTO.getCustStreetAddress2());
		entity = demoCustomerRepository.save(entity);
		customerDTO.setCustomerId(entity.getCustomerId());
		return customerDTO;
	}
	
	
	
}
