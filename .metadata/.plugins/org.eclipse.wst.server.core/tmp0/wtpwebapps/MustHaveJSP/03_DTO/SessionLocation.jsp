<%@ page import ="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head><title>session 영역</title>
<meta charset="UTF-8">
</head>
<body>

	<h2>페이지 이동 후 session 영역의 속성 읽기</h2>
	
	<%
	@SuppressWarnings("unchecked")
	ArrayList<String> lists = (ArrayList<String>)session.getAttribute("lists");
	for (String str : lists) {
		out.println(str + "<br/>");
	}
	%>
</body>
</html>