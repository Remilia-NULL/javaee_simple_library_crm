<%--
  Created by IntelliJ IDEA.
  User: edward
  Date: 2019-06-07
  Time: 16:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
    <link rel='stylesheet' href="/assets/CSS/style.css"/>
    <link rel="stylesheet" href="/assets/CSS/bootstrap.min.css"/>
</head>

<body>

<div class="wrapper">
    <form class="form-signin" action="/Normal/signupcheck.html" method="post">
        <h2 class="form-signin-heading">注册新的账户</h2>
        <input type="text" class="form-control" name="username" placeholder="用户名" required=""/>
        <input type="password" class="form-control" name="passwd" placeholder="密码" required=""/>
        <input type="email" class="form-control" name="email" placeholder="电子邮箱" required=""/>
        <button class="btn btn-lg btn-primary btn-block" type="submit">注册</button>
    </form>

</div>
</body>
</html>
