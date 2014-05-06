<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pers Input</title>
    </head>
    <body>
        <jsp:useBean id="pers" scope="request" class="models.Person" />
        <h1>Pers Input</h1>
        <c:set var="context" value="${pageContext.request.contextPath}" />
        <form name="formmain" action="${context}/pers" method="POST">
            <label for="age">Age</label>
            <input type="text" name="age" value="" />
            <br />
            <label for="name">Name</label>
            <input type="text" name="name" value="" />
            <br />
            <input type="submit" value="Submit" name="submit" />
        </form>
    </body>
</html>
