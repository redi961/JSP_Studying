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
<title>게시판 입력</title>
</head>
<body>
	<!-- 1. 파라미터 읽기 title content id-->
	<%
	
	request.setCharacterEncoding("UTF-8");
	
	//request -> BoardInputForm input 받은 값 저장
	String num = request.getParameter("num");
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	String id = request.getParameter("id");
	
	//임시 출력
	System.out.println("title : " + title + " content : " + content + " id : " + id);

	// 2. 데이터 베이스 연결 및 기타 

	//드라이버 로드
	//Class.forName("com.mysql.cj.jdbc.Driver");
	Class.forName("org.h2.Driver");

	//드라이버 연결
	//DB url 위치
	//String dburl = "jdbc:mysql://localhost:3306/musthave";
	//DB id
	//String dbid = "musthave";
	//DB pw
	//String dbpw = "q1w2e3r4";
	
	String dburl = "jdbc:h2:tcp://localhost/~/test";
	String dbid = "sa";	
	String dbpw = "";
	Connection con = DriverManager.getConnection(dburl, dbid, dbpw);

	//statement
	//sql 입력 ? 값
	String sql = "insert into board (num,title,content,id) values(?,?,?,?)";
	
	//PreparedStatement	
	PreparedStatement psmt = con.prepareStatement(sql);
	psmt.setString(1, num);
	//psmt.setInt(1, Integer.parseInt(num));
	psmt.setString(2, title);
	psmt.setString(3, content);
	psmt.setString(4, id);
	int result = psmt.executeUpdate();

	psmt.close();
	con.close();

	//query
	if (result == 1) out.println("입력 성공하였습니다");
	else out.println("입력에 실패하였습니다");
	%>
	<br>
	<br>
	<a href="BoardInputForm.jsp">입력창 돌아가기</a>

	<!-- 3. 데이터 베이스 입력 -->

	<!-- 4. 완료메세지 출려 -->

</body>
</html>