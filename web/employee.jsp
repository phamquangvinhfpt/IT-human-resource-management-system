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

        <script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
        <script src="https://kit.fontawesome.com/b3fa33d056.js" crossorigin="anonymous"></script>
    </head>
    <body>
        <%
            List<User> user = (List<User>) request.getAttribute("list");
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
                                </ul>
                                <button class="btn-add" onclick="$('#mymodal').modal('show')"><i data-feather="plus"></i> Add Person</button>
                            </div>
                        </div>
                        <form class="myform">
                            <div class="modal fade" data-backdrop='static' id="mymodal">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h3 class="modal-title">Add New Employee</h3>
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                <span aria-hidden="true">&times;</span>
                                            </button>
                                        </div>

                                        <div class="modal-body">
                                            <div class="form-group">
                                                <label for="userID">UserID:</label>
                                                <input type="text" class="form-control" id="userID" name="userID">
                                            </div>
                                            <div class="form-group">
                                                <label for="name">Name:</label>
                                                <input type="text" class="form-control" id="name" name="name">
                                            </div>
                                            <div class="form-group">
                                                <label for="phone">Phone:</label>
                                                <input type="text" class="form-control" id="phone" name="phone">
                                            </div>
                                            <div class="form-group">
                                                <label for="email">Email:</label>
                                                <input type="email" class="form-control" id="email" name="email">
                                            </div>
                                            <div class="form-group">
                                                <label for="username">Username:</label>
                                                <input type="text" class="form-control" id="username" name="username">
                                            </div>
                                            <div class="form-group">
                                                <label for="password">Password:</label>
                                                <input type="password" class="form-control" id="password" name="password">
                                            </div>
                                            <div class="form-group">
                                                <label for="address">Address:</label>
                                                <input type="text" class="form-control" id="address" name="address">
                                            </div>
                                            <div class="form-group">
                                                <label for="birthday">Birthday:</label>
                                                <input type="date" class="form-control" id="birthday" name="birthday">
                                            </div>
                                            <div class="form-group">
                                                <label for="experienceId">ExperienceId:</label>
                                                <input type="text" class="form-control" id="experienceId" name="experienceId">
                                            </div>
                                            <div class="form-group">
                                                <label for="teamID">Team_ID:</label>
                                                <input type="text" class="form-control" id="teamID" name="teamID">
                                            </div>
                                        </div>

                                        <div class="modal-footer">
                                            <input type="submit" value="Save" class="btn btn-primary" />
                                            <input type="reset" value="Reset" class="btn btn-danger" />
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </form>

                        <div class="col-xl-12 col-sm-12 col-12 mb-4">
                            <div class="row">
                                <div class="col-xl-10 col-sm-8 col-12 ">
                                    <label class="employee_count"><%=count%> People</label>
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
                                                <th>Action</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <% for (User u : user) {%>
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
                                                <td>
                                                    <button style="background-color: white;box-shadow: none" class="btn"><i class="fa-solid fa-trash text-danger"></i></button>
                                                    <button style="background-color: white;box-shadow: none" class="btn"><i class="fa-solid fa-pen-to-square text-primary"></i></button>
                                                </td>
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
        <script type="text/javascript">
                                    $(document).ready(function () {
                                    $(".myform").on("submit", function (e) {
                                    e.preventDefault();
                                            $.ajax({
                                            method: "POST",
                                                    url: "/HRManagement/addEmployee",
                                                    data: new FormData(this),
                                                    processData:false,
                                                    contentType:false,
                                                    success:function(res){
                                                    console.log(res);
                                                    },
                                                    error:function(error){
                                                    console.log(error);
                                                    }
                                            });
                                    });
                                    });
        </script>
    </body>
</html>
