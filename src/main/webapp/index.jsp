<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv="Cache-Control" content="no-cache">
    <meta http-equiv="Expires" content="0">
    <title>后台管理</title>
    <link href="css/login.css" rel="stylesheet" type="text/css" />
</head>

<body>
<div class="login_box">
    <div class="login_l_img"><img src="images/login-img.png" /></div>
    <div class="login">
        <div class="login_logo"><a href="#"><img src="images/login_logo.png" /></a></div>
        <div class="login_name">
            <p>后台管理系统</p>
        </div>
        <form method="post" action="login/doLogin">
            <input name="username" type="text" value="${username}" onfocus="this.value=''" placeholder="请输入用户名">

            <input name="password" type="password" id="password" placeholder="请输入密码"/>
            <input value="登录" style="width:100%;" type="submit">
            <span style="color:red;font-size:16px">${errormsg}</span>
        </form>
    </div>
    <div class="copyright">-------河南工程学院-------</div>
</div>
</body>
</html>
