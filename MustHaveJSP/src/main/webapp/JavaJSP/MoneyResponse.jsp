<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
int money = Integer.parseInt(request.getParameter("money"));


int tmoney = (money / 1000) * 1000;
int[] array= {50000,10000,5000,1000};
int[] num = new int[4];
	

for(int i=0;i>array.length;i++){
	int c = tmoney/array[i];	
	
	if (0 < c){
		System.out.printf("%5d원 * %d장 = %d원\n", array[i], c, array[i]*c);
		num[i]=c;
	}
	else{
		System.out.printf("%5d원\n", array[i]);
		num[i]=c;		
	}	
	
	tmoney -= (array[i] * c);
	
}
for (int t : array) {
	int c = tmoney/t;
	int n = 0;
	
	if (0 < c){
		System.out.printf("%5d원 * %d장 = %d원\n", t, c, t*c);
		n = n+1;
	}
	else{
		System.out.printf("%5d원\n", t);
		n = n+1;
	}
	n = n+1;
	System.out.printf("%d %d %d \n", t,c,n);
	
	
	
	tmoney -= (t * c);
}
 %>
	<li>50000 <%= num[0] %> 장
	</li>
	<li>10000 <%= num[1] %> 장
	</li>
	<li>5000 <%= num[2] %> 장
	</li>
	<li>1000 <%= num[3] %> 장
	</li>





</body>
</html>