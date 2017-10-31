<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
欢迎来到哒哒商城!
<shiro:hasRole name="管理员">
    <a href="admin/qx.jsp">后台</a>

</shiro:hasRole>
<a href="tobooklist.do">买书</a>
<a href="/main/hisorder.jsp">历史订单</a>
</body>
</html>
