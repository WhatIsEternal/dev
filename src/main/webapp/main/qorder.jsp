<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/7/28/028
  Time: 20:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<c:forEach items="${cart.show()}" var="item">
    <div>
            ${item.title}--------${item.num}
    </div>
</c:forEach>
---------------${cart.total()}--------------------------收货人:${user.account}<br/>
<a href="../toorder.do">提交订单</a><br/>
<a href="../booklist.jsp">返回商品页面</a><br/>
<a href="../index.jsp">返回首页</a>
</body>
</html>
