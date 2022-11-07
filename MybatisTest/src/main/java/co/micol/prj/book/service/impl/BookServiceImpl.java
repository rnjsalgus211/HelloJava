package co.micol.prj.book.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.micol.prj.book.mapper.BookMapper;
import co.micol.prj.book.service.BookService;
import co.micol.prj.book.vo.BookVO;
import co.micol.prj.common.DataSource;

public class BookServiceImpl implements BookService {
	private SqlSession sqlSession = DataSource.getInstance().openSession(true); //true 써주면 오토커밋.
	private BookMapper map = sqlSession.getMapper(BookMapper.class); //DAO를 연결, Mapper도 연결.
	
	@Override
	public List<BookVO> bookSelectList() {
		//북 전체 리스트
		return map.bookSelectList();
	}

	@Override
	public BookVO bookSelect(BookVO vo) {
		//한권의 정보 가져오기
		return map.bookSelect(vo);
	}

	@Override
	public int bookInsert(BookVO vo) {
		//책 입력
		return map.bookInsert(vo);
	}

	@Override
	public int bookDelete(BookVO vo) {
		//책 삭제
		return map.bookDelete(vo);
	}

	@Override
	public int bookUpdate(BookVO vo) {
		//책 수정
		return map.bookUpdate(vo);
	}

}
