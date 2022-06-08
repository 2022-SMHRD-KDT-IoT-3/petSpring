package kr.pet.mapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class QnaCmtVO {

	private int qna_seq;
	private String qna_cmt_content;
	private String qna_cmt_date;
}
