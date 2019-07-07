package com.tirmizee.backend.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tirmizee.backend.dto.MemberDTO;
import com.tirmizee.core.mapper.MemberMapper;
import com.tirmizee.domain.repository.DemoMembersRepository;

@RestController
@RequestMapping(path = "/member")
public class MemberApiController {

	@Autowired
	private DemoMembersRepository memberRepository;
	
	@GetMapping(value = "/find/all")
	public List<MemberDTO> findAll(){ 
		return MemberMapper.INSTANCE.toListDTO(memberRepository.findAll());
	}
	
}
