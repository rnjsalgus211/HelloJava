package co.edu.control;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.board.MemberVO;
import co.edu.common.Control;
import co.edu.common.HttpUtil;
import co.edu.service.BoardService;
import co.edu.service.BoardServiceImpl;

public class passwdReConfirmForm implements Control {
	MailApp app = new MailApp();
	
	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = req.getParameter("id");
		System.out.println(id);
		BoardService service = new BoardServiceImpl();
		MemberVO result = service.getInfo(id);
		
		
		Random random = new Random();
		int createNum = 0;
		String ranNum = "";
		int letter = 6;
		String resultNum = "";
		for (int i = 0; i < letter; i++) {

			createNum = random.nextInt(9);
			ranNum = Integer.toString(createNum);
			resultNum += ranNum;
		}

		String email = result.getEmail();
		String from = "" + email + "";
		String to = "rnjsalgus211@naver.com";
		String subject = "회원 비밀번호 입니다.";
		String content = resultNum;
		
		
		app.sendMail(from, to, subject, content);
		
		service.update(new MemberVO(id, resultNum, null, null, null));
		
		HttpUtil.forward(req, resp, "member/loginForm.tiles");
		
		
	}

}
