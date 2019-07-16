package com.tirmizee.backend.api;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tirmizee.backend.dao.ProcedureDao;
import com.tirmizee.backend.dao.StoredProcedureDao;
import com.tirmizee.backend.dto.CustomerDTO;
import com.tirmizee.core.entities.DemoCustomer;
import com.tirmizee.core.entities.DemoMember;
import com.tirmizee.core.mapper.CustomerMapper;
import com.tirmizee.core.repositories.DemoCustomerRepository;

@RestController
@RequestMapping(path = "/custormer")
public class CustomerApiController {

	@Autowired
	private ProcedureDao procedureDao;
	
	@Autowired
	private StoredProcedureDao storedProcedureDao;
	
	@Autowired
	private DemoCustomerRepository customerRepository;
	
	@GetMapping(value = "/find/all")
	public List<CustomerDTO> findAll() {
		return CustomerMapper.INSTANCE.toListDTO(customerRepository.findAll());
	}
	
	@GetMapping(value = "/delete/{customerId}")
	public CustomerDTO update(@PathVariable Integer customerId) {
		customerRepository.delete(customerId);
		return new CustomerDTO();
	}
	
	@PostMapping(value = "/update")
	public CustomerDTO update(@RequestBody CustomerDTO customerDTO) {
		DemoCustomer entity = customerRepository.findOne(customerDTO.getCustomerId());
		entity = CustomerMapper.INSTANCE.toEntity(customerDTO);
		entity = customerRepository.save(entity);
		return CustomerMapper.INSTANCE.toDTO(entity);
	}
	
	@PostMapping(value = "/create")
	public CustomerDTO create(@RequestBody CustomerDTO customerDTO) {
		DemoCustomer entity = CustomerMapper.INSTANCE.toEntity(customerDTO);
		entity = customerRepository.save(entity);
		return CustomerMapper.INSTANCE.toDTO(entity);
	}
	
	@GetMapping(value = "/hql/all")
	public List<CustomerDTO> hqlAll() {
		List<DemoCustomer> entities = customerRepository.allCustomerHql();
		return CustomerMapper.INSTANCE.toListDTO(entities);
	}
	
	@GetMapping(value = "/sql/all")
	public List<CustomerDTO> sqlAll() {
		List<DemoCustomer> entities = customerRepository.allCustomerSql("zee_prta");
		return  CustomerMapper.INSTANCE.toListDTO(entities);
	}
	
	@GetMapping(value = "/test")
	public List<CustomerDTO> test() {
		Map<String, Object> map = procedureDao.callStoredProcedureAllCustomerAndMember();
		List<DemoCustomer> list = (List<DemoCustomer>) map.get("customers");
		List<DemoMember> list2 = (List<DemoMember>) map.get("members");
		for (DemoCustomer demoCustomer : list) {
			System.out.println(demoCustomer.getCustFirstName());
		}
		for (DemoMember demoMember : list2) {
			System.out.println(demoMember.getMemberCode());
		}
		map = procedureDao.callStoredProcedureAllCustomerAndMemberWithParameter(2, "00008");
		List<DemoCustomer> list3 =  (List<DemoCustomer>) map.get("customers");
		System.out.println(list3.get(0).getCustomerId());
		List<DemoMember>  list4 =  (List<DemoMember>) map.get("members");
		System.out.println(list4.get(0).getMemberCode());
		return null;
	}
	
}
