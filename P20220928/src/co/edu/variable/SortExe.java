package co.edu.variable;

public class SortExe {
	public static void main(String[] args) {
		int[] numAry = {34, 21, 12};
		
		//반복적인 처리
//		numAry = {12, 21, 34}순으로 위치 바꿔서 배열 만들기
//	 	34,21 값 비교하고 두개중에 큰 값의 위치를 뒤로 옮기는 작업
		//케이스 : n1 > n2 > n3 =>?
		//케이스 : n1<n2 >n3 =>?
		//위치 바꾸는 연습 하기.
		if(numAry[0] > numAry[1]) { //34 > 21
			int temp = numAry[0];
			numAry[0] = numAry[1]; // 34위치에 21넣기 작은 값을 앞쪽에 배치
			numAry[1] = temp; // 
		}
		for (int n : numAry) {
			System.out.println(n);
		}
	}

}
