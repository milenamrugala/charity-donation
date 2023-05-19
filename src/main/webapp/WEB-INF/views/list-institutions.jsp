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
    <h2>Instytucje:</h2>
    <table>
        <thead>
        <tr>
            <th>Id</th>
            <th>Nazwa</th>
            <th>Opis</th>
            <th>Akcja</th>

        </tr>
        </thead>
        <tbody>
        <c:forEach var="institution" items="${institutions}">
            <tr>
                <td><c:out value="${institution.id}"/></td>
                <td><c:out value="${institution.name}"/></td>
                <td><c:out value="${institution.description}"/></td>
                <td>
                    <a href="/list-institutions/update?id=${institution.id}" class="btn">Aktualizuj</a>
                </td>
                <td>
                    <a href="/list-institutions/delete-confirm?id=${institution.id}" class="btn">Usuń</a>
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
