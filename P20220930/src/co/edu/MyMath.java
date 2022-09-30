package co.edu;

public class MyMath {
	// 절대값 구하는 메소드.
	public static int abs(int num) { // 정수에 어떤 값이 들어오면 그 값의 절대값을 산출
		return num > 0 ? num : -num;
	}

	// 제곱(지수) 값 구하는 메소드.
	public static int power(int base, int exponent) {
		int result = 1;
		for (int i = 1; i <= exponent; i++) {
			result = result * base;
		}
		return result;
	}

}
