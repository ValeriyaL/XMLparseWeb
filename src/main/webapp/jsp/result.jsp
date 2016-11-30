<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" language="java" pageEncoding="UTF-8"%>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="properties.text"/>
<html><head><title><fmt:message key="title"/></title></head>
<body>
<fmt:message key="label.parser"/>: ${parser}
<table border="1">
    <caption><b><fmt:message key="table.candy.caption"/></b></caption>
    <thead>
    <tr>
        <th rowspan="2"><fmt:message key="table.candy.name"/></th>
        <th rowspan="2"><fmt:message key="table.candy.id"/></th>
        <th rowspan="2"><fmt:message key="table.candy.type"/></th>
        <th rowspan="2"><fmt:message key="table.candy.production"/></th>
        <th rowspan="2"><fmt:message key="table.candy.energy"/></th>
        <th colspan="4"><fmt:message key="table.candy.ingredients"/></th>
        <th colspan="3"><fmt:message key="table.candy.value"/></th>
    </tr>
    <tr>
        <th><fmt:message key="table.candy.water"/></th>
        <th><fmt:message key="table.candy.sugar"/></th>
        <th><fmt:message key="table.candy.fructose"/></th>
        <th><fmt:message key="table.candy.vanilin"/></th>
        <th><fmt:message key="table.candy.proteins"/></th>
        <th><fmt:message key="table.candy.fats"/></th>
        <th><fmt:message key="table.candy.carbonhydrates"/></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="row" items="${candies}" >
        <tr>
            <td><c:out value="${row.name}"/></td>
            <td><c:out value="${row.candyId}"/></td>
            <td><c:out value="${row.type}"/></td>
            <td><c:out value="${row.production}"/></td>
            <td><c:out value="${row.energy}"/></td>
            <td><c:out value="${row.ingredients.water}"/></td>
            <td><c:out value="${row.ingredients.sugar}"/></td>
            <td><c:out value="${row.ingredients.fructose}"/></td>
            <td><c:out value="${row.ingredients.vanilin}"/></td>
            <td><c:out value="${row.value.proteins}"/></td>
            <td><c:out value="${row.value.fats}"/></td>
            <td><c:out value="${row.value.carbonhydrates}"/></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<table border="1">
    <caption><b><fmt:message key="table.chocolate.caption"/></b></caption>
    <thead>
    <tr>
        <th rowspan="2"><fmt:message key="table.candy.name"/></th>
        <th rowspan="2"><fmt:message key="table.candy.id"/></th>
        <th rowspan="2"><fmt:message key="table.chocolate.kind"/></th>
        <th rowspan="2"><fmt:message key="table.candy.production"/></th>
        <th rowspan="2"><fmt:message key="table.candy.energy"/></th>
        <th colspan="4"><fmt:message key="table.candy.ingredients"/></th>
        <th colspan="3"><fmt:message key="table.candy.value"/></th>
        <th rowspan="2"><fmt:message key="table.chocolate.percent"/></th>
        <th colspan="3"><fmt:message key="table.chocolate.additives"/></th>
    </tr>
    <tr>
        <th><fmt:message key="table.candy.water"/></th>
        <th><fmt:message key="table.candy.sugar"/></th>
        <th><fmt:message key="table.candy.fructose"/></th>
        <th><fmt:message key="table.candy.vanilin"/></th>
        <th><fmt:message key="table.candy.proteins"/></th>
        <th><fmt:message key="table.candy.fats"/></th>
        <th><fmt:message key="table.candy.carbonhydrates"/></th>
        <th><fmt:message key="table.chocolate.raisins"/></th>
        <th><fmt:message key="table.chocolate.hazelnut"/></th>
        <th><fmt:message key="table.chocolate.cookies"/></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="row" items="${chocolates}" >
        <tr>
            <td><c:out value="${row.name}"/></td>
            <td><c:out value="${row.candyId}"/></td>
            <td><c:out value="${row.kind}"/></td>
            <td><c:out value="${row.production}"/></td>
            <td><c:out value="${row.energy}"/></td>
            <td><c:out value="${row.ingredients.water}"/></td>
            <td><c:out value="${row.ingredients.sugar}"/></td>
            <td><c:out value="${row.ingredients.fructose}"/></td>
            <td><c:out value="${row.ingredients.vanilin}"/></td>
            <td><c:out value="${row.value.proteins}"/></td>
            <td><c:out value="${row.value.fats}"/></td>
            <td><c:out value="${row.value.carbonhydrates}"/></td>
            <td><c:out value="${row.percent}"/></td>
            <td><c:out value="${row.additives.raising}"/></td>
            <td><c:out value="${row.additives.hazelnut}"/></td>
            <td><c:out value="${row.additives.cookies}"/></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
    <a href="jsp/main.jsp"><fmt:message key="label.back"/></a>
</body>
</html>
