<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 6/15/2021
  Time: 2:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Simple Dictionary</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>
</head>
<body>
<div class="row">
    <div class="container d-flex justify-content-center">
        <div class="col-6 d-flex flex-column">
            <h1>Simple Dictionary</h1>
<form action="/translate" method="post">
    <div class="form-group">
        <label for="word">Word</label>
        <input type="text" class="form-control" id="word" name="word">
    </div>
    <div class="form-group">
        <label for="fromTo">From-To</label>
        <select name="fromTo" id="fromTo" class="form-control">
           <option value="1">Anh - Việt</option>
           <option value="2">Việt - Anh</option>
        </select>
    </div>
    <button type="submit" class="btn btn-primary">Translate</button>
</form>
            <p class="text-info">Result: ${result}</p>
        </div>
    </div>
</div>
</body>
</html>
