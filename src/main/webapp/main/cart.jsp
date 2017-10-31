<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/7/26/026
  Time: 12:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>购物车</title>
    <script type="text/javascript" src="../js/jquery.js"></script>
    <script>
        function delete2(id) {
            $.get("../delete.do", {id: id}, function (d) {
                // alert();
                console.log(d);
                location.reload(true);//刷新页面
            });
        }
    </script>
</head>
<body>
<div>购物车书籍列表</div>
<div>
    <%--items = "" 双引号之内不能有空格--%>
    <c:forEach items="${cart.show()}" var="item">
        <div>
                ${item.title}--------${item.num} <a href="javascript:delete2('${item.id}')">删除</a>
        </div>
    </c:forEach>
        <div >
            应付:      ￥ ${cart.total()}           <a href="qorder.jsp">去付款</a>
        </div>

</div><br/>
<a href="../booklist.jsp">返回上一页</a><br/>
<a href="../index.jsp">返回首页</a>
</body>
</html>
