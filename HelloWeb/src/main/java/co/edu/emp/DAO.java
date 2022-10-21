package co.edu.emp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

//데이터 베이스를 처리해주는 클래스 (DB연결 Connection객체 생성).
public class DAO {
	Connection conn;
	Statement stmt;
	ResultSet rs;
	PreparedStatement psmt;
	
	//Connection 반환 getConnect메소드 만들기
	public Connection getConnect() {
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
		System.out.println("연결 성공");
		}catch(Exception e) {
			System.out.println("연결 실패");
		}
		return conn;
	}
		
	//Resource 해제하는 disconnect메소드 만들기
	public void disconnect() {
		try {
		if(rs != null) rs.close(); 
		if(stmt != null) stmt.close();
		if(conn != null) conn.close();
		if(psmt != null) psmt.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
