<%@page import="Form.domain.BoardDTO"%>
<%@page import="java.sql.Connection "%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Form.domain.MemberDTO"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%!List<MemberDTO> list = new ArrayList<>();%>

	<%
	// 2. 데이터 베이스 연결 및 기타 
	//드라이버 로드
	Class.forName("com.mysql.cj.jdbc.Driver");	
	
	
	String dburl = "jdbc:mysql://localhost:3306/musthave";	
	String dbid = "musthave";	
	String dbpw = "q1w2e3r4";
	

	Connection con = DriverManager.getConnection(dburl, dbid, dbpw);

	//statement
	Statement st = con.createStatement();
	ResultSet rs = st.executeQuery("select * from member");

	//실행 결과를 객체 리스트에 저장
	while (rs.next()) {
		list.add(new MemberDTO(
				rs.getString("id"),
				rs.getString("pass"),
				rs.getString("name"),
				rs.getString("regidate")				
				));
	}

	//PreparedStatement		
	st.close();
	rs.close();
	con.close();

	//query
	%>

	<table border="1">
		<%
		for (MemberDTO b : list) {
			//out.println(b.toString() + "<br>");
		%>
		<tr>		
			<td><%=b.getId()%></td>
			<td><%=b.getPass()%></td>
			<td><%=b.getName()%></td>
			<td><%=b.getRegidate()%></td>			
		</tr>
		<%
		}
		%>
	</table>

</body>
</html>