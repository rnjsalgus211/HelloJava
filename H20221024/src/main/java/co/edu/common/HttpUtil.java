package co.edu.common;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpUtil {
	public static void forward(HttpServletRequest req //
			, HttpServletResponse resp//
			, String path) {

		RequestDispatcher rs = req.getRequestDispatcher(path);
		try {
			rs.forward(req, resp); //first.do를 호출하면 WEB-INF/jsp/first.jpg 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
