<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Autors</title>
</head>
<body>
ADD Autor
<form:form action="saveAutor" modelAttribute="autor" method="POST">
    <table>
        <tbody>
        <tr>
            <td><label>imie:</label></td>
            <td><form:input path="imie"/></td>
        </tr>
        <tr>
            <td><label>nazwisko:</label></td>
            <td><form:input path="nazwisko"/></td>
        </tr>
        <tr>
            <td><form:hidden path="id"/></td>

        </tr>
        <tr>
            <td><label></label></td>
            <td><input type="submit" value="Save" class="save"/></td>
        </tr>
        </tbody>
    </table>
</form:form>
<!-- -wracamy do listy bez zapisu-->
<p>
    <a href="${pageContext.request.contextPath}/autors/list "> return </a>
</p>
</body>
</html>