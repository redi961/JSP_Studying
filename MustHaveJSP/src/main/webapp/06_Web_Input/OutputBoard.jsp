<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="org.apache.catalina.startup.ConnectorCreateRule"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection" %>
<%@ page import="common.BoardDTO"%>
<%@ page import="common.member_DTO" %>
<%@page import="java.sql.PreparedStatement" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	List <BoardDTO> list = new ArrayList<>();
	List <member_DTO> list2 = new ArrayList<>();
%>
    <%
	//드라이버 로드
	Class.forName("com.mysql.cj.jdbc.Driver");
	
	// 3. 데이터베이스 연결
	String durl = "jdbc:mysql://localhost:3306/musthave";
	String dbid = "musthave";
	String dbpw = "tiger";
	Connection con = DriverManager.getConnection(durl, dbid, dbpw);

	//statement
	Statement st = con.createStatement();
	Statement st2 = con.createStatement();
	
	//query 실행
	ResultSet rs = st.executeQuery("select * from board order by num limit 10");
	ResultSet rs2 = st2.executeQuery("select * from member");
	
	//실행 결과를 객체 리스트에 저장
 	 while(rs.next()) {
		list.add(new BoardDTO(
				rs.getInt("num"),
				rs.getString("title"),
				rs.getString("content"),
				rs.getString("id"),
				rs.getString("postdate"),
				rs.getInt("visitcount")
				));
	}  

	while(rs2.next()) {
		list2.add(new member_DTO(
				rs2.getString("id"),
				rs2.getString("pass"),
				rs2.getString("name"),
				rs2.getString("regidate")
				));
	}
	rs2.close();
	st2.close();
	con.close();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
<h2>보드 테이블</h2>
<%
	for (BoardDTO d : list) {
%>
	<tr>
		<td><%=d.getNum() %></td>
		<td><%=d.getTitle() %></td>
		<td><%=d.getContent() %></td>
		<td><%=d.getId() %></td>
		<td><%=d.getPostdate() %></td>
		<td><%=d.getVisitcount() %></td>
	</tr>
<%
	}
%>
</table>


<h2>멤버 테이블</h2>
<table border="1">
<%
	for (member_DTO b : list2) {
		//out.println(b.toString() + "<br>")
%>
	<tr>
		<td><%=b.getId() %></td>
		<td><%=b.getPass() %></td>
		<td><%=b.getName() %></td>
		<td><%=b.getRegidate()%></td>
	</tr>
<%
	}
%>
</table>
</body>
</html>