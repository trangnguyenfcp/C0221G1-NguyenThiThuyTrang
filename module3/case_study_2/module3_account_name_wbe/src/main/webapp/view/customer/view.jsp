<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 5/29/2021
  Time: 5:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Product details</h1>
<p>
    <a href="/products">Back to product list</a>
</p>
<table>
    <tr>
        <td>Product: </td>
        <td>${product.name}</td>
    </tr>
    <tr>
        <td>Manufacturer: </td>
        <td>${product.manufacturer}</td>
    </tr>
    <tr>
        <td>Price: </td>
        <td>${product.price}</td>
    </tr>
</table>
</body>
</html>
