<%@page import="Form.domain.BoardDTO"%>
<%@page import="java.sql.Connection "%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Form.domain.BoardDTO"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%!List<BoardDTO> list = new ArrayList<>();%>

	<%
	// 2. 데이터 베이스 연결 및 기타 
	//드라이버 로드
	Class.forName("com.mysql.cj.jdbc.Driver");
	//드라이버 연결
	//DB url 위치
	String dburl = "jdbc:mysql://localhost:3306/musthave";
	//DB id
	String dbid = "musthave";
	//DB pw
	String dbpw = "q1w2e3r4";
	Connection con = DriverManager.getConnection(dburl, dbid, dbpw);

	//statement
	Statement st = con.createStatement();
	ResultSet rs = st.executeQuery("select * from board order by num limit 10");

	//실행 결과를 객체 리스트에 저장
	while (rs.next()) {
		list.add(new BoardDTO(rs.getInt("num"), rs.getString("title"), rs.getString("content"), rs.getString("id"),
		rs.getString("postdate"), rs.getInt("visitcount")));

	}

	//PreparedStatement		
	st.close();
	rs.close();
	con.close();

	//query
	%>

	<table border="1">
		<%
		for (BoardDTO b : list) {
			//out.println(b.toString() + "<br>");
		%>
		<tr>
		
			<td><%=b.getNum()%></td>
			<td><%=b.getTitle()%></td>
			<td><%=b.getContent()%></td>
			<td><%=b.getId()%></td>
			<td><%=b.getPostdate()%></td>
			<td><%=b.getVisitcount()%></td>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>