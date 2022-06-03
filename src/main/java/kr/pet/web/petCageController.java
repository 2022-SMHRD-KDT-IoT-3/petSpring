package kr.pet.web;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.pet.mapper.CageVO;
import kr.pet.mapper.petCageMapper;
import kr.pet.mapper.petMemberVO;

@Controller
public class petCageController {
	public static String control = "OFF";
	
	@Inject
	private petCageMapper mapper;
	
	
			//케이지 등록
		@RequestMapping("/Register.do")
		public @ResponseBody CageVO Register(CageVO cvo) {
			System.out.println(cvo.toString());
			mapper.Register(cvo);
			System.out.println("케이지 등록!");
			System.out.println(cvo);
			return cvo;
			
		}
		
	@RequestMapping("/fanControl.do")
	public @ResponseBody String fanControl(String fan) {
		System.out.println(fan);
		control = fan;
		return "완료";
	}
	
}
