<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Form main</title>
        <style type="text/css">
            body { background-color: #eee; font: helvetica; }
            #container { width: 500px; background-color: #fff; margin: 30px auto; padding: 30px; border-radius: 5px; }
            .green { font-weight: bold; color: green; }
            .message { margin-bottom: 10px; }
            label {width:70px; display:inline-block;}
            input { display:inline-block; margin-right: 10px; }
            form {line-height: 160%; }
            .hide { display: none; }
            .error { color: red; font-size: 0.9em; font-weight: bold; }
        </style>
    </head>
    <body>
        <div id="container">
            <c:set var="context" value="${pageContext.request.contextPath}" />
            <form:form action="${context}/hello" modelAttribute="animal">
                <label for="ageInput">Age: </label>
                <form:input path="age" id="ageInput" />
                <form:errors path="age" cssClass="error" />
                <br/>
                <input type="submit" value="Submit" />
            </form:form>
        </div>
    </body>
</html>
