
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Getting Started: Handing Form Submission</title>
    </head>
    <body>
        <jsp:useBean id="greeting" scope="request" class="models.Greeting" />
        <h1>Result</h1>
        <h2>id: ${greeting.id}</h2>
        <h2>content: ${greeting.content}</h2>
    </body>
</html>
