package kr.pet.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface petBoardMapper {

	public List<petBoardVO> boardList();

	public void boardInsert(petBoardVO vo);

	public void count(int idx);

	public petBoardVO boardContents(int idx);

	public void boardUpdate(petBoardVO vo);

	public void boardDelete(int idx);

	
	// 아래부터 댓글 기능
	public List<CmtVO> cmtList(String board_seq);

	public void cmtInsert(CmtVO vo);

}
