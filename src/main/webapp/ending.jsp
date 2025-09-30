<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/styles.css" />
    <title>Результат</title>
</head>
<body>
<h2>Результат квеста</h2>

<c:choose>
    <c:when test="${fn:contains(sessionScope.suddenLoseReason, '...')}">
        <p>${sessionScope.suddenLoseReason}</p>
    </c:when>
    <c:otherwise>
        <p>ты  пришел на работу</p>
    </c:otherwise>
</c:choose>

<c:if test="${!fn:contains(sessionScope.suddenLoseReason, '...')
             && sessionScope.isCleanBody == 'true'
            && sessionScope.isCleanTeeth =='true'
            && sessionScope.isEated =='true'
            && sessionScope.isDressed =='true'}">
    <p>Ты бодр  и сияешь энергией, тебе сегодня явно повезет</p>
</c:if>
<c:if test="${fn:contains(sessionScope.suddenLoseReason, '')
            && (sessionScope.isCleanBody == 'false'
            || sessionScope.isCleanTeeth =='false'
            || sessionScope.isEated =='false'
            || sessionScope.isDressed =='false')}">
    <p>Выглядишь разбитым, возможно лучше взять  отгул</p>
</c:if>

<form action="restart" method="get">
    <button type="submit">Начать заново</button>
</form>
</body>
</html>
