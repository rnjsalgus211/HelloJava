package co.test.dao;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class DAO {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "kmh";
	private String password = "kmh";
	public Connection conn;
	public ResultSet rs;
	public PreparedStatement psmt;

	//Connection 객체를 반환해주는 getConnect().
	public Connection getConnect() {
		try {
			Properties prop = new Properties();
			prop.load(new FileReader("C:/Temp/database.properties"));
			String driver = prop.getProperty("driver");
			String url = prop.getProperty("url");
			String id = prop.getProperty("user");
			String passwd = prop.getProperty("passwd");
			
			Class.forName(driver);
			conn = DriverManager.getConnection(url,id,passwd);
			System.out.println("연결 성공");
			
		}catch (Exception e) {
			System.out.println("연결실패");
		}
		return conn;
	}
		
	public void conn() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("데이터베이스 연결 실패!!!!");
		}
	}

	public void disconn() {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (psmt != null) {
			try {
				psmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
