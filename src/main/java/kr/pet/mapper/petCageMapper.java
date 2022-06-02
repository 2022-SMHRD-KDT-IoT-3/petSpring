package kr.pet.mapper;

import org.apache.ibatis.annotations.Mapper;


	@Mapper
	public interface petCageMapper {


	public void Register(CageVO cvo);

}
