<jsp:useBean id="question" scope="session" type="com.kornienko.quest.models.Question"/>
<jsp:useBean id="answer_1" scope="session" type="com.kornienko.quest.models.Answer"/>
<jsp:useBean id="answer_2" scope="session" type="com.kornienko.quest.models.Answer"/>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE>
<html lang="ru">
<head>
    <title>Quest</title>
</head>
<body>
<h2>${question.getTitle()}</h2>
<form action="${pageContext.request.contextPath}/question">
    <p>
        <input name="answerId" type="radio" value="${answer_1.getId()}">${answer_1.getTitle()}
        <br>
        <input name="answerId" type="radio" value="${answer_2.getId()}">${answer_2.getTitle()}
    </p>
    <p><input type="submit" value="Ответить"></p>
</form>
<jsp:include page="statistics.jsp">
    <jsp:param name="CLIENT" value="${CLIENT}"/>
</jsp:include>
</body>
</html>
