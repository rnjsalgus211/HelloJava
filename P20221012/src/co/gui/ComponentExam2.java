package co.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.*;

//입력
public class ComponentExam2 extends JFrame {

	public ComponentExam2() {
		setTitle("입력 필드UI");
		setSize(350, 300);
		Dimension lblDim = new Dimension(60, 16);
		
		setLayout(new BorderLayout()); //센터하고 아래쪽만 설정하면 센터가 전체너비 차지		
		
		//panel : 컨테이너 역할
		JPanel center = new JPanel();
		JPanel bottom = new JPanel();
		
		JLabel idLbl = new JLabel("id");
		idLbl.setPreferredSize(lblDim);
		JLabel pwLbl = new JLabel("password");
		pwLbl.setPreferredSize(lblDim);
		JTextField idTxt = new JTextField(23); //매개값을 넣어서 크기를 지정 
		JPasswordField pwTxt = new JPasswordField(23); //비밀번호를 안보이게
		
		//패널에 라벨을 부착
		center.add(idLbl);
		center.add(idTxt);
		center.add(pwLbl);
		center.add(pwTxt);
		
		JButton btn = new JButton("확인");
		bottom.add(btn);
	
		
		//패널을 윈도우에 부착
		add("Center", center);
		add("South", bottom);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
	}
	
	public static void main(String[] args) {
		new ComponentExam2();
	}
}
