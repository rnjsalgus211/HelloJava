package co.gui;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


//간단한 계산기.
public class ComponentExam3 extends JFrame{
	
	String[] keys = {"1", "2", "3", "+", "4","5","6", //
					"-","7","8","9","*","0","=","C","/"};
	JButton[] keyBtn = new JButton[16];
	String displayText = "";
	String left, right; 
	
	public ComponentExam3() {
		setTitle("계산기 UI");
		setBounds(100, 100, 300, 220); //위치와 크기.
		
		setLayout(new FlowLayout());
		
		//display정보를 출력하기 위한 패널
		JPanel displayPanel = new JPanel();
		JTextField display = new JTextField("0", 20); 
		display.setHorizontalAlignment(JTextField.RIGHT); //수평 정렬할 때 쓰는 메소드
		displayPanel.add(display);
		
		//버튼을 생성하기 위한 패널.
		JPanel keyPanel = new JPanel();
		keyPanel.setLayout(new GridLayout(4, 4, 5, 5));//로우,칼럼 설정
		for(int i =0; i<keyBtn.length; i++) {
			keyBtn[i] = new JButton(keys[i]); //keys의 인덱스 값으로 라벨을 붙이도록 하겠습니다.
			//버튼 이벤트.
			keyBtn[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println(((JButton) e.getSource()).getText());//오브젝트 타입으로 리턴
					
					String keyOper = ((JButton) e.getSource()).getText();
					//계산처리
					if(keyOper.equals("=")) { //=키가 눌러지면
						left = displayText.substring(0, displayText.indexOf("+")); // 345+12 연산자 기준으로 값 구분하기
						right = displayText.substring(displayText.indexOf("+")+1);
						displayText = String.valueOf(Integer.parseInt(left) + Integer.parseInt(right));
						display.setText(displayText);
						return;
					}
					if(keyOper.equals("C")) {
						displayText ="0";
						display.setText(displayText);
						return;
					}
					displayText += keyOper;
					display.setText(displayText); 
					
				}
				
			});
			keyPanel.add(keyBtn[i]);
			
		}
		
		add(displayPanel);
		add(keyPanel);
		
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
	}
	

	public static void main(String[] args) {
		new ComponentExam3();
	}

}
