<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%  
int num1 = 1;
int num2 = 1;
//Parameter num 값을 받는다
String snum1 = request.getParameter("num1");
String snum2 = request.getParameter("num2");
//Parameter가 정상인지 확인하고 정수로 변환하여 저장
if(snum1!=null && snum1.equals("")==false) {
	num1 = Integer.parseInt(snum1);
}
if(snum2!=null && snum2.equals("")==false) {
	num2 = Integer.parseInt(snum2);
}

//공배수 , 공약수 설정 공식
int max;
int min;

max = (num1<num2)?num2:num1;
min = (num1<num2)?num1:num2;

int rem = max%min;
while(rem != 0) {
	max = min;
	min = rem;
	rem = max%min;
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
<h2>입력받은 num1값은 <%=num1%> // num2값은 <%=num2%> 입니다.</h2>
<h2>최대공약수 <%= min %> 최소공배수는 <%= (num1*num2)/min %> 입니다.</h2>

</body>
</html>
