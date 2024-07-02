<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Statistics</title>
    <link rel="stylesheet" type="text/css" href="styles/style.css">
</head>
<body>
<div id="left-bottom">
    <p>
        Статистика:<br>
        IP address: ${CLIENT.getId()}<br>
        Имя в игре: ${CLIENT.getUsername()}<br>
        Количество игр: ${CLIENT.getGameCount()}
    </p>
</div>
</body>
</html>
