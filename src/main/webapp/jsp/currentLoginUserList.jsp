<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>현재 접속자 : ${currentLoginUserList.size() }</h2>
<%-- currentLoginUserList --%>
<table>
	<tr>
		<th>사용자 아이디</th>
		<th>사용자 이름</th>
		<th>별명</th>
	</tr>
	<c:forEach items="${currentLoginUserList }" var="loginUser">
		<tr>
			<td>${loginUser.userId }</td>
			<td>${loginUser.userNm }</td>
			<td>${loginUser.alias }</td>
		</tr>
	</c:forEach>
</table>

</body>
</html>