<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title> Tag Example</title>
</head>

<body>
<c:forEach var="i" items="${list}">

    Item <c:out value="${i.name}"/> <a href="/view/${i.id}">view</a> <a href="/delete/${i.id}">Delete</a>  <a href="/update/${i.id}">Update</a>
    <br>
    <br>
</c:forEach>
<form method="post" action="/save">
    <input type="hidden" name="id" value=-1>
    Name:<br>
    <input type="text" name="name">
    <br>
    Age:<br>
    <input type="number" name="age">
    <br>
    Gender:<br>
    <input type="text" name="gender">
    <br><br>
    <input type="submit" value="submit">
</form>

</body>
</html>