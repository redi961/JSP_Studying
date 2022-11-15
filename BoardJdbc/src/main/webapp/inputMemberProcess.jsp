<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection "%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
//request 
String id = request.getParameter("id");
String pass = request.getParameter("pass");
String name = request.getParameter("name");
String regidate = request.getParameter("regidate");

Class.forName("com.mysql.cj/jdbc.Driver");


//계정 접속
String dburl = "jdbc:mysql://localhost:3306/musthave";
String dbid = "musthave";
String dbpw = "q1w2e3r4";

Connection con = DriverManager.getConnection(dburl,dbid,dbpw);

String sql = "insert into member (id,pass,name) values(?,?,?)";

//PreparedStatement	
PreparedStatement psmt = con.prepareStatement(sql);
psmt.setString(1, id);
psmt.setString(2, pass);
psmt.setString(3, name);
int result = psmt.executeUpdate();

psmt.close();
con.close();

//query

%>




%>

</body>
</html>