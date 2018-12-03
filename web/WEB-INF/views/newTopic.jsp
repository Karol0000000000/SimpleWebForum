<%--
  Created by IntelliJ IDEA.
  User: Karol & Monia
  Date: 11/21/2018
  Time: 1:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>new Topic</title>
</head>
<body>
<h1>Add topic</h1>
<a href="index">Go to all topics</a>
<br/>
<form method="post">
    <h4>Title: </h4>
    <input name="title" type="text" maxlength="255">
    <h4>Conntent: </h4>
    <textarea cols="50" rows="10" name="content"></textarea>
    <br/>
    <input type="submit" value="Add">
</form>
<h3>${error}</h3>
</body>
</html>
