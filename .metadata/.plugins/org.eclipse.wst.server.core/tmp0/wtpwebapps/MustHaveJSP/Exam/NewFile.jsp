<%@ page import ="common.WeiCalc" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
pageContext.setAttribute("WeiCalc", new WeiCalc (31));
%>
<!DOCTYPE html>
<html>
<head><title>무게추 계산</title>
<meta charset="UTF-8">
</head>
<body>
	<%
	WeiCalc wei = (WeiCalc)(pageContext.getAttribute("WeiCalc"));
	wei.calc();
	%>
	<ul>
		<li>계산 값 : <%= wei.geti()%></li>
	</ul>
</body>
</html>