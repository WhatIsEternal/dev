<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="quanxian_window" class="easyui-panel"
     style="width:100%;height:100%;">
    <div style="margin-top: 50px; margin-left: 50px;">

        <ul id="usertree" class="easyui-tree"
            data-options="url:'../showRole.do', checkbox:true">
        </ul>
    </div>
    <a href="javascript:fun()" class="easyui-linkbutton">修改权限</a>
</div>
<script>

        function fun() {
            //获取权限的id
            var da = $("#usertree").tree("getChecked");
             console.log("data " + da[0].rid);
            console.log("data " + da[0].text);
          //  console.log("data2 " + da[1].pid);
         //   console.log("data2 " + da[1].text);
            var arr=[];
           for (i = 0; i < da.length; i++) {
               if(i==0){
                   arr[i] = da[i].rid;
                   console.log("data " + arr[i]);
               }else{
                   arr[i]=da[i].pid;
                   console.log("datap " + arr[i]);
               }

             }
             console.log("arr" + arr);
             //把数据包装成json格式的字符串
           //  var json = JSON.stringify(arr);
             //把json发送到后台
             $.ajax({
               //  url : "../change.do",
                 type : "post",
                 data : arr,
                 //contentType : "application/json",
                 success : function(d) {
                     $("#usertree").tree("reload");
                 }
             })

        };



</script>