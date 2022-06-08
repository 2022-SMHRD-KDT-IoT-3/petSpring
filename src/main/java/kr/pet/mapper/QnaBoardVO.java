package kr.pet.mapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class QnaBoardVO {
	
	private int qna_seq;
	private String mb_id;
	private String qna_title;
	private String qna_content;
	private String qna_date;
}
