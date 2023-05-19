<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>Document</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>"/>
</head>
<body>
<%@ include file="header.jsp" %>
<div class="slogan container container--90">
    <h2>Użytkownicy:</h2>
    <table>
        <thead>
        <tr>
            <th>Id</th>
            <th>Email</th>
            <th>Akcja</th>

        </tr>
        </thead>
        <tbody>
        <c:forEach var="user" items="${users}">
            <tr>
                <td><c:out value="${user.id}"/></td>
                <td><c:out value="${user.email}"/></td>
                <td>
                    <a href="/list-users/update?id=${user.id}" class="btn">Aktualizuj</a>
                </td>
                <td>
                    <a href="/list-users/delete-confirm?id=${user.id}" class="btn">Usuń</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<%@ include file="footer.jsp" %>
<script src="<c:url value="/resources/js/app.js"/>"></script>
</body>
</html>
