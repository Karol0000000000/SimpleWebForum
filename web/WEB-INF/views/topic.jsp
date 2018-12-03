<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Karol & Monia
  Date: 11/21/2018
  Time: 3:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>topic</title>
</head>
<body>
<h1>${topic.title}</h1>
<a href="index">Go to all topics</a>
<br/>
<c:url scope="page" value="/delete" var="delete">
    <c:param name="id_topic" value="${topic.id_topic}"/>
</c:url>
<a href="${delete}">Delete this topic</a>

<h3>Details of topic</h3>
<table border="1">
    <tr>
        <th>Login</th>
        <th width="500">Content</th>
        <th>Date</th>
    </tr>
    <tr>
        <td>${topic.user.login}</td>
        <td>${topic.content}</td>
        <td>${topic.date}</td>
    </tr>
</table>
<br/>
<br/>
<h3>Registrations of topic</h3>
<table border="2">
    <c:forEach var="registration" items="${topic.registrationsOfTopic}">
        <tr>
            <td>${registration.user.login}</td>
            <td width="500">${registration.content}</td>
            <td>${registration.date}</td>
        </tr>
    </c:forEach>
</table>
<br/>
<form method="post">
    <input type="hidden" name="id" value="${temat.id}">
    <p>Add registration to topic: </p>
    <textarea cols="50" rows="10" name="content"></textarea>
    <br/>
    <input type="submit" value="Send">
</form>
</body>
</html>
