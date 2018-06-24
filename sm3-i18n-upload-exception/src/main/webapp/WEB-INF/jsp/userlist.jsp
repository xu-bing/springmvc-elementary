<%--
  Created by IntelliJ IDEA.
  User: xab
  Date: 2017/10/20
  Time: 20:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>Title</title>

    ${userList}

    <hr>

    <table>
    <tr>
        <td>姓名</td>
        <td>年龄</td>
    </tr>
    <c:forEach items="${userList}" var="user">
        <tr>
            <td>${user.username}</td>
            <td>${user.age}</td>
        </tr>
    </c:forEach>
    </table>

    <hr>

    ${agee}

</head>
<body>

</body>
</html>
