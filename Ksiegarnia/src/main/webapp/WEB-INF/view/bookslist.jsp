<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List books</title>
</head>
<body>
<h2>Książkii :</h2>
<div>
    <table>
        <tr>
            <th>Tytuł</th>
            <th>Wydawnictwo</th>
            <th>Cena</th>
            <th>Kategoriaa</th>
            <th>Autorr</th>


        </tr>
        <c:forEach var="book" items="${books}">
         <c:url var="update" value="/books/updateBookForm">
            <c:param name="bookId" value="${book.id}"/>
         </c:url>
         <c:url var="delete" value="/books/deleteBookForm">
            <c:param name="bookId" value="${book.id}"/>
         </c:url>
            <tr>

                <td>${book.nazwa}</td>
                <td>${book.wydawnictwo}</td>
                <td>${book.cena}</td>
                <td>${book.kategoria.nazwa}</td>
                <td>${book.autorzy}</td>
                <td><a href="${update}">update</a></td>
                <td><a href="${delete}">delete</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
<div>
    <input type="button" value="Add Book" onclick="window.location.href='formadd';return false;"/>
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