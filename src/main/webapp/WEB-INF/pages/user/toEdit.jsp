<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>Edit</title>
</head>
<body>
<center>
    <form action="user/edit" method="post">
        <input type="hidden" name="id" value="${user.id}"/>
        <table style="margin-top: 50px;" border="1" cellspacing="0" cellpadding="3">
            <tr>
                <td>姓名：</td>
                <td><input type="text" name="name" value="${user.name}"/></td>
            </tr>
            <tr>
                <td>性别：</td>
                <td><input type="text" name="sex" value="${user.sex}" /></td>
            </tr>
            <tr>
                <td>地址</td>
                <td><input type="text" name="address" value="${user.address}" /></td>
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
