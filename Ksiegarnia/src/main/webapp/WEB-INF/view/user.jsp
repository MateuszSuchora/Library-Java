b<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>List books</title>
</head>
<body>


<%--<a href="${pageContext.request.contextPath}/autors/list">Autorzy</a>--%>
<%--<a href="${pageContext.request.contextPath}/categories/list">Kategorie</a>--%>
<%--<a href="${pageContext.request.contextPath}/books/list">Książki</a>--%>
<h2>Książki :</h2>
<td>
    <table>
        <thead>
        <tr>
            <th>Tytuł</th>
            <th>Wydawnictwo</th>
            <th>Cena</th>
            <th>Kategoria</th>



        </tr>
        </thead>
        <c:forEach var="books" items="${books}">
            <tr>
                <td>${books.nazwa}</td>
                <td>${books.wydawnictwo}</td>
                <td>${books.cena}</td>
                <td>${books.kategoria.nazwa}</td>
                <td><c:out value="${books.getAutorzy}"/></td>

            </tr>
        </c:forEach>

    </table>
</td>
<p>
<form id="logout" action="<%=request.getContextPath()%>/logout" method="post" >
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    <input type="submit" value="logout" />
</form>
</p>
</body>
</html>