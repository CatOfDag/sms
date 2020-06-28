<%@page contentType="text/html; UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0,
minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>学生管理系统</title>
    <script src="${pageContext.request.contextPath}/back/statics/js/jquery-1.8.3.min.js"></script>
</head>
<%--
frameset使用时不能存在body标签
cols:将页面划分的列数
rows:将页面划分的行数
注意: 在一个frameset标签上 cols rows不能同时出现
--%>
<frameset rows="50px,*" border="1px">
    <%--引入标题--%>
    <frame src="head.jsp">
    <frameset cols="200px,*">
        <frame src="menu.jsp">
        <%--中心布局--%>
        <frame src="home.jsp" name="content">
    </frameset>
</frameset>
<script>
    history.pushState(null, null, document.URL);
    window.addEventListener('popstate', function () {
        history.pushState(null, null, document.URL);
    });
</script>
</html>