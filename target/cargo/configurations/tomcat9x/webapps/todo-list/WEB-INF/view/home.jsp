<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.utils.Mappings" %>

<!DOCTYPE html>
<html>
    <head>
        <title> Home </title>
    </head>
    <body>
        <div align="center">
            <c:url var= "itemsLink" value= "${Mappings.ITEMS}"/>
            <h2><a href="${itemsLink}">Go to items</a></h2>
        </div>
    </body>
</html>