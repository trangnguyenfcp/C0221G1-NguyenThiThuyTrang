<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 5/27/2021
  Time: 3:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
  <head>
    <title>Simple Calculator</title>
  </head>
  <body>
  <h2>Simple Calculator</h2>
  <form action="calculate" method="get">
    <table>
      <tr>
        <td><label>First operand</label></td>
        <td><input type="text" name="firstOperand" placeholder="RATE" value="22000"/></td>
      </tr>
      <tr>
        <td><label>Operator</label></td>
        <td>
          <select id="sign" name="sign">
            <option value="+">+</option>
            <option value="-">-</option>
            <option value="*">x</option>
            <option value="/">/</option>
          </select>
        </td>
      </tr>
      <tr>
        <td><label>Second operand</label></td>
        <td><input type="text" name="secondOperand" placeholder="RATE" value="22000"/></td>
      </tr>
      <tr>
        <td></td>
        <td><input type="submit" value="Calculate" id="submit"></td>
      </tr>
    </table>
  </form>

  </body>
</html>
