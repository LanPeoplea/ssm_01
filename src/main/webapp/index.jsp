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
    <script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
    <script type="text/javascript">
        $(function(){
            $("#userName").on("focus",function(){
                $("#errorMsg").fadeOut();
            });
            $("#password").on("focus",function(){
                $("#errorMsg").fadeOut();
            });
            $("#_img").on("click",function(){
                $(this).attr("src","login/verify?"+new Date());
            });
        });
    </script>
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
            <input name="username" id="userName" type="text" value="${username}" onfocus="this.value=''" placeholder="请输入用户名">

            <input name="password" id="password" type="password" id="password" placeholder="请输入密码"/>
            <input name="verifyCode" id="verifyCode" type="text" id="verifyCode" placeholder="请输入验证码"
                   style="width: 60%"
            />
            <img id="_img" src="login/verify" style="width: 110px; height:50px; margin-left: 10px;position: absolute" title="点击切换"/>
            <input value="登录" style="width:100%;" type="submit">
            <span id="errorMsg" style="color:red;font-size:16px">${errormsg}</span>
        </form>
    </div>
    <div class="copyright">-------河南工程学院-------</div>
</div>
</body>
</html>
