package com.tirmizee.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.tirmizee.entities.Dept;
import com.tirmizee.repository.DeptRepository;

@RestController
public class SampleApi {

	@Autowired
	private DeptRepository empRepository;
	
	@GetMapping(value = "/findall")
	public List<Dept> test() {
		return empRepository.findAll();
	}
	
	@GetMapping(value = "/findone/{id}")
	public Dept findone(@PathVariable Integer id) {
		return empRepository.findOne(id);
	}
	
	@GetMapping(value = "/getone/{id}")
	public Dept getone(@PathVariable Integer id) {
		return empRepository.getOne(id);
	}
	
}
