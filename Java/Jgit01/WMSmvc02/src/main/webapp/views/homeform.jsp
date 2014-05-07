<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home form</title>
    </head>
    <body>
        <div>
            <c:set var="context" value="${pageContext.request.contextPath}" />
            <form:form action="${context}/home" modelAttribute="animal">
                <label for="ageInput">Age: </label>
                <form:input path="age" id="ageInput" />
                <form:errors path="age" cssClass="error" />
                <br/>
                <input type="submit" value="Submit" />
            </form:form>
        </div>
    </body>
</html>
