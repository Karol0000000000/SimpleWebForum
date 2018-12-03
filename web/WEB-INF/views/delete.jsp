<%--
  Created by IntelliJ IDEA.
  User: Karol & Monia
  Date: 11/23/2018
  Time: 9:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>delete topic</title>
</head>
<body>
<h1>Topic created ${topic.user.login}</h1>
<h4>Enter password of profile ${topic.user.login}: </h4>
<form method="post">
    <input type="hidden" name="id_topic" value="${topic.id_topic}">
    <input type="password" name="password"/>
    <input type="submit" value="Delete"/>
</form>
<h2>${error}</h2>
<a href="index">Go to all topics</a>
</body>
</html>
