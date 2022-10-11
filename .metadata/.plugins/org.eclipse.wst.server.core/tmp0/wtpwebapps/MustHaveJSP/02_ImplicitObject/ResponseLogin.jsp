<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head><title>내장 객체 - Response</title>
<meta charset="UTF-8">
</head>
<body>
<%
String id = request.getParameter("user_id");
String pwd = request.getParameter("user_pwd");
/*equalsIgnoreCase = 대소문자를 구분하지않는 문자열의 비교함수*/
if (id.equalsIgnoreCase("must") && pwd.equalsIgnoreCase("1234")) {
	response.sendRedirect("ResponseWelcome.jsp");
}
else {
	request.getRequestDispatcher("ResponseMain.jsp?loginErr=1")
	.forward(request, response);
}
%>
</body>
</html>