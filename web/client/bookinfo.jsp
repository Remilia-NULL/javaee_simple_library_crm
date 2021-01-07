<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: edward
  Date: 2019-06-12
  Time: 16:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="../assets/bootstrap-3.3.4/dist/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="../assets/Flat-UI-master/dist/css/flat-ui.min.css"/>
    <script src="../assets/bootstrap-3.3.4/dist/js/bootstrap.min.js"></script>
    <title></title>
    <style>
        .row {
            margin-left: 20px;
            margin-right: 20px;;
        }

        .center {
            text-align: center;
        }
    </style>
</head>
<body>

<div class="navbar navbar-default navbar-static-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only"></span>
            </button>
            <a class="navbar-brand" href="/">图书馆借书系统</a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="/">首页</a></li>
                <li><a href="/client/userborrow.html">我的借书</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right hidden-sm">
                <li><a href="/client/login.html">登录</a></li>
                <li><a href="/client/signup.html">注册</a></li>
            </ul>
        </div>
    </div>
</div>
<div class="row thumbnail">
    <div class="col-sm-4">
        <img style="width: 100%; height: 40%; display: block;" src="/productImg/${BootData.book_uuid}.png"
             data-holder-rendered="true">
        <div class="caption center">
            <h3>书名:${BootData.book_name}</h3>
            <h5>作者:${BootData.book_author}</h5>
            <h5>剩余库存:${BootData.book_remsining}</h5>
            <p><a class="btn btn-primary btn-block" role="button"
                  href="/client/newborrow.html?uuid=${BootData.book_uuid}&id=${BootData.book_remsining}">立即借书</a>
            </p>
        </div>
    </div>
    <div class="col-sm-8">
        <div class="caption">
            <h3>图书介绍</h3>
            <p>${BootData.book_remarks}</p>
        </div>
    </div>
</div>

</body>
</html>