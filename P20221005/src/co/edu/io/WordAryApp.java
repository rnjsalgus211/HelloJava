package co.edu.io;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class WordAryApp {
	public static void main(String[] args) throws Exception {
		Scanner scn = new Scanner(System.in);
		//임의 문장을 10개씩 출력하고, 타이핑해서 맞으면 사라지고 아니면 남아있도록
		ArrayList<String> words = randomWords(10);
		
		for(String word : words) {
			System.out.println(word);
		}
		//하나씩 찾아서 지우기.
		while(true) {
			System.out.println("입력>>");
			String text = scn.nextLine();
		for(int i=0; i<words.size(); i++) {
			if(words.get(i)!=null && words.get(i).equals(text)) {
				words.remove(i);		
			}
		}
		System.out.println("삭제되었습니다.");
		

		for(String word : words) {
			if(word!=null) {
				System.out.printf("%s", word);
			}
		}
		if(words.isEmpty()) {
			System.out.println("모든 문장을 삭제했습니다.");
			break;
		}
		
			
			
		}
		
	}
	
	public static ArrayList<String> randomWords(int times) throws Exception{
		//ArrayList<String> 전체 문장을 담고..
		//매개값으로 10이라는 값을 받으면 전체 문장에서 랜덤으로 10개 출력해주도록
		ArrayList<String> words = new ArrayList<String>();
		String path = "src/co/edu/io/wordAry.txt"; //이 경로에 있는 파일을
		File file = new File(path); //파일 객체로 하나 만들겠습니다.
		Scanner scn = new Scanner(file); //file객체를 읽기용도로
		while(scn.hasNext()) { //hasNext >> 읽어올 값이 있는지 체크하는 메소드
		String readStr = scn.nextLine(); //nextLine>> 한문장을 읽어오는 메소드
		readStr = readStr.replaceAll("\"", "").trim(); //따옴표 삭제하고 trim으로 양쪽 여백 삭제
//		System.out.println(readStr);
		words.add(readStr.substring(0,readStr.indexOf(","))); //문장의 처음부터 ,까지 잘라오도록
		
		}
		
		//임의의 갯수 times 갯수만큼 반환하도록.
		ArrayList<String> randomWords = new ArrayList<String>();
		for(int i=0; i<times; i++) {
			//words.indexOf((int) ((Math.random()*494)+1));
				randomWords.add(words.get(((int)((Math.random()*494)))));
//				int random = (int) (Math.random() *494);
//				randomWords.add(words.get(random));
		//중복된 값을 제거.
		Set<Integer> idxSet = new HashSet<>();
		while (idxSet.size() > times) {
			idxSet.add((int) (Math.random() * words.size()));
		}
		for(int idx : idxSet) {
			randomWords.add(words.get(idx));
		}
 		}
		
		scn.close();
		return randomWords;
	}
}
