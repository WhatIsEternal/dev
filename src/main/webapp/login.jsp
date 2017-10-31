<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>超级后台管理系统</title>
</head>
<body>
<div style="position:relative;background: url('img/c.jpg');background-size: 100%;width: 100%;height: 100%">
    <div style="margin-left: 950px;width:300px;height:750px;display:flex;justify-content:center;align-items:center;">
        <form action="login.do" method="post">
            <input type="text" name="account" style="height: 20px;border-radius: 5px;border: 0.1px solid transparent;background-color: transparent" placeholder="账号"/><br/><br/>
            <input type="password" name="pwd" style="height: 20px;border-radius: 5px;border: 0.1px solid transparent;background-color: transparent" placeholder="密码"/><br/><br/>
            <input type="submit" style="border-radius: 5px;background-color: transparent;border: 0.3px solid transparent" value="登录"/>
        </form>
    </div>
</div>
</body>
</html>