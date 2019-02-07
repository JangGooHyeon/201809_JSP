package kr.or.ddit.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SelectLangController")
public class SelectLangController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// localhost/jstl/selectLang.jsp ==> lang 파라미터 미존재
		//form (button -> select) ==> lang 파라미터 존재
		String lang = request.getParameter("lang");
		lang = lang == null ? "ko" : lang;
		request.setAttribute("lang", lang);
		
		request.getRequestDispatcher("/jstl/selectLangWS.jsp").forward(request, response);
		
	}
	
}
