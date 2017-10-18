<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.io.IOException" %>
<html>
<head>
    <title>LOG IN SCREEN </title>
</head>
<body>
<%@ include file="partials/navbar.jsp" %>
<%@ include file="partials/scripts.jsp" %>
<%@ include file="partials/styles.jsp" %>



<form action="/login.jsp" method="post">

name : <input type="text"  class="form-control" name="username" >


password : <input type="password"  class="form-control" name="password">



    <button type="submit" class="btn" >submit</button>




    </form>
<c:if test="${param.password == 'p'}">
    <% response.sendRedirect("/profile.jsp?username=" + request.getParameter("username"));%>
</c:if>

<c:if test="${param.username == '' || param.password == ''}">
    <% response.sendRedirect("/error.jsp");%>
</c:if>

</body>
</html>
