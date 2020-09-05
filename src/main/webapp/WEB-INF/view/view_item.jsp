<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.utils.Mappings" %>
<%@ page import="com.utils.AttributeNames" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title> View item </title>
    </head>
    <body>
        <div align="CENTER">
            <table border="1" cellpading="1">
                <c:url var="itemsUrl" value="${Mappings.ITEMS}"/>
                <caption><h1>Item</h1></caption>
                <tr>
                    <th><c:out value="${todoItem.title}"/></th>
                </tr>
                <tr>
                    <td><c:out value="${todoItem.deadLine}"/></td>
                </tr>
                <tr>
                    <td><c:out value="${todoItem.details}"/></td>
                </tr>
                <tr>
                    <td><a href="${itemsUrl}">Go back</a></td>
                </tr>
            </table>
        </div>
    </body>
</html>