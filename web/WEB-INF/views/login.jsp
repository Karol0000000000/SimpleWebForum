<%--
  Created by IntelliJ IDEA.
  User: Karol & Monia
  Date: 11/21/2018
  Time: 1:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Forum</title>
</head>
<body>
    <h1>Log In</h1>
    <form method="post" action="j_security_check">
        <h4>Login: </h4>
        <input type="text" name="j_username"/>
        <h4>Password: </h4>
        <input type="password" name="j_password" autocomplete="off"/>
        <br/><br/>
        <input type="submit" value="Log In"/>
    </form>
<br/>
<br/>
<c:url var="registration" scope="page" value="/registration"/>
<a href="${registration}">Registrate</a>
</body>
</html>
