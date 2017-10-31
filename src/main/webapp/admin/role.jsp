<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<div id="one"></div>
<div id="user_role" class="easyui-window"
     style=" width:400px; height:300px;"
     data-options="closed:true,modal:true">
    <!-- closed:true 表示当前窗口隐藏   modal:true 表示只能操作当前弹出窗口,后面的都不能操作 -->
    <div
            style="width:100%; height:100%; display:flex;justify-content:center;align-items:center">
        <form action="../editUserRole.do" id="role_form">
            <input type="hidden" name="uid" class="textbox"><br/>
            <input type="text" name="account" class="textbox"><br/>
            <input type="hidden" id = "rid" name="rid" class="textbox">

            <br/>

        </form>
        <input id="role_" style="width:150px"/>
        <div>
            <a href="javascript:editr()" class="easyui-linkbutton">修改</a>
        </div>

    </div>

</div>
<script>
    function init7() {

        $("#one").datagrid({
            title: "用户",
            url: "../showUser.do",
            columns: [[
                {
                    field: "uid",
                    title: "序号",
                    width: 50,
                    checkbox: true
                },
                {
                    field: "account",
                    title: "姓名",
                    width: 100
                },
                {
                    field: "role_name",
                    title: "角色",
                    width: 100
                }
            ]],

            toolbar: [
                {
                    text: "修改",
                    iconCls: "icon-edit",
                    handler: function () {
                        open_editr();
                    }
                }

            ]
        });
    }

    function open_editr() {
        var data = $("#one").datagrid("getSelected");
        console.log(data);
        if (data) {
            $("#role_form").form("load", {
                uid: data.uid,
                account: data.account,
            });

            $('#role_').combobox({
                url: "../selectRole.do",
               // required: true,
                valueField: 'rid',
                textField: 'text',

            });

            $("#user_role").window("open");


        } else {
            $.messager.alert("系统提示", "请选择需要修改的账号");
        }
    }
    //提交数据
    function editr() {
        var data = $("#role_").combobox("getValue");
        console.log(data);
        $("#rid").val(data);
         $("#role_form").form("submit", {
             success : function(d) {
                    console.log("成功"+d);
                 $("#user_role").window("close");

                 $("#one").datagrid("reload");
             }
         });
    }
        init7();
</script>



