<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: king
  Date: 2017/7/26
  Time: 16:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <th>编号</th>
        <th>标题</th>
        <th>日期</th>
        <th>状态</th>
    </tr>
<c:forEach items="${plans}" var="plan">
    <tr>
        <td>${plan.id}</td>
        <td>${plan.title}</td>
        <td>${plan.date}</td>
        <td>${plan.status}</td>
        <td><a href="/modify?id=${plan.id}">修改</a></td>
        <td><a href="/delete?id=${plan.id}">删除</a></td>
    </tr>
</c:forEach>
</table>
</body>
</html>
