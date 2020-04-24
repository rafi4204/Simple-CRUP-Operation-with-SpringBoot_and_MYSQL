<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html>
<head>
    <title> Tag Example</title>
</head>

<body>
<c:forEach var = "i" items="${list}">
Item <c:out value = "${i.name}"/><p>
    </c:forEach>
</body>
</html>