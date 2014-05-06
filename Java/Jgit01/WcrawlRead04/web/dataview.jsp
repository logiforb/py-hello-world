<%-- 
    Document   : dataview
    Created on : Apr 24, 2014, 11:36:47 PM
    Author     : Kantaus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Data View</title>
        <%@include file="headerscripts.jsp" %>
    </head>
    <body>
        <script type="text/javascript">
            $(document).ready(function() {
                $('#datatable').dataTable();
            });
            
            function btnAction(id) {
                
                var jqxhr = $.ajax({
                    url: 'IPManipulatorServlet',
                    type: 'POST',
                    data: {
                        id: id
                    }
                });
                jqxhr.done(function() {
                    $("#hmanipulated").html("Manipulated: " + id);
                });
                jqxhr.fail(function() {
                    alert( "error" ); 
                });
                
            };
            
        </script>
        <h1>Start of data view</h1>
        <h2>Removed: ${removedIPsCount}</h2>
        <h2 id="hmanipulated">Manipulated: N/A</h2>
        <jsp:useBean id="ip" class="crawl.IPInfoHeavy" scope="page" />
        <div id="demo">
            <table cellpading="0" cellspacing="0" border="0" class="display" id="datatable" width="100%">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>IP</th>
                    <th>TITLE</th>
                    <th>STATUS CODE</th>
                    <th>STATUS MESSAGE</th>
                    <th>HEADERS</th>
                    <th>SOURCE LENGTH</th>
                    <th>EXCEPTION MESSAGE</th>
                    <th>LAST UPDATE</th>
                    <th>JOB ID</th>
                    <th>&nbsp;</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="ip" items="${data}" begin="0" step="1">
                <tr>
                    <td><c:out value="${ip.id}" /></td>
                    <td><c:out value="${ip.ip}" /></td>
                    <td><c:out value="${ip.title}" /></td>
                    <td><c:out value="${ip.statusCode}" /></td>
                    <td><c:out value="${ip.statusMessage}" /></td>
                    <td><c:out value="${ip.headersLength}" /></td>
                    <td><c:out value="${ip.sourceLength}" /></td>
                    <td><c:out value="${ip.exceptionMessage}" /></td>
                    <td><c:out value="${ip.lastUpdate}" /></td>
                    <td><c:out value="${ip.jobId}" /></td>
                    <td><button class="btnIP" id="btn${ip.id}" onclick="btnAction(${ip.id})">Alert</button></td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
        </div>
        <br />
        <h1>End of data view</h1>
    </body>
</html>
