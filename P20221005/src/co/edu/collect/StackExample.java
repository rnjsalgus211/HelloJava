package co.edu.collect;

import java.util.Stack;

class Coin{
	private int val;
	public Coin(int val) {
		this.val = val;
		
	}
	public int getVal() {
		return val;
		
	}
}

public class StackExample {
	public static void main(String[] args) {
		Stack<Coin> coinBox = new Stack<>();
		//추가할때는 push 사용
		coinBox.push(new Coin(100));
		coinBox.push(new Coin(60));
		coinBox.push(new Coin(80));
		
		//출력.
		while(!coinBox.isEmpty()) { //->값이 있을 동안에는 계속 출력 해주세요 /isEmpty는 값이 있으면 false, 없으면 true.
			Coin coin = coinBox.pop(); // 마지막 인스턴스부터
			System.out.println(coin.getVal());
			
		}
		
	}
}
