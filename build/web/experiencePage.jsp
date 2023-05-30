<%-- 
    Document   : experiencePage
    Created on : May 30, 2023, 10:38:13 AM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="mainController" method="POST">
            <input type="submit" name="btAction" value="getProject" />
        </form>

        <c:set var="result" value="${requestScope.projectList}"/>
        <c:if test="${not empty result}">
            <table border="1">
                <thead>
                    <tr>
                        <th>No.</th>
                        <th>ID</th>
                        <th>Name Project</th>
                        <th>Start Date</th>
                        <th>End Date</th>
                        <th>Tech Stack</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="dto" items="${result}" varStatus="counter">
                        <tr>
                            <td>
                                ${counter.count}
                            </td>
                            <td>
                                ${dto.ExperienceID}
                            </td>
                            <td>
                                ${dto.NameProject}
                            </td>
                            <td>
                                ${dto.startDate}
                            </td>
                            <td>
                                ${dto.endDate}
                            </td>
                            <td>
                                ${dto.techStack}
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

        </c:if>
    </body>
</html>
