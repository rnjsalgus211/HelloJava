package co.edu.nested;

class People {
	int height;
	int weight;
	
	void showInfo() {
		
		
	}
}

class Student extends People{ //People 클래스 상속받았기 때문에 People이 가지고있는 필드 사용할수있음.
	int studNo; 
}

public class AnonymousExampel {
	public static void main(String[] args) {
		//익명 상속 클래스 : Student를 굳이 만들지 않고 상속받는 클래스를 만들어줄때. (클래스를 몇번 사용하지 않을 때)
		People people = new People() {
		//people클래스를 상속받는 익명의 클래스를 선언하겠습니다.	
			String color;
			
			@Override
			void showInfo() {
				System.out.println("익명 showInfo.");
				showColor();
				
			}
			void showColor() {
				System.out.println(this.color);
			}
		};
		people.showInfo();
		
	}
}
