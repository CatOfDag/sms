<%@page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ page import="java.io.*,java.util.*" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0,
minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>用户注册</title>
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"/>
    <script src="statics/js/jquery-1.8.3.min.js">
    </script>
</head>
<body>
<div class="container-fluid">
    <%--用户注册--%>
    <div class="row" style="margin-top: 70px;">
        <div class="col-sm-4 col-sm-offset-4">
            <h1 class="text-center">用户注册</h1>
        </div>
    </div>
    <%--完成表单--%>
    <div class="row">
        <div class="col-sm-4 col-sm-offset-4">
            <form id="regForm">
                <div class="form-group">
                    <label for="name">用户名:</label>
                    <input type="text" class="form-control" name="name" id="name"
                           placeholder="请输入用户名...">
                </div>
                <div class="form-group">
                    <label for="password">密码:</label>
                    <input type="password" class="form-control" name="password"
                           id="password" placeholder="请输入密码...">
                </div>
                <div class="form-group">
                    <label for="role">角色选择:</label>
                    <select name="role" class="form-control" id="role">
                        <option value="admin">管理员</option>
                        <option value="student">学生</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="code">验证码:</label>
                    <div>
                        <input id="code" type="text" name="code" class="form-control"
                               style="height:48px;width: 50%;float: left;" placeholder="请输入验证码....">
                        <img src="${pageContext.request.contextPath}/user/getCaptcha" id="image" style="height:48px;float: right;"  alt="请点击刷新"/>
                    </div>
                </div>
                <div id="clearfix" class="clearfix" style="color: red">
                    <%if (session.getAttribute("error") == null) out.print("");
                    else out.print(session.getAttribute("error"));%>
                </div>
                <input type="button" id="regBtn" class="btn btn-danger" style="margin-top:20px;width: 30%;margin-left: 10px;" value="立即注册">
                <a href="login.jsp" class="btn btninfo" style="margin-top:20px;width: 30%;margin-left: 30px;">返回登录</a>
            </form>
        </div>
    </div>
</div>
</body>
<script>

    $(function(){
        //更换验证码
        $("#image").click(function () {
            $(this).attr("src", "${pageContext.request.contextPath}/user/getCaptcha?id=" + Math.random());
        });

        $("#regBtn").click(function(){
            $.post("${pageContext.request.contextPath}/user/registerCheck",$("#regForm").serialize(),function
                (res) {
                if(res.res){
                    alert("注册成功!!!");
                    location.href = "${pageContext.request.contextPath}/back/login.jsp";
                }else{
                    document.getElementById("clearfix").innerHTML = res.info;
                }
            });
        });
    });


</script>
</html>