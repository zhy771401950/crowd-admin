<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <%@ include file="/common/taglib.jsp" %>
    <%@ include file="/common/header.jsp" %>
    <title>500</title>
</head>
<body class="gray-bg">
<div class="middle-box text-center animated fadeInDown">
    <h1>500</h1>
    <h3 class="font-bold">服务器内部错误</h3>
    <div class="error-desc">
        抱歉，请联系管理员哦~
        <br/>您可以返回主页看看 <br/>
        <a href="${_ctx }" class="btn btn-primary m-t">主页</a>
    </div>
</div>

</body>
</html>
