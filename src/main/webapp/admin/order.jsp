<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/7/27/027
  Time: 19:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="order"></div>

    <script>
        function initor() {
            $("#order").datagrid({
                title: "订单管理",
                url: "../showorder.do",
                columns: [[
                    {field: "id", title: "id",  align:'center',width: 300,checkbox:true},
                    {field: "code", title: "订单编号",  align:'center',width: 300},
                    {field: "owner", title: "会员名",  align:'center',width: 100},
                    {field: "total", title: "订单总额", align:'center', width: 100},
                    {field: "createTime", title: "订单日期", align:'center', width: 200},
                    {
                        field: "status", title: "订单状态", width: 100,  align:'center',formatter: function (value, row, index) {
                        if (value == 0) {
                            return "未确认";
                        }else{
                            return "确认";
                        }
                    }
                    },
                    {
                        field: "pay_status", title: "支付状态", width: 100,  align:'center',formatter: function (value, row, index) {
                        if (value == 0) {
                            return "未支付";
                        }else{
                            return "已支付";
                        }
                    }
                    },
                    {
                        field: "ship_status", title: "发货状态", width: 100,  align:'center',formatter: function (value, row, index) {
                        if (value == 0) {
                            return "未发货";
                        }else  if (value == 1){
                            return "已发货";
                        }else if(value == 3){
                            return "申请退货";
                        }else{
                            return "已退货"
                        }
                    }
                    }
                ]],
                toolbar:[
                    {text:"确认订单",iconCls:"icon-edit",handler:function () {
                        editOrder();
                    }}
                ]

            });
        }

        $(initor);
        function editOrder() {
            var dd = $("#order").datagrid("getSelected");

            console.log(dd.id);
           $.get("../editorder.do",{data:dd.id},function (d) {
               $("#order").datagrid("reload");
            })
        }
    </script>



