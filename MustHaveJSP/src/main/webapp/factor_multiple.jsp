<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    int num1=1;int num2=1;    
    int max=0;
    int min=0;
    int x=0;
    
    //변수입력
    String snum1 = request.getParameter("num1");
    String snum2 = request.getParameter("num2");
    //변수저장
	num1 = Integer.parseInt(snum1);
	num2 = Integer.parseInt(snum2);
    
    
    //max min
    if (num1 < num2) {
		max = num2;
		min = num1;
	} else {
		max = num1;
		min = num2;
	}
    
    int rem = max%min;
    
    while(rem != 0) {
		rem = max%min;
		max = min;
		min = rem;		
	}
    
    
    
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%

out.println("최대 공약수 : "+ min);
out.println("최소 공배수 : "+(num1*num2)/min);

%>

</body>
</html>