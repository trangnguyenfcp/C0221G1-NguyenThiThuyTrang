<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create new Employee</title>
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
    <a href="/employee">Back to employee list</a>
</p>
<div style="width: 400px">
<form method="post">
    <div class="form-group">
        <label for="employeeName" class="form-label">Employee Name</label>
        <input type="text" class="form-control" name="employeeName" id="employeeName">
    </div>
    <div class="form-group">
        <label for="positionId" class="form-label">Position Id</label>
        <input type="text" class="form-control" name="positionId" id="positionId">
    </div>
    <div class="form-group">
        <label for="educationDegreeId" class="form-label">Education Degree Id</label>
        <input type="text" class="form-control" name="educationDegreeId" id="educationDegreeId">
    </div>
    <div class="form-group">
        <label for="divisionId" class="form-label">Division Id</label>
        <input type="text" class="form-control" name="divisionId" id="divisionId">
    </div>
    <div class="form-group">
        <label for="username" class="form-label">Username</label>
        <input type="text" class="form-control" name="username" id="username">
    </div>
    <div class="form-group">
        <label for="employeeBirthday" class="form-label">Employee Birthday</label>
        <input type="text" class="form-control" name="employeeBirthday" id="employeeBirthday">
    </div>
    <div class="form-group">
        <label for="employeeIdCard" class="form-label">Employee Id Card</label>
        <input type="text" class="form-control" name="employeeIdCard" id="employeeIdCard">
    </div>
    <div class="form-group">
        <label for="employeeSalary" class="form-label">Employee Salary</label>
        <input type="text" class="form-control" name="employeeSalary" id="employeeSalary">
    </div>
    <div class="form-group">
        <label for="employeePhone" class="form-label">Employee Phone</label>
        <input type="text" class="form-control" name="employeePhone" id="employeePhone">
    </div>
    <div class="form-group">
        <label for="employeeEmail" class="form-label">Employee Email</label>
        <input type="text" class="form-control" name="employeeEmail" id="employeeEmail">
    </div>
    <div class="form-group">
        <label for="employeeAddress" class="form-label">Employee Address</label>
        <input type="text" class="form-control" name="employeeAddress" id="employeeAddress">
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
