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
        <div class="col-md-10 col-md-offset-1">
            <h2 class="text-center">用户列表界面</h2>
            <!--新增用户表单模块-->
            <div>
                <div style="float: left;margin: 20px;">
                    <form class="form-inline" action="${pageContext.request.contextPath}/userlist" method="post">
                        <div class="form-group">
                            <label for="exampleInputName2">用户名</label>
                            <input type="text" name="name" value="${nameForm}"
                                   class="form-control" id="exampleInputName2" placeholder="Enter name">
                        </div>
                        <div class="form-group">
                            <label for="exampleInputName3">籍贯</label>
                            <input type="text" name="hometown" value="${hometownForm}"
                                   class="form-control" id="exampleInputName3" placeholder="Enter hometown">
                        </div>
                        <div class="form-group">
                            <label for="exampleInputEmail2">邮箱</label>
                            <input type="email" name="email" value="${emailForm}"
                                   class="form-control" id="exampleInputEmail2" placeholder="Enter email">
                        </div>
                        <button type="submit" class="btn btn-default">查询</button>
                    </form>
                </div>
                <div style="float: right">
                    <a href="${pageContext.request.contextPath}/adduser.jsp">
                        <button type="button" class="btn btn-primary">新增用户</button>
                    </a>
                    <a>
                        <button type="button" class="btn btn-primary" id="selectdel">选中删除</button>
                    </a>
                </div>
            </div>
            <!--用户表格模块-->
            <div>

                <table class="table table-bordered table-hover text-center">
                    <tr class="success">
                        <th><input type="checkbox" id="firSelBtn"></th>
                        <th class="text-center">编号</th>
                        <th class="text-center">姓名</th>
                        <th class="text-center">性别</th>
                        <th class="text-center">年龄</th>
                        <th class="text-center">籍贯</th>
                        <th class="text-center">QQ</th>
                        <th class="text-center">邮箱</th>
                        <th class="text-center">操作</th>
                    </tr>
                    <form action="${pageContext.request.contextPath}/selectdel" method="post" id="selform">
                        <c:if test="${not empty upage}">
                            <c:forEach items="${upage.datalist}" var="user" varStatus="s">
                                <tr>
                                    <td><input type="checkbox" name="selid" value="${user.id}"></td>
                                    <td>${user.id}</td>
                                    <td>${user.name}</td>
                                    <td>${user.gender}</td>
                                    <td>${user.age}</td>
                                    <td>${user.hometown}</td>
                                    <td>${user.qq}</td>
                                    <td>${user.email}</td>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/finduserbyid?userid=${user.id}">
                                            <button type="button">修改</button>
                                        </a>
                                        <a href="javascript:isDel(${user.id});">
                                            <button type="button">删除</button>
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                    </c:if>
                    </form>
                </table>
            </div>
            <!--分页模块-->
            <div>
                <nav aria-label="Page navigation" style="float: left;">
                    <ul class="pagination">
                        <c:if test="${upage.nowpage!=1}">
                            <li>
                                <a href="${pageContext.request.contextPath}/userlist?topage=${upage.nowpage-1}" aria-label="Previous">
                                    <span aria-hidden="true">&laquo;</span>
                                </a>
                            </li>
                        </c:if>
                        <c:forEach begin="1" end="${upage.totalpage}" var="i">
                            <c:if test="${i==upage.nowpage}">
                                <li class="active"><a href="${pageContext.request.contextPath}/userlist?topage=${i}">${i}</a></li>
                            </c:if>
                            <c:if test="${i!=upage.nowpage}">
                                <li><a href="${pageContext.request.contextPath}/userlist?topage=${i}">${i}</a></li>
                            </c:if>
                        </c:forEach>
                        <c:if test="${upage.nowpage!=upage.totalpage}">
                            <li>
                                <a href="${pageContext.request.contextPath}/userlist?topage=${upage.nowpage+1}" aria-label="Next">
                                    <span aria-hidden="true">&raquo;</span>
                                </a>
                            </li>
                        </c:if>
                        <span style="font-size: 25px;margin-left: 5px">${upage.nowpage}/${upage.totalpage}，共${upage.totalrows}条记录</span>
                    </ul>
                </nav>
            </div>
        </div>
    </div>

    <script>
        function isDel(id) {
            if( confirm("确认删除'用户"+id+"'吗？") ){
                location.href = "${pageContext.request.contextPath}/deluser?userid="+id;
            }
        }
        window.onload = function (){
            //选择删除绑定提交表单
            document.getElementById("selectdel").onclick = function (){
                if( confirm("确认删除 选中的用户 吗？") ){
                    document.getElementById("selform").submit();
                }
            }
            document.getElementById("firSelBtn").onclick = function (){
                var selBths = document.getElementsByName("selid");
                for (let i = 0; i < selBths.length; i++) {
                    selBths[i].checked = this.checked;
                }
            }
        }
    </script>
<script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js" integrity="sha384-nvAa0+6Qg9clwYCGGPpDQLVpLNn0fRaROjHqs13t4Ggj3Ez50XnGQqc/r8MhnRDZ" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js" integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous"></script>
</body>
</html>
