<%--
  Created by IntelliJ IDEA.
  User: cegth
  Date: 28.06.2024
  Time: 14:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>${question}</p>
<form action="handler.php">
    <p><input name="dzen" type="radio" value="nedzen">${answer_1}</p>
    <p><input name="dzen" type="radio" value="dzen">${answer_2}</p>
    <p><input type="submit" value="Ответить"></p>
</form>
</body>
</html>
