<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        Language: <a href="?locale=en">English</a>|<a href="?locale=de">German</a>

        <h3>
            home.springmvc: <spring:message code="home.springmvc" text="default text" />
        </h3>

        Current Locale : ${pageContext.response.locale}

    </body>
</html>