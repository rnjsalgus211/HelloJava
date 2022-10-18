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

//메일 발송 화면 만들기
public class MailScreen extends JFrame{
	
	Dimension lbl1 = new Dimension(65, 15); //높이와 넓이를 선언
	Dimension lbl2 = new Dimension(45, 15); 
	JPanel center, bottom; //컴포넌트 모아놓기 위한 컨테이너
	JLabel fromLbl, toLbl, subjectLbl, contentLbl; //발신,수신,제목,내용에 대한 라벨 선언
	JTextField fromTxt, toTxt, subjectTxt; //입력하기 위한 텍스트 필드
	JTextArea contentTxt; //내용을 담기위한 Area (여러 라인에 걸쳐서 작성해야되기 때문)
	JButton send, cancel; 
	
	MailApp app = new MailApp();
	
	
	public MailScreen() {
		setTitle("메일 보내기 UI");
		setSize(340, 300);
		setLayout(new BorderLayout()); //배치관리자 선언
		
		//패널 세팅
		center = new JPanel();
		bottom = new JPanel();
		
		//라벨 세팅
		toLbl = new JLabel("받는 사람");
		fromLbl = new JLabel("보내는 사람");
		subjectLbl = new JLabel("제목: ");
		contentLbl = new JLabel("내용");
		toLbl.setPreferredSize(lbl1);
		fromLbl.setPreferredSize(lbl1);
		subjectLbl.setPreferredSize(lbl1);
		contentLbl.setPreferredSize(lbl2);
		
		//text 필드 세팅   //라벨 + 필드는 center에 붙일것
		toTxt = new JTextField(22); //J텍스트의 생성자 매개값으로 크기를 넣을수 있음.
		fromTxt = new JTextField(22);
		subjectTxt = new JTextField(22);
		contentTxt = new JTextArea(10, 25); //로우와 칼럼을 설정 가능.
		
		//button 세팅
		send = new JButton("보내기");
		send.addActionListener(new MyActionListener()); //ActionListener >>인터페이스 -> 구현객체.
		cancel = new JButton("취소");
		cancel.addActionListener(new MyActionListener());
		
		//container 세팅 add하는 순서대로 만들어짐 순서에 유의하기
		center.add(fromLbl);
		center.add(fromTxt);
		center.add(toLbl);
		center.add(toTxt);
		center.add(subjectLbl);
		center.add(subjectTxt);
		center.add(contentLbl);
		center.add(contentTxt);
		
		//컨테이너에 컴포넌트 배치.
		bottom.add(send);
		bottom.add(cancel);
		
		//윈도우에 컨테이너 배치.
		add("Center", center);
		add("South", bottom);
		
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null); //화면 중앙에 창을 띄우겠습니다.
	}
	
	//기능을 실행하는 구현 객체 생성
	class MyActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			Object src = e.getSource(); //어떤 객체에 이벤트가 발생했는지 알고싶을때
			if(src == send) {
			System.out.println("보내기 버튼 actionPerformed.");
			String from = fromTxt.getText(); //텍스트 필드에 들어있는 값을 읽어들인다.
			String to = toTxt.getText(); //get 값 가져오기 , set 값 지정하기
			String subject = subjectTxt.getText();
			String content = contentTxt.getText();
			
			if(app.sendMail(from, to, subject, content).equals("Success")) {
				//콘솔에 "성공"; -> 값을 지워주도록.
				JOptionPane.showMessageDialog(null, "발송성공!!", "전송결과", JOptionPane.DEFAULT_OPTION);
				System.out.println("성공!");
				fromTxt.setText("");
				toTxt.setText("");
				subjectTxt.setText("");
				contentTxt.setText("");
			}else {
				//콘솔에 "실패"; 
				JOptionPane.showMessageDialog(null, "발송실패!!", "에러", JOptionPane.WARNING_MESSAGE);
				System.out.println("실패!");
			}
			
			
			}else if (src == cancel) {
				System.out.println("취소 버튼 actionPerformed.");
			}
		}
		
		
	}
	
	
	//화면 시작
	public static void main(String[] args) {
		new MailScreen();
	}
	
}




















