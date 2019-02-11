<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>Dashboard Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="<%=request.getContextPath()%>/css/dashboard.css" rel="stylesheet">
  </head>

  <body>
	<%@include file="/module/header.jsp"%>
	<%@include file="/module/left.jsp"%>
	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
		<h1 class="page-header">사용자 정보 조회</h1>
		
		<form id="frm" class="form-horizontal" role="form" action="${pageContextPath.request.contextPath }/userModifyForm" method="get">
		
			<% UserVo user = (UserVo)request.getAttribute("userVo"); %>
			
			<div class="form-group">
				<label for="userNm" class="col-sm-2 control-label">사용자 아이디</label>
				<div class="col-sm-10">
					<label class="control-label">${userVo.getUserId() }</label>
					<input type="hidden" id="userId" name="userId" value="${userVo.userId }"/>
				</div>
			</div>

			<div class="form-group">
				<label for="userNm" class="col-sm-2 control-label">사용자 이름</label>
				<div class="col-sm-10">
					<label class="control-label" ><%=user.getUserNm()%></label>
				</div>
			</div>
			
			<div class="form-group">
				<label for="userNm" class="col-sm-2 control-label">별명</label>
				<div class="col-sm-10">
					<label class="control-label">미구현</label>
				</div>
			</div>

			<div class="form-group">
				<label for="pass" class="col-sm-2 control-label">Password</label>
				<div class="col-sm-10">
					<label class="control-label">********</label>
				</div>
			</div>

			<div class="form-group">
				<label for="userNm" class="col-sm-2 control-label">등록일시</label>
				<div class="col-sm-10">
					<label class="control-label"><%=user.getReg_dt_fmt()%></label>
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button id="btn_modify" type="submit" class="btn btn-default">사용자 정보 수정</button>
				</div>
			</div>
		</form>
		
	</div>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <!--  JQuery가 먼저 load된 후 bootstrap이 로드 된다. -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
    
  </body>
</html>