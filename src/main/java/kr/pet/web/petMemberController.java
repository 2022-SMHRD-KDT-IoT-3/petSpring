package kr.pet.web;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import kr.pet.mapper.petMemberMapper;
import kr.pet.mapper.petMemberVO;

@Controller
public class petMemberController {

	@Inject
	private petMemberMapper mapper;
	
	
	
	@RequestMapping("/joinInsert.do")
	public void joinInsert(petMemberVO vo) {
		System.out.println(vo.toString());
		mapper.joinInsert(vo);
		System.out.println("회원가입기능요청");
		
	}
	
	
	@RequestMapping("/loginSelectOne.do") 
	public void loginSelectOne(HttpSession session, petMemberVO vo) {
		System.out.println("로그인기능실행");
		petMemberVO info =  mapper.loginSelectOne(vo);
		System.out.println(info);
		if(info!=null) {
			session.setAttribute("info", info);
		}
	}
	
	
	
	@RequestMapping("/updateService.do")
	public void updateService(HttpSession session, petMemberVO vo) {
		System.out.println("회원정보실행");
		mapper.updateService(vo);
		session.setAttribute("info", vo);
	
	}
	
	@RequestMapping("/memberList.do")
	public @ResponseBody List<petMemberVO> memberList() {
		System.out.println("멤버목록 비동기 통신");
		List<petMemberVO> list = mapper.memberList();
		return list;
	}
	
	@RequestMapping("/andLogin.do")
	public @ResponseBody petMemberVO andLogin(petMemberVO vo){
		System.out.println("로그인이 요청됨");
		System.out.println(vo.toString());
		petMemberVO info = mapper.loginSelectOne(vo);
		System.out.println(info);
		
		return info;
		
	}
	
	
	
	
}
