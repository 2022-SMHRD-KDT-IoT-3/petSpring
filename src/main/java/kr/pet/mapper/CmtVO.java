package kr.pet.mapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CmtVO {
	private int board_seq;
	private int cmt_seq;
	private String mb_id;
	private String cmt_content;
	private String cmt_date;

}
