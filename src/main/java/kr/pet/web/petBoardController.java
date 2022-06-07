package kr.pet.web;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.pet.mapper.CmtVO;
import kr.pet.mapper.QnaBoardVO;
import kr.pet.mapper.QnaCmtVO;
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

	
	//게시판 글 보기 기능 --- 안드로이드랑 연동 안함 (안해도됨)
	@RequestMapping("/boardContents.do")
	public @ResponseBody petBoardVO boardContents(int board_seq) {
		System.out.println("글보기 기능실행");
		petBoardVO vo = mapper.boardContents(board_seq);
		return vo;
	}
	
	
	
	// 게시글 수정
	@RequestMapping("/boardUpdate.do")
	public @ResponseBody petBoardVO boardUpdate(petBoardVO vo) {
		System.out.println("글 수정 실행");
		System.out.println(vo.toString());
		mapper.boardUpdate(vo);
		return vo;
	}
	
	// 게시글 삭제
	@RequestMapping("/boardDelete.do")
	public @ResponseBody String boardDelete(int board_seq) {
		System.out.println("글 삭제 실행");
		System.out.println(board_seq);
		mapper.boardDelete(board_seq);
		
		return "삭제 완료";
	}
	
	
	
	
	
	
	// 여기부터 문의 사항 게시판 
	
	@RequestMapping("/qnaList.do")
	public @ResponseBody List<QnaBoardVO> qnaList() {
		System.out.println("문의게시판전체보기 실행");
		List<QnaBoardVO> list = mapper.qnaList();
		return list;
	}
	
	//문의글 디비 등록 메소드
	@RequestMapping("/qnaInsert.do")
	public @ResponseBody String qnaInsert(QnaBoardVO vo) {
		System.out.println("문의글쓰기 기능 실행");
		System.out.println(vo.toString());
		mapper.qnaInsert(vo);
		return "완료";
	}
	
	//관리자가쓴 댓글 조회 메소드
	@RequestMapping("/qnaCmtList.do")
	public @ResponseBody List<QnaCmtVO> qnaCmtList(String qna_seq) {
		System.out.println("문의게시판 댓글 전체보기 실행");
		System.out.println("qna seq 값 : "+qna_seq);
		List<QnaCmtVO> list = mapper.qnaCmtList(qna_seq);
		return list;
	}
	
	//관리자 댓글 디비 입력 메소드
	@RequestMapping("/qnaCmtInsert.do")
	public @ResponseBody String qnaCmtInsert(QnaCmtVO vo) {
		System.out.println("글쓰기 기능 실행");
		System.out.println(vo.toString());
		mapper.qnaCmtInsert(vo);
		return "완료";
	}
	
}

