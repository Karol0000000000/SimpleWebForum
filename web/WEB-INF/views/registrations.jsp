<%--
  Created by IntelliJ IDEA.
  User: Karol & Monia
  Date: 11/21/2018
  Time: 2:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>registrations</title>
</head>
<body>
<h1>Registration</h1>
<h3>${error}</h3>
<form method="post">
    <h4>Login: </h4>
    <input name="login" type="text" maxlength="30"/>
    <h4>Password: </h4>
    <input name="password1" type="password" autocomplete="false" maxlength="20"/>
    <h4>Repeat password: </h4>
    <input name="password2" type="password" autocomplete="false" maxlength="20">
    <br/>
    <br/>
    <input type="submit" value="Registrate"/>
</form>
</body>
</html>
