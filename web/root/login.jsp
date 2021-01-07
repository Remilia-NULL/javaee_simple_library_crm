<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员登入</title>
    <link rel='stylesheet' href="/assets/CSS/style.css"/>
    <link rel="stylesheet" href="/assets/CSS/bootstrap.min.css"/>
</head>

<body>
<div class="wrapper">
    <form class="form-signin" action="/Admin/logincheck.html" method="post">
        <h2 class="form-signin-heading">请登入</h2>
        <input type="text" class="form-control" name="username" placeholder="用户名" required="" autofocus=""/>
        <input type="password" class="form-control" name="passwd" placeholder="密码" required=""/>
        <div style="color: red;">${msg}</div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">登入</button>
    </form>
</div>


</body>

</html>
