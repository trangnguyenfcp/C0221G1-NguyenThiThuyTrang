<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create new service</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
</head>
<body>
<jsp:include page="/view/header.jsp"></jsp:include>
<div style="margin-left: 30px">
<h1>Create new contract</h1>
<p>
    <c:if test='${message!=null}'>
        <span class="message">${message}</span>
    </c:if>
</p>
<p>
    <a href="/contract">Back to contract list</a>
</p>
<div style="width: 400px">
<form method="post">
    <div class="form-group">
        <label for="employeeId" class="form-label">Employee</label>
        <select class="form-control" id="employeeId" name="employeeId">
            <c:forEach items="${listEmployee}" var="employee">
                <option value="<c:out value="${employee.key}"></c:out>"><c:out value="${employee.value}"></c:out> </option>
            </c:forEach>
        </select>
    </div>
    <div class="form-group">
        <label for="customerId" class="form-label">Customer</label>
        <select class="form-control" id="customerId" name="customerId">
            <c:forEach items="${listCustomer}" var="customer">
                <option value="<c:out value="${customer.key}"></c:out>"><c:out value="${customer.value}"></c:out> </option>
            </c:forEach>
        </select>
    </div>
    <div class="form-group">
        <label for="serviceId" class="form-label">Service</label>
        <select class="form-control" id="serviceId" name="serviceId">
            <c:forEach items="${listService}" var="service">
                <option value="<c:out value="${service.key}"></c:out>"><c:out value="${service.value}"></c:out> </option>
            </c:forEach>
        </select>
    </div>
    <div class="form-group">
        <label for="contractStartDate" class="form-label">Contract Start Date</label>
        <input type="date" class="form-control" name="contractStartDate" id="contractStartDate">
    </div>
    <div class="form-group">
        <label for="contractEndDate" class="form-label">Contract Start Date</label>
        <input type="date" class="form-control" name="contractEndDate" id="contractEndDate">
    </div>
    <div class="form-group">
        <label for="contractDeposit" class="form-label">contract Deposit</label>
        <input type="text" class="form-control" name="contractDeposit" id="contractDeposit">
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
