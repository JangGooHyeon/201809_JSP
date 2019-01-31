<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	Cookie[] cookies = request.getCookies();

	for(Cookie cookie : cookies){
		out.write("cookieName : " + cookie.getName() + " / cookieValue : " + cookie.getValue() + "<br>");
	}
	// 1. 웹 브라우저에서 주소줄에 localhost/cookieList
	// 2. /cookieList url을 처리하는 CookieServlet
	// 3. 웹 브라우저의 주소줄로 요청을 보냈기 때문에  get요청이 되고
	// 4. cookieServlet의 doGet()가 실행된다.
	// 5. request.getRequestDispather("/jsp/cookieList.jsp").forward(req, resp)로 위임하여 화면에 출력
%>
	<h1>session</h1>
	session.getId() : <%=session.getId() %>
	
	<h3>서버 사이드 cookie 생성</h3>
<%
	Cookie newCookie = new Cookie("serverSideCookie", "serverSideValue");
	//setMaxAge()는 초단위 값(int형)을 파라미터로 받는다.
	// ex) 5일 : 5*24(hour) * 60(minute) * 60(second)
	newCookie.setMaxAge(5*25*60*60);
	response.addCookie(newCookie);
		
%>	

</body>
</html>