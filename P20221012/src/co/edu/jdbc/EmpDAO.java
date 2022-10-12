package co.edu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmpDAO {
	public static void main(String[] args) {
		update();
	}
	
	public static void update() {
		Connection conn = null;
		Statement stmt = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
			stmt = conn.createStatement();
			int d = stmt.executeUpdate("update empl set first_name = 'messi' where employee_id=500");
			System.out.println(d+ "건이 수정되었습니다");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
//				rs.close();
				stmt.close();
				conn.close(); //연결하고 나서는 클로즈
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void delete() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");//클래스가 위치해있는 경로 넣어주기
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
		
		stmt = conn.createStatement();
		int r = stmt.executeUpdate("delete from empl where employee_id=700"); //insert, delete,update
		System.out.println(r+ "건 삭제되었습니다.");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
//				rs.close();
				stmt.close();
				conn.close(); //연결하고 나서는 클로즈
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
		public static void search() {
			//jdbc driver로드
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");//클래스가 위치해있는 경로 넣어주기
				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");//url,사용자계정,패스워드 순
				
				stmt = conn.createStatement(); //해당되는 컬렉션을 통해서 실행할 쿼리문을 전송하고 결과를 받아오도록 하는 객체
				rs = stmt.executeQuery("select * from empl order by employee_id"); //select(조회)할경우
				//Set 컬렉션 
				while(rs.next()) {
					System.out.println("사원번호: " + rs.getInt("employee_id"));
					System.out.println("이름: "+ rs.getString("first_name"));
					System.out.println("급여: "+ rs.getInt("Salary"));
					System.out.println("=========================================");
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				//예외발생, 정상처리 되더라도 반드시 실행 할 코드
				try {
					rs.close();
					stmt.close();
					conn.close(); //연결하고 나서는 클로즈
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			System.out.println("프로그램 종료");
		}
		
		
		
		
	}

