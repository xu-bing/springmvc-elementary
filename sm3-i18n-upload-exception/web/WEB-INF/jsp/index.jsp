<%--
  Created by IntelliJ IDEA.
  User: xab
  Date: 2017/10/20
  Time: 23:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
this is index.
<hr>

<%--
  存于session中的username
--%>
${sessionUsername}

<%--
  使用addFlashAttribute()存于session中的值，再次刷新页面就为空了。
  与上面直接存于session中的usename观察对比
  --%>
${agee}
</body>
</html>
