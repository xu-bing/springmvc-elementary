<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    <%--
      文件上传2个要求：
      method:post
      enctype: multipart/form-data
    --%>

	<form action="uploadFile" method="post" enctype="multipart/form-data"> <!--mutlitpart：以二进制流的形式上传文件-->
		文件：<input type="file" name="file"/><br>
		<input type="submit" value="上传"/>
		
	</form>
</body>
</html>