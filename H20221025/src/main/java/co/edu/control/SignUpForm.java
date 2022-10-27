package co.edu.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.common.Control;
import co.edu.common.HttpUtil;

public class SignUpForm implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//responsibility는 user로 고정해서 받기 (기본값)
		//memberForm으로 이동해서 사용자가 값을 입력해주도록.
		HttpUtil.forward(req, resp, "member/memberForm.tiles");
	}

}
