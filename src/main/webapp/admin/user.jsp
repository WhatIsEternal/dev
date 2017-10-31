<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<div class="easyui-panel" title="搜索" style="width:100%;height:50px">
    <input class="easyui-searchbox" data-options="menu:'#choice',prompt:'输入搜索关键字',searcher:doSearch"/>
    <div id="choice">
        <div data-options="name:'account'">账号</div>
        <div data-options="name:'pwd'">密码</div>
    </div>
</div>
<div id="first"></div>
<div id="ada" class="easyui-window" style="width:500px;height:300px;"
     data-options="closed:true,modal:true">
    <div style="width:100%;height:100%;display:flex;justify-content:center;align-items:center">
        <form id="adda" action="../adda.do">
            <input type="hidden" name="uid" value="0">
            <input type="text" name="account" class="textbox" /><br />
            <input type="password" name="pwd" class="textbox" />
            <div style="display:flex;justify-content:center">
                <a href="javascript:save()" class="easyui-linkbutton">保存</a>
            </div>
        </form>
    </div>
</div>
<div id="u_w" class="easyui-window" style="width:300px;hright:400px;" data-options="closed:true,modal:true">
    <ul id="user_t" class="easyui-tree" data-options="url:'',checkbox:true"></ul>
    <div>
        <a class="easyui-linkbutton" href="javascript:dofenp()">分配</a>
    </div>
</div>

<script type="text/javascript">
    function init4() {
        var pa = 1;
        $("#first").datagrid({
            title : "用户",
            pagination : true,
            columns : [ [
                {
                    field : "uid",
                    title : "序号",
                    width : 50,
                    checkbox : true
                },
                {
                    field : "account",
                    title : "账号",
                    width : 100
                },
                {
                    field : "pwd",
                    title : "密码",
                    width : 100
                },
                {   field:'operate',
                    title:'操作',
                    align:'center',
                    width:$(this).width()*0.1,
                    formatter:function(value, row, index){
                        var str = '<a href="#" name="opera" onclick="adda()" class="easyui-linkbutton" ></a>'+'<a href="#" name="opera2" onclick="upd()" class="easyui-linkbutton" ></a>';
                        return str;
                    }}
            ] ],
            onLoadSuccess:function(data){
                $("a[name='opera']").linkbutton({text:'',plain:true,iconCls:'icon-add'});
                $("a[name='opera2']").linkbutton({text:'',plain:true,iconCls:'icon-edit'});
            },

            toolbar : [
                {
                    text : "修改",
                    iconCls : "icon-edit",
                    handler : function() {
                        upd();
                    }
                },
                {
                    text : "增加",
                    iconCls : "icon-add",
                    handler : function() {
                        adda();
                    }
                },
                {
                    text : "删除",
                    iconCls : "icon-remove",
                    handler : function() {
                        dele();
                    }
                },
                {
                    text:"分配权限",
                    iconCls:"icon-search",
                    handler:function(){
                        fenp();
                    }
                }

            ]
        });
        load1(1);
    }

    //加载数据
    function load1(p) {
        //获取服务端json地址
        pa = p;
        $.getJSON("../find.do", {
            page : p
        }, function(d) {
            //填充数据
            $("#first").datagrid("loadData", d);
            //获取分页组件
            var page = $("#first").datagrid("getPager");
            page.pagination({
                total : 10,
                pageNumber : p,
                pageSize : 2,
                pageList : [ 1, 2, 3, 4, 5, 6 ],
                //页面改变时从新加载数据
                onSelectPage : function(page, size) {
                    pa = page;
                    load1(page);
                }
            });
        });
    }
    function adda() {
        $("#adda").form("clear");
        $("#adda").form("load", {uid:0});
        $("[name='account']").removeAttr("readonly");
        $("#ada").window("open");
    }
    function save() {
        $("#adda").form("submit", {
            success : function(d) {
                load1(pa);
                $("#first").datagrid("reload");
                $("#ada").window("close")
            }
        });
    }
    function dele() {
        var da = $("#first").datagrid("getSelections");
        var ids=[];
        for(var i=0;i<da.length;i++){
            ids[i]=da[i].uid;
        }
        var x=JSON.stringify(ids);
        $.ajax({
            url:"../del.do",
            method:"post",
            data:x,
            contentType:"application/json",
            success:function(d){
                $("#first").datagrid("reload");
                load1(pa);
            }
        });
    }

    function upd() {
        var data = $("#first").datagrid("getSelected");
        $("#adda").form("load", {
            uid : data.uid,
            account : data.account,
            pwd : data.pwd
        });
        $("[name='account']").attr("readonly", "readonly");
        $("#ada").window("open");
    }

    function fenp(){
        var user=$("#first").datagrid("getSelected");
        if(user){
            $("#u_w").window("open");
        }else{
            $.messager.alert("系统提示","选择要分配权限的账号");
        }

    }

    function dofenp(){
        var user=$("#first").datagrid("getSelected");
        var data=$("#user_t").tree("getChecked");
        var as=[user.uid];
        for(i=0;i<data.length;i++){
            as[i+1]=data[i].uid;
        }
        var json=JSON.stringify(as);
        $.ajax({
            url:"../fenp.do",
            method:"post",
            data:json,
            contentType:"application/json",
            success:function(d){
                if(d){
                    $.messager.alert("系统提示","分配成功!");
                    load1(pa);
                    $("#u_w").window("close");
                    $("#first").datagrid("reload");
                }else{
                    $.messager.alert("系统提示","分配不成功，请重新分配");
                }

            }
        });
    }
    //搜索
    function doSearch(key,type){
        $.getJSON("../search.do",{type:type,key:key},function(d){
            $("#first").datagrid("loadData",d);
        });
    }
    init4();
</script>
