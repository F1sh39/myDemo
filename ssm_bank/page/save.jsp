<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>添加账户</h1>
    <form action="${pageContext.request.contextPath}/account/Save" method="post">
        账户：<input type="text" name="name" /><br/>
        存款：<input type="text" name="money" /><br/>
        <input type="submit" value="提交">
    </form>
</body>
</html>
