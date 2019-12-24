<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored = "false" %>

<html>
<body>
<h1>My Blog</h1>


<a href="post/create">create post..</a>
<c:forEach var="post" items="${postList}">
<section>
--------------------------------------------------------------------------------------------------------------------------------------------------
    <article>
        <h1>
            ${post.getTitle()}
        </h1>
        <p>
            ${post.getContent()}
        </p>
    </article>

    <form action="post/update/${post.id}">
        <input type="submit" value="UPDATE" >
    </form>

    <form action="post/delete/${post.id}">
        <input type="submit" value="DELETE" >
    </form>


</section>
</c:forEach>
</body>
</html>
