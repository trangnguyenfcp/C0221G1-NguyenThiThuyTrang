<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Calculator</title>
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
<div class="row">
    <div class="container d-flex justify-content-center">
        <div class="col-6 d-flex flex-column">
            <h2>Calculator</h2>
            <form action="/calculate" method="post">
                <div class="form-group">
                    <input type="text" class="form-control" name="number1" id="number1">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="number2" id="number2">
                </div>
                <div>
                    <button type="submit" class="btn btn-primary" value="+" name="sign">Addition(+)</button>
                    <button type="submit" class="btn btn-primary" value="-" name="sign">Subtraction(-)</button>
                    <button type="submit" class="btn btn-primary" value="X" name="sign">Multiplication(X)</button>
                    <button type="submit" class="btn btn-primary" value="/" name="sign">Division(/)</button>
                </div>
            </form>
            <p class="text-danger">Result: ${result} </p>
        </div>
    </div>
</div>
</body>
</html>