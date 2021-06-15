<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>customer details</h1>
<p>
    <a href="/product">Back to product list</a>
</p>
<table>
    <c:forEach items='${products}' var="product">
        <tr>
            <td>Product Name: </td>
            <td>${product.productName}</td>
        </tr>
        <tr>
            <td>Product Id: </td>
            <td>${product.productId}</td>
        </tr>
        <tr>
            <td>Product Description: </td>
            <td>${product.productDescription}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
