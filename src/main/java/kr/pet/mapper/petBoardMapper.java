package kr.pet.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface petBoardMapper {

	public List<petBoardVO> boardList();

	public petBoardVO boardInsert(petBoardVO vo);

}
