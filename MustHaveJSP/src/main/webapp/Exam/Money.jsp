<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%  int money = 0;	
	%>
<!DOCTYPE html>
<html>
<head><title>계산기 시뮬레이터</title>
<meta charset="UTF-8">
</head>
<body>
	<form action="ResultMoney.jsp" method="post">
		계산할 값을 입력하세요 : <input type ="text" name="money" value="금액" /> <br/>
		<input type ="submit" value="계산" />
	</form>
	
</body>
</html>