<%-- 
    Document   : employee
    Created on : May 18, 2023, 9:42:44 AM
    Author     : Admin
--%>
<%@page import="java.util.List"%>
<%@page import="sample.dto.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee</title>

        <link rel="stylesheet" href="assets/css/bootstrap.min.css">

        <link rel="stylesheet" href="assets/plugins/select2/css/select2.min.css">

        <link rel="stylesheet" href="assets/plugins/fontawesome/css/fontawesome.min.css">
        <link rel="stylesheet" href="assets/plugins/fontawesome/css/all.min.css">

        <link rel="stylesheet" href="assets/css/style.css">

    </head>
    <body>
        <%
        List<User> user = (List<User>)request.getAttribute("list");
        //get number of users
        int count = (user == null || user.isEmpty()) ? 0 : user.size();
        %>
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
                                    <li class="breadcrumb-item"><a href="index.html"><img src="assets/img/dash.png" class="mr-2" alt="breadcrumb" />Home</a>
                                    </li>
                                    <li class="breadcrumb-item active"> Employees</li>
                                </ul>
                                <h3>Employees</h3>
                            </div>
                        </div>
                        <div class="col-xl-12 col-sm-12 col-12 mb-4">
                            <div class="head-link-set">
                                <ul>
                                    <li><a class="active" href="#">All</a></li>
                                    <li><a href="#">Teams</a></li>
                                    <li><a href="#">Offices</a></li>
                                </ul>
                                <a class="btn-add" href="add-employee.html"><i data-feather="plus"></i> Add Person</a>
                            </div>
                        </div>
                        <div class="col-xl-12 col-sm-12 col-12 mb-4">
                            <div class="row">
                                <div class="col-xl-10 col-sm-8 col-12 ">
                                    <label class="employee_count"><%=count %> People</label>
                                </div>
                                <div class="col-xl-1 col-sm-2 col-12 ">
                                    <a href="employee-grid.html" class="btn-view "><i data-feather="grid"></i> </a>
                                </div>
                                <div class="col-xl-1 col-sm-2 col-12 ">
                                    <a href="#" class="btn-view active"><i data-feather="list"></i> </a>
                                </div>
                            </div>
                        </div>
                        <div class="col-xl-12 col-sm-12 col-12 mb-4">
                            <div class="card">
                                <div class="table-heading">
                                    <h2>Project Summery</h2>
                                </div>
                                <div class="table-responsive">
                                    <table class="table  custom-table no-footer" id="userTable">
                                        <thead>
                                            <tr>
                                                <th>UserID</th>
                                                <th>Name</th>
                                                <th>Phone</th>
                                                <th>Email</th>
                                                <th>Username</th>
                                                <th>Password</th>
                                                <th>Address</th>
                                                <th>Birthday</th>
                                                <th>ExperienceId</th>
                                                <th>Team_ID</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <% for (User u: user) {%>
                                            <tr>
                                                <td><%=u.getUserID()%></td>
                                                <td><%=u.getName()%></td>
                                                <td><%=u.getPhone()%></td>
                                                <td><%=u.getEmail()%></td>
                                                <td><%=u.getUsername()%></td>
                                                <td><%=u.getPassword()%></td>
                                                <td><%=u.getAddress()%></td>
                                                <td><%=u.getBirthday()%></td>
                                                <td><%=u.getExperienceId()%></td>
                                                <td><%=u.getTeam_ID()%></td>
                                            </tr>
                                            <%}%>
                                        </tbody>
                                    </table>
                                </div>
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

        <!--<script src="assets/plugins/slimscroll/jquery.slimscroll.min.js"></script>-->

        <script src="assets/plugins/select2/js/select2.min.js"></script>

        <script src="assets/js/script.js"></script>
    </body>
</html>
