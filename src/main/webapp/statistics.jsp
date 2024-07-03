<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE>
<html lang="ru">
<head>
    <title>Statistics</title>
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
