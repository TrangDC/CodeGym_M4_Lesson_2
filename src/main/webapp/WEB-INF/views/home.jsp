<%--
  Created by IntelliJ IDEA.
  User: Trang99
  Date: 12/18/2023
  Time: 2:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Email Validate</h1>

<h3>${message}</h3>
<form action="validate" method="post">
    <input type="text" name="email">
    <br>
    <input type="submit" value="Validate">
</form>

</body>
</html>
