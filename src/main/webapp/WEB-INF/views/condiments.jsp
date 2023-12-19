
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sandwich Form</title>
</head>
<body>
<h2>Create Your Sandwich</h2>

<form action="home/save" method="post">
    <div>
        <input type="checkbox" id="lettuce" name="condiment" value="lettuce">
        <label for="lettuce">Lettuce</label>
    </div>

    <div>
        <input type="checkbox" id="mustard" name="condiment" value="mustard">
        <label for="mustard">Mustard</label>
    </div>

    <div>
        <input type="checkbox" id="tomato" name="condiment" value="tomato">
        <label for="tomato">Tomato</label>
    </div>

    <div>
        <input type="checkbox" id="sprouts" name="condiment" value="sprouts">
        <label for="sprouts">Sprouts</label>
    </div>

    <div>
        <input type="submit" value="Save">
    </div>
</form>
<h4>
    <c:forEach var="condiment" items="${condiments}">
        <span>${condiment}</span>
    </c:forEach>
</h4>
</body>
</html>
