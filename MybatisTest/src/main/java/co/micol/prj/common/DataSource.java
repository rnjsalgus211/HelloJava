package co.micol.prj.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionException;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DataSource {
	private static SqlSessionFactory sqlSessionFactory; //Mybatis 사용
	
//	private static DataSource dataSource;
	
	private DataSource() {} // 생성자를 다른곳에서 생성하지 못하도록 묶어두기
	
	public static SqlSessionFactory getInstance() {		
		String resource = "config/mybatis-config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			System.out.println("DB 연결 성공");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("DB 연결 실패"); //mybatis가 동작하지 않는것.
		}
		
		return sqlSessionFactory;
	}
	
	
}
