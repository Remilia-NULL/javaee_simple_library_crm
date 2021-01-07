<%--
  Created by IntelliJ IDEA.
  User: edward
  Date: 2019-06-07
  Time: 18:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html class="no-js">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>用户管理</title>
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
            <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">用户信息</strong> /
                <small>USER</small>
            </div>
        </div>

        <div class="am-g">
            <div class="am-u-md-6 am-cf">
                <div class="am-fl am-cf">
                    <div class="am-btn-toolbar am-fl">
                        <div class="am-btn-group am-btn-group-xs">
                            <a href="/Admin/adduser.html" type="button" class="am-btn am-btn-default"><span
                                    class="am-icon-plus"></span> 新增
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="am-g">
            <div class="am-u-sm-12">
                <form class="am-form">
                    <table class="am-table am-table-striped am-table-hover table-main">
                        <thead>
                        <tr>
                            <th class="table-id">UUID</th>
                            <th class="table-title">用户名</th>
                            <th class="table-title">Email</th>
                            <th class="table-type">用户状态</th>
                            <th class="table-author">操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${sysList}" var="user">
                            <tr>
                                <td>${user.nor_uuid}</td>
                                <td>${user.nor_name}</td>
                                <td>${user.nor_email}</td>
                                <td><c:choose>
                                    <c:when test="${user.nor_static==1}">
                                        可用
                                    </c:when>
                                    <c:otherwise>
                                        不可用
                                    </c:otherwise>
                                </c:choose></td>
                                <td>
                                    <div class="am-btn-toolbar">
                                        <div class="am-btn-group am-btn-group-xs">
                                            <a href="/Admin/edituserout.html?uuid=${user.nor_uuid}"
                                               class="am-btn am-btn-default am-btn-xs am-text-secondary"><span
                                                    class="am-icon-pencil-square-o"></span> 编辑
                                            </a>

                                            <a href="/Admin/DeleteUser.html?uuid=${user.nor_uuid}"
                                               class="am-btn am-btn-default am-btn-xs am-text-danger"><span
                                                    class="am-icon-trash-o"></span> 删除
                                            </a>
                                        </div>
                                    </div>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <div class="am-cf">
                        共 ${sysUserSize} 条记录
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
