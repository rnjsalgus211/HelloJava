package co.edu.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.board.BoardVO;
import co.edu.common.Control;
import co.edu.common.HttpUtil;
import co.edu.service.BoardService;
import co.edu.service.BoardServiceImpl;

public class SearchBoard implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//bno 파라메터를 읽음.
		
		String bno = req.getParameter("bno"); //bno에 값이 들어감

		BoardService service = new BoardServiceImpl();
		BoardVO board = service.findBoard(Integer.parseInt(bno)); //한건 조회. bno를 int로 변경
	
		req.setAttribute("board", board);
		
		HttpUtil.forward(req, resp, "bulletin/searchBulletin.tiles");
		
	}

}
