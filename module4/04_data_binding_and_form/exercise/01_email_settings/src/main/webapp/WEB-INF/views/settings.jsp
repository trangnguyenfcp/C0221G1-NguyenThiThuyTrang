<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 6/17/2021
  Time: 7:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Settings</h2>
<form:form modelAttribute="settings" action="/create" method="post">
    <table>
        <tr>
            <td>Language</td>
            <td><form:select items="${languages}" path="language">
            </form:select></td>
        </tr>
        <tr>
            <td>Page Size</td>
            <td>Show <form:select  items="${pageSizes}" path="pageSize"></form:select> emails per page</td>
        </tr>
        <tr>
            <td>Spams filter</td>
            <td> <form:checkbox path="spamsFilter"></form:checkbox></td>
        </tr>
        <tr>
            <td>Signature</td>
            <td><form:textarea path="signature"></form:textarea></td>
        </tr>
    </table>

    <input type="submit" value="submit">
</form:form>
</body>
</html>
