<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: edward
  Date: 2019-06-11
  Time: 22:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head lang="en">
    <link rel="stylesheet" href="../assets/bootstrap-3.3.4/dist/css/bootstrap.min.css"/>
    <script src="../assets/bootstrap-3.3.4/dist/js/jquery-1.11.3.min.js"></script>
    <script src="../assets/bootstrap-3.3.4/dist/js/bootstrap.min.js"></script>
    <title></title>
    <style>
        .row {
            margin-top: 20px;;
        }

        .center {
            text-align: center;
        }

        .pagination {
            background: #cccccc;
        }
    </style>
    <script>
        $(function () {
            $('#myTabs a').click(function (e) {
                $(this).tab('show')
            });
        })
    </script>
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
            <c:choose>
                <c:when test="${USER_DATA==null}">
                    <ul class="nav navbar-nav navbar-right hidden-sm">
                        <li><a href="/client/login.html">登录</a></li>
                        <li><a href="/client/signup.html">注册</a></li>
                    </ul>
                </c:when>
                <c:otherwise>
                    <ul class="nav navbar-nav navbar-right hidden-sm">
                        <li><a href="/logout.html">登出</a></li>
                    </ul>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</div>
<div class="container">
    <div class="jumbotron">
        <h1>图书馆图书</h1>
    </div>


    <div class="row">
        <c:forEach items="${BookData}" var="data">
            <div class="col-sm-4 col-md-3">
                <div class="thumbnail">
                    <img style="width: 100%; height: 40%; display: block;"
                         src="/productImg/${data.book_uuid}.png"
                         data-src="holder.js/100%x40%" data-holder-rendered="true">
                    <div class="caption center">
                        <h3>${data.book_name}</h3>
                        <p><span>剩余本数:</span><span>${data.book_remsining}</span></p>
                        <p><a class="btn btn-primary btn-block" role="button"
                              href="/client/bookinfo.html?uuid=${data.book_uuid}">查看详情</a></p>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>

</div>
</body>
</html>