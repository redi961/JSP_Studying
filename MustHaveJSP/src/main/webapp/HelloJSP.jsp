<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="UTF-8"%>

<!-- 변수 선언부 -->
<%!String str1 = "JSP";
	String str2 = "안녕하세요..";%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>HelloJSP</title>
</head>
<body>
	<h2>
		처음 만들어보는
		<!-- 변수적용 -->
		<%=str1%>
	</h2>
	<p>
		<!-- 메인 자바 코드 영역 -->
		<%
		out.println(str2 + str1 + "입니다. 열공합시다^^*");
		%>
	</p>
</body>
</html>