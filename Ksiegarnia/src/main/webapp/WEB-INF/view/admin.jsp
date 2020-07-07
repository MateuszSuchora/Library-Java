<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List books</title>
</head>
<body>
<h1>${ message }</h1>
<a href="${pageContext.request.contextPath}/autors/list">Autorzy</a>
<a href="${pageContext.request.contextPath}/categories/list">Kategorie</a>
<a href="${pageContext.request.contextPath}/books/list">Książki</a>
<h2>Books:</h2>
<table>

    <tr>
        <th>Name</th>
        <th>Publisher</th>
        <th>Price</th>
        <th>Category</th>
        <th>Autor</th>
    </tr>
    <c:forEach var="books" items="${books}">

        <c:url var="update" value="/books/updateBookForm">
            <c:param name="bookId" value="${books.id}"/>
        </c:url>

        <c:url var="delete" value="/books/deleteBookForm">
            <c:param name="bookId" value="${books.id}"/>
        </c:url>


        <tr>
            <td>${books.nazwa}</td>
            <td>${books.wydawnictwo}</td>
            <td>${books.cena}</td>
            <td>${books.kategoria.nazwa}</td>
            <td><c:out value="${ksiazka.getAutorzy}"/></td>
            <td><a href="${update}" >update</a> </td>
            <td><a href="${delete}" >delete</a> </td>

        </tr>


    </c:forEach>

</table></div>
<div>
    <a href="${pageContext.request.contextPath}/books/formadd" >Dodaj książkę</a>
</div>
</div>
<form id="logout" action="<%=request.getContextPath()%>/logout" method="post" >
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    <input type="submit" value="logout" />
</form>
</body>
</html>