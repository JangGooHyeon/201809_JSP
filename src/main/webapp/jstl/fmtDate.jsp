<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:set var="now" value="<%= new Date() %>"></c:set>
now : ${now }<br>
<%-- date ==> String --%>

<h2>ko</h2>
<fmt:setLocale value="ko_kr"/>
ko date : <fmt:formatDate value="${now }"/><br>
ko date pattern : <fmt:formatDate value="${now }" pattern="yyyy-MM-dd"/><br>

<h2>de</h2>
<fmt:setLocale value="de_de"/>
de date : <fmt:formatDate value="${now }"/><br>

<%-- String ==> date --%>
<h2>String ==> date </h2>
parse date : <fmt:parseDate value="2019-02-13 02:26" pattern="yyyy-MM-dd HH:mm"></fmt:parseDate><br>

<h2>time zone</h2>
<fmt:timeZone value="Asia/Shanghai"> 
shanghai : <fmt:formatDate value="${now }" pattern="yyyy-MM-dd HH:mm"/><br>
</fmt:timeZone>

<h2>setTimezone</h2>
<fmt:setTimeZone value="US/Alaska" var="alaska"/>
alaska : <fmt:formatDate value="${now }" timeZone="${alaska }" pattern="yyyy-MM-dd HH:mm"/><br>

</body>
</html>