package co.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.*;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ComponentExam extends JFrame{
	public ComponentExam() {
		setTitle("라벨 예제");
		setSize(new Dimension(300, 250));
		
		
		JPanel panel = new JPanel(); //컨테이너 역할 라벨을>패널에부착> 윈도우프레임에 부착
		//선언할때 JLabel이라는 객체를 생성
		JLabel label1 = new JLabel("Color Label");
		label1.setFont(new Font("Arial", Font.ITALIC, 20));
		label1.setForeground(Color.YELLOW);
		label1.setText("Yellow Font"); //=>라벨의 값을 지정. setText는 메소드
		
		JLabel label3 = new JLabel();
		ImageIcon icon = new ImageIcon("c:/Temp/fall.jpg");
		//이미지 크기 지정?
		label3.setIcon(icon);
		label3.setPreferredSize(new Dimension(180,150));
		
		JLabel label2 = new JLabel("Font Label");
		label2.setFont(new Font("Arial", Font.BOLD, 25)); //"?" , 폰트디자인, 폰트크기
		label2.setForeground(Color.GREEN);
		
		panel.add(label1);
		panel.add(label2);
		panel.add(label3);
		
		add(panel);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		
	}
	
	public static void main(String[] args) {
		new ComponentExam();
	}
}
