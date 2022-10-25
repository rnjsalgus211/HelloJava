package co.edu.board;

import lombok.Data;

@Data
public class BoardVO { //Value Object를 담당하는 클래스
	private int boardNo;
	private String title;
	private String content;
	private String writer;
	private String writeDate;
	private int clickCnt;
	private String image;

}
