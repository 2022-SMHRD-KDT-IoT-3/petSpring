package kr.pet.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import kr.pet.mapper.DogVO;


@Mapper
public interface petMapper {
	
	
//	public void joinInsert(petMemberVO vo);
	

	
	public void dog_update(DogVO dogvo);

	public void dog_regist(DogVO dogvo);

	
}
