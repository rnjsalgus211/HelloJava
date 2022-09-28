package co.edu.variable;

public class GetMaxval {
	public static void main(String[] args) {
		int[] randomAry = new int[5];
		// 0~1사이 임의의 수를 생성. 왼쪽을 int로 설정하면 오류 (math.random은 실수타입)
		randomAry[0] = (int) (Math.random() * 100) + 1; //
		randomAry[1] = (int) (Math.random() * 100) + 1;
		randomAry[2] = (int) (Math.random() * 100) + 1;
		randomAry[3] = (int) (Math.random() * 100) + 1;
		randomAry[4] = (int) (Math.random() * 100) + 1;
		// randomAry[5] =(int)(Math.random()*100)+1; //>배열의 6번째 방에 들어가는 정보 배열의 크기가 정해져있기
		// 때문에 늘릴수없음.

		// 넣어준 랜덤 값을 5번 반복하여 출력
		// 랜덤으로 만들어진 배열 요소 중 가장 큰 값을 maxVal에 담고싶다.
		int maxVal = 0;
		for (int j = 0; j < 5; j++) {
			System.out.println(randomAry[j]);
			if (randomAry[j] > maxVal) {
				maxVal = randomAry[j];
			}
		}
		System.out.println("생성된 배열의 임의의 값 중 최대값 =>" + maxVal);

		int minVal = 100;
		for (int i = 0; i < 5; i++) {
			System.out.println(randomAry[i]);
			// 교수님 답안
			if (randomAry[i] < minVal) {
				minVal = randomAry[i];

			}
		}
		System.out.println("생성된 배열의 임의의 값 중 최소값=>" + minVal);

	}
}
