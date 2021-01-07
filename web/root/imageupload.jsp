<%--
  Created by IntelliJ IDEA.
  User: edward
  Date: 2019-06-13
  Time: 18:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html class="no-js">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>图书封面上传</title>
    <meta name="description" content="这是一个form页面">
    <meta name="keywords" content="form">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <link rel="icon" type="image/png" href="/assets/i/favicon.png">
    <link rel="apple-touch-icon-precomposed" href="/assets/i/app-icon72x72@2x.png">
    <meta name="apple-mobile-web-app-title" content="Amaze UI"/>
    <link rel="stylesheet" href="/assets/CSS/amazeui.min.css"/>
    <link rel="stylesheet" href="/assets/CSS/admin.css">
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
            <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">图书封面</strong> /
                <small>IMAGE</small>
            </div>
        </div>
        <form action="/Admin/imageupload.html" method="post" enctype="multipart/form-data">
            <div class="am-g am-margin-top">
                <div class="am-u-sm-2 am-text-right">
                    图书UUID：
                </div>
                <div class="am-u-sm-4">
                    <input type="text" name="uuid" class="am-input-sm" value="${Data}"
                           readonly unselectable="on">
                </div>
                <div class="am-u-sm-6">随机的不可修改的</div>
            </div>
            <div class="am-g am-margin-top">
                <div class="am-u-sm-2 am-text-right">
                    图书封面：
                </div>
                <div class="am-u-sm-4">
                    <input type="file" name="image" class="am-input-sm" required>
                </div>
                <div class="am-u-sm-6">用于图书的封面显示</div>
            </div>

            <input type="submit" class="am-btn am-btn-primary am-btn-xs" value="上传"/>
        </form>

    </div>
    <!-- content end -->

</div>


<!--[if lt IE 9]>
<script src="/assets/JS/polyfill/rem.min.js"></script>
<script src="/assets/JS/polyfill/respond.min.js"></script>
<script src="/assets/JS/amazeui.legacy.js"></script>
<![endif]-->

<!--[if (gte IE 9)|!(IE)]><!-->
<script src="/assets/JS/jquery.min.js"></script>
<script src="/assets/JS/amazeui.min.js"></script>
<!--<![endif]-->
<script src="/assets/JS/app.js"></script>
</body>
</html>
