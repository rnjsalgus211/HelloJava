package co.edu.service;

import java.util.List;

import co.edu.board.BoardVO;
import co.edu.board.FaqVO;
import co.edu.board.MemberVO;

public interface BoardService {
	//기능만 정의.
	public BoardVO insertBoard(BoardVO vo); //입력기능
	public List<BoardVO> getList(BoardVO vo); //목록조회
	public BoardVO findBoard(int boardNo); //한건 조회
	public boolean updateBoard(BoardVO vo); //수정
	public boolean deleteBoard(int boardNo); //삭제
	public BoardVO insertQna(BoardVO vo);//등록
	public MemberVO SignUp(MemberVO vo); //회원가입
	public MemberVO login(String id, String passwd);  //로그인
	public List<MemberVO> memberList(); //회원목록
	
	//페이지 기능.
	public List<BoardVO> pageList(int page);
	public List<FaqVO> pageFAQ(int page); //FAQ 목록

}
