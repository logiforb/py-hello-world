<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Redirecting to index page</title>
    </head>
    <body>
        <h1>Redirecting to index page</h1>
        <c:redirect url="/greeting" />
    </body>
</html>
