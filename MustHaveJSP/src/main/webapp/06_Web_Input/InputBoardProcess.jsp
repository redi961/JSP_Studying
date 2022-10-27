<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection" %>
<%@page import="java.sql.PreparedStatement" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 1. 파라미터 읽기, Title, Content, id-->
<%	
	request.setCharacterEncoding("utf-8"); //콘솔창 한글깨짐 방지	

	String num = request.getParameter("num");
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	String id = request.getParameter("id");
	
	//System.out.println(title +", "+ content + ", " + id);

	// 2. 데이터베이스 연결 및 기타 -->
	// 드라이버 로드
	//Class.forName("com.mysql.cj.jdbc.Driver");
	Class.forName("org.h2.Driver");
		
	// 3. 데이터베이스 연결
	//String durl = "jdbc:mysql://localhost:3306/musthave"; //// MYSQL
	//String dbid = "musthave"; //// MYSQL
	//String dbpw = "tiger"; //// MYSQL
	
	String durl = "jdbc:h2:tcp://localhost/~/test"; // H2 DB
	String dbid = "sa"; // H2 DB
	String dbpw = ""; //H2 DB
	
	Connection con = DriverManager.getConnection(durl, dbid, dbpw);

	//Prepare statement
	String sql = "insert into board(num,title,content,id) values(?,?,?,?)";
	PreparedStatement psmt = con.prepareStatement(sql);
	psmt.setString(1, num);
	psmt.setString(2, title);
	psmt.setString(3, content);
	psmt.setString(4, id);
	
	//query
	int result = psmt.executeUpdate();
	
	psmt.close();
	con.close();
	
	
	// 4. 완료메세지 출력
	if (result == 1) 
		out.println("입력에 성공 하였습니다.");
	else
		out.println("입력에 실패 하였습니다.");
	
%>
	<br>
	<br>
	<a href="BoardInputForm.jsp">입력창으로 돌아가기</a>
	
		
	

</body>
</html>