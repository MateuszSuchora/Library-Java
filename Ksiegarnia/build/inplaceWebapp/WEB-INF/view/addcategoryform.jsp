
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
<title>Dodaj kategorie</title>
</head>
<body>
<form:form action="saveCategory" modelAttribute="category" method="POST">
    <table>
        <tr>
            <td><label for="nazwa">nazwa:</label></td>
            <td><form:input path="nazwa" id="nazwa"/></td>
        </tr>
        <tr>
            <td><form:hidden path="id"/></td>
        </tr>
        <tr>
            <td>
                <button type="submit">Zapisz</button>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>