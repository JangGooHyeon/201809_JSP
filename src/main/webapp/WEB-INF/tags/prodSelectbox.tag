<%@tag import="java.sql.PreparedStatement"%>
<%@tag import="java.sql.ResultSet"%>
<%@tag import="java.sql.DriverManager"%>
<%@tag import="java.sql.Connection"%>
<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="prod_lgu" required="true" %>
prod_lgu : ${prod_lgu }<br>
<%
	String prod_lgu = (String)jspContext.getAttribute("prod_lgu");
	
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "goo8455";
	String pass = "java";
	
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	
	try{	
		Class.forName(driver);
		conn = DriverManager.getConnection(url, user, pass);
		pst = conn.prepareStatement("select prod_id, prod_name from prod where prod_lgu= ?");
		pst.setString(1, prod_lgu);
		
		rs = pst.executeQuery();
		
		out.write("<select>");
		while(rs.next()){
			out.write("<option id=\"" + rs.getString("prod_id") + "\">" + rs.getString("prod_name") + "</option>");
		}
		out.write("</select>");
		
		conn.close();
	} catch(Exception e){
		e.printStackTrace();
	}
%>