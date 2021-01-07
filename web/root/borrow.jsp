<%--
  Created by IntelliJ IDEA.
  User: edward
  Date: 2019-06-09
  Time: 15:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html class="no-js">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>借还书管理</title>
    <meta name="description" content="这是一个 table 页面">
    <meta name="keywords" content="table">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <link rel="icon" type="image/png" href="../assets/i/favicon.png">
    <link rel="apple-touch-icon-precomposed" href="../assets/i/app-icon72x72@2x.png">
    <meta name="apple-mobile-web-app-title" content="Amaze UI"/>
    <link rel="stylesheet" href="../assets/CSS/amazeui.min.css"/>
    <link rel="stylesheet" href="../assets/CSS/admin.css">
</head>
<body>
<!--[if lte IE 9]>
<p class="browsehappy">你正在使用<strong>过时</strong>的浏览器，Amaze UI 暂不支持。 请 <a href="http://browsehappy.com/" target="_blank">升级浏览器</a>
    以获得更好的体验！</p>
<![endif]-->

<header class="am-topbar admin-header">

    <button class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-success am-show-sm-only"
            data-am-collapse="{target: '#topbar-collapse'}"><span class="am-sr-only">导航切换</span> <span
            class="am-icon-bars"></span></button>

    <div class="am-collapse am-topbar-collapse" id="topbar-collapse">

        <ul class="am-nav am-nav-pills am-topbar-nav am-topbar-right admin-header-list">
            <li class="am-dropdown" data-am-dropdown>
                <a class="am-dropdown-toggle" data-am-dropdown-toggle href="javascript:;">
                    <span class="am-icon-users"></span> 管理员 <span class="am-icon-caret-down"></span>
                </a>
                <ul class="am-dropdown-content">
                    <li><a href="#"><span class="am-icon-user"></span>${ADMIN_USER.admin_name}</a></li>
                    <li><a href="/logout.html"><span class="am-icon-power-off"></span> 退出</a></li>
                </ul>
            </li>
            <li><a href="javascript:;" id="admin-fullscreen"><span class="am-icon-arrows-alt"></span> <span
                    class="admin-fullText">开启全屏</span></a></li>
        </ul>
    </div>
</header>

<div class="am-cf admin-main">
    <!-- sidebar start -->
    <div class="admin-sidebar">
        <ul class="am-list admin-sidebar-list">
            <li><a href="/"><span class="am-icon-home"></span> 首页</a></li>
            <li class="admin-parent">
                <a class="am-cf" data-am-collapse="{target: '#collapse-nav'}"><span class="am-icon-file"></span> 图书管理
                    <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
                <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav">
                    <li><a href="/Admin/editbook.html" class="am-cf"><span class="am-icon-check"></span>
                        管理图书</a></li>
                    <li><a href="/Admin/borrow.html"><span class="am-icon-puzzle-piece"></span> 借还书管理</a>
                    </li>
                </ul>
            </li>
            <li><a href="/Admin/AdminPage.html"><span class="am-icon-table"></span>用户</a></li>
            <li><a href="/logout.html"><span class="am-icon-sign-out"></span> 注销</a></li>
        </ul>
    </div>
    <!-- sidebar end -->

    <!-- content start -->
    <div class="admin-content">

        <div class="am-cf am-padding">
            <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">借还书信息</strong> /
                <small>DATA</small>
            </div>
        </div>


        <div class="am-g">
            <div class="am-u-sm-12">
                <form class="am-form">
                    <table class="am-table am-table-striped am-table-hover table-main">
                        <thead>
                        <tr>
                            <th class="table-id">借还书ID</th>
                            <th class="table-title">书籍UUID</th>
                            <th class="table-title">书籍名称</th>
                            <th class="table-title">借书时间</th>
                            <th class="table-title">还书时间</th>
                            <th class="table-title">借书人UUID</th>
                            <th class="table-title">借书人用户名</th>
                            <th class="table-type">借还状态</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${BorrowList}" var="borrow">
                            <tr>
                                <td>${borrow.borrow_id}</td>
                                <td>${borrow.book_uuid}</td>
                                <td>${borrow.bookData.book_name}</td>
                                <td>${borrow.out_time}</td>
                                <td>${borrow.in_time}</td>
                                <td>${borrow.user_uuid}</td>
                                <td>${borrow.normalUser.nor_name}</td>
                                <td><c:choose>
                                    <c:when test="${borrow.book_static==0}">
                                        已还
                                    </c:when>
                                    <c:otherwise>
                                        未还
                                    </c:otherwise>
                                </c:choose></td>
                                <c:if test="${borrow.book_static==1}">
                                    <td>
                                        <div class="am-btn-toolbar">
                                            <div class="am-btn-group am-btn-group-xs">
                                                <a href="/Admin/borrowedit.html?id=${borrow.borrow_id}"
                                                   class="am-btn am-btn-default am-btn-xs am-text-secondary"><span
                                                        class="am-icon-pencil-square-o"></span> 设置已还书
                                                </a>
                                            </div>
                                        </div>
                                    </td>
                                </c:if>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <div class="am-cf">
                        共 ${size} 条记录
                    </div>
                    <hr/>
                </form>
            </div>

        </div>
    </div>
    <!-- content end -->
</div>

<!--[if lt IE 9]>
<script src="../assets/JS/polyfill/rem.min.js"></script>
<script src="../assets/js/polyfill/respond.min.js"></script>
<script src="../assets/js/amazeui.legacy.js"></script>
<![endif]-->

<!--[if (gte IE 9)|!(IE)]><!-->
<script src="../assets/JS/jquery.min.js"></script>
<script src="../assets/JS/amazeui.min.js"></script>
<!--<![endif]-->
<script src="../assets/JS/app.js"></script>
</body>
</html>
