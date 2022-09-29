package co.edu.variable;

public class MethodExample {
	// 가로, 세로의 길이 => 넓이가 나오도록
	// 매개변수 계산 식을 return 값으로 저장
	public static int getArea(int x, int y) {
		int res = x*y;
		return res;
	}
	// 배열 요소의 각 값의 합
	
	public static int sumAry(int[] ary) {
		int sum =0;
		for(int i=0; i<ary.length; i++) {
			sum = sum + ary[i];
		}return sum;
	}
	//두수를 나눈 결과를 반환하는 메소드를 만들어보자.
	public static double divide(double n1, double n2) {
		double result= n1/n2;
		return result;
	}
	
	//두수를 나누는 작업. n1이 인트고 n2가 롱이면 n1가 long 타입으로 자동변환 (큰 타입으로 자동형변환)
	public static double divide(int n1, long n2) {
		//1bit * 8 => 1byte ( -128~ 127 값만 담을 수 있음 )
		//유형 : 정수는 byte(1byte), short(2byte), int(4byte), long(8byte)
		//    : 실수는 float(4byte), double(8byte)
		if (n2 ==0) { //0으로 나누었을 때 무한값이 뜨는 것을 방지 하기위해 0일때 0값을 리턴해줌
			return 0;
		}
		double result = (double) n1 /n2; //3 /2 => 1.5 나누면 실수값 나올 확률이 크니까 나눠진 값을 double로 (강제 형변환)받아줌 
		return result;
	}
	//매개변수에 값을 입력했을 때 return값에서 받아온 계산식에 대입하여 결과 출력
	public static void main(String[] args) {
	 int result = getArea(20, 15);
	 System.out.println("전체 너비는 "+ result);
	 
	 int[] intAry = {23, 45, 12};
	 result = sumAry(intAry);
	 System.out.println("전체 배열 요소의 합계는" + result);
	 
	 //실수. float, double(float 보다 더 큰 값 담을수 있음)타입 >> 보통은 double타입 사용
	 double d1 = 23.4567;
	 double d2 = 12.34;
	 double d3 = d1+d2; //데이터 타입 동일하게 정해주기
	 
	 d3 = divide(d1, d2);
	 System.out.println("나눈 결과는"+ d3);
	 d3 = divide(3, 2);
	 System.out.println("나눈 결과는" + d3);
//	 int[] intAry2 = {22,33,44,55};
//	 result = sumAry(intAry2);
//	 System.out.println("2.전체 배열 요소의 합계는" + result);

//	 int sum = 0;
//	 for(int i=0; i<intAry.length; i++) {
//		 sum = sum + intAry[i];
//		 System.out.println(sum);
//	 }
	}
	
}
