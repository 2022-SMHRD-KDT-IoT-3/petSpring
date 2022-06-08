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
	private String cg_gas;
	private String cg_temp;
	private String cg_hum;
	private String cg_angle;
	private String cg_time;
	private String cg_motor;

	public CageInfoVO(String cg_serial, String cg_gas, String cg_temp, String cg_hum, String cg_angle, String cg_motor) {
		super();
		this.cg_serial = cg_serial;
		this.cg_gas = cg_gas;
		this.cg_temp = cg_temp;
		this.cg_hum = cg_hum;
		this.cg_angle = cg_angle;
		this.cg_motor = cg_motor;
		
	}
}
