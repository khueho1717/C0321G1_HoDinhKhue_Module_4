<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Create a new employee</title>
</head>
<body>
<h3>Welcome, Enter The Employee Details</h3>
<%--@elvariable id="employee" type="com"--%>
<form:form method="POST" action="update" modelAttribute="email">
    <table>
        <tr>
            <td><form:label path="language">Language: </form:label></td>
            <td><form:select path="language">
                <option
                        th:value="English">English
                </option>
                <option
                        th:value="Vietnamese">Vietnamese
                </option>
                <option
                        th:value="Japanese">Japanese
                </option>
                <option
                        th:value="Chinese">Chinese
                </option>
                <option selected
                        th:value="${email.language}">${email.language}
                </option>
            </form:select></td>
        </tr>
        <tr>
            <td><form:label path="pageSize">Page Size: </form:label></td>
            <td>Show <form:select path="pageSize">
                <option
                        th:value="5">5
                </option>
                <option

                        th:value="10">10
                </option>
                <option
                        selected
                        th:value="${email.pageSize}">${email.pageSize}
                </option>
                <option
                        th:value="15">15
                </option>
                <option
                        th:value="25">25
                </option>
                <option
                        th:value="50">50
                </option>
                <option
                        th:value="100">100
                </option>
            </form:select> email per page
            </td>
        </tr>
        <tr>
            <td><form:label path="spamsFilter">Spams Filter</form:label></td>
            <td><form:checkbox path="spamsFilter"/></td>
        </tr>
        <tr>
            <td><form:label path="signature">Signature</form:label></td>
            <td><form:textarea path="signature" items="sfrgrgsgf"/></td>

        </tr>

        <tr>
            <td><input type="submit" value="Submit"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>
