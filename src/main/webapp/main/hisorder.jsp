<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/7/28/028
  Time: 22:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../css/icon.css">
    <link rel="stylesheet" href="../css/easyui.css">
    <script type="text/javascript" src="../js/jquery.js"></script>
    <script type="text/javascript" src="../js/easyui.js"></script>
    <script>
        function ininorderall() {
            $("#orderall").datagrid({
                url: "../hisorder.do",
                columns: [[
                    {field: "id", title: "id", width: 200, checkbox: true},
                    {field: "code", title: "订单编号", width: 200},
                    {field: "createTime", title: "订单时间", width: 200},
                    {field: "title", title: "书名", width: 200},
                    {field: "num", title: "数量", width: 200},
                    {field: "total", title: "总价", width: 200},
                    {
                        field: "ship_status", title: "发货状态", width: 100,  align:'center',formatter: function (value, row, index) {
                        if (value == 0) {
                            return "未发货";
                        }else  if (value == 1){
                            return "已发货";
                        }else if(value == 3){
                            return "申请退货中...";
                        } else  if(value == 4){
                            return "完成退货"
                        }
                    }
                    }
                ]],
                toolbar: [
                    {
                        text: "退货", iconCls: "icon-add", handler: function () {
                        orderreturn();

                    }
                    }
                ]

            });
        }

        function orderreturn() {
            var data = $("#orderall").datagrid("getSelected");
            console.log(data);
            var code = data.code;
            var createTime = data.createTime;
            var account = data.owner;
            $.get("../returnorder.do",{code:code,createTime:createTime,account:account},function (d) {
                $("#orderall").datagrid("reload");

            });

        }

        $(ininorderall);
    </script>
</head>
<body>

<div id="orderall"></div><br/>
<a href="../booklist.jsp">返回商品页面</a><br/>
<a href="../index.jsp">返回首页</a>
</body>
</html>
