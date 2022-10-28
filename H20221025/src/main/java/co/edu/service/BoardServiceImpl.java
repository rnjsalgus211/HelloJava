package co.edu.service;

import java.util.List;

import co.edu.board.BoardVO;
import co.edu.board.FaqVO;
import co.edu.board.MemberVO;
import co.edu.dao.BoardDAO;

public class BoardServiceImpl implements BoardService {
	
	BoardDAO dao = new BoardDAO();
	

	@Override
	public BoardVO insertBoard(BoardVO vo) { //입력
		return dao.insertBoard(vo);
	}

	@Override
	public List<BoardVO> getList(BoardVO vo) { //목록조회
		return dao.boardList(vo);
	}

	@Override
	public BoardVO findBoard(int boardNo) { //상세조회
		return dao.searchBoard(boardNo);
	}

	@Override
	public boolean updateBoard(BoardVO vo) { //수정
		return dao.updateBoard(vo);
	}

	@Override
	public boolean deleteBoard(int boardNo) { //삭제
		return dao.deleteBoard(boardNo);
	}

	@Override
	public List<BoardVO> pageList(int page) {
		return dao.pageList(page);
	}

	@Override
	public BoardVO insertQna(BoardVO vo) {
		return dao.insertBoard(vo);
	}

	@Override
	public MemberVO SignUp(MemberVO vo) {
		return dao.SignUp(vo);
	}

	@Override
	public MemberVO login(String id, String passwd) {
		return dao.login(id, passwd);
	}

	@Override
	public List<MemberVO> memberList() {
		return dao.memberList();
	}

	@Override
	public List<FaqVO> pageFAQ(int page) {
		return dao.pageFAQ(page);
	}

	@Override
	public MemberVO getInfo(String id) {
		return dao.getInfo(id);
	}

	@Override
	public boolean update(MemberVO vo) {
		return dao.update(vo);
		
	}

}
