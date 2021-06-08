<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create new product</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
          integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
            integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns"
            crossorigin="anonymous"></script>
</head>
<body>
<jsp:include page="/view/header.jsp"></jsp:include>
<div class="row">
    <div class="container d-flex justify-content-center">
        <div class="col-6 d-flex flex-column">
            <h1>Edit customer</h1>
            <p>
                <c:if test='${message!=null}'>
                    <span class="message">${message}</span>
                </c:if>
            </p>
            <p>
                <a href="/customer">Back to customer list</a>
            </p>
            <div>
                <form method="post">
                    <div class="form-group">
                        <c:if test="${customer != null}">
                            <input type="hidden" name="id" value="<c:out value='${customer.customerId}' />"/>
                        </c:if>
                    </div>
                    <div class="form-group">
                        <div class="form-group">
                            <label for="customerCode" class="form-label">Customer Code</label>
                            <input type="text" class="form-control" name="customerCode" id="customerCode"
                                   value="${customer.customerCode}">
                            <p class="text-danger">${msgCode}</p>
                        </div>
                        <label for="customerTypeId" class="form-label">Customer Type</label>
                        <select class="form-control" id="customerTypeId" name="customerTypeId">
                            <c:forEach items="${customerTypes}" var="customerType">
                                <option value="${customerType.key}" ${customerType.key==customer.customerTypeId?"selected":""}>${customerType.value}</option>
                            </c:forEach>
                        </select>
                    </div>

                    <div class="form-group">
                        <label for="customerName" class="form-label">Customer Name</label>
                        <input type="text" class="form-control" name="customerName" id="customerName"
                               value="${customer.customerName}">
                    </div>
                    <div class="form-group">
                        <label for="customerBirthday" class="form-label">Customer Birthday</label>
                        <input type="text" class="form-control" name="customerBirthday" id="customerBirthday"
                               value="${customer.customerBirthday}">
                    </div>
                    <div class="form-group">
                        <label for="customerGender" class="form-label">Customer Gender</label>
                        <select class="form-control" id="customerGender" name="customerGender">
                            <option value="Male">Male</option>
                            <option value="Female">Female</option>
                            <option value="Other">Other</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="customerIdCard" class="form-label">Customer ID Card</label>
                        <input type="text" class="form-control" name="customerIdCard" id="customerIdCard"
                               value="${customer.customerIdCard}">
                    </div>
                    <div class="form-group">
                        <label for="customerPhone" class="form-label">Customer Phone</label>
                        <input type="text" class="form-control" name="customerPhone" id="customerPhone"
                               value="${customer.customerPhone}">
                        <p class="text-danger">${msgPhone}</p>
                    </div>
                    <div class="form-group">
                        <label for="customerEmail" class="form-label">Customer Email</label>
                        <input type="text" class="form-control" name="customerEmail" id="customerEmail"
                               value="${customer.customerEmail}">
                    </div>
                    <div class="form-group">
                        <label for="customerAddress" class="form-label">Customer Address</label>
                        <input type="text" class="form-control" name="customerAddress" id="customerAddress"
                               value="${customer.customerAddress}">
                    </div>
                    <div class="form-group">
                        <button type="submit" class="btn btn-primary">Edit</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>
