package com.tirmizee.backend.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tirmizee.backend.dto.MemberDTO;
import com.tirmizee.backend.dto.Response;
import com.tirmizee.core.mapper.MemberDetailMapper;
import com.tirmizee.core.mapper.MemberMapper;
import com.tirmizee.core.utilities.DateUtils;
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
		return MemberMapper.INSTANCE.toDTO(entity);
	}
	
	@Transactional
	@GetMapping(value = "/delete/{memberId}")
	public Response<Object> deleteMember(@PathVariable Integer memberId){
		DemoMember memberPersist = memberRepository.findOne(memberId);
		memberRepository.delete(memberPersist);
		Response<Object> response = new Response<>();
		response.setMsgCode("OK");
		return response;
	}
	
	@Transactional
	@PostMapping(path = "/create")
	public Response<MemberDTO> create(@RequestBody MemberDTO memberDTO) {
		Response<MemberDTO> response = new Response<>();
		DemoMember memberEntity = MemberMapper.INSTANCE.toEntity(memberDTO);
		DemoMemberDetail memberDetailEntity = MemberDetailMapper.INSTANCE.toEntity(memberDTO.getMemberDatail());
		memberDetailEntity.setUpdateDate(DateUtils.nowTimestamp());
		memberEntity.setMemberDatail(memberDetailEntity);
		memberEntity = memberRepository.save(memberEntity);
		response.setMsgCode("OK");
		response.setDetail(MemberMapper.INSTANCE.toDTO(memberEntity));
		return response;
	} 
	
	@GetMapping(value = "/code/{code}")
	public MemberDTO getByMemberCode(@PathVariable String code){
		DemoMember entity = memberRepository.findByMemberCode(code);
		return MemberMapper.INSTANCE.toDTO(entity);
	}
	
	@GetMapping(value = "/codes/{code}")
	public List<MemberDTO> findByMemberCode(@PathVariable String code){
		List<DemoMember> entities = memberRepository.findByMemberCodeContaining(code);
		return MemberMapper.INSTANCE.toListDTO(entities);
	}
	
}
