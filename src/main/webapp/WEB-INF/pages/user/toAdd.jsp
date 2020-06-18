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
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <!-- Bootstrap -->
    <link href="/css/bootstrap.min.css" rel="stylesheet">

    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="/js/jquery-3.4.1.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="/js/bootstrap.min.js"></script>
    <title>增加信息</title>
</head>
<body>
<center>
    <form action="/user/add" method="post">
        <table style="margin-top: 150px;" class="table table-bordered table-hover table-striped table-responsive">
            <tr class="col-lg-6 col-md-offset-5 ">
                <td class="form-control-static">姓名：</td>
                <td><input class="form-control" type="text" name="name"/></td>
            </tr>
            <tr class="col-lg-6 col-md-offset-5 ">
                <td>性别：</td>
                <td><input class="form-control" type="text" name="sex"/></td>
            </tr>
            <tr class="col-lg-6 col-md-offset-5 ">
                <td>地址：</td>
                <td><input class="form-control" type="text" name="address" /></td>
            </tr>
            <tr>
                <td colspan=2 style="text-align: center;">
                    <input type="submit" value="确定" />
                    &nbsp; &nbsp;&nbsp;
                    <input type="reset" value="重置" />
                </td>
            </tr>
        </table>
    </form>
</center>
</body>
</html>
