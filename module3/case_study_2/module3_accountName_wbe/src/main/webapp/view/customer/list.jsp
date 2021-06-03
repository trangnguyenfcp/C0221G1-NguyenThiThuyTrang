<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Customer Management Application</title>
</head>
<body>
<center>
    <h1>Customer Management</h1>
    <h2>
        <a href="/customer?action=create">Add New Customer</a><br>
        <a href="/customer?action=search">Search user by country</a>
    </h2>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Customers</h2></caption>
        <tr>
            <th>Customer ID</th>
            <th>Customer type ID</th>
            <th><a href="/customer">Customer Name</a> <a href="/users?action=sort">Sort</a></th>
            <th>Customer Birthday</th>
            <th>Customer Gender</th>
            <th>Customer ID Card</th>
            <th>Customer Phone</th>
            <th>Customer Email</th>
            <th>Customer Address</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="customer" items="${customers}">
            <tr>
                <td><c:out value="${customer.customer_id}"/></td>
                <td><c:out value="${customer.customer_type_id}"/></td>
                <td><c:out value="${customer.customer_name}"/></td>
                <td><c:out value="${customer.customer_birthday}"/></td>
                <td><c:out value="${customer.customer_gender}"/></td>
                <td><c:out value="${customer.customer_id_card}"/></td>
                <td><c:out value="${customer.customer_phone}"/></td>
                <td><c:out value="${customer.customer_email}"/></td>
                <td><c:out value="${customer.customer_address}"/></td>
                <td>
                    <a href="/customer?action=edit&id=${customer.customer_id}">Edit</a>
                    <a href="/customer?action=delete&id=${customer.customer_id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>