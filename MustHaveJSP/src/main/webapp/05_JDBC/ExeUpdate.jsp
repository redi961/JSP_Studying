<%@page import="java.sql.DriverManager"%>
<%@ page import="java.sql.PreparedStatement"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="common.JDBConnect"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%  String stitle = request.getParameter("title");
	if(stitle == null || stitle.equals("") == true)
		stitle = "title";

	String scont = request.getParameter("content");
	if(scont == null || scont.equals("") == true)
		scont = "content";
	
	String sid = request.getParameter("id");
	if(sid == null || sid.equals("") == true)
		sid = "ID";
%>
    
<html>
<head><title>JDBC</title></head>
<body>
    <h2>회원 추가 테스트(executeUpdate() 사용)</h2>
    <%
    // DB에 연결
    String driver = "com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/musthave";
    String ids = "musthave";
    String pwd = "tiger";
    int count =0;
    
    JDBConnect jdbc = new JDBConnect(driver, url, ids, pwd);
    System.out.println("jdbc : " + jdbc);
    System.out.println("jdbc con : " + jdbc.con);
    
     // 테스트용 입력값 준비 

  	 // int num = 0;	
     // String title = "제목" + num;
     // String content = "내용" + num ;
     // String id = "test" + num;

     // 쿼리문 생성
     String sql = "INSERT INTO Board (title, content, id) VALUES (?, ?, ?)";  
     // String sql = "DELETE FROM Board where num = (?, ?, ?, ?)";
     PreparedStatement psmt = jdbc.con.prepareStatement(sql);  
     // psmt.setInt(1, num);
      psmt.setString(1, stitle);
      psmt.setString(2, scont);
      psmt.setString(3, sid);
     
     // 쿼리 수행
	 int inResult = psmt.executeUpdate();
     out.println(count + "행이 입력되었습니다.");
     
	// 연결 닫기 
    jdbc.close(); 
    %>
</body>
</html>
