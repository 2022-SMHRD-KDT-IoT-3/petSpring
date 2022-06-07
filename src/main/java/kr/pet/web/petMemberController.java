package kr.pet.web;

import java.io.IOException;
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
	
	
	//가입 메소드
	@RequestMapping("/joinInsert.do")
	public @ResponseBody String joinInsert(petMemberVO vo) {
		System.out.println(vo.toString());
		mapper.joinInsert(vo);
		System.out.println("회원가입기능요청");
		return "회원가입성공";
	}
	
	
	//로그인기능 
	@RequestMapping("/loginSelectOne.do") 
	public void loginSelectOne(HttpSession session, petMemberVO vo) {
		System.out.println("로그인기능실행");
		petMemberVO info =  mapper.loginSelectOne(vo);
		System.out.println(info);
		if(info!=null) {
			session.setAttribute("info", info);
		}
	}
	
	
	//회원정보수정메소드
	@RequestMapping("/updateService.do")
	public @ResponseBody petMemberVO updateService(petMemberVO vo) {
		System.out.println("회원정보실행");
		System.out.println(vo);
		mapper.updateService(vo);
		//session.setAttribute("info", vo);
		return vo;
	
	}
	
	//멤버 목록 메소드
	@RequestMapping("/memberList.do")
	public @ResponseBody List<petMemberVO> memberList() {
		System.out.println("멤버목록 비동기 통신");
		List<petMemberVO> list = mapper.memberList();
		return list;
	}
	
	//안드로그인메소드
	@RequestMapping("/andLogin.do")
	public @ResponseBody petMemberVO andLogin(petMemberVO vo){
		System.out.println("로그인이 요청됨");
		petMemberVO info = mapper.loginSelectOne(vo);
		System.out.println(info);
		return info;
		
	}
	
	//id체크 메소드
	@RequestMapping("/idCheck.do")
	public @ResponseBody petMemberVO idCheck(String mb_id) {
		System.out.println(mb_id);
		System.out.println("아이디체크실행");
		petMemberVO vo = mapper.idCheck(mb_id);
		return vo;
	}
	
	// id찾기 메소드
	@RequestMapping("/findId.do")
	public @ResponseBody petMemberVO findId(String mb_phone) {
		String mb_id;
		System.out.println("멤버 아이디 찾기 요청");
		petMemberVO info = mapper.findId(mb_phone);
		System.out.println(info.toString());
		
		return info;
	}
	
	// 비밀번호 재설정 시 정보체크 메소드
	@RequestMapping("/pwrsinfo.do")
	public @ResponseBody petMemberVO pwrsinfo(petMemberVO vo) {
		System.out.println("비밀번호 재설정 정보 확인");
		petMemberVO info = mapper.pwrsinfo(vo);
		System.out.println(vo.toString());
		
		return info;
	}
	
	@RequestMapping("/new_pwrs.do")
	public void new_pwrs(petMemberVO vo){
		System.out.println("------구분선-------");
		mapper.new_pwrs(vo);
		System.out.println(vo.toString());
		
	}
	
}