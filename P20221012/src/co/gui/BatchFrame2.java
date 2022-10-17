package co.gui;

import java.awt.BorderLayout;

import javax.swing.*;

public class BatchFrame2 extends JFrame{
	
	public BatchFrame2() {
		setTitle("BorderLayout 관리자");
		setSize(300, 250);
		
		setLayout(new BorderLayout(10, 10)); //좌우 여백
		
		JButton top = new JButton("top");
		JButton left = new JButton("left");
		JButton center = new JButton("center");
		JButton right = new JButton("right");
		JButton bottom = new JButton("bottom");
		
		add("North", top);
		add("West", left);
		add("Center", center);
		add("East", right);
		add("South", bottom);
		
		
		setVisible(true); //Component를 다 선언한 후에 setVisible을 호출해줘야 화면에 다 보여줌
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null); //윈도우 화면의 중앙
		
		
		
	}
	
	//메인메소드
	public static void main(String[] args) {
		new BatchFrame2();
	}

}
