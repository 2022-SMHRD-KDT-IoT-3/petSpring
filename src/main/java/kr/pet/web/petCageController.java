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
import kr.pet.mapper.MatchingVO;
import kr.pet.mapper.petBoardVO;
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
		System.out.println("환풍기 컨트롤");
		List<CageInfoVO> list = (List<CageInfoVO>)mapper.select_cage(civo);
		System.out.println(list);
		return list;
	}
	
	
	@RequestMapping("/select_angle.do")
	public @ResponseBody List<CageInfoVO> select_angle(CageInfoVO civo){
		System.out.println("배급기 컨트롤");
		List<CageInfoVO> list = (List<CageInfoVO>)mapper.select_angle(civo);
		System.out.println(list);
		return list;
	}
	
	
	
	
	
	
	//케이지 매칭을 위한 리스트 출력 메소드
	@RequestMapping("/matchingList.do")
	public @ResponseBody List<MatchingVO> matchingList() {
		System.out.println("매칭테이블전체보기 실행");
		List<MatchingVO> list = mapper.matchingList();
		System.out.println("매칭 테이블 출력 : "+list);
		return list;
	}
	
	// 케이지 매칭시 mb_id 입력받아 디비 update하는 메소드
	@RequestMapping("/cageMbidUpdate.do")
	public @ResponseBody String boardUpdate(MatchingVO vo) {
		System.out.println("케이지매칭 아이디 수정 실행");
		System.out.println(vo.toString());
		mapper.cageMbidUpdate(vo);
		return "완료";
	}
	
	
}

