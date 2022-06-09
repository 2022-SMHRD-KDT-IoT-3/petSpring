package kr.pet.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;


	@Mapper
	public interface petCageMapper {


	public void Register(CageVO cvo);
	

	public List<CageInfoVO> select_cage(CageInfoVO civo);


	public List<CageInfoVO> select_angle(CageInfoVO civo);
	
	
	
	
}
