<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%-- factorial 메소드 로직 작성 
	 jsp 스크립틀릿을 이용한 1부터 8까지 factorial을 화면에 출력--%>

<%! public int factorial(int param){
	if (param <= 1){
		return param;
	} else {
		return factorial(param-1) * param;
	}
}
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

Factorial 구하기<br><br>

<% for(int i=1; i<9; i++){ %>
	factorial <%= i %>! : <%= factorial(i) %><br>
<% } %>

</body>
</html>