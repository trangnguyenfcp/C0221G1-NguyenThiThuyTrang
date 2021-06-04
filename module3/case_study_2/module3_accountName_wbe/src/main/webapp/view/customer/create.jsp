<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create new service</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>
</head>
<body>
<jsp:include page="/view/header.jsp"></jsp:include>
<div style="margin-left: 30px">
<h1>Create new product</h1>
<p>
    <c:if test='${message!=null}'>
        <span class="message">${message}</span>
    </c:if>
</p>
<p>
    <a href="/customer">Back to customer list</a>
</p>
<div style="width: 400px">
<form method="post">
    <div class="form-group">
        <label for="customer_type_id" class="form-label">Customer Type ID</label>
        <input type="text" class="form-control" name="customer_type_id" id="customer_type_id">
    </div>
    <div class="form-group">
        <label for="customer_name" class="form-label">Customer Name</label>
        <input type="password" class="form-control" name="customer_name" id="customer_name">
    </div>
    <div class="form-group">
        <label for="customer_birthday" class="form-label">Customer Birthday</label>
        <input type="text" class="form-control" name="customer_birthday" id="customer_birthday">
    </div>
    <div class="form-group">
        <label for="customer_gender" class="form-label">Customer Gender</label>
        <input type="text" class="form-control" name="customer_gender" id="customer_gender" placeholder="0:female, 1:male, 2:other">
    </div>
    <div class="form-group">
        <label for="customer_id_card" class="form-label">Customer ID Card</label>
        <input type="text" class="form-control" name="customer_id_card" id="customer_id_card">
    </div>
    <div class="form-group">
        <label for="customer_phone" class="form-label">Customer Phone</label>
        <input type="text" class="form-control" name="customer_phone" id="customer_phone">
    </div>
    <div class="form-group">
        <label for="customer_email" class="form-label">Customer Email</label>
        <input type="text" class="form-control" name="customer_email" id="customer_email">
    </div>
    <div class="form-group">
        <label for="customer_address" class="form-label">Customer Address</label>
        <input type="text" class="form-control" name="customer_address" id="customer_address">
    </div>
    <div class="form-group">
        <button type="submit" class="btn btn-primary">Create</button>
    </div>
</form>
</div>
</div>
<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>
