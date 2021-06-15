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
                <a href="/employee">Back to employee list</a>
            </p>
            <div>
                <form method="post">
                    <div class="form-group">
                        <c:if test="${employee != null}">
                            <input type="hidden" name="id" value="<c:out value='${employee.employeeId}' />"/>
                        </c:if>
                    </div>

                    <div class="form-group">
                        <label for="employeeName" class="form-label">Employee Name</label>
                        <input type="text" class="form-control" name="employeeName" id="employeeName"
                               value="${employee.employeeName}">
                        <p class="text-danger">${msgName}</p>
                    </div>
                    <div class="form-group">
                        <label for="employeeBirthday" class="form-label">Employee Birthday</label>
                        <input type="text" class="form-control" name="employeeBirthday" id="employeeBirthday"
                               value="${employee.employeeBirthday}">
                        <p class="text-danger">${msgBirthday}</p>
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
