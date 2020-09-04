<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <title>"Items list"</title>
    </head>
    <body>
        <div align="center">
            <table border="1" cellpading="1">
                <caption><h2> Todo Items </h2></caption>
                <tr>
                    <th> Title </th>
                    <th> Deadline </th>

                </tr>
                <c:forEach var="item" items="${todoData.items}">
                    <tr>
                        <td><c:out value="${item.title}"></c:out></td>
                        <td><c:out value="${item.deadLine}"></c:out></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>