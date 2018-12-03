<%--
  Created by IntelliJ IDEA.
  User: Karol & Monia
  Date: 11/21/2018
  Time: 1:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Forum</title>
</head>
<body>
<h1>Forum</h1>
<table>
    <tr>
        <th>Topic</th>
        <th>Date</th>
        <th>Author</th>
    </tr>
    <c:forEach var="topic" items="${allTopics}">
        <tr>
            <td>
                <c:url var="topicUrl" scope="page" value="/topics">
                    <c:param name="id" value="${topic.id_topic}"/>
                </c:url>
                <a href="${topicUrl}">${topic.title}</a>
            </td>
            <td>
                <fmt:formatDate value="${topic.date}" dateStyle="short" timeStyle="short" type="both"/>
            </td>
            <td>
                ${topic.user.login}
            </td>
        </tr>
    </c:forEach>
</table>
    <c:url value="/newTopic" scope="page" var="newTopic"/>
        <form action="${newTopic}">
            <input type="submit" value="Insert new topic"/>
        </form>
<br/>
<br/>
<a href="logout">Logout</a>
</body>
</html>
