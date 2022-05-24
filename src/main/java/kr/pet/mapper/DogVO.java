package kr.pet.mapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DogVO {
	private String mb_id;
	private String dog_name;
	private String dog_type;
	private int dog_age;
	private String dog_etc;
	

}
