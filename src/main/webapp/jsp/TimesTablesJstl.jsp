<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>스크립트릿을 이용한 구구단 출력</h2>
<table border="1">
	<% for(int i=1; i<10; i++){ %>
		<tr>
		<% for(int j=2; j<10; j++){ %>
			<td><%=j + " * " + i + " = " + (i*j) %></td>
		<% } %>
		</tr>
<% } %>
</table><br>

<h2>jstl을 이용한 구구단 출력</h2>
<table border="1">
	<c:forEach begin="1" end="9" var="i">
	<tr>
		<c:forEach begin="2" end="9" var="j">
			<span><td>${j } * ${i } = ${i * j }</td></span>
		</c:forEach>
	</tr>
	</c:forEach>
</table>
</body>
</html>