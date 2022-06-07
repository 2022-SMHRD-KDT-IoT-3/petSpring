package kr.pet.web;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.pet.mapper.CmtVO;
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
	
	
	//게시글 디비 등록 메소드
	@RequestMapping("/boardInsert.do")
	public @ResponseBody String boardInsert(petBoardVO vo) {
		System.out.println("글쓰기 기능 실행");
		System.out.println(vo.toString());
		mapper.boardInsert(vo);
		return "완료";
	}
	
	//게시판 조회 메소드
	@RequestMapping("/boardList.do")
	public @ResponseBody List<petBoardVO> boardList() {
		System.out.println("게시판전체보기 실행");
		List<petBoardVO> list = mapper.boardList();
		return list;
	}
	
	//댓글 조회 메소드
	@RequestMapping("/cmtList.do")
	public @ResponseBody List<CmtVO> cmtList(String board_seq) {
		System.out.println("댓글 전체보기 실행");
		System.out.println(board_seq);
		List<CmtVO> list = mapper.cmtList(board_seq);
		return list;
	}

	
	//댓글 디비 등록 메소드
	@RequestMapping("/cmtInsert.do")
	public @ResponseBody String cmtInsert(CmtVO vo) {
		System.out.println("글쓰기 기능 실행");
		System.out.println(vo.toString());
		mapper.cmtInsert(vo);
		return "완료";
	}

	
	//게시판 글 보기 기능 + 조회수 올라가는 기능 
	@RequestMapping("/boardContents.do")
	public @ResponseBody petBoardVO boardContents(int idx) {
		System.out.println("글보기 기능실행");
		mapper.count(idx);			//해당글을 보면 조회가 올라가는 기능
		petBoardVO vo = mapper.boardContents(idx);
		return vo;
	}
	
	// 게시글 수정
	@RequestMapping("/boardUpdate.do")
	public String boardUpdate(petBoardVO vo) {
		System.out.println("글 수정 실행");
		System.out.println(vo.toString());
		mapper.boardUpdate(vo);
		return "수정완료";
	}
	
	// 게시글 삭제
	@RequestMapping("/boardDelete.do")
	public String boardDelete(int idx) {
		System.out.println("글 삭제 실행");
		System.out.println(idx);
		mapper.boardDelete(idx);
		
		return "redirect:/boardList.do";
	}
}

