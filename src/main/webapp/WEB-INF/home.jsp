<%--
  Created by IntelliJ IDEA.
  User: tapusd
  Date: 2/9/21
  Time: 2:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Home Page</title>
</head>
<body>
This is the home page! Welcome <c:if test="${not empty name}">${name}</c:if> <c:if test="${empty name}">Home!</c:if>
Heello no 2: ${name2}
</body>
</html>
