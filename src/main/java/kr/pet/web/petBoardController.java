package kr.pet.web;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.pet.mapper.petBoardMapper;

@Controller
public class petBoardController {
	
	
	@Inject
	private petBoardMapper mapper;	
	
	@RequestMapping("/pethome.do")
	public void pethome() {
		System.out.println("홈페이지 실행");
	}

}
