
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Create new product</title>
</head>
<body>
<h1>Create new product</h1>
<p>
    <c:if test='${"message" != null}'>
        <span class="message">${"message"}</span>
    </c:if>
</p>
<p>
    <a href="/customer">Back to customer list</a>
</p>
<form method="post">
    <fieldset>
        <legend>Customer information</legend>
        <table>
            <tr>
                <td>Customer Type ID: </td>
                <td><input type="text" name="customer_type_id" id="customer_type_id"></td>
            </tr>
            <tr>
                <td>Customer Name: </td>
                <td><input type="text" name="customer_name" id="customer_name"></td>
            </tr>
            <tr>
                <td>Customer Birthday: </td>
                <td><input type="text" name="customer_birthday" id="customer_birthday"></td>
            </tr>
            <tr>
                <td>Customer Gender: </td>
                <td><input type="text" name="customer_gender" id="customer_gender"></td>
            </tr>
            <tr>
                <td>Customer ID Card: </td>
                <td><input type="text" name="customer_id_card" id="customer_id_card"></td>
            </tr>
            <tr>
                <td>Customer Phone: </td>
                <td><input type="text" name="customer_phone" id="customer_phone"></td>
            </tr>
            <tr>
                <td>Customer Email: </td>
                <td><input type="text" name="customer_email" id="customer_email"></td>
            </tr>
            <tr>
                <td>Customer Address: </td>
                <td><input type="text" name="customer_address" id="customer_address"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Create customer"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
