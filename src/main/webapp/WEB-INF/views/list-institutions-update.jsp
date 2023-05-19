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
<section class="login-page">
    <h2>Aktualizacja instytucji:</h2>
    <form action="" method="POST">
        <div class="form-group">
            <input type="name" name="name" placeholder="Nazwa instytucji" required/>
        </div>
        <div class="form-group">
            <input type="description" name="description" placeholder="Opis" required/>
        </div>

        <div class="form-group form-group--buttons">
            <button class="btn" type="submit">Aktualizuj</button>
            <a href="<c:url value='/list-institutions'/>" class="btn">Cofnij</a>
        </div>
    </form>
</section>
<%@ include file="footer.jsp" %>
<script src="<c:url value="resources/js/app.js"/>"></script>
</body>
</html>