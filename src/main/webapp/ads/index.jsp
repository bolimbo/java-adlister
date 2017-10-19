<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@  page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ads</title>
</head>
<body>

    <c:forEach var="ad" items="${ads}">
       <h1> ${ad.title}</h1>
        <h3>${ad.description}</h3>
    </c:forEach>

</body>
</html>