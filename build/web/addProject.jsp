<%-- 
    Document   : addProject
    Created on : Jun 4, 2023, 10:34:43 AM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="assets/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets/plugins/fontawesome/css/fontawesome.min.css">
        <link rel="stylesheet" href="assets/plugins/fontawesome/css/all.min.css">
        <link rel="stylesheet" href="assets/css/style.css">
    </head>
    <body>
        <div class="main-wrapper">

            <div class="header">
                <jsp:include page="common/navbar.jsp" />  
            </div>


            <div class="sidebar" id="sidebar">
                <jsp:include page="common/sidebar.jsp" />
            </div>


            <div class="page-wrapper">
                <div class="content container-fluid">
                    <div class="row">
                        <div class="col-xl-12 col-sm-12 col-12">
                            <div class="breadcrumb-path mb-4">
                                <ul class="breadcrumb">
                                    <li class="breadcrumb-item"><a href="index.html"><img src="assets/img/dash.png"
                                                                                          class="mr-2" alt="breadcrumb" />Home</a>
                                    </li>
                                    <li class="breadcrumb-item active"> Projects</li>
                                </ul>
                                <h3>Add new Project</h3>
                            </div>
                        </div>
                        
                        
                        <div class="col-xl-12 col-sm-12 col-12 mb-4">
                            <div class="card">
                                
                                <div class="table-responsive">
                                    <c:set var="result" value="${requestScope.projectList}"/>
                                    <c:if test="${not empty result}">
                                        <table class="table  custom-table no-footer">
                                            <thead>
                                                <tr>
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
                                                            ${dto.getNameProject()}
                                                        </td>
                                                        <td>
                                                            ${dto.getStartDate()}
                                                        </td>
                                                        <td>
                                                            ${dto.getEndDate()}
                                                        </td>
                                                        <td>
                                                            ${dto.getTechStack()}
                                                        </td>
                                                    </tr>
                                                </c:forEach>
                                            </tbody>
                                        </table>
                                    </c:if>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>


            </div>


            <script src="assets/js/jquery-3.6.0.min.js"></script>

            <script src="assets/js/popper.min.js"></script>
            <script src="assets/js/bootstrap.min.js"></script>

            <script src="assets/js/feather.min.js"></script>

            <script src="assets/plugins/slimscroll/jquery.slimscroll.min.js"></script>

            <script src="assets/plugins/apexchart/apexcharts.min.js"></script>
            <script src="assets/plugins/apexchart/chart-data.js"></script>

            <script src="assets/js/script.js"></script>
            <script>
                var dt = new Date();
                document.getElementById('date-time').innerHTML = dt;
            </script>
        </div>
    </body>
</html>
