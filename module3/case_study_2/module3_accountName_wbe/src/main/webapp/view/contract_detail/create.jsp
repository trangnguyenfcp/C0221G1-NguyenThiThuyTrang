<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create new contract detail</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
</head>
<body>
<jsp:include page="/view/header.jsp"></jsp:include>
<div style="margin-left: 30px">
<h1>Create new contract detail</h1>
<p>
    <c:if test='${message!=null}'>
        <span class="message">${message}</span>
    </c:if>
</p>
<p>
    <a href="/contract">Back to contract detail list</a>
</p>
<div style="width: 400px">
<form method="post">
    <div class="form-group">
        <label for="contractId" class="form-label">Contract ID</label>
        <select class="form-control" id="contractId" name="contractId">
            <c:forEach items="${contractIds}" var="contractId">
                <option value="<c:out value="${contractId}"></c:out>"><c:out value="${contractId}"></c:out> </option>
            </c:forEach>
        </select>
    </div>
    <div class="form-group">
        <label for="attachServiceId" class="form-label">Attach Service Id</label>
        <select class="form-control" id="attachServiceId" name="attachServiceId">
            <c:forEach items="${attachServiceIds}" var="attachServiceId">
                <option value="<c:out value="${attachServiceId.key}"></c:out>"><c:out value="${attachServiceId.value}"></c:out> </option>
            </c:forEach>
        </select>
    </div>
    <div class="form-group">
        <label for="quantity" class="form-label">Quantity</label>
        <input type="text" class="form-control" name="quantity" id="quantity">
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
