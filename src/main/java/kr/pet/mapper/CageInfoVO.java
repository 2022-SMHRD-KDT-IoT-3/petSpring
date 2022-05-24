package kr.pet.mapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CageInfoVO {
	private String cg_serial;
	private String mb_id;
	private String cg_gas;
	private String cg_temp;
	private String cg_angle;
	private String cg_time;

}
