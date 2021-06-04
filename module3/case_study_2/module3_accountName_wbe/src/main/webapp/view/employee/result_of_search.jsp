<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>customer details</h1>
<p>
    <a href="/customer">Back to customer list</a>
</p>
<table>
    <c:forEach items='${customers}' var="customer">
        <tr>
            <td>Customer Name: </td>
            <td>${customer.customerName}</td>
        </tr>
        <tr>
            <td>Customer Id: </td>
            <td>${customer.customerId}</td>
        </tr>
        <tr>
            <td>Customer Address: </td>
            <td>${customer.customerAdress}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
