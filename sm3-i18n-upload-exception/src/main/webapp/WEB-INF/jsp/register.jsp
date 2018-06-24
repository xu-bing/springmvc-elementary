<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>  

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="?lang=zh_CN"><spring:message code="language.cn"></spring:message></a>
	|
	<a href="?lang=en_US"><spring:message code="language.en"></spring:message></a>
	<h3><spring:message code="title.register.welcome"></spring:message> </h3>
	<form action="addUser" method="post">
		<spring:message code="register.username"></spring:message>：<input type="text" name="username"/> 
		<form:errors path="user.username" cssStyle="color:red"></form:errors><br>	
		年龄：<input type="text" name="age"/> <br>
		密码：<input type="text" name="password"/> <br>
		邮箱：<input type="text" name="mail"/> <br>
		
		<input type="submit" value="注册"> <br>
	</form>

	<!-- 显示错误信息 -->
	<form:form commandName="user">
		<form:errors path="*" cssStyle="color:red"></form:errors>
	</form:form>
</body>
</html>