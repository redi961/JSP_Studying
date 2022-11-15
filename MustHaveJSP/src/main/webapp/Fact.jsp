<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
int num = 0;
int fact = 1;
//Paramecter num 값을 받는다
String snum = request.getParameter("num");
//Parameter가 정상인지 확인하고 정수로 변환하여 저장
//주소창에 ?num=10 | ?num1=10 & num2=20 
if (snum != null && snum.equals("") == false) {
	num = Integer.parseInt(snum);
}


for (int i = num; i > 0; i--) {
	fact = fact * i;
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>fact</h2>
	<p>
		<%
		out.println("fact : " + fact);
		%>
	</p>

</body>
</html>