<%@page import="org.apache.commons.dbcp2.BasicDataSource"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%	
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null; // 쿼리문이 select일 결우에 필요함
	BasicDataSource bds = null;
	
	try {
		// connection pool준비
		bds = new BasicDataSource();
		bds.setUsername("goo8455");
		bds.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		bds.setPassword("java");
		bds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		bds.setInitialSize(5);
		
// 		Class.forNme("oracle.jdbc.driver.OracleDriver");
	   
// 		String url = "jdbc:oracle:thin:@localhost:1521/xe";
// 		String userId = "goo8455";
// 		String password = "java";
		conn = bds.getConnection();
		   
	   	stmt = conn.createStatement();
	   
	   	String sql = "select * from lprod";  
	   	rs = stmt.executeQuery(sql);  
	   
	   	while(rs.next()) {
	    	out.write("lprod_id : " + rs.getInt("lprod_id") + "<br>");
	      	out.write("lprod_gu : " + rs.getString("lprod_gu") + "<br>");
	      	out.write("lprod_nm : " + rs.getString("lprod_nm") + "<br>");
	      	out.write("-----------------------------------" + "<br>");
	   	}
	   
	}catch(SQLException e) {
   	e.printStackTrace();
   
	}finally {
   		if(rs != null) try {rs.close();} catch (SQLException e2) {}
   		if(stmt != null) try {stmt.close();} catch (SQLException e2) {} 
   		if(conn != null) try {conn.close();} catch (SQLException e2) {}
	   
	}
	bds.close();
	// localhost/connection/connectionPool.jsp
	
%>
</body>
</html>