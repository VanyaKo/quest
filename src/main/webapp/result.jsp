<jsp:useBean id="RESULT" scope="session" type="com.kornienko.quest.models.Result"/>
<%@ page import="com.kornienko.quest.models.Result" %>
<%@ page import="com.kornienko.quest.consts.Consts" %>
<%@ page import="java.util.Calendar" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Quest</title>
</head>
<body>
<h1>
    <c:if test="${RESULT.isFailed()}">
        <c:out value="Поражение"></c:out>
    </c:if>
    <c:if test="${RESULT.isSuccess()}">
        <c:out value="Победа"></c:out>
    </c:if>
</h1>
<p>${RESULT.getTitle()}</p>
<form action="${pageContext.request.contextPath}/question">
    <button>К началу</button>
</form>
<jsp:include page="statistics.jsp">
    <jsp:param name="CLIENT" value="${CLIENT}"/>
</jsp:include>
</body>
</html>
