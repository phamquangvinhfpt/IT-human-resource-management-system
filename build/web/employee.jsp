<%-- 
    Document   : employee
    Created on : May 18, 2023, 9:42:44 AM
    Author     : Admin
--%>
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

        <%-- <script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script> --%>
        <script src="https://kit.fontawesome.com/b3fa33d056.js" crossorigin="anonymous"></script>

        <!--CDN-->
        <link rel="stylesheet" href="https://cdn.datatables.net/1.13.4/css/jquery.dataTables.css" />
        <script src="https://cdn.datatables.net/1.13.4/js/jquery.dataTables.js"></script>
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
                            "className": 'details-control',
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
                        {data: 'ExperienceId'},
                        {data: 'Team_ID'},
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
                // Add event listener for opening and closing details
                $('#example tbody').on('click', 'td.details-control', function () {
                    var tr = $(this).closest('tr');
                    var row = $('#example').DataTable().row(tr);

                    if (row.child.isShown()) {
                        // This row is already open - close it
                        row.child.hide();
                        tr.removeClass('shown');
                    } else {
                        // Open this row
                        row.child(format(row.data())).show();
                        tr.addClass('shown');
                    }
                });
                //format detail
                function format(d) {
                    // `d` is the original data object for the row
                    return '<table cellpadding="5" cellspacing="0" border="0" style="padding-left:50px;">' +
                            '<tr>' +
                            '<td>Full name:</td>' +
                            '<td>' + d.Name + '</td>' +
                            '</tr>' +
                            '<tr>' +
                            '<td>Phone:</td>' +
                            '<td>' + d.Phone + '</td>' +
                            '</tr>' +
                            '<tr>' +
                            '<td>Extra info:</td>' +
                            '<td>And any further details here (images etc)...</td>' +
                            '</tr>' +
                            '</table>';
                }
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
            if (user == null || user.getRole() != 1) {
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


                                        <tfoot>
                                            <tr>
                                                <th></th>
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
