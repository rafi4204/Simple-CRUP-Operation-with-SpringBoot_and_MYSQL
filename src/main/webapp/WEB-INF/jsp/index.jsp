<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title> Tag Example</title>
</head>

<body>
<c:forEach var="i" items="${list}">

    Item <c:out value="${i.name}"/> <a href="/view/${i.id}">view</a>

    <%--Item <c:out value="${i.id}"/><p>--%>
    <%--    "${i.id}"--%>

    <%--Item <c:out value="${i.id}"/><p>--%>

    <br>
</c:forEach>
<form method="post" action="/save">
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