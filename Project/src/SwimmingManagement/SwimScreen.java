package SwimmingManagement;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

//화면 만들기
public class SwimScreen extends JFrame implements ActionListener, MouseListener {

	// 입력 항목을 처리 하기 위한 컴포넌트
	private String[] labels = { "회원번호", "이름", "나이 및 성별", "휴대폰번호", "코스", "등록일시" };
	private JTextField[] fields = new JTextField[6];

	// 컴포넌트를 배치하기 위한 컨테이너 역할의 패널들
	private JPanel topPanel;
	private JScrollPane centerPanel; // 스크롤
	private JPanel rightPanel; // 오른쪽에 버튼 배치 시키기 위한 패널

	// 데이터를 담기위한 J테이블
	private JTable table; // 데이터를 테이블 형식으로 보여주도록

	// 이벤트를 일으키기 위한 버튼
	private JButton addBtn, delBtn, findBtn, initBtn;

	SwimDAO2 dao = new SwimDAO2();
	List<Swim> list; // 리스트를 처리하기 위한 컬렉션을 미리 선언.

	public SwimScreen() {
		setTitle("회원정보 관리화면");
		setLayout(new BorderLayout(10, 10));

		// topPanel 추가.
		topPanel = new JPanel(new GridLayout(6, 2));
		for (int i = 0; i < labels.length; i++) {
			topPanel.add(new JLabel(labels[i])); // 라벨의 이름은 라벨즈 배열에 선언되어있는 이름을 사용하겠다.
			fields[i] = new JTextField(30); // 입력할수있는 공간의 너비
			topPanel.add(fields[i]);
		}
		// centerPanel 추가. 타이틀에 들어갈 내용들
		String[] headers = { "회원번호", "이름", "나이 및 성별", "휴대폰번호", "코스", "등록일시" };
		DefaultTableModel model = new DefaultTableModel(headers, 0);

		table = new JTable(model);
		table.addMouseListener(this);
		centerPanel = new JScrollPane(table);

		// 오른쪽 버튼.
		rightPanel = new JPanel(new GridLayout(4, 1));
		addBtn = new JButton("레코드 추가");
		delBtn = new JButton("레코드 삭제");
		findBtn = new JButton("레코드 조회");
		initBtn = new JButton("초기화");
		// 버튼 눌렀을 때 (this)에 구현되어져있는 코드를 실행하겠습니다.
		addBtn.addActionListener(this); // 자신을 가리키는것.
		delBtn.addActionListener(this);
		findBtn.addActionListener(this);
		initBtn.addActionListener(this);

		rightPanel.add(addBtn);
		rightPanel.add(delBtn);
		rightPanel.add(findBtn);
		rightPanel.add(initBtn);

		add("North", topPanel); // 위 입력항목들 배치.
		add("Center", centerPanel);
		add("East", rightPanel);

		setSize(800, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);

	} // end of EmpScreen()

	// DB 조회 후 table에다가 결과를 반영하겠습니다.
	public void searchDate() {
		DefaultTableModel model = (DefaultTableModel) table.getModel(); // 코드 간단하게 작성하기 위해 변수에다가 넣어줌
		
		//화면에 조회된 결과가 있으면 ... clear처리
		int allCnt = model.getRowCount(); //현재 모델에 담겨져있는 데이터 건수를 리턴.
		for(int i=0; i<allCnt; i++) {
			model.removeRow(0); //첫번째 인덱스를 카운트 만큼 삭제하겠습니다. 
		}
		
		
		String[] record = new String[6];
		list = dao.swimList(new Swim(0, fields[1].getText(), null, null, null, null)); // 0이 들어가면 전체 사원을 조회하겠습니다.

		for (int i = 0; i < list.size(); i++) {
			record[0] = String.valueOf(list.get(i).getUserSeq()); // 리스트안에 있는 개수만큼 반복해서 배열의 첫번째에는 사원번호를 넣을것이다.
			record[1] = list.get(i).getUserName();
			record[2] = list.get(i).getUserAge();
			record[3] = list.get(i).getPhoneNum();
			record[4] = list.get(i).getcDate();
			record[5] = list.get(i).getCourse();
			model.addRow(record);

		}

	}

	// 삭제를 위한 메소드
	public void removeDate() {
		// 테이블을 클릭했을 때 처리해주는 이벤트.
		int selectedRow = table.getSelectedRow(); // 선택된 row를 반환.
		if(selectedRow <0) {
			return; //메소드 종료 
		}
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		int userSeq = Integer.parseInt((String) model.getValueAt(selectedRow, 0)); // 선택되어져있는 인덱스값을 기준으로 첫번째(0인덱스, empId)의 값을 가져오겠습니다. 두번째(1인덱스, 이름)

		dao.deleteSwim(userSeq);
		
		model.removeRow(selectedRow); //화면에서 삭제.
		
	
	}
	
	//등록
	public void addDate() {
		String[] records = new String[6];
		
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		for(int i=0; i<fields.length; i++) {
			records[i] = fields[i].getText();
		}
		Swim swim = new Swim(0, records[1], records[2], records[3], records[4], records[5]);
		dao.insertSwim(swim);
		records[0] = String.valueOf(swim.getUserSeq()); //인트타입을 스트링 타입으로 바꾸겠습니다.
		
		model.addRow(records); //매개값이 배열로 들어감.
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// addBtn, delBtn, findBtn, initBtn ... 구분해서 코드 작성
		Object src = e.getSource(); // 이벤트가 발생 한 객체가 어느것인지를 리턴.

		if (src == addBtn) {
			addDate();
		} else if (src == delBtn) {
			removeDate();
		} else if (src == findBtn) {
			searchDate();
		} else if (src == initBtn) {

		}

	}// end of actionPerformed(ActionEvent e)

	// 마우스 이벤트 처리
	@Override
	public void mouseClicked(MouseEvent e) {

	}

	// 프로그램의 시작
	public static void main(String[] args) {
		new SwimScreen();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}// end of class.
