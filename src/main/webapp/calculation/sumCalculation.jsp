<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>sum Result</title>
</head>
<body>

<%

	String a = (String)session.getAttribute("sumResult");
	out.write("sumResult : "+a);

%>

</body>
</html>