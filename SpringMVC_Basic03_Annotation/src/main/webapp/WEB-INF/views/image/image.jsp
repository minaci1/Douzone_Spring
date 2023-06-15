<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- <form action="" method="post" enctype="application/x-www-form-urlencoded"></form> -->
	
	
	<form method="post" enctype="multipart/form-data"><!-- 파일과 텍스트 다 전달할 거야, 파일보낼때 무조건 -->
		이름:<input type="text" name="name"><br>
		나이:<input type="text" name="age"><br>
		사진:<input type="file" name="file"><br>
		<input type="submit" value="파일업로드">
	</form>
 
</body>
</html>