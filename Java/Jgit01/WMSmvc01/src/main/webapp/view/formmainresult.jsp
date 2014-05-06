
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Animal!</title>
    </head>
    <body>
        <jsp:useBean id="animal" scope="request" class="com.codetutr.model.Animal" />
        <h1>Result</h1>
        <h2>age: ${animal.age}</h2>
    </body>
</html>
