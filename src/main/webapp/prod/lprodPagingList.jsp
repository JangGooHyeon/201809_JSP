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
    <link href="<%=request.getContextPath()%>/css/dashboard.css" rel="stylesheet">
  </head>

  <body>
	<%@include file="/module/header.jsp"%>
	<%@include file="/module/left.jsp"%>
	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
		<h1 class="page-header">제품 카테고리</h1>
		<table class="table table-striped">
              <thead>
                <tr>
                  <th>번호</th>
                  <th>분류 코드</th>
                  <th>분류명</th>
                </tr>
              </thead>
              <tbody>
              
              <% 
	              List<LprodVo> list = (List<LprodVo>)request.getAttribute("lprodList");
	              for(int i=0; i<list.size(); i++){ %>
	              	<tr class="lprodTr" data-lprodgu="<%=list.get(i).getLprod_gu()%>">
	              	<% 
		              	out.write("<td>" + list.get(i).getLprod_id()+ "</td>");
		              	out.write("<td>" + list.get(i).getLprod_gu()+ "</td>");
		              	out.write("<td>" + list.get(i).getLprod_nm() + "</td>");
	              	%>
	              	</tr>
              <%  }%>
              
              </tbody>
            </table>
            
            <%
            	int lprodCnt = (Integer)request.getAttribute("lprodCnt");
            	int pageSize = (Integer)request.getAttribute("pageSize");
            	int cPage 	 = (Integer)request.getAttribute("page");
            	int lastPage = lprodCnt/pageSize + (lprodCnt%pageSize > 0 ? 1 : 0);
            	String cp = request.getContextPath();
            %>
		<nav style="text-align: center">
			<ul class="pagination">
				<%if(cPage == 1){ %>
					<li class="disabled">
						<a aria-label="Previous"> <span aria-hidden="true">&laquo;</span></a>
					</li>
				<%} else { %>
					<li>
						<a href="<%=cp%>/lprodPagingList" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a>
					</li>
				<%} %>
	
				<%for(int i = 1; i <= lastPage; i++){ %>
					<li <%if(i == cPage){ %> 
							class="active" 
						<%} %>>
						<a href="<%=cp%>/lprodPagingList?page=<%=i%>"><%=i%></a>
					</li>
				<%} %>
				<li>
					<a href="<%=cp%>/lprodPagingList?page=<%=lastPage%>"aria-label="Next"><span aria-hidden="true">&raquo;</span></a>
				</li>
			</ul>
		</nav>
            
	</div>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <!--  JQuery가 먼저 load된 후 bootstrap이 로드 된다. -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
    
    <script type="text/javascript">
    	//문서로딩이 완료된 이후 이벤트 등록
    	$(document).ready(function(){
    		console.log("document ready");
    		
    		$(".lprodTr").on("click", function(){
    			//클릭한 userTr 태그의 userId값을 출력
    			var lprod_gu = $(this).data("lprodgu");
    			
    			// /user로 이동 방법
    			// 1. document
    			
    			// 2. form태그
    			$("#lprodgu").val(lprod_gu);
    			$("#frm").submit();
				
    		});
    		
    	});
    	
    </script>
    
    
    
  <form id="frm" action="<%=request.getContextPath()%>/prodList" method="get">
  	<input type="hidden" id="lprodgu" name="lprodgu" />
  </form>
  </body>
</html>