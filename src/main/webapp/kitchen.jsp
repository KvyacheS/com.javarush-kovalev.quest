<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
    <title>Кухня</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css" />
</head>
<body>
<p>Ты на кухне, выхаешь ароматы кушаний</p>

<p>сейчас ты</p>

<c:choose>
    <c:when test="${fn:contains(sessionScope.isCleanBody, 'false')}">
        <p class="bad-text">Грязный</p>
    </c:when>
    <c:when test="${fn:contains(sessionScope.isCleanBody, 'true')}">
        <p class="good-text">Чистый</p>
    </c:when>
</c:choose>

<c:choose>
    <c:when test="${fn:contains(sessionScope.isCleanTeeth, 'false')}">
        <p class="bad-text">У тебя пахнет изо рта</p>
    </c:when>
    <c:when test="${fn:contains(sessionScope.isCleanTeeth, 'true')}">
        <p class="good-text">У тебя свежее дыхание</p>
    </c:when>
</c:choose>

<c:choose>
    <c:when test="${fn:contains(sessionScope.isEated, 'false')}">
        <p class="bad-text">Голоден</p>
    </c:when>
    <c:when test="${fn:contains(sessionScope.isEated, 'true')}">
        <p class="good-text">Сыт</p>
    </c:when>
</c:choose>

<c:choose>
    <c:when test="${fn:contains(sessionScope.isDressed, 'false')}">
        <p class="bad-text">Голый</p>
    </c:when>
    <c:when test="${fn:contains(sessionScope.isDressed, 'true')}">
        <p class="good-text">Одет</p>
    </c:when>
</c:choose>

<form action="walk-to" method="post">
    <button type="submit" name="targetScene" value="corridor">вернуться в коридор</button>
</form>
<form action="eat" method="post">
    <button type="submit">поесть</button>
</form>
</body>
</html>