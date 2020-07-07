<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
<title>Lista kategorii </title>
</head>
<html>
<body>
<h2>Kategorie :</h2>
    <table>
        <thead >
        <tr>
            <th>Nazwa</th>

        </tr>
        </thead>
        <tbody>
        <c:forEach var="category" items="${categories}">
            <c:url var="update" value="/categories/updateCategoryForm">
                <c:param name="categoryId" value="${category.id}"/>
            </c:url>
            <c:url var="delete" value="/categories/deleteCategoryForm">
                <c:param name="categoryId" value="${category.id}"/>
            </c:url>
            <tr>
                <td><c:out value="${category.nazwa}"/></td>
                <td><a href="${update}">update</a></td>
                <td><a href="${delete}">delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<%--<div>--%>
<%--    <a href="${pageContext.request.contextPath}/categories/formadd" >Dodaj kategorię</a>--%>
<%--</div>--%>
    <div>
        <input type="button" value="Dodaj kategorię" onclick="window.location.href='formadd';return false;"/>
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