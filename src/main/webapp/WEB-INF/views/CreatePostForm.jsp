<%--
  Created by IntelliJ IDEA.
  User: Gautam Rajbhar
  Date: 22-12-2019
  Time: 21:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form action="savePost" modelAttribute="posts">
    Title <br><form:input path="title"/>
    <br><br>
    Content <br><form:input path="content"/>
    <br><br>
    <input type="submit" value="PUBLISH">
</form:form>
</body>
</html>
