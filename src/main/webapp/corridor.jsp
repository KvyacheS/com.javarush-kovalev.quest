<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/styles.css" />
    <title>Коридор</title>
</head>
<body>
<p>Ты стоишь в коридоре своего дома, почесывая голову</p>

<p>сейчас ты</p>

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




<form action="walk-to" method="post">
    <button type="submit" name="targetScene" value="bathroom">Пойти в ванную</button>
    <button type="submit" name="targetScene" value="kitchen">Пойти на кухню</button>
    <button type="submit" name="targetScene" value="ending">пойти на работу</button>
</form>

<form action="sleep" method="post">
    <button type="submit">ты все еще можешь пойти спать...</button>
</form>

<form action="dress-up" method="post">
    <button type="submit">одеться</button>
</form>
</body>
</html>