<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@tag description="Executes body if value is not null" pageEncoding="UTF-8"%>
<%@attribute name="value" required="true"%>
<c:if test="${not empty value}">
<jsp:doBody />
</c:if>