<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>   
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--
   select 변경(ko-jo)--> 서버 요청 ???
   1. select로 변경한 로케일이 설정된 selectLang.jsp가 화면에 출력하도록
   2. select box option태그가 요청한 로케일이 선택이 되도록 설정
   3. 만약 로케일 파라미터가 없을경우 기본값은 ko   
 --%>
 
<%   
   // localhost/jstl/selectLang.jsp ==> lang 파라미터 미존재
   // form(button -> select)-->lang 파라미터 존재
   String lang = request.getParameter("lang");
   lang = lang == null ? "ko" : lang;
   pageContext.setAttribute("lang", lang);
%>

<form id="frm" action="${cp}/SelectLangController">
   <select id="langselect" name="lang">
      <option value="ko" <c:if test="${lang =='ko'}">selected</c:if> >한국어</option>
      <option value="ja" <c:if test="${lang =='ja'}">selected</c:if> >日本言</option>
      <option value="en" <c:if test="${lang =='en'}">selected</c:if> >English</option>
   </select> <br>
   <!-- <input type="submit" value="전송"> -->
</form>

<fmt:setLocale value="${lang}"/>
<fmt:bundle basename="kr.or.ddit.msg.msg">
   <fmt:message key="hello" />
   <fmt:message key="visitor">
      <fmt:param value="brown" />
   </fmt:message>
</fmt:bundle>

<script type="text/javascript">
   $("#langselect").change(function(){
      $("#frm").submit();
      
   });
</script>

</body>
</html>