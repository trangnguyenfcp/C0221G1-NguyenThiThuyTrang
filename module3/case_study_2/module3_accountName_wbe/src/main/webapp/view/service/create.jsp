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
    <a href="/service">Back to service list</a>
</p>
<div style="width: 400px">
<form method="post">
    <div class="form-group">
        <label for="serviceName" class="form-label">Service Name</label>
        <input type="text" class="form-control" name="serviceName" id="serviceName">
    </div>
    <div class="form-group">
        <label for="serviceArea" class="form-label">Service Area</label>
        <input type="text" class="form-control" name="serviceArea" id="serviceArea">
    </div>
    <div class="form-group">
        <label for="serviceCost" class="form-label">Service Cost</label>
        <input type="text" class="form-control" name="serviceCost" id="serviceCost">
    </div>
    <div class="form-group">
        <label for="numberOfFloors" class="form-label">Number Of Floors</label>
        <input type="text" class="form-control" name="numberOfFloors" id="numberOfFloors">
    </div>
    <div class="form-group">
        <label for="serviceMaxPeople" class="form-label">Service Max People</label>
        <input type="text" class="form-control" name="serviceMaxPeople" id="serviceMaxPeople">
    </div>
    <div class="form-group">
        <label for="serviceTypeId" class="form-label">Service Type Id</label>
        <input type="text" class="form-control" name="serviceTypeId" id="serviceTypeId">
    </div>
    <div class="form-group">
        <label for="poolArea" class="form-label">Pool Area</label>
        <input type="text" class="form-control" name="poolArea" id="poolArea">
    </div>
    <div class="form-group">
        <label for="standardRoom" class="form-label">Standard Room</label>
        <input type="text" class="form-control" name="standardRoom" id="standardRoom">
    </div>
    <div class="form-group">
        <label for="descriptionOtherConvenience" class="form-label">Description Other Convenience</label>
        <input type="text" class="form-control" name="descriptionOtherConvenience" id="descriptionOtherConvenience">
    </div>
    <div class="form-group">
        <label for="rentTypeId" class="form-label">rent Type Id</label>
        <input type="text" class="form-control" name="rentTypeId" id="rentTypeId">
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
