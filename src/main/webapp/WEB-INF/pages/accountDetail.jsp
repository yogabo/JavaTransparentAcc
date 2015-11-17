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
    <title>Detail účtu</title>
    <link href="<spring:url value="/resources/css/style.css"/>" rel="stylesheet">
</head>
<body>
<div id="main">

    <header_detail>
        <nav>
        </nav>
    </header_detail>
    <div id="site_detail">
        <div id="content">
            <div class="content_item">
                <table>
                    <tr>
                        <td style="width: 200px">Jméno</td>
                        <td>${transAccItem.name}</td>
                    </tr>
                    <tr>
                        <td>Iban
                        </td>
                        <td><a href="${url}">${transAccItem.iban}</a></td>
                    </tr>
                    <tr>
                        <td>Číslo účtu</td>
                        <td>${transAccItem.accNumber} / ${transAccItem.accBankCode}</td>
                    </tr>
                    <tr>
                        <td>Zůstatek</td>
                        <td>${transAccItem.balance} ${transAccItem.currency}</td>
                    </tr>
                    <tr>
                        <td>Transparentní od</td>
                        <td><fmt:formatDate pattern="dd.MM.yyyy" value="${transAccItem.transparencyFrom}"/></td>
                    </tr>
                    <tr>
                        <td>Transparentní do</td>
                        <td><fmt:formatDate pattern="dd.MM.yyyy" value="${transAccItem.transparencyTo}"/></td>
                    </tr>
                    <tr>
                        <td>Veřejný do</td>
                        <td><fmt:formatDate pattern="dd.MM.yyyy" value="${transAccItem.publicationTo}"/></td>
                    </tr>
                    <tr>
                        <td>Aktualizován</td>
                        <td><fmt:formatDate pattern="dd.MM.yyyy HH:MM" value="${transAccItem.actualizationDate}"/></td>
                    </tr>
                    <tr>
                        <td>Popis</td>
                        <td>${transAccItem.description}</td>
                    </tr>
                    <tr>
                        <td>Poznámka</td>
                        <td>${transAccItem.note}</td>
                    </tr>
                </table>
            </div><!--close content_item-->
        </div><!--close content-->
    </div><!--close site_content-->
</div>
</body>
</html>