<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 5/26/2021
  Time: 8:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<p>Product Discount Calculator</p>
<form action="/discount" method="get">
<input type="text" name="productDes" placeholder="Product Des">
<input type="text" name="listPrice" placeholder="List Price">
<input type="text" name="discountPercent" placeholder="discount percent">
<input type="submit" value="calculate">
</form>
</body>
</html>
