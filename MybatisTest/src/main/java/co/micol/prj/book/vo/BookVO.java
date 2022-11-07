package co.micol.prj.book.vo;

import lombok.Getter;
import lombok.Setter;

//자바에서는 @Data 사용
@Getter
@Setter
public class BookVO {
	private String bookCode;
	private String bookTitle;
	private String bookAuthor;
	private String bookPress;
	private int bookPrice;
}
