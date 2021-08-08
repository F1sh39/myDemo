<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>新增用户</title>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/html5shiv@3.7.3/dist/html5shiv.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/respond.js@1.4.2/dest/respond.min.js"></script>
</head>
<body>
    <h2 class="text-center">新增用户页面</h2>
    <div class="row">
        <div class="col-md-8 col-md-offset-2">
            <form action="${pageContext.request.contextPath}/adduser" method="post">
                <div class="form-group">
                    <label for="InputName">
                        姓名<c:if test="${not empty namenull}"><span style="color: red">不能为空</span></c:if>
                    </label>
                    <input type="text" name="name"
                           class="form-control" id="InputName" placeholder="Enter your name">
                </div>
                <div class="form-group">
                    <label>性别</label>
                    <label class="radio-inline">
                        <input type="radio" name="gender" value="男" checked> 男
                    </label>
                    <label class="checkbox-inline">
                        <input type="radio" name="gender" value="女"> 女
                    </label>
                </div>
                <div class="form-group">
                    <label for="InputAge">年龄</label>
                    <input type="text" name="age"
                           class="form-control" id="InputAge" placeholder="Enter your age">
                </div>
                <div class="form-group">
                    <label>籍贯</label>
                    <select class="form-control" name="hometown">
                        <option>—— please choose ——</option>
                        <option value="北京">北京</option>
                        <option value="上海">上海</option>
                        <option value="广州">广州</option>
                        <option value="深圳">深圳</option>
                        <option value="香港">香港</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="InputQQ">QQ</label>
                    <input type="text" name="qq"
                           class="form-control" id="InputQQ" placeholder="Enter your QQ">
                </div>
                <div class="form-group">
                    <label for="InputEmail">
                        邮箱<c:if test="${not empty emailnull}"><span style="color: red">不能为空</span></c:if>
                    </label>
                    <input type="email" name="email"
                           class="form-control" id="InputEmail" placeholder="Enter your email">
                </div>
                <div>
                    <button class="btn btn-primary" type="submit">提交</button>
                    <button class="btn btn-default" type="button">重置</button>
                    <button class="btn btn-default" type="button">返回</button>
                </div>
            </form>
        </div>
    </div>

<script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js" integrity="sha384-nvAa0+6Qg9clwYCGGPpDQLVpLNn0fRaROjHqs13t4Ggj3Ez50XnGQqc/r8MhnRDZ" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js" integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous"></script>
</body>
</html>
