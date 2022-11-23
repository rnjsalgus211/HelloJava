package co.newcomers.prj.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DataSource {
private static SqlSessionFactory sqlSessionFactory; // Mybatis 사용
	
	private DataSource() {} // 생성자를 다른곳에서 생성할 수 없도록
	
	public static SqlSessionFactory getInstance() {
		
		String resource = "config/mybatis-config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			System.out.println("DB 연결성공!!");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("DB 연결실패!!");
		}
		return sqlSessionFactory;
	}
}
