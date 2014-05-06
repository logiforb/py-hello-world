
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pers Result</title>
    </head>
    <body>
        <jsp:useBean id="pers" scope="request" class="models.Person" />
        <h1>Result</h1>
        <h2>Age: ${pers.age}</h2>
        <h2>Name: ${pers.name}</h2>
    </body>
</html>
