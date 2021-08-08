<%@ page import="java.util.List" %>
<%@ page import="com.fish.Web02.domain.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>用户列表</title>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/html5shiv@3.7.3/dist/html5shiv.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/respond.js@1.4.2/dest/respond.min.js"></script>
</head>
<body>
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <h2 class="text-center">管理员登陆</h2>
            <form action="${pageContext.request.contextPath}/login" method="post">
                <div class="form-group">
                    <label for="exampleInputEmail1">用户名</label>
                    <input type="text" name="username"
                           class="form-control" id="exampleInputEmail1" placeholder="Enter your username">
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1">密码</label>
                    <input type="password" name="password"
                           class="form-control" id="exampleInputPassword1" placeholder="Enter password">
                </div>
                <div class="form-inline">
                    <label for="exampleInputCheckcode">验证码</label>
                    <input type="text" name="checkcode"
                           class="form-control" id="exampleInputCheckcode" placeholder="Enter checkcode">
                    <img src="${pageContext.request.contextPath}/CheckcodeServlet" title="看不清,换一张" id="checkcodeimg">
                </div>
                <button type="submit" class="btn btn-info" style="margin: 20px 250px">登陆</button>
            </form>
            <c:if test="${not empty loginMsg}">
                <div class="alert alert-danger alert-dismissible" role="alert">
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <strong>登陆失败!</strong>${loginMsg}
                </div>
            </c:if>
        </div>
    </div>

    <script>
        window.onload = function(){
            var yzmImg = document.getElementById("checkcodeimg");
            yzmImg.onclick = function (){
                yzmImg.src =
                    "${pageContext.request.contextPath}/CheckcodeServlet?"+new Date().getTime();
            }
        }
    </script>
<script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js" integrity="sha384-nvAa0+6Qg9clwYCGGPpDQLVpLNn0fRaROjHqs13t4Ggj3Ez50XnGQqc/r8MhnRDZ" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js" integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous"></script>
</body>
</html>
