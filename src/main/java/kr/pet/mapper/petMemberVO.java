package kr.pet.mapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class petMemberVO {
	private String mb_id;
	private String mb_pw;
	private String mb_nick;
	private String mb_name;
	private String mb_phone;
	private String mb_address;
	private String mb_joindate;
	private String mb_type;
	
	
}
