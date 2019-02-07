<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>logging.tag</h2>
logging.jsp 출력<br>
<tags:loggings></tags:loggings>
logging.jsp 출력<br>
<tags:loggings/>

<h2>colorLogging.tag</h2>
<tags:colorLogging color="purple" size="50"/>
<tags:colorLogging color="red" size="40"/>
<tags:colorLogging color="green" size="30"/>
<tags:colorLogging color="orange" size="20"/>

</body>
</html>