
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>List autors</title>
</head>
<body>
<h2>Autors:</h2>
<div>
    <table>
        <tr>
            <th>Id</th>
            <th>Imie</th>
            <th>Nazwisko</th>
        </tr>
        <c:forEach var="autors" items="${autors}">
            <c:url var="update" value="/autors/updateAutorForm">
                <c:param name="autorId" value="${autors.id}"/>
            </c:url>

            <c:url var="delete" value="/autors/deleteAutorForm">
                <c:param name="autorId" value="${autors.id}"/>
            </c:url>
            <tr>
                <td>${autors.id}</td>
                <td>${autors.imie}</td>
                <td>${autors.nazwisko}</td>
                <td><a href="${update}" >update</a> </td>

                <td><a href="${delete}" >delete</a> </td>

            </tr>
        </c:forEach>
    </table>
</div>
<div>
    <input type="button" value="Add AUTOR" onclick="window.location.href='formadd';return false;"/>
</div>
</body>
</html>