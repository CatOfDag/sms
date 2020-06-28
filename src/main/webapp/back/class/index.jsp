<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html; UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>班级管理</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"/>
    <script src="${pageContext.request.contextPath}/back/statics/js/jquery-1.8.3.min.js"></script>

</head>
<body>
<div class="container-fluid">

    <div class="row" style="margin-bottom: 20px">
        <div class="col-sm-4 col-sm-offset-4">
            <h1 class="text-center">班级管理</h1>
        </div>
    </div>

    <div class="row" style="margin-bottom: 20px">
        <div class="col-sm-12">
            <form id="inputForm" class="form-inline" action="${pageContext.request.contextPath}/class/insertClass" method="post">
                <div class="form-group">
                    <label for="name">名称:</label>
                    <input type="text" class="form-control" id="name" name="name">
                </div>
                <div class="form-group" id="tag">
                    <label for="tagid">选择对应标签:</label>
                    <select name="tagid" id="tagid" class="form-control">
                    </select>
                </div>
                <input type="submit" class="btn btn-success" value="添加班级" />
            </form>
        </div>
    </div>

    <div class="row">
        <div class="col-sm-12">
            <table class="table table-striped table-hover table-bordered">
                <tr>
                    <th>编号</th>
                    <th>名称</th>
                    <th>所属标签</th>
                    <th>操作</th>
                </tr>
                <c:forEach items="${requestScope.classes}" var="clazz">
                    <tr>
                        <td>${clazz.id}</td>
                        <td>${clazz.name}</td>
                        <td>${clazz.tag.tname}</td>
                        <td>
                            <a href="" class="btn btn-info">修改</a>
                            <a href="javascript:" onclick="if(confirm('是否删除？'))
                                    location.href='${pageContext.request.contextPath}/class/delete?id=${clazz.id}';" methods="post" class="btn btn-danger">删除</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>

</div>
</body>
<script>
    $(function () {
        $.post("${pageContext.request.contextPath}/tag/selectByType",{type:'班级'},function(res){
            //console.log(res);
            $.each(res,function(index,tag){
                let option = $("<option/>").text(tag.tname).val(tag.tid);
                $("#tagid").append(option);
            });
        });

        $("#inputForm").submit(function(e){

            if (document.getElementById("name").value === ""){
                alert("Submitted");
                return false
            }
            return true;
        });
    })
</script>
</html>
