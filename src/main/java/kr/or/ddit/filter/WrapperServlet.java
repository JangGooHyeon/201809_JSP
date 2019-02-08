package kr.or.ddit.filter;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/wrapper")
public class WrapperServlet extends HttpServlet {

	//wrapper test page 요청
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/wrapper/wrapperTest.jsp").forward(request, response);
	}

	//wrapper test page에서 parameter 전송 요청
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/wrapper/wrapperResult.jsp").forward(request, response);
	}

	
	
}
