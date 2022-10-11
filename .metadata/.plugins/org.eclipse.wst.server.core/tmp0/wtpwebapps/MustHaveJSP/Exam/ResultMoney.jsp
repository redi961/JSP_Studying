<%@page import="javax.security.auth.message.callback.PrivateKeyCallback.Request"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	int money = Integer.parseInt(request.getParameter("money"));

	int tmoney = (money / 1000) * 1000;
	int arr [] = {50000,10000,5000,1000};
	int num [] = new int[arr.length];
	
	for (int i = 0; i<arr.length; i++) {
		int c = tmoney / arr[i];
		if (0 < c) {
			System.out.printf("%5d원 * %d장 = %d원\n", arr[i] , c, arr[i] * c);
			num[i] = c;
		}
		else 
			System.out.printf("%5d원\n",arr[i]);
		tmoney -= (arr[i] * c);
	}
		
%>
<!DOCTYPE html>
<html>
<head><title>결과창</title>
<meta charset="UTF-8">
</head>
<body>
<h2> 입력받은 금액 : <%= money %></br></h2>
<h2> 50000원 권 : <%=num[0] %> 장</h2>
<h2> 10000원 권 : <%=num[1] %> 장</h2>
<h2> 5000원 권 : <%=num[2] %> 장</h2>
<h2> 1000원 권 : <%=num[3] %> 장</h2>
</body>
</html>