package kr.pet.web;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.pet.mapper.petBoardMapper;
import kr.pet.mapper.petBoardVO;

@Controller
public class petBoardController {
	
	
	@Inject
	private petBoardMapper mapper;	
	
	@RequestMapping("/pethome.do")
	public void pethome() {
		System.out.println("홈페이지 실행");
	}
	
	@RequestMapping("/boardInsert.do")
	public @ResponseBody petBoardVO boardInsert(petBoardVO vo) {
		System.out.println("글쓰기 기능 실행");
		System.out.println(vo.toString());
		
		mapper.boardInsert(vo);
		return vo;
	}
	@RequestMapping("/boardList.do")
	public @ResponseBody List<petBoardVO> boardList(Model model) {
		System.out.println("게시판전체보기 실행");
		List<petBoardVO> list = mapper.boardList();
		model.addAttribute("list",list);
		return list;
		
	}

	
	
}

