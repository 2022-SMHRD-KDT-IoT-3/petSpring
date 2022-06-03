package kr.pet.web;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.pet.mapper.DogVO;
import kr.pet.mapper.petMapper;
import kr.pet.mapper.petMemberMapper;
import kr.pet.mapper.petMemberVO;

@Controller
public class petController {
	
	@Inject
	private petMapper mapper;
	
	
	
	@RequestMapping("/dog_update.do")
	public @ResponseBody DogVO dog_update(HttpSession session, DogVO dogvo) {
		System.out.println("개 정보 수정");
		mapper.dog_update(dogvo);
		//session.setAttribute("info", dogvo);
		return dogvo;
	}
	
		
		
	
		
		
	@RequestMapping("/dog_regist.do")
	public @ResponseBody DogVO dog_regist(DogVO dogvo) {
		System.out.println(dogvo.toString());
		mapper.dog_regist(dogvo);
		System.out.println("반려견 등록");
		return dogvo;
		}	
		
		
	}
	
	
