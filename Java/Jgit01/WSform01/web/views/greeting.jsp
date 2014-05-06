<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Getting Started: Handing Form Submission</title>
    </head>
    <body>
        <jsp:useBean id="greeting" scope="request" class="models.Greeting" />
        <h1>Form</h1>
        <c:set var="context" value="${pageContext.request.contextPath}" />
        <form name="formmain" action="${context}/greeting" method="POST">
            <label for="id">Id</label>
            <input type="text" name="id" value="" />
            <br />
            <label for="content">Content</label>
            <input type="text" name="content" value="" />
            <br />
            <input type="submit" value="Submit" name="submit" />
        </form>
    </body>
</html>
