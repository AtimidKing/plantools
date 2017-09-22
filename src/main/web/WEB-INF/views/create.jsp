<%--
  Created by IntelliJ IDEA.
  User: king
  Date: 2017/7/26
  Time: 22:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>创建计划</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="../../css/create.css">
</head>
<body>
<div class="container">
    <div class="nav">
        <ul>
            <li><a href="#">首页</a></li>
            <li><a href="">创建计划</a></li>
        </ul>
    </div>
    <div class="add-plan">
        <h1>创建计划</h1>
        <form class="form-inline" action="/create" method="post" enctype="multipart/form-data">
            <div class="form-group">
                <label for="exampleInputName2">标题:</label>
                <div class="control">
                    <input type="text" class="form-control" id="exampleInputName2" placeholder="未命名" name="title">
                </div>
            </div>
            <div class="form-group">
                <label for="inputTextarea">计划描述</label>
                <div class="control-textarea">
                    <textarea id="inputTextarea" name="detail"></textarea>
                </div>
            </div>

            <div class="form-group">
                <label for="inputFile">附加资源</label>
                <div class="control">
                    <input id="inputFile" name="planFile" type="file">
                </div>
            </div>
            <div class="form-group">
                <button type="submit">保存</button>
                <a href="/index">
                    <button type="button">取消</button>
                </a>
            </div>
        </form>
    </div>
</div>
</body>
</html>
