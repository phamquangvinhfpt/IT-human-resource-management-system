<%-- 
    Document   : employee
    Created on : May 18, 2023, 9:42:44 AM
    Author     : Admin
--%>
<%@page import="sample.dao.TeamDAO"%>
<%@page import="sample.dto.Team"%>
<%@page import="sample.dto.Project"%>
<%@page import="sample.dao.ProjectDAO"%>
<%@page import="java.text.SimpleDateFormat"%>
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

        <script src="https://kit.fontawesome.com/b3fa33d056.js" crossorigin="anonymous"></script>

        <!--CDN-->
        <link rel="stylesheet" href="https://cdn.datatables.net/1.13.4/css/jquery.dataTables.css" />
        <link rel="stylesheet" href="https://cdn.datatables.net/1.13.4/css/jquery.dataTables.min.css" />
        <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
        <script src="https://cdn.datatables.net/1.13.4/js/jquery.dataTables.min.js"></script>
        <!-- Bootstrap JavaScript library -->
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <script>
            $(document).ready(function () {
                $('#example').DataTable({

                    ajax: {
                        url: '/HRManagement/employee',
                        dataSrc: ''
                    },
                    columns: [
                        {
                            "className": 'dt-center',
                            "orderable": false,
                            "data": null,
                            "defaultContent": ''
                        },
                        {data: 'UserID'},
                        {data: 'Name'},
                        {data: 'Phone'},
                        {data: 'Email'},
                        {data: 'Username'},
                        {data: 'Password'},
                        {data: 'Address'},
                        {data: 'Birthday'},
                        {data: 'NameProject'},
                        {data: 'Team_Name'},
                        {data: 'Role'},
                        {
                            data: null,
                            render: function (data, type, row) {
                                //set id for button = id of employee
                                return `
                        <button onclick="deleteEmployee()" style="background-color: white;box-shadow: none" class="btn"><i class="fa-solid fa-trash text-danger"></i></button>
                        <button onclick="update(this)" style="background-color: white;box-shadow: none" class="btn"><i class="fa-solid fa-pen-to-square text-primary"></i></button>
                    `;
                            }
                        }
                    ],
                    "order": [[1, 'asc']]
                });

                $(document).ready(function () {
                    $(".myform").on("submit", function (e) {
                        e.preventDefault();
                        $.ajax({
                            method: "POST",
                            url: "/HRManagement/addEmployee",
                            data: new FormData(this),
                            processData: false,
                            contentType: false,
                            success: function (res) {
                                console.log(res);
                                //reload datatable
                                $('#example').DataTable().ajax.reload();
                                //close modal and popup alert success
                                $('#mymodal').modal('hide');
                                alert("Add success");
                            },
                            error: function (error) {
                                console.log(error);
                            }
                        });
                    });
                });
                //delete employee
                $(document).ready(function () {
                    var table = $('#example').DataTable();

                    $('#example tbody').on('click', 'tr', function () {
                        $(this).toggleClass('selected');
                    });

                    $('#button').click(function () {
                        alert(table.rows('.selected').data().length + ' row(s) selected');
                    });


                });
            });
        </script>
    </head>
    <body>
        <%
            //check user login
            User user = (User) session.getAttribute("user");
            if (user == null || !user.getRole().equals("admin")) {
                response.sendRedirect("login.jsp");
            }
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
                                                <label for="name">Name:</label>
                                                <input type="text" class="form-control" id="name" name="name">
                                            </div>
                                            <div class="form-group">
                                                <label for="name">Image:</label>
                                                <input type="file" class="form-control" id="image" name="image">
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
                                                <%-- combo box --%>
                                                <select class="form-control" id="experienceId" name="projectName">
                                                    <%
                                                        List<Project> list = ProjectDAO.getAll();
                                                        for (Project project : list) {
                                                    %>
                                                    <option value="<%=project.getNameProject()%>"><%=project.getNameProject()%></option>
                                                    <%
                                                        }
                                                    %>
                                                </select>
                                            </div>
                                            <div class="form-group">
                                                <label for="teamID">Team_ID:</label>
                                                <%-- combo box --%>
                                                <select class="form-control" id="teamID" name="teamName">
                                                    <%
                                                        List<Team> listTeam = TeamDAO.getAll();
                                                        for (Team team : listTeam) {
                                                    %>
                                                    <option value="<%=team.getTeam_Name() %>"><%=team.getTeam_Name()%></option>
                                                    <%
                                                        }
                                                    %>
                                                </select>
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
                                    <label class="employee_count"> People</label>
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
                                    <table id="example" class="display" style="width:100%">
                                        <thead>
                                            <tr>
                                                <th></th>
                                                <th>STT</th>
                                                <th>Name</th>
                                                <th>Phone</th>
                                                <th>Email</th>
                                                <th>Username</th>
                                                <th>Password</th>
                                                <th>Address</th>
                                                <th>Birthday</th>
                                                <th>NameProject</th>
                                                <th>Team_Name</th>
                                                <th>Role</th>
                                                <th>Action</th>
                                            </tr>
                                        </thead>
                                        <tbody>


                                        <tfoot>
                                            <tr>
                                                <th></th>
                                                <th>STT</th>
                                                <th>Name</th>
                                                <th>Phone</th>
                                                <th>Email</th>
                                                <th>Username</th>
                                                <th>Password</th>
                                                <th>Address</th>
                                                <th>Birthday</th>
                                                <th>NameProject</th>
                                                <th>Team_Name</th>
                                                <th>Role</th>
                                                <th>Action</th>
                                            </tr>
                                        </tfoot>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>

            <script src="assets/js/popper.min.js"></script>
            <script src="assets/js/bootstrap.min.js"></script>

            <script src="assets/js/feather.min.js"></script>

            <!--<script src="assets/plugins/slimscroll/jquery.slimscroll.min.js"></script>-->

            <script src="assets/plugins/select2/js/select2.min.js"></script>
            <script src="assets/js/script.js"></script>
    </body>
</html>
