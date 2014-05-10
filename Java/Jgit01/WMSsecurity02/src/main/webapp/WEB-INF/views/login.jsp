<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <div>
            <div style="color: red">${error}</div>
        </div>
        <div>
            <form action="<c:url value='j_spring_security_check' />" method="POST">
                <label for="j_username">Username</label>
                <input type="text" name="j_username" value="" />
                <br />
                <label for="j_password">Password</label>
                <input type="password" name="j_password" value="" />
                <br />
                <input type="submit" name="login" value="Login" />
            </form>
        </div>
    </body>
</html>
