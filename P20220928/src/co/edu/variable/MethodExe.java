package co.edu.variable;

public class MethodExe {
	// 메소드(기능): 오브젝트 멤버
	// public static 반환값 printHello(매개변수{
	// ..실행문...
	// }
	// main 메소드: 첫번째 실행.
	public static void main(String[] args) {
		printStar(); // 1)실행
		printStar(3); // 2)실행, 변수 타입은 적어줄 필요 없고 실제 값이 들어가면 됨
		printCircle("@");//3)실행
		printCircle("♡", 5);//4)실행
		int result = sum(sum(2,3), sum(3,4));//5)실행
		
	}

	// 별을 출력하는 메소드를 만들겠습니다. 1)반환값도 없고 매개변수도 없는 유형의 메소드
	public static void printStar() {
		System.out.println("★");
	}

	// 2)반환값 없음, 매개변수 있음
	public static void printStar(int times) {
		for (int i = 0; i < times; i++) {
			System.out.println("★");
		}
	}
	//3)
	public static void printCircle(String circle) {// 내가 찍고 싶은 값을 매개값으로 받아서 출력
		System.out.println(circle);
	}

	// 어떤 도형circle이 몇번times 반복될지 정하겠다, 단 변수의 데이터 타입 주의 String일 경우 문자 타입만 입력 가능
	//4)
	public static void printCircle(String circle, int times) {
		for (int i = 0; i < times; i++) {
			System.out.print(circle);
		}	System.out.println();
		
	}//5) 반환(return)값을 가지는 메소드 
	public static int sum(int n1, int n2) {
		int result = n1*2 + n2*3;
		System.out.println(n1 +"x"+ n2 +"의 결과값은 "+ result + "입니다.");
		return result; //반환 값의 유형은 int
	}
	
	}

