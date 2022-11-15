<%@ page import="java.sql.PreparedStatement"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="common.JDBConnect"%>
<%@ page import="java.sql.Statement"%>
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.ResultSet"%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 

<html>
<head><title>JDBC</title></head>
<body>
    <h2>회원 추가 테스트(executeUpdate() 사용)</h2>
    <%
    String title;
    String content;
    String id;
    
    
    // DB에 연결
    
    
    
    String driver = "com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/musthave";
	String ids="musthave";
	String pwds="tiger";
    
    JDBConnect jdbc = new JDBConnect(driver,url,ids,pwds);
    
    
    for(int num = 2; num<=100;num++){
    // 테스트용 입0력값 준비 
//     String title = "test"+num;
//     String content = "내용"+num;
//     String id = "테스트"+num+"회원";    

    
    // 쿼리문 생성
    String sql = "INSERT INTO board (num,title,content,id) VALUES(?,?,?,?)";
    
    PreparedStatement psmt = jdbc.con.prepareStatement(sql);  
    psmt.setInt(1, num);
//     psmt.setString(2, title);
//     psmt.setString(3, content);
//     psmt.setString(4, id);
    
    
    // 쿼리 수행
    int inResult = psmt.executeUpdate(); 
    out.println(inResult + "행이 입력되었습니다.");
    }
    // 연결 닫기
    String t1="test";    
    jdbc.close();
    %>
</body>
</html>
