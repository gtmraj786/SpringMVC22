<%--
  Created by IntelliJ IDEA.
  User: Gautam Rajbhar
  Date: 23-12-2019
  Time: 15:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
isELIgnored="false"
%>
<html>
<head>
    <title>Updating..</title>
</head>
<body>
<form action="/SpringMVC22_war_exploded/post/updateCommit/${post.id}" >
    Title <br><input type="text" value="${post.title}" name="title"><br><br>

    Content <br><input type="text" value="${post.content}" name="content"><br><br>

    <input type="submit">
</form>

</body>
</html>
