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
            <h1>Edit product</h1>
            <p>
                <c:if test='${message!=null}'>
                    <span class="message">${message}</span>
                </c:if>
            </p>
            <p>
                <a href="/product">Back to product list</a>
            </p>
            <div>
                <form method="post">
                    <div class="form-group">
                        <c:if test="${product != null}">
                            <input type="hidden" name="id" value="<c:out value='${product.productId}' />"/>
                        </c:if>
                    </div>
                    <div class="form-group">
                        <div class="form-group">
                            <label for="productName" class="form-label">Name</label>
                            <input type="text" class="form-control" name="productName" id="productName"
                                   value="${product.productName}">
                        </div>
                        <div class="form-group">
                            <label for="productPrice" class="form-label">Price</label>
                            <input type="text" class="form-control" name="productPrice" id="productPrice"
                                   value="${product.productPrice}">
                        </div>
                        <div class="form-group">
                            <label for="productQuantity" class="form-label">Quantity</label>
                            <input type="text" class="form-control" name="productQuantity" id="productQuantity"
                                   value="${product.productQuantity}">
                        </div>
                        <div class="form-group">
                            <label for="customerDescription" class="form-label">Description</label>
                            <input type="text" class="form-control" name="customerDescription" id="customerDescription"
                                   value="${product.productDescription}">
                        </div>
                        <label for="categoryId" class="form-label">Category</label>
                        <select class="form-control" id="categoryId" name="categoryId">
                            <c:forEach items="${categoryList}" var="category">
                                <option value="${category.key}" ${category.key==product.categoryId?"selected":""}>${category.value}</option>
                            </c:forEach>
                        </select>
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
