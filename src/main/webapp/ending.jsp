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
<p>и при этом ты</p>
<c:choose>
    <c:when test="${fn:contains(sessionScope.isCleanBody, 'false')}">
        <p class="bad-text">Грязный</p>
    </c:when>
    <c:otherwise>
        <p class="good-text">Чистый</p>
    </c:otherwise>
</c:choose>

<c:choose>
    <c:when test="${fn:contains(sessionScope.isCleanTeeth, 'false')}">
        <p class="bad-text">У тебя пахнет изо рта</p>
    </c:when>
    <c:otherwise>
        <p class="good-text">У тебя свежее дыхание</p>
    </c:otherwise>
</c:choose>

<c:choose>
    <c:when test="${fn:contains(sessionScope.isEated, 'false')}">
        <p class="bad-text">Голоден</p>
    </c:when>
    <c:otherwise>
        <p class="good-text">Сыт</p>
    </c:otherwise>
</c:choose>

<c:choose>
    <c:when test="${fn:contains(sessionScope.isDressed, 'false')}">
        <p class="bad-text">Голый</p>
    </c:when>
    <c:otherwise>
        <p class="good-text">Одет</p>
    </c:otherwise>
</c:choose>

<form action="restart" method="get">
    <button type="submit">Начать заново</button>
</form>
</body>
</html>
