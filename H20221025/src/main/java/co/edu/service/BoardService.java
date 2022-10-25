package co.edu.service;

import java.util.List;

import co.edu.board.BoardVO;

//기능만 정의.
public interface BoardService {
	public BoardVO insertBoard(BoardVO vo); //입력
	public List<BoardVO> getList(BoardVO vo); //목록조회
	public BoardVO findBoard(int boardNo); //한건 조회
	public boolean updateBoard(BoardVO vo); //수정
	public boolean deleteBoard(int boardNo); //한건 삭제
	
	
}
