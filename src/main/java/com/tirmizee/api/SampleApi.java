package com.tirmizee.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tirmizee.entities.Emp;
import com.tirmizee.repository.EmpRepository;

@RestController
public class SampleApi {

	@Autowired
	private EmpRepository empRepository;
	
	@GetMapping(value = "/findall")
	public List<Emp> test() {
		return empRepository.findAll();
	}
	
	@GetMapping(value = "/findone/{id}")
	public Emp findone(Integer id) {
		return empRepository.findOne(id);
	}
	
	@GetMapping(value = "/getone/{id}")
	public Emp getone(Integer id) {
		return empRepository.getOne(id);
	}
	
}
