<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List authors</title>
</head>
<body>
<h2>Autorzy :</h2>
<div>
    <table>
        <tr>
        <tr>

            <th>Imie</th>
            <th>Nazwisko</th>
        </tr>
        </tr>
        <c:forEach var="autors" items="${autors}">
            <c:url var="update" value="/autors/updateAutorForm">
                <c:param name="autorId" value="${autors.id}"/>
            </c:url>

            <c:url var="delete" value="/autors/deleteAutorForm">
                <c:param name="autorId" value="${autors.id}"/>
            </c:url>
            <tr>
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
<form id="logout" action="<%=request.getContextPath()%>/logout" method="post" >
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    <input type="submit" value="logout" />
</form>
<p>
    <a href="${pageContext.request.contextPath}/ "> return </a>
</p>
</body>
</html>