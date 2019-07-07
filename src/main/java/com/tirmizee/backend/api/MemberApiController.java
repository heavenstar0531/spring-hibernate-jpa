package com.tirmizee.backend.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tirmizee.backend.dto.MemberDTO;
import com.tirmizee.core.mapper.MemberMapper;
import com.tirmizee.domain.entities.DemoMember;
import com.tirmizee.domain.entities.DemoMemberDetail;
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
	
	@GetMapping(value = "/get/{memberId}")
	public MemberDTO getMember(@PathVariable Integer memberId){ 
		DemoMember entity = memberRepository.findOne(memberId);
		DemoMemberDetail memberDetail = entity.getMemberDatail();
		if (memberDetail != null) {
			System.out.println(memberDetail.getId());
			System.out.println(memberDetail.getFname());
			System.out.println(memberDetail.getLname());
			System.out.println(memberDetail.getEmail());
			System.out.println(memberDetail.getCreateDate());
			System.out.println(memberDetail.getUpdateDate());
		}
		return MemberMapper.INSTANCE.toDTO(entity);
	}
	
}
