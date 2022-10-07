package co.edu.collect;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

//이것이 자바다 740p
public class MapExample {
	public static void main(String[] args) {
		//key:Integer, val:String 키,밸류값을 둘다 설정해주어야함.
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(100, "홍길동");
		map.put(200, "권미현");
		map.put(300, "박문식");
		map.put(300,  "윤문식");
		
		map.remove(300); //키 값 넣으면 삭제
		
		System.out.println("컬렉션: " + map.size());
		System.out.println("Val: " + map.get(300)); //get은 키값 넣어주면 값을 리턴해주는 메소드
		
		//반복자 생성. 맵 컬렉션은 한번에 반복할수있는 방법이 없어서
		//키 컬렉션에 있는 값들을 셋 컬렉션에 넣어주고 
		//셋 컬렉션에 담긴 키 값을 통해서 
		Set<Integer> keySet = map.keySet(); //키만 새로운 set컬렉션에 저장
		 	for(Integer key : keySet) {                        //get(key)라고 해야 키에 해당하는 밸류 값 불러옴
		 		System.out.println("키: " + key + ", 값: " + map.get(key));
		 	}
		 	//<Entry>다음 키와 밸류가 무슨 타입인지 꼭 적어줘야함
		 	Set<Entry<Integer, String>> entSet = map.entrySet(); // entry(key+value)값 가져와서 set컬렉션에 저장.
		 	for(Entry<Integer, String>ent : entSet) { //entSet컬렉션안의 요소 갯수만큼 반복을 돌겠다, 가지고 오는 타입은 Entry타입
		 		System.out.println("키: " + ent.getKey()+ ", 값: "+ ent.getValue());
		 		
		 	}
		 	
		 	
		 	
	}
}
