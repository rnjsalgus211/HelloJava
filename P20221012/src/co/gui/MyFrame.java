package co.gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFrame extends JFrame { //JFrame을 상속 받았기 때문에 윈도우 같은 역할을 할 수 있음.
	
	public MyFrame() {
		//MyFrame 생성자 안에 필요한 Component를 넣을 수 있음
		
		setTitle("윈도우 UI"); //setTitle이라는 메소드는 JFrame이 가지고있음.
		setSize(300, 250); //윈도우 크기 지정 (가로,세로)
		
		setLayout(new FlowLayout()); //배치 관리자.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //X버튼 눌러서 화면 종료.
		JButton btn = new JButton("확인"); // 버튼 Component 만든것.
		JButton btn2 = new JButton("취소");
		
		//어떤 이벤트가 발생하면 그 이벤트를 듣고있다가? 매개값으로 설정되어있는 인터페이스(동작)를 구현해준다. (Listener)
		btn.addActionListener(e ->System.out.println("확인버튼 클릭."));
		
		
		//람다표현식
		btn2.addActionListener((e) -> {
			System.out.println("취소버튼 클릭.");
			System.exit(0); //종료
		});	
		
		
		add(btn); //컨트롤등록 하겠습니다.
		add(btn2);
		
		setVisible(true); //화면 출력
		
	}
	
	
	//메인메소드
	public static void main(String[] args) {
		new MyFrame(); //생성자를 호출해서 실행하겠습니다.
		
		
	}
		
		
		
		
	}

	
	

