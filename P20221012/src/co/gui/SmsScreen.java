package co.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import co.gui.MailScreen.MyActionListener;

public class SmsScreen extends JFrame {
	
	Dimension lbl1 = new Dimension(65, 15);
	Dimension lbl2 = new Dimension(45, 15);
	JPanel center, bottom;
	JLabel fromLbl, toLbl, contentLbl;
	JTextField fromTxt, toTxt;
	JTextArea contentTxt;
	JButton send, cancel;
	
	SmsApp app = new SmsApp();
	
	public SmsScreen() {
		setTitle ("문자 보내기 UI");
		setSize (340, 300);
		setLayout(new BorderLayout());
		
		//패널
		center = new JPanel();
		bottom = new JPanel();
		
		//라벨
		toLbl = new JLabel("수신번호");
		fromLbl = new JLabel("발신번호");
		contentLbl = new JLabel("내용");
		toLbl.setPreferredSize(lbl1);
		fromLbl.setPreferredSize(lbl1);
		contentLbl.setPreferredSize(lbl2);
		
		//text 필드
		toTxt = new JTextField(22);
		fromTxt = new JTextField(22);
		contentTxt = new JTextArea(10, 25);
		
		//button
		send = new JButton("보내기");
		send.addActionListener(new MyActionListener());
		cancel = new JButton("취소");
		cancel.addActionListener(new MyActionListener());
		
		//container
		center.add(fromLbl);
		center.add(fromTxt);
		center.add(toLbl);
		center.add(toTxt);
		center.add(contentLbl);
		center.add(contentTxt);
		
		bottom.add(send);
		bottom.add(cancel);
		
		add("Center", center);
		add("South", bottom);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);	
	}
	
		//기능을 실현하는 구현 객체
	class MyActionListener implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				Object src = e.getSource();
				if(src == send) {
					System.out.println("보내기 버튼.");
					String from = fromTxt.getText();
					String to = toTxt.getText();
					String content = contentTxt.getText();
				
				if(app.sendSms(to, from, content).equals("Success")) {
					JOptionPane.showMessageDialog(null, "발송성공!!", "전송결과", JOptionPane.DEFAULT_OPTION);
					System.out.println("성공!");
					toTxt.setText("");
					contentTxt.setText("");
					
				}else {
					JOptionPane.showMessageDialog(null, "발송실패!!", "에러", JOptionPane.WARNING_MESSAGE);
					System.out.println("실패!");
				}
				
					
				}else if (src == cancel) {
					System.out.println("취소버튼.");
				}
				
			}
			
			}
		
	public static void main(String[] args) {
		new SmsScreen();
		
	}

}
