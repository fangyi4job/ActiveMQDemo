<%--
  Created by 蓝鸥科技有限公司  www.lanou3g.com.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>欢迎页</title>

    <script src="../../js/jquery-3.2.1.js" type="text/javascript"></script>

    <style type="text/css">
        #producer {
            width: 48%;
            border: 1px solid blue;
            height: 80%;
            align: center;
            margin: 0 auto;
        }

        body {
            text-align: center;
        }

        div {
            text-align: center;
        }

        textarea {
            width: 80%;
            height: 100px;
            border: 1px solid gray;
        }

        button {
            background-color: rgb(62, 156, 66);
            border: none;
            font-weight: bold;
            color: white;
            height: 30px;
        }
    </style>
</head>
<body>
<h1>Hello ActiveMQ</h1>
<div id="producer">
    <h2>Producer</h2>
    <textarea id="message"></textarea>
    <br>
    <button onclick="send('queueSender')">发送Queue消息</button>
    <button onclick="send('topicSender')">发送Topic消息</button>
    <br>
    <span id="status"></span>
</div>


<script type="text/javascript">


</script>
</body>
</html>
