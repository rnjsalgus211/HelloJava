package co.edu.collect;

import java.util.LinkedList;
import java.util.Queue;

public class QueExample {
	public static void main(String[] args) {
		Queue<String> que = new LinkedList<>(); //구현하는 대표적인 클래스가 LinkedList.
		//추가
		que.offer("Hong");
		que.offer("Park");
		que.offer("Choi");
		
		while(!que.isEmpty()) { //->값이 있을 동안에는 계속 출력하겠습니다. 컬렉션안에 값이 있는지 없는지 체크(isEmpty())
			System.out.println(que.poll());
			
			
			
		}
			
	}
}
