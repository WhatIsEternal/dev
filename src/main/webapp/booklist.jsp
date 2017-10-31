<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/7/26/026
  Time: 11:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>书籍列表</title>
</head>
<body>
    <c:forEach items="${bs}" var="b">
        ${b.title}-----<a href="/buy.do?id=${b.id}">购买</a><br/>
    </c:forEach><br/>
<a href="index.jsp">返回首页</a>
</body>
</html>
