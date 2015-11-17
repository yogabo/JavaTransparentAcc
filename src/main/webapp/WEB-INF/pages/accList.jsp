<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%--
  Created by IntelliJ IDEA.
  User: sytensky
  Date: 15/11/15
  Time: 16:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="<spring:url value="/resources/css/style.css"/>" rel="stylesheet">
    <title>Seznam Trasparentních účtů</title>
</head>
<body>
<div id="main">

    <header>
        <nav>
        </nav>
    </header>
    <div id="site_content">
        <div id="content">
            <div class="content_item">
                <table border="1">
                    <tr>
                        <th>&nbsp;</th>
                        <th>Jméno</th>
                        <th>Číslo účtu</th>
                        <th>Zůstatek</th>
                        <th>Transparentní od</th>
                        <th>Transparentní do</th>
                        <th>Veřejný do</th>
                        <th>Aktualizován</th>
                        <th>Popis</th>
                        <th>Poznámka</th>
                        <th>&nbsp;</th>
                    </tr>
                    <c:forEach var="transAccItem" items="${TransAccItemList}" varStatus="loop">
                        <spring:url value="/transDetail" var="url">
                            <spring:param name="accNum" value="${transAccItem.accNumber}"/>
                        </spring:url>
                        <tr>
                            <td>${loop.index}</td>
                            <td>${transAccItem.name}</td>
                            <td style="width:100px">${transAccItem.accNumber}</td>
                            <td>${transAccItem.balance} ${transAccItem.currency}</td>
                            <td><fmt:formatDate pattern="dd.MM.yyyy" value="${transAccItem.transparencyFrom}"/></td>
                            <td><fmt:formatDate pattern="dd.MM.yyyy" value="${transAccItem.transparencyTo}"/></td>
                            <td><fmt:formatDate pattern="dd.MM.yyyy" value="${transAccItem.publicationTo}" /></td>
                            <td><fmt:formatDate pattern="dd.MM.yyyy HH:MM" value="${transAccItem.actualizationDate}"/></td>
                            <td>${transAccItem.description}</td>
                            <td>${transAccItem.note}</td>
                            <td>
                                <div class="content_container button_small"><a href='${url}'>Detail&nbsp;účtu</a></div>
                            </td>
                        </tr>
                    </c:forEach>
                    <tr>
                        <td></td>
                    </tr>
                </table>
            </div><!--close content_item-->
        </div><!--close content-->
    </div><!--close site_content-->
</div>
</body>
</html>
