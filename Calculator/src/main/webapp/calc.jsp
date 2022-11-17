<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>계산기</title>
<style>
input{
	width:50px;
	height:50px;
}
.output{
	height:50px;
	background: #e9e9e9;
	font-size:24px;
	font-weight: bold;
	text-align: right;
	padding: 0px 5px;
}
</style>
</head>
<%
	Cookie[] cookies = request.getCookies();
	if (cookies != null) {
		for (Cookie c : cookies) {
			if (c.getName().equals("exp")) {
				pageContext.setAttribute("pexp", c.getValue());
				break;
			}
		}
	}
%>
<body>
	<form action="calc" method="post">
		<table>
			<tr>
				<td class="output" colspan="4">${pexp }</td>
			</tr>
			<tr>
				<td><input type="submit" name="value" value="7"/> </td>
				<td><input type="submit" name="value" value="8"/> </td>
				<td><input type="submit" name="value" value="9"/> </td>
				<td><input type="submit" name="operator" value="/"/> </td>
			</tr>
			<tr>
				<td><input type="submit" name="value" value="4"/> </td>
				<td><input type="submit" name="value" value="5"/> </td>
				<td><input type="submit" name="value" value="6"/> </td>
				<td><input type="submit" name="operator" value="*"/> </td>
			</tr>
			<tr>
				<td><input type="submit" name="value" value="1"/> </td>
				<td><input type="submit" name="value" value="2"/> </td>
				<td><input type="submit" name="value" value="3"/> </td>
				<td><input type="submit" name="operator" value="-"/> </td>
			</tr>
			<tr>
				<td><input type="submit" name="operator" value="C"/> </td>
				<td><input type="submit" name="value" value="0"/> </td>
				<td><input type="submit" name="operator" value="="/> </td>
				<td><input type="submit" name="operator" value="+"/> </td>
			</tr>
		</table>
	</form>

</body>
</html>