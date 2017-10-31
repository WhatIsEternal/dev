<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/7/27/027
  Time: 19:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="returnorder"></div>

    <script>
        function initreturn() {
            $("#returnorder").datagrid({
                title: "退货管理",
                url: "../showorderreturn.do",
                columns: [[
                    {field: "id", title: "id",  align:'center',width: 300,checkbox:true},
                    {field: "ordercode", title: "订单编号",  align:'center',width: 300},
                    {field: "own_account", title: "用户",  align:'center',width: 100},
                    {field: "createorder_time", title: "生成订单时间",  align:'center',width: 100},


                    {
                        field: "return_status", title: "退货状态", width: 100,  align:'center',formatter: function (value, row, index) {
                        if (value == 1) {
                            return "退货中";
                        }else{
                            return "";
                        }
                    }
                    },
                    {field: "createreturn_time", title: "确认退货单",  align:'center',width: 100},
                    {
                        field: "status", title: "", width: 100,  align:'center',formatter: function (value, row, index) {
                        if (value == 0) {
                            return "申请退货";
                        }else{
                            return "已确认";
                        }
                    }
                    },

                ]],
                toolbar:[
                    {text:"确认退货订单",iconCls:"icon-edit",handler:function () {
                            doreturn();
                    }}
                ]

            });
        }

        $(initreturn);
        function doreturn() {
            var data = $("#returnorder").datagrid("getSelected");
            $.get("../editreturnorder.do",{ordercode:data.ordercode},function (d) {
                $("#returnorder").datagrid("reload");
            });

        }
    </script>


