<%@ page import="com.aneon.po.User" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>Jumbotron Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link href="https://cdn.bootcss.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->


</head>

<body>

<!-- 顶部导航栏 -->
<nav class="navbar navbar-expand-lg bg-dark navbar-dark fixed-top">
    <div class="container">
        <a class="navbar-brand" href="#">TOSIT学员管理系统</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <form class="form-inline my-2 my-lg-0" id="navbarNavDropdown" onload="check(); return false;">
              <input type="text" placeholder="用户名" name="zh" id="zh" class="form-control mr-sm-2 ">
              <input type="password" placeholder="密码" name="mm" id="mm" class="form-control mr-sm-2">
              <button class="btn btn-success" onclick="login(); return false;" id="loginBtn">登录</button>
              <a class="text-light " id="hello" style="display: none"><span id="name"></span>，您好</a>
              <a class="text-light ml-sm-2" id="backend" href="pages/backend.jsp" style="display: none">进入后台</a>
        </form>
    </div>
</nav>

<!-- Main jumbotron for a primary marketing message or call to action -->
<div class="jumbotron">
    <div class="container">
        <h1>Hello, world!</h1>
        <p>This is a template for a simple marketing or informational website. It includes a large callout called a jumbotron and three supporting pieces of content. Use it as a starting point to create something more unique.</p>
        <p><a class="btn btn-primary btn-lg" href="#" role="button">Learn more &raquo;</a></p>
    </div>
</div>

<div class="container">

    <hr>

    <footer>
        <p>&copy; 2018 四只小猪, Inc.</p>
    </footer>
</div> <!-- /container -->


<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>

<!-- 自己的js代码 -->
<script src="resources/js/index.js"></script>

</body>
</html>

<%--<html>--%>
<%--<head>--%>
<%--<script src="resources/lib/layui/layui.js"></script>--%>
<%--</head>--%>
<%--<body>--%>

<%--</body>--%>
<%--</html>--%>
