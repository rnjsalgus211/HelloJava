package co.edu.collect;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

//이것이 자바다 724p참고
public class ListExample {
	public static void main(String[] args) {
		//만들어진 인스턴스 값을 strs라는 변수에 담겠다.
		ArrayList<String> strs = new ArrayList<String>(); 
		//추가.
		strs.add("홍길동");
		strs.add("김민식");
		strs.add("박유식");
		
		strs.remove(0); //인덱스 값으로 지울수도 있고
		strs.remove("박유식"); //'박유식'이라는 값을 지울수도 있다.
		
		strs.add(0, "최기분"); //첫번째(0인덱스)위치에 '최기분'을 넣겠다. 
		//넣으면 원래 있던 값이 뒤로 밀림
		
		System.out.println("collect크기: " + strs.size());
		
		for(String str : strs) { //확장 for를 사용하는게 가장 간단
			System.out.println(str); 
		}
		for (int i = 0; i < strs.size(); i ++) {
			System.out.printf("%d번째의 값은 %s \n", i,strs.get(i));
					}
		//반복자를 생성.
		Iterator<String> itr = strs.iterator(); //요소?
		while(itr.hasNext()) {
			String result = itr.next();
			System.out.println(result);
		}
		//100만건
		ArrayList<Integer> inAry = new ArrayList<Integer>();
		long start = System.nanoTime(); // 현재 시점을 nano타임으로 기록
		for(int i=0; i<10000; i++) {
			inAry.add(0, i); //앞에 공간을 만들어주고 미는 작업 계속하기때문에 상대적으로 오래걸림
		}
		long end = System.nanoTime(); // 현재 시점을 nano타임으로 기록
		System.out.println("Aray: " + (end-start));
		
		LinkedList<Integer> InAry = new LinkedList<Integer>();
		start = System.nanoTime(); // 현재 시점을 nano타임으로 기록
		for(int i=0; i<10000; i++) {
			InAry.add(0, i); 
		}
		end = System.nanoTime(); // 현재 시점을 nano타임으로 기록
		System.out.println("lna: " + (end-start));
		
		
		
		
	}
}
