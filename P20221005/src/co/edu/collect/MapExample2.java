package co.edu.collect;

import java.util.HashMap;
import java.util.Map;

class Book {
	String bookCode;
	String author;
	String publish;
	
	public Book(String bookCode, String author, String publish) {
		this.bookCode = bookCode;
		this.author = author;
		this.publish = publish;
	}
	//hashCod, equals 메소드가 동일한 값이면.
	@Override
	public int hashCode() {
		return bookCode.hashCode(); //문자가 같은 문자면 똑같은 코드값을 리턴
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Book){ //obj가 Book클래스의 인스턴스가 맞으면
			Book target = (Book) obj; 
			return this.bookCode.equals(target.bookCode);
	}else {
		return false;
	}

}
}
public class MapExample2 {
	public static void main(String[] args) {
		Map<Book, Integer> map = new HashMap<>(); //HashMap<>안에 생략가능 앞에 선언한 Book, Integer 자동으로 들어감
		map.put(new Book("234908", "홍길동", "순수출판사"), 2000); ///((키값), 2000(밸류))
		map.put(new Book("125409", "김민수", "한빛미디어"), 3000);
		map.put(new Book("635328", "권미현", "우리출판사"), 5000);
		
							//Book
		Integer val = map.get(new Book("234908", "홍길동", "순수출판사"));
		System.out.println("값: " + val); //null 나옴
		
		
		
	}
}
