<%@page import="kr.or.ddit.prod.model.ProdVo"%>
<%@page import="kr.or.ddit.prod.model.LprodVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    <link href="${cp }/css/dashboard.css" rel="stylesheet">
  </head>

  <body>
	<%@include file="/module/header.jsp"%>
	<%@include file="/module/left.jsp"%>
	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
		<h1 class="page-header">제품 카테고리</h1>
		<table class="table table-striped">
              <thead>
                <tr>
                  <th>제품 코드</th>
                  <th>제품명</th>
                  <th>판매자</th>
                  <th>제품가격</th>
                </tr>
              </thead>
              <tbody>
              
              <% 
	              List<ProdVo> list = (List<ProdVo>)request.getAttribute("list");
	              for(int i=0; i<list.size(); i++){ %>
	              	<tr>
	              	<% 
		              	out.write("<td>" + list.get(i).getProd_id()+ "</td>");
		              	out.write("<td>" + list.get(i).getProd_name()+ "</td>");
		              	out.write("<td>" + list.get(i).getProd_buyer() + "</td>");
		              	out.write("<td>" + list.get(i).getProd_cost() + "</td>");
	              	%>
	              	</tr>
              <%  }%>
              
              </tbody>
            </table>
	</div>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <!--  JQuery가 먼저 load된 후 bootstrap이 로드 된다. -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
    
  </body>
</html>