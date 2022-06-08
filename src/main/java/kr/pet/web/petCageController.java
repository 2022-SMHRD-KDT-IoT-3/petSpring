package kr.pet.web;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.pet.mapper.CageInfoVO;
import kr.pet.mapper.CageVO;
import kr.pet.mapper.DogVO;
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
	
	
	

	@RequestMapping("/select_cage.do") 
	public @ResponseBody List<CageInfoVO> select_cage(CageInfoVO civo) {
		System.out.println("케이지 컨트롤하러 갑니다");
		List<CageInfoVO> list = (List<CageInfoVO>)mapper.select_cage(civo);
		System.out.println(list);
		return list;
	}
	
}

