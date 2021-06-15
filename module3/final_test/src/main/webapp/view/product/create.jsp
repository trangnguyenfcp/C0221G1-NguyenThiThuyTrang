<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns:jsp="http://java.sun.com/JSP/Page">
<head>
    <title>Create new Customer</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>
</head>
<body>
<jsp:include page="/view/header.jsp"></jsp:include>
<div class="row">
    <div class="container d-flex justify-content-center">
        <div class="col-6 d-flex flex-column">
            <h1>Create new product</h1>
            <p>
                <c:if test='${message!=null}'>
                    <span class="message text-success">${message}</span>
                </c:if>
            </p>
            <p>
                <a href="/product">Back to product list</a>
            </p>
                <form method="post">
                    <div class="form-group">
                        <div class="form-group">
                            <label for="productName" class="form-label">Customer Name</label>
                            <input type="text" class="form-control" name="productName" id="productName">
                        </div>
                        <label for="productPrice" class="form-label">Price</label>
                        <input type="text" class="form-control" name="productPrice" id="productPrice">
                    </div>
                    <div class="form-group">
                        <label for="productQuantity" class="form-label">Quantity</label>
                        <input type="text" class="form-control" name="productQuantity" id="productQuantity">
                    </div>
                    <div class="form-group">
                        <label for="productDescription" class="form-label">Description</label>
                        <input type="text" class="form-control" name="productDescription" id="productDescription">
                    </div>
                    <div class="form-group">
                        <label for="categoryId" class="form-label">Category</label>
                        <select class="form-control" id="categoryId" name="categoryId">
                            <c:forEach items="${categoryList}" var="category">
                                <option value="<c:out value="${category.key}"></c:out>"><c:out value="${category.value}"></c:out> </option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <button type="submit" class="btn btn-primary">Create</button>
                    </div>
                </form>
        </div>
    </div>
</div>
<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>
