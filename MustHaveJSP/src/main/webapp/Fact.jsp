<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%  int num = 0;
	int f = 1;
	// Parameter num 값을 받는다
	String snum = request.getParameter("num");
	// Parameter가 정상인지 확인하고 정수로 변환하여 저장
	if(snum!=null && snum.equals("")==false) {
		num = Integer.parseInt(snum);
	}	
	
	for (int i = 1; i <= num;i++) {
		f *= i;
	}
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 주소 뒤 ? 변수= 변수입력을 통하여 변수 변경 가능 -->
<h2>입력받은 숫자는 <%=num%> 팩토리얼은 <%=f%> 입니다.</h2>
</body>
</html>