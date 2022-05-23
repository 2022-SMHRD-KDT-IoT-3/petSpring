package kr.pet.web;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;

import kr.pet.mapper.petMemberMapper;

@Controller
public class petMemberController {

	@Inject
	private petMemberMapper mapper;
	
	
	
	
}
