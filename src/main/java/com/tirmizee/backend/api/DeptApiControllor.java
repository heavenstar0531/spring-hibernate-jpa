package com.tirmizee.backend.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tirmizee.domain.entities.Dept;
import com.tirmizee.domain.repository.DeptRepository;

@RestController
@RequestMapping(path = "/dept")
public class DeptApiControllor {

	@Autowired
	private DeptRepository deptRepository;
	
	@GetMapping(value = "/find/all")
	public List<Dept> findAll() {
		return deptRepository.findAll();
	}
	
	@GetMapping(value = "/find/sort")
	public List<Dept> findAndSort() {
		return deptRepository.findAll(new Sort(Direction.DESC, "loc"));
	}
	
	@GetMapping(value = "/findone/{id}")
	public Dept findone(@PathVariable Integer id) {
		return deptRepository.findOne(id);
	}
	
	@GetMapping(value = "/getone/{id}")
	public Dept getone(@PathVariable Integer id) {
		return deptRepository.getOne(id);
	}
	
}
