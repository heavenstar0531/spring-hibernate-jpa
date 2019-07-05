package com.tirmizee.backend.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tirmizee.backend.dto.DeptDTO;
import com.tirmizee.backend.dto.Response;
import com.tirmizee.domain.entities.DemoDept;
import com.tirmizee.domain.repository.DeptRepository;

@RestController
@RequestMapping(path = "/dept")
public class DeptApiControllor {

	@Autowired
	private DeptRepository deptRepository;
	
	@GetMapping(value = "/find/all")
	public List<DemoDept> findAll() {
		return deptRepository.findAll();
	}
	
	@GetMapping(value = "/find/sort")
	public List<DemoDept> findAndSort() {
		return deptRepository.findAll(new Sort(Direction.DESC, "loc"));
	}
	
	@GetMapping(value = "/findone/{id}")
	public DemoDept findone(@PathVariable Integer id) {
		return deptRepository.findOne(id);
	}
	
	@GetMapping(value = "/getone/{id}")
	public DemoDept getone(@PathVariable Integer id) {
		return deptRepository.getOne(id);
	}
	
	@PostMapping(value = "/create")
	public Response<DeptDTO> create(@RequestBody DeptDTO deptDTO) {
		Response<DeptDTO> response = new Response<>();
		DemoDept dept = new DemoDept();
		dept.setDeptno(deptDTO.getDeptno());
		dept.setDname(deptDTO.getDname());
		dept.setLoc(deptDTO.getLoc());
		deptRepository.save(dept);
		response.setMsgCode("200");
		response.setMsgName("Success");
		response.setDetail(deptDTO);
		return response;
	}
	
	@PostMapping(value = "/update")
	public Response<DeptDTO> update(@RequestBody DeptDTO deptDTO) {
		Response<DeptDTO> response = new Response<>();
		DemoDept entity = deptRepository.findOne(deptDTO.getDeptno());
		entity.setDname(deptDTO.getDname());
		entity.setLoc(deptDTO.getLoc());
		deptRepository.save(entity);
		response.setMsgCode("200");
		response.setMsgName("Success");
		response.setDetail(deptDTO);
		return response;
	}
	
	@GetMapping(value = "/delete/{deptno}")
	public Response<Object> delete(@PathVariable Integer deptno) {
		Response<Object> response = new Response<>();
		deptRepository.delete(deptno);
		response.setMsgCode("200");
		response.setMsgName("Success");
		return response;
	}
	
	@ExceptionHandler(value = Exception.class)
	public Response<?> handleException(Exception ex){
		Response<DeptDTO> response = new Response<>();
		response.setMsgCode("ERROR000");
		response.setMsgName(ex.getMessage());
		return response;
	}
	
}
