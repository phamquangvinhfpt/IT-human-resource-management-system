<%-- 
    Document   : error
    Created on : May 31, 2023, 1:24:44 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String errorMessage = (String)request.getAttribute("errorMessage");
            //get error message from parse response.sendRedirect("error.jsp?message=Invalid input parameters");
            String message = request.getParameter("message");
        %>
        <p><span><%=errorMessage%></span></p>
        <p><span><%=message%></span></p>
    </body>
</html>
