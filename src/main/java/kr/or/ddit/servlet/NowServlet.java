package kr.or.ddit.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
* NowServlet.java
*
* @author goo84
* @version 1.0
* @see
*
* <pre>
* << 개정이력(Modification Information) >>
*
* 수정자 수정내용
* ------ ------------------------
* goo84 최초 생성
*
* </pre>
*/
public class NowServlet extends HttpServlet{

	/**
	 * Method : doGet
	 * 작성자 : goo84
	 * 변경이력 :
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 * Method 설명 : 현재 시간을 출력하는 html을 동적으로 생성
	 */
	//doGet : http메소드를 get 메소드 요청을 처리
	
	//get : 1. 웹 브라우저에서 주소줄에 입력 : get 요청
	//		2. <a> 태그 href 속성에 설정된 주소 : get 요청
	
	//post: 1. form tag안에 있는 input 태그중 type="submit"으로 되어있고 form tag태그 action속성이 post인 경우
	//		2. javascript로 post 전송을 강제한 경우
	
	//doget : get요청에 대해 처리해주는 메소드
	//servlet : 자바코드에 html 코드를 삽입하는 형태
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		resp.setContentType("text/html; charset=utf-8"); 
		
		PrintWriter pw = resp.getWriter();
		
//		pw.println("Now Servlet");
		
		pw.println("<!DOCTYPE html>                   ");
		pw.println("<html>                            ");
		pw.println("<head>                            ");
		pw.println("<meta charset=\"UTF-8\">          ");
		pw.println("<title>Insert title here</title>  ");
		pw.println("</head>                           ");
		pw.println("<body>                            ");
		pw.println("	현재시간 : " + (new Date())	   );
		pw.println("</body>                           ");
		pw.println("</html>                           ");
		
		pw.flush();
		pw.close();
		
		// servlet	: 정적인 형태를 갖는 리소스가 아님
		// html/index.html --> localhost:8080/html/index.html
		// src/main/java/kr/or/ddit/servlet/Nowservlet.java
		// url - servlet mapping 작업 필요
		/*
		 *  Mapping 작업
		 *  1.web.xml
		 *  2.annotation
		 *  
		 */
		
	}

	@Override
	public void destroy() {
		System.out.println("destroy");
	}

	@Override
	public void init() throws ServletException {
		System.out.println("init");
	}
	
}
