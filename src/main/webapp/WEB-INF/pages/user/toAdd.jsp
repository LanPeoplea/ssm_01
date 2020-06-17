<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>增加信息</title>
</head>
<body>
<center>
    <form action="/user/add" method="post">
        <table style="margin-top: 50px;" border="1" cellspacing="0" cellpadding="3">
            <tr>
                <td>姓名：</td>
                <td><input type="text" name="name"/></td>
            </tr>
            <tr>
                <td>性别：</td>
                <td><input type="text" name="sex"/></td>
            </tr>
            <tr>
                <td>地址</td>
                <td><input type="text" name="address" /></td>
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
