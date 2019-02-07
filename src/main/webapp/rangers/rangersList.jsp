<%@ page import="java.util.List"%>
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
	
<%
	List<String> rangersList = (List<String>)request.getAttribute("rangersList");

%>
<table border="1">
	<tr>
		<th>이름</th>
	</tr>
<!-- 	출력 -->
	<% 
		for(String ranger : rangersList){
			out.write("<tr>");
			out.write("<td>"+ ranger +"</td>");
			out.write("</tr>");
		}
	%>
</table>

<h2>jstl / el</h2>

<table border="1">
	<tr>
		<th>이름</th>
	</tr>
<!-- 	for(String srt : request.getAttribute("rangersList"))와 동일 -->
	<c:forEach items="${rangersList }" var="ranger">
		<tr>
			<td>${ranger }</td>
		</tr>
	</c:forEach>
</table>
<!-- localhost/rangersList -->

<h2>jstl / el - vo</h2>
<table border="1">
	<tr>
		<th>이름</th>
		<th>별명</th>
		<th>나이</th>
	</tr>
	<c:forEach items="${rangersVoList }" var="ranger">
	<tr>
<!-- 		foreach를 사용할 때, List객체의 값을 가져오기 위해 getter를 호출한다. getter를 호출하는 형식은 '객체명.필드명'이다. -->
<!-- 		이때, List객체의 제너릭 타입의 객체를 참조한다...? -->
		<td>${ranger.name }</td> <%-- <td>${ranger.getName() }</td>와 동일 --%>
<%-- 		<td>${ranger.test }</td> <!-- getTest()가 alias를 반환하기 때문에 별명을 한번 더 출력함 -->  --%>
		<td>${ranger.alias }</td>
		<td>${ranger.age }</td>
	</tr>	
	</c:forEach>
</table>

<h3>동일한 속성명(Attribute)</h3>
userName(표현식) : <%=request.getAttribute("userName") %> <br>
userName(el-default) : ${userName } <br>
userName(el-request) : ${requestScope.userName } <br>
userName(el-session) : ${sessionScope.userName } <br>
userName(el-application) : ${applicationScope.userName } <br>
<!-- request ->> session ->> application -->

<h2>el 기본 객체 param</h2>
표현식 : <%=request.getParameter("p") %> <br>
el : ${param.p } <br>


</body>
</html>






