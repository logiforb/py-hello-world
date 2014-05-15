<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="mytags" tagdir="/WEB-INF/tags/" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<mytags:mymain 
    mymaintitle="Login" 
    subheadingtitle="Login"
    mycontextpath="${pageContext.request.contextPath}">

    <div>
        <mytags:ifnotnull value="${error}">
            <div class="alert alert-danger">${error}</div>
        </mytags:ifnotnull>
    </div>
    <div class="form-group">
        <form action="<c:url value='j_spring_security_check' />" method="POST">
            <label for="j_username">Username</label>
            <input type="text" name="j_username" class="form-control" placeholder="Enter username" />
            <br />
            <label for="j_password">Password</label>
            <input type="password" name="j_password" class="form-control" placeholder="Enter password" />
            <br />
            <input type="submit" name="login" value="Login" class="btn btn-default" />
        </form>
    </div>

</mytags:mymain>