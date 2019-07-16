package com.tirmizee.backend.api;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tirmizee.backend.dto.MemberDTO;
import com.tirmizee.backend.dto.Response;
import com.tirmizee.backend.dto.UserDTO;
import com.tirmizee.core.entities.DemoMember;
import com.tirmizee.core.entities.DemoMemberDetail;
import com.tirmizee.core.entities.DemoUser;
import com.tirmizee.core.mapper.MemberDetailMapper;
import com.tirmizee.core.mapper.MemberMapper;
import com.tirmizee.core.mapper.PageMapper;
import com.tirmizee.core.mapper.UserMapper;
import com.tirmizee.core.repositories.DemoMemberRepository;
import com.tirmizee.core.utilities.DateUtils;

@RestController
@RequestMapping(path = "/member")
public class MemberApiController {

	@Autowired
	private PageMapper mapper;
	
	@Autowired
	private DemoMemberRepository memberRepository;
	
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
	
	@GetMapping(value = "/codeis/{code}")
	public MemberDTO getByMemberCodeIs(@PathVariable String code){
		DemoMember entity = memberRepository.findByMemberCodeIs(code);
		return MemberMapper.INSTANCE.toDTO(entity);
	}
	
	@GetMapping(value = "/codeequals/{code}")
	public MemberDTO getByMemberCodeEquals(@PathVariable String code){
		DemoMember entity = memberRepository.findByMemberCodeEquals(code);
		return MemberMapper.INSTANCE.toDTO(entity);
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
	
	@GetMapping(value = "/codes/{code}/desc")
	public List<MemberDTO> findByMemberCodeOrderByMemberCodeDesc(@PathVariable String code){
		List<DemoMember> entities = memberRepository.findByMemberCodeContainingOrderByMemberCodeDesc(code);
		return MemberMapper.INSTANCE.toListDTO(entities);
	}
	
	@GetMapping(value = "/codeandname/{code}/{name}")
	public MemberDTO getByMemberCodeAndName(@PathVariable String code, @PathVariable String name){
		DemoMember entity = memberRepository.findByMemberCodeAndMemberName(code, name);
		return MemberMapper.INSTANCE.toDTO(entity);
	}
	
	@GetMapping(value = "/codeorname/{code}/{name}")
	public List<MemberDTO> findByMemberCodeOrName(@PathVariable String code, @PathVariable String name){
		List<DemoMember> entities = memberRepository.findByMemberCodeOrMemberName(code, name);
		return MemberMapper.INSTANCE.toListDTO(entities);
	}
	
	@GetMapping(value = "/codenot/{code}")
	public List<MemberDTO> findByMemberCodeNot(@PathVariable String code){
		List<DemoMember> entities = memberRepository.findByMemberCodeNot(code);
		return MemberMapper.INSTANCE.toListDTO(entities);
	}
	
	@GetMapping(value = "/nameendingwith/{name}")
	public List<MemberDTO> findByMemberNameEndingWith(@PathVariable String name){
		List<DemoMember> entities = memberRepository.findByMemberNameEndingWith(name);
		return MemberMapper.INSTANCE.toListDTO(entities);
	}
	
	@GetMapping(value = "/namestartingwith/{name}")
	public List<MemberDTO> findByMemberNameStartingWith(@PathVariable String name){
		List<DemoMember> entities = memberRepository.findByMemberNameStartingWith(name);
		return MemberMapper.INSTANCE.toListDTO(entities);
	}
	
	@GetMapping(value = "/namelike/{name}")
	public List<MemberDTO> findByMemberNameLike(@PathVariable String name){
		List<DemoMember> entities = memberRepository.findByMemberNameLike(name);
		return MemberMapper.INSTANCE.toListDTO(entities);
	}
	
	@GetMapping(value = "/createdate/between")
	public List<MemberDTO> findByMemberNameLike(){
		Timestamp startDate = DateUtils.nowTimestampPlusYear(-1);
		Timestamp endDate = DateUtils.nowTimestamp();
		List<DemoMember> entities = memberRepository.findByCreateDateBetween(startDate, endDate);
		return MemberMapper.INSTANCE.toListDTO(entities);
	}
	
	@GetMapping(value = "/scoreisnull")
	public List<MemberDTO> findByScoreIsNull(){
		List<DemoMember> entities = memberRepository.findByScoreIsNull();
		return MemberMapper.INSTANCE.toListDTO(entities);
	}
	
	@GetMapping(value = "/scoreisnotnull")
	public List<MemberDTO> findByScoreIsNotNull(){
		List<DemoMember> entities = memberRepository.findByScoreIsNotNull();
		return MemberMapper.INSTANCE.toListDTO(entities);
	}
	
	@GetMapping(value = "/codesdesc/{code}")
	public List<MemberDTO> findByMemberCodeAndScoreIsNotNullOrderBy(@PathVariable String code){
		List<DemoMember> entities = memberRepository.findByMemberCodeContainingAndScoreIsNotNullOrderByMemberCodeDesc(code);
		return MemberMapper.INSTANCE.toListDTO(entities);
	}
	
	@GetMapping(value = "/scorein")
	public List<MemberDTO> findByScoreIn(){
		Collection<Integer> codes = Arrays.asList(1,2);
		List<DemoMember> entities = memberRepository.findByScoreIn(codes);
		return MemberMapper.INSTANCE.toListDTO(entities);
	}
	
	@GetMapping(value = "/scoreless/{score}")
	public List<MemberDTO> findByScoreLessThan(@PathVariable Integer score){
		List<DemoMember> entities = memberRepository.findByScoreLessThan(score);
		return MemberMapper.INSTANCE.toListDTO(entities);
	}
	
	@GetMapping(value = "/scoregreater/{score}")
	public List<MemberDTO> findByScoreGreaterThan(@PathVariable Integer score){
		List<DemoMember> entities = memberRepository.findByScoreGreaterThan(score);
		return MemberMapper.INSTANCE.toListDTO(entities);
	}
	
	@GetMapping(value = "/activeture")
	public List<MemberDTO> findByActiveTrue(){
		List<DemoMember> entities = memberRepository.findByActiveTrue();
		return MemberMapper.INSTANCE.toListDTO(entities);
	}
	
	@GetMapping(value = "/activefalse")
	public List<MemberDTO> findByActiveFalse(){
		List<DemoMember> entities = memberRepository.findByActiveFalse();
		return MemberMapper.INSTANCE.toListDTO(entities);
	}
	
	@GetMapping(value = "/username/{username}")
	public List<MemberDTO> findByDemoUserUserName(@PathVariable String username){
		List<DemoMember> entities = memberRepository.findByUserUserName(username);
		return MemberMapper.INSTANCE.toListDTO(entities);
	}
	
	@GetMapping(value = "/email/{email}")
	public List<MemberDTO> findByMemberDatailEmailContaining(@PathVariable String email){
		List<DemoMember> entities = memberRepository.findByMemberDatailEmailContaining(email);
		return MemberMapper.INSTANCE.toListDTO(entities);
	}
	
	@GetMapping(value = "/page/{page}/{size}")
	public Page<MemberDTO> findByMemberDatailEmailContaining(@PathVariable int page, @PathVariable int size){
		Pageable pageable = new PageRequest(page, size);
		Page<DemoMember> entities = memberRepository.findAll(pageable);
		return mapper.map(entities, MemberDTO.class);
	}
	
	@PostMapping(value = "/findbyuser")
	public List<MemberDTO> findByUser(@RequestBody UserDTO userDTO){
		DemoUser user = UserMapper.INSTANCE.toEntity(userDTO);
		List<DemoMember> entities = memberRepository.findByUser(user);
		return MemberMapper.INSTANCE.toListDTO(entities);
	}
	
	@GetMapping(value = "/page/{code}")
	public Page<MemberDTO> page(@PathVariable String code){
		Pageable pageable = new PageRequest(0, 3);
		Page<DemoMember> entities = memberRepository.findByMemberCodeContaining(code, pageable);
		return mapper.map(entities, MemberDTO.class);
	}
	
	@PostMapping(value = "/page")
	public Page<MemberDTO> page(@RequestBody MemberDTO criteria){
		Sort sort = new Sort(Sort.Direction.DESC, "memberCode");
		Pageable pageable = new PageRequest(0, 3,sort);
		Page<DemoMember> entities = memberRepository.findByMemberCodeContainingOrMemberNameContaining(
			criteria.getMemberCode(),
			criteria.getMemberName(), 
			pageable);
		return mapper.map(entities, MemberDTO.class);
	}
	
}
