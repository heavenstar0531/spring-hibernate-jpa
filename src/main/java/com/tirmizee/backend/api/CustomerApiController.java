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
import com.tirmizee.core.mapper.CustomerMapper;
import com.tirmizee.domain.entities.DemoCustomer;
import com.tirmizee.domain.repository.DemoCustomerRepository;

@RestController
@RequestMapping(path = "/custormer")
public class CustomerApiController {

	@Autowired
	private DemoCustomerRepository demoCustomerRepository;
	
	@GetMapping(value = "/find/all")
	public List<CustomerDTO> findAll() {
		return CustomerMapper.INSTANCE.toListDTO(demoCustomerRepository.findAll());
	}
	
	@GetMapping(value = "/delete/{customerId}")
	public CustomerDTO update(@PathVariable Integer customerId) {
		demoCustomerRepository.delete(customerId);
		return new CustomerDTO();
	}
	
	@PostMapping(value = "/update")
	public CustomerDTO update(@RequestBody CustomerDTO customerDTO) {
		DemoCustomer entity = demoCustomerRepository.findOne(customerDTO.getCustomerId());
		entity = CustomerMapper.INSTANCE.toEntity(customerDTO);
		entity = demoCustomerRepository.save(entity);
		return CustomerMapper.INSTANCE.toDTO(entity);
	}
	
	@PostMapping(value = "/create")
	public CustomerDTO create(@RequestBody CustomerDTO customerDTO) {
		DemoCustomer entity = CustomerMapper.INSTANCE.toEntity(customerDTO);
		entity = demoCustomerRepository.save(entity);
		return CustomerMapper.INSTANCE.toDTO(entity);
	}
	
	@GetMapping(value = "/email/{email}")
	public List<CustomerDTO> findByEmail(@PathVariable String email){
		List<DemoCustomer> entities = demoCustomerRepository.findByCustEmail(email);
		return CustomerMapper.INSTANCE.toListDTO(entities);
	}
	
}
