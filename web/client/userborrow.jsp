<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: edward
  Date: 2019-06-12
  Time: 16:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="../assets/bootstrap-3.3.4/dist/css/bootstrap.min.css"/>
    <script src="../assets/bootstrap-3.3.4/dist/js/bootstrap.min.js"></script>
    <title>我的借书</title>
    <style>
        .row {
            margin-left: 20px;
            margin-right: 20px;;
        }

        .line-center {
            line-height: 50px;
            text-align: center;
        }

        .row input {
            width: 50px;
        }

        .list-group-item:hover {
            background: #9485ae;

        }

        .list-group-item div:first-child:hover {

            cursor: pointer;
        }
    </style>
    <script>
        function myClick(n) {
            location.href = "OrderInfo.html";
        }

        function btnClick() {
            alert("btn");
            return false;
        }

        $(function () {

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
            <ul class="nav navbar-nav navbar-right hidden-sm">
                <li><a href="/client/login.html">登录</a></li>
                <li><a href="/client/signup.html">注册</a></li>
            </ul>
        </div>
    </div>
</div>
<div class="container">
    <div class="row thumbnail center">
        <div class="col-sm-12">
            <h1 class="text-center" style="margin-bottom: 30px">我的借书</h1>
        </div>
        <div class="col-sm-12 thumbnail">
            <div class="col-sm-2 line-center">借书编号</div>
            <div class="col-sm-2 line-center">当前状态</div>
            <div class="col-sm-2 line-center">书籍名称</div>
            <div class="col-lg-2 line-center">借书时间</div>
            <div class="col-sm-3 line-center">操作</div>
        </div>
        <c:forEach items="${Borrow_Data}" var="data">
        <div class="list-group">
            <div class="col-sm-12  list-group-item">
                <div class="col-sm-2 line-center">${data.borrow_id}</div>
                <div class="col-sm-2 line-center">
                    <c:choose>
                        <c:when test="${data.book_static==0}">
                            已还
                        </c:when>
                        <c:otherwise>
                            未还
                        </c:otherwise>
                    </c:choose>
                </div>
                <div class="col-sm-2 line-center">${data.bookData.book_name}</div>
                <div class="col-lg-2 line-center">${data.out_time}</div>
                <c:if test="${data.book_static==1}">
                    <div class="col-sm-3 line-center">
                        <a href="/client/setborrow.html?id=${data.borrow_id}" class="btn btn-danger">我以还书</a>
                    </div>
                </c:if>
            </div>
            </c:forEach>
        </div>
    </div>
</div>
</body>
</html>