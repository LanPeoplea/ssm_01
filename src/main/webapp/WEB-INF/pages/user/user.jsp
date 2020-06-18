<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <!-- Bootstrap -->
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="/js/jquery-3.4.1.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="/js/bootstrap.min.js"></script>
    <base href="<%=basePath%>">
    <title>users信息表</title>
<%--    <script type="text/javascript" src="/js/jquery-3.4.1.min.js"></script>--%>
    <script type="text/javascript">
        function _delete(id){
            $.ajax({
                url:"user/delete",
                type:"post",
                data:{"id":id},
                success : function(data){
                    if(data.status==200){
                        alert(data.msg);
                        // $(obj).parent().parent().remove();
                    }else{
                        alert(data.msg);
                    }
                }
            });
        }
    </script>
</head>
<body>
    <table style="margin-top: 100px;" class="table table-bordered table-hover table-striped table-responsive">
        <thead>
        <tr>
            <th>id</th>
            <th>name</th>
            <th>sex</th>
            <th class="col-md-2">address</th>
            <th class="col-md-2">操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${users}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.sex}</td>
                <td>${user.address}</td>
                <td><a href="user/toAdd">添加</a>
                    &nbsp;&nbsp;
                    <a href="user/toEdit?id=${user.id}">编辑</a>
                    &nbsp;&nbsp;
                    <a href="javascript:void(0);" onclick="_delete('${user.id}');">删除</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</body>
</html>
