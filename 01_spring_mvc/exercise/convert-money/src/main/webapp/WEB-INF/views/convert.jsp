<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 7/14/2021
  Time: 9:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<title>Conver-Money</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<body>

<form class="w3-container w3-card-4" action="/convert" >
    <h2 class="w3-text-blue">Input Form</h2>
    <p>Convert Money</p>
    <p>
        <label class="w3-text-blue"><b>USD</b></label>
        <input class="w3-input w3-border" name="usd" type="number" value="${usd}"></p>
    <button class="w3-btn w3-blue">Convert</button></p>
    <p>
        <label class="w3-text-blue"><b>VND</b></label>
        <input class="w3-input w3-border" name="vnd" type="text" value="${vnd}"></p>
    <p>

</form>

</body>
</html>
