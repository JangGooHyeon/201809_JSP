<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>with unt_cd</h2>
<form action="${pageContextPath.reqeust.contextPath }/wrapper" method="post">
	<input type="text" name="userId" value="brown"/><br>
	<input type="text" name="unt_cd" value="Line"/><br>
	<input type="submit" value="send"/><br>
</form>

<h2>without unt_cd</h2>
<form action="${pageContextPath.reqeust.contextPath }/wrapper" method="post">
	<input type="text" name="userId" value="brown"/><br>
	<input type="submit" value="send"/><br>
</form>

</body>
</html>