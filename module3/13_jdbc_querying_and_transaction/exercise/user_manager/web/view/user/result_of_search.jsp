<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>User details</h1>
<p>
    <a href="/users">Back to user list</a>
</p>
<table>
    <c:forEach items='${users}' var="user">
        <tr>
            <td>User: </td>
            <td>${user.name}</td>
        </tr>
        <tr>
            <td>Email: </td>
            <td>${user.email}</td>
        </tr>
        <tr>
            <td>Country: </td>
            <td>${user.country}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
