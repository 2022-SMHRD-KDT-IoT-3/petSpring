package kr.pet.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import kr.pet.mapper.DogVO;


@Mapper
public interface petMapper {
	
//	public petMemberVO loginSelectOne(petMemberVO vo);
	
//	public void joinInsert(petMemberVO vo);
	
//	public List<petMemberVO> memberList();

//	public petMemberVO idCheck(String id);
	
	public void dog_update(DogVO dogvo);
}
