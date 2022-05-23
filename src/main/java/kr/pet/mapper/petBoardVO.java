package kr.pet.mapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class petBoardVO {
	private int board_seq;
	private String mb_id;
	private String board_title;
	private String board_content;
	private int board_viewcount;
	private String board_date;

}
