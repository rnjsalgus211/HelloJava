package co.edu.variable;

public class SortExe {
	public static void main(String[] args) {
		int[] numAry = { 34, 21, 12, 37, 44, 55 };

		// 반복적인 처리
//		numAry = {12, 21, 34}순으로 위치 바꿔서 배열 만들기
//	 	34,21 값 비교하고 두개중에 큰 값의 위치를 뒤로 옮기는 작업
		// 케이스 : n1 > n2 > n3 =>?
		// 케이스 : n1 <n2 >n3 =>?
		// 위치 바꾸는 연습 하기.
		// 1)
//		if (numAry[0] > numAry[1]) { // 34 > 21
//			int temp = numAry[0];
//			numAry[0] = numAry[1]; // 34위치에 21넣기 작은 값을 앞쪽에 배치
//			numAry[1] = temp; //
//		}
//		// )2
//		if (numAry[1] > numAry[2]) {
//			int temp = numAry[1];
//			numAry[1] = numAry[2];
//			numAry[2] = temp;
//		}
//		if (numAry[0] > numAry[1]) { // 34 > 21
//			int temp = numAry[0];
//			numAry[0] = numAry[1]; // 34위치에 21넣기 작은 값을 앞쪽에 배치
//			numAry[1] = temp; //
//		}
		
//		교수님 답안
//		for(int j=0; j<numAry.length-1; j++)
//		for (int i=0; i<numAry.length-1; i++) {
//			if (numAry[i]> numAry[i+1]) {
//				int temp = 0;
//				temp = numAry[i];
//				numAry[i] = numAry[i+1];
//				numAry[i+1] = temp;
//			}
//		}
//		}
		int tmp = 0; //변수 0으로 선언
		for (int i = 0; i < numAry.length; i++) { //i는 배열의 첫번째 (0인덱스)부터 시작
			for (int j = i + 1; j < numAry.length; j++) { //j는 배열의 두번째 (i+1 = 1인덱스)부터 시작
				if (numAry[i] > numAry[j]) { //첫번째 값이 뒤에 값 보다 클 경우
					tmp = numAry[i]; //다른 공간에 첫번째 값을 저장해 둔 뒤
					numAry[i] = numAry[j];// 비어있는 첫번째 공간에 뒤엣값 (작은값)을 넣어줌
					numAry[j] = tmp;// 배열의 두번째 공간에 저장해뒀던 첫번째(큰)값을 넣어줌 이후 계속 반복 
				}
			}
			// 3)순서대로 출력

		}
		for (int n : numAry) {
			System.out.print(n + " ");
		}
	}
}
