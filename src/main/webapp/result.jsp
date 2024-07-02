<%@ page import="com.kornienko.quest.models.Result" %><%--
  Created by IntelliJ IDEA.
  User: cegth
  Date: 28.06.2024
  Time: 14:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Result</title>
</head>
<body>
<h1>
    <%
        if(((Result) request.getAttribute("result")).isFailed()) {
            out.print("Поражение");
        } else {
            out.print("Победа");
        }
    %>
</h1>
<p>${result.getTitle()}</p>
<form action="${pageContext.request.contextPath}/question">
    <button>К началу</button>
</form>
<jsp:include page="statistics.jsp">
    <jsp:param name="CLIENT" value="${CLIENT}" />
</jsp:include>
</body>
</html>
