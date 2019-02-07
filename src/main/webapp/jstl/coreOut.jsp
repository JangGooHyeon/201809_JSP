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
<%
	request.setAttribute("userId", "brown");
	request.removeAttribute("userId");
// 	session.removeAttribute("userId");
// 	application.removeAttribute("userId");
%>
pageScope.userId : ${pageScope.userId } <br>
resultScope.userId : ${resultScope.userId } <br>
sessionScope.userId : ${sessionScope.userId } <br>
applictionScope.userId : ${applictionScope.userId } <br>

userId : <c:out value="${requestScope.userId }" default="수액	"></c:out>

</body>
</html>