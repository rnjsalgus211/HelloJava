package co.gui;


import java.awt.Button;
import java.awt.FlowLayout;

//모든 클래스를 임포트
import javax.swing.JButton;
import javax.swing.JFrame;

public class BatchFrame extends JFrame{
	
	
	//생성자 선언
	public BatchFrame() {
		setTitle("배치관리자 UI");
		setSize(300,250);
		//레이아웃 생성 Component 배치 . 화면 구성\\
		setLayout(new FlowLayout());//배치관리자. FlowLayout();
		
		JButton btn1 = new JButton("확인");
		JButton btn2 = new JButton("취소");
		JButton btn3 = new JButton("추가");
		JButton btn4 = new JButton("수정");
		JButton btn5 = new JButton("삭제");
		JButton btn6 = new JButton("조회");
		
		add(btn1);
		add(btn2);
		add(btn3);
		add(btn4);
		add(btn5);
		add(btn6);
		
		
		setVisible(true); //이때까지 만들었던 레이아웃을 화면에 보여주겠습니다.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //x버튼 누르면 종료 기능

		
	}
	
	//메인메소드
	public static void main(String[] args) {
		new BatchFrame();
	}
	
}
