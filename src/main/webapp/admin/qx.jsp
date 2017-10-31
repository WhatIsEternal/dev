<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>
    <title>qx页</title>
    <link rel="stylesheet" href="../css/bootstrap.css">
    <link rel="stylesheet" href="../css/icon.css">
    <link rel="stylesheet" href="../css/easyui.css">
    <script type="text/javascript" src="../js/jquery.js"></script>
    <script type="text/javascript" src="../js/easyui.js"></script>
    <script  type="text/javascript" src="../ckeditor/ckeditor.js"></script>
    <script type="text/javascript" src="../js/echarts.min.js"></script>

    <script>
        function init() {
             $("#menu_tree").treegrid({
                 title : "资源管理",
                 url:"../showQx.do",
                 idField:"id",
                 treeField:"name1",
                 columns : [ [
                     {
                         field : "name1",
                         title : "账号",
                         width : 200
                     },
                 ] ],


                 onClickRow:function (node) {
                     var had = $("#work").tabs("exists",node.name1);
                     if (!had){
                         $("#work").tabs("add",{
                             title:node.name1,
                             closable:true,
                             href: (node.url),
                         })
                     }else{
                         $("#work").tabs("select",node.name1)
                     }
                 }
             })
        }

        $(init);
    </script>
</head>
<body>
<div class="easyui-layout" style="width: 100%; height:100%; ">
    <div data-options="region:'north'"
         style="width: 100%; height: 200px;">
        <img src="../img/1.png" style="width: 100%">
    </div>
    <div data-options="region:'west'"
         style="width: 200px; height:100%">
        <div id="menu_tree"  style="width: 200px; height:100%;">
        </div>
    </div>
    <div id="work" data-options="region:'center'" class="easyui-tabs"></div>
</div>

</body>
</html>
