<%--
  Created by IntelliJ IDEA.
  User: ed
  Date: 29.05.2019
  Time: 15:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="designTable.css">
    <link rel="stylesheet" href="designLogout.css">

</head>
<body background="#191919">
<table class="myTable2" style="margin-left: 490px">
    <h1 style="width: 100%;
        text-align: center" >Pass statistics</h1>
    <tr>
        <th>id</th>
        <th>turnstile</th>
        <th>passes</th>
        <th>date</th>
    </tr>
    <c:forEach var="pass" items="${pass}">
        <tr>
            <td>${pass.getId()}</td>
            <td>${pass.getTurnstileId()}</td>
            <td>${pass.getNumOfPasses()}</td>
            <td>${pass.getCurrentDay()}</td>
        </tr>
    </c:forEach>
</table>

<form class="box2" action="/courseorkJava_Turnstile_exploded/myUrl" method="post">
    <input type="submit" value="Logout" style="margin-left: 1100px; margin-top: 10px">

    <input type="hidden" name="command" value="clickLogout">
</form>
</body>
</html>
