<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>	
	<form action="addUser" method="post">
		姓名：<input type="text" name="username"/> <br>
		年龄：<input type="text" name="age"/> <br>
		
		城市：<input type="text" name="address.city"/> <br>
		邮编：<input type="text" name="address.zipcode"/> <br>
		地址：<input type="text" name="address.address"/> <br>
		
		生日：<input type="text" name="birthdate" /><br>
		
		电话号码1：<input type="text" name="telephone"> <br>
		电话号码2：<input type="text" name="telephone"> <br>
		
		<input type="submit" value="注册"> <br>
	</form>

</body>
</html>