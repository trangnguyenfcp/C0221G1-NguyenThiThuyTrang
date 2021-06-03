
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Create new product</title>
</head>
<body>
<h1>Create new product</h1>
<p>
    <c:if test='${message!=null}'>
        <span class="message">${message}</span>
    </c:if>
</p>
<p>
    <a href="/customer">Back to customer list</a>
</p>
<form class="row g-3"  method="post">
    <div class="col-md-6">
        <label for="customer_type_id" class="form-label">Customer Type ID</label>
        <input type="text" class="form-control" name="customer_type_id" id="customer_type_id">
    </div>
    <div class="col-md-6">
        <label for="customer_name" class="form-label">Customer Name</label>
        <input type="password" class="form-control" name="customer_name" id="customer_name">
    </div>
    <div class="col-12">
        <label for="customer_birthday" class="form-label">Customer Birthday</label>
        <input type="text" class="form-control" name="customer_birthday" id="customer_birthday">
    </div>
    <div class="col-12">
        <label for="customer_gender" class="form-label">Customer Gender</label>
        <input type="text" class="form-control" name="customer_gender" id="customer_gender" placeholder="0:female, 1:male, 2:other">
    </div>
    <div class="col-12">
        <label for="customer_id_card" class="form-label">Customer ID Card</label>
        <input type="text" class="form-control" name="customer_id_card" id="customer_id_card">
    </div>
    <div class="col-12">
        <label for="customer_phone" class="form-label">Customer Phone</label>
        <input type="text" class="form-control" name="customer_phone" id="customer_phone">
    </div>
    <div class="col-12">
        <label for="customer_email" class="form-label">Customer Email</label>
        <input type="text" class="form-control" name="customer_email" id="customer_email">
    </div>
    <div class="col-12">
        <label for="customer_address" class="form-label">Customer Address</label>
        <input type="text" class="form-control" name="customer_address" id="customer_address">
    </div>
    <div class="col-12">
        <button type="submit" class="btn btn-primary">Create</button>
    </div>
</form>
</body>
</html>
