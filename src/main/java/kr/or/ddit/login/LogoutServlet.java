package kr.or.ddit.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	
	private Logger logger = LoggerFactory.getLogger(LogoutServlet.class);
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//logout기능 구현
		//session객체 무효화
		//1. 정해진 시간이 지날 경우
		//2. session.invalidate()메소드를 호출 할 경우
		
		//session 활성화 시간 설정
		//1. session.setMaxInactiveInterval(60*60);
		// session 활성화 시간을 설정하는 메소드(초 단위로 설정 가능) -> 60(초) * 60(분) 
		
		//2. web.xml에서 설정
		//<session-config>
		//	<session-timeout>분단위</session-timeout>
		//</session-config>
		
		HttpSession session = request.getSession();
		session.invalidate();
		
		//로그인 페이지로 이동
		request.getRequestDispatcher("/login").forward(request, response);
	}

}
