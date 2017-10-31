<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<div id="bk" style="width: 600px; height:600px"></div>
<div id="kcs" class="easyui-window" data-options="closed:true,modal:true" style="width: 300px;height: 300px">
    <form id="kc" action="../ups.do">
        <input type="hidden" name="id" value="0">
        库存数量：<input name="numbers" class="easyui-textbox"/>
        <div style="display:flex;justify-content:center">
            <a href="javascript:up()" class="easyui-linkbutton">修改</a>
        </div>
    </form>
</div>
<%--弹出窗口--%>
<div id="window_addbook" data-options="closed:true,modal:true" class="easyui-window"
     style="width: 400px;height: 500px;">
    <form id="form1">
        书名：<input name="title" class="easyui-textbox" width="400px;height:30px"/><br/>
        <%--从服务器获取数据显示为下拉列表--%>
        类别：<input name="typeid" class="easyui-combobox" data-options="url:'../booktype.do',valueField:'id',textField:'name'"/>
        <br/>
        库存：<input name="numbers" class="easyui-textbox"/><br/>
        封面：<input name="ff" type="file" onchange="showpic(this)"/>
        <%--显示将要上传的图片--%>
        <span id="pics" style="width: 200px;height: 200px">
           </span>
    </form>
    <div>
        <textarea class="ckeditor" rows="3" cols="3" name="bookcontent" style="width: 100%;height:400px"></textarea>
        <br/>
    </div>
    <button class="easyui-linkbutton" onclick="save()">保存</button>
</div>

    <script>
        function initbk() {
            $("#bk").datagrid({
                url: "../findallbook.do",
                columns: [[
                    {field:"id",title:"序号",width:100,checkbox:true},
                    {field: "title", title: "书名", width: 100},
                    {field: "btype", title: "类别", width: 100,formatter:function (value, row, index) {
                        return row["btype"]["name"];
                    }},
                    {field:"numbers",title:"库存",width:100}
                ]],
                toolbar: [
                    {
                        text: "添加", iconCls: "icon-add", handler: function () {
                        addbook();
                    }
                    },
                    {
                        text : "修改库存",
                        iconCls : "icon-edit",
                        handler : function() {
                            ups();
                        }
                    }
                ]

            });
            //初始化
            CKEDITOR.replace("bookcontent");
        }



        function addbook() {
            $("#window_addbook").window("open");
        }

        /*显示图片*/
        function showpic(p) {
            var f1 = p.files[0];

            //伪造url地址
            var x = URL.createObjectURL(f1);
            var y = "<img src='" + x + "'>";
            $("#pics").html(y);
        }

        function up() {
            $("#kc").form("submit", {
                success : function(d) {
                    $("#bk").datagrid("reload");
                    $("#kcs").window("close")
                }
            });
        }
        function ups() {
            var a=$("#bk").datagrid("getSelected");
            $("#kc").form("load",{
                id:a.id,
                numbers:a.numbers,
            });
            $("#kcs").window("open");
        }
        function save() {
            //封装指定form中输入框的值
            //var  data = new FormDate(document.getElementById("form1"));
            var data = new FormData(document.getElementById("form1"));
            //获取大编辑框中的内容
            var x = CKEDITOR.instances.bookcontent.getData();
            //附加到数组中
            data.append("bookcontent", x);
            //异步提交
            $.ajax({
                url: "../addbook.do",
                type: "post",
                data: data,
                contentType: false,  //提交非数组数据一定要关闭
                processData: false,
                success: function (d) {
                    $("#window_addbook").window("close");
                    $.messager.alert("系统提示","添加成功");
                    $("#bk").datagrid("reload");

                }
            })


        }

        initbk();
    </script>


