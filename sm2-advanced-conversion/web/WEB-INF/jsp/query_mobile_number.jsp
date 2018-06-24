<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link href="resources/css/index.css" rel="stylesheet" type="text/css" />
<link href="resources/css/reset.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div id="select_number_contain">

	<form action="saveMobileNumber" method="post">
		手机号码：<input type="text" name="mobileNumber" ><br>
		归属地：<input type="text" name="area"><br>
		预充值：<select name="amount">
				<option value="50">50元</option>
				<option value="100">100元</option>
				<option value="200">200元</option>
			  </select><br>
	   <input type="submit" value="保存">
	</form>
    <div id="select_number_main_main">

      <table width="700" class="table-infor-record-style" >
  <tr>
    <th>号码</th>
    <th>号码归属地</th>
    <th>预存话费</th>
    <th>操作</th>
  </tr>
  
  <!-- <tr>
	<td>13861931535</td>
	<td>南通</td>
	<td>50</td>
	<td><input type="button" class="buy" value="立即购买"/></td>
  </tr> -->

	<c:forEach items="${numberList}" var="mobile">
		<tr>
			<td>${mobile.mobileNumber }</td>
			<td>${mobile.area }</td>
			<td>${mobile.amount }</td>
			<td><input type="button" class="buy" value="立即购买"/></td>		
		</tr>
	</c:forEach>
	
	${mobileNumber }
	
	
</table>



  </div>
</div>


</div>
</body>
</html>