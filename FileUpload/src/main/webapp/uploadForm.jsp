<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="uploadfile" enctype="multipart/form-data">
		<input type="text" name="title" value="타이틀"><br>
		<!-- 인풋타입이 파일인 경우 파일을 선택가능한 버튼이 자동으로 생성됨 -->
		<input type="file" name="fname"><br>
		<input type="file" name="fname"><br>
		<!-- 기본 업로드 경로: C:\02Workspaces\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\FileUpload\upload -->
		<input type="submit" value="업로드">
	</form>
</body>
</html>