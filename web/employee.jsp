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
        <%-- import node_modules --%>
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>

        <script>
            function format(d) {
                // `d` is the original data object for the row
                return (
                        '<table cellpadding="5" cellspacing="0" border="0" style="padding-left:50px;">' +
                        '<tr>' +
                        '<td>Image:</td>' +
                        '<td>' +
                        '<img src="images/' + d.Image + '" width="100px" height="100px"/>' +
                        '</td>' +
                        '</tr>' +
                        '<tr>' +
                        '<td>Address:</td>' +
                        '<td>' +
                        d.Address +
                        '</td>' +
                        '</tr>' +
                        '<tr>' +
                        '<td>Project:</td>' +
                        '<td>' + d.NameProject + '</td>' +
                        '</tr>' +
                        '<tr>' +
                        '<td>Team:</td>' +
                        '<td>' + d.Team_Name + '</td>' +
                        '</tr>' +
                        '</table>'
                        );
            }
            $(document).ready(function () {
                //load data for datatable
                $('#example').DataTable({

                    ajax: {
                        url: '/HRManagement/employee',
                        dataSrc: ''
                    },
                    //justify content table center
                    "columnDefs": [
                        {"className": "dt-center", "targets": "_all"}
                    ],
                    columns: [
                        {
                            className: 'dt-control',
                            orderable: false,
                            data: null,
                            defaultContent: ''
                        },
                        {data: null,
                            //set identity for row
                            render: function (data, type, row, meta) {
                                return meta.row + meta.settings._iDisplayStart + 1;
                            }
                        },
                        {data: 'Name'},
                        {data: 'Phone'},
                        {data: 'Email'},
                        {data: 'Birthday'},
                        {
                            data: null,
                            render: function (data, type, row) {
                                //set id for button = id of employee
                                return `
                        <button style="background-color: white;box-shadow: none" class="del-employee btn m-1"><i class="fa-solid fa-trash text-danger"></i></button>
                        <button style="background-color: white;box-shadow: none" class="edit-employee btn m-1"><i class="fa-solid fa-pen-to-square text-primary"></i></button>
                    `;
                            }
                        }
                    ],
                    "order": [[0, "asc"]]
                });

                // Add event listener for opening and closing details
                $('#example tbody').on('click', 'td.dt-control', function () {
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

                $(document).ready(function () {
                    //add employee
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
                                //remove "" from string
                                if (res === `"Insert success"`) {
                                    swal.fire({
                                        title: "Success!",
                                        text: "Add employee success!",
                                        icon: "success",
                                        button: "OK"
                                    }).then((value) => {
                                        //click oke will hide modal and reload datatable
                                        $("#mymodal").modal("hide");
                                        $('#example').DataTable().ajax.reload();
                                    });
                                } else {
                                    swal.fire({
                                        title: "Error!",
                                        //remove "" from string
                                        text: res.replace(/"/g, ""),
                                        icon: "error",
                                        button: "OK!"
                                    });
                                }
                            },
                            error: function (error) {
                                console.log(error);
                                sweetAlert("Oops...", "Something went wrong!", "error");
                            }
                        });
                    });
                    //delete employee
                    //set event for button delete employee in table 
                    $('#example tbody').on('click', '.del-employee', function () {
                        //get data of row which is clicked
                        var data = $('#example').DataTable().row($(this).parents('tr')).data();
                        //set id for button delete
                        var id = data.UserID;
                        //console id of employee
                        console.log(id);
                        //use method post to send id to server
                        const swalWithBootstrapButtons = Swal.mixin({
                            customClass: {
                                confirmButton: 'btn btn-success',
                                cancelButton: 'btn btn-danger'
                            },
                            buttonsStyling: false
                        });
                        swalWithBootstrapButtons.fire({
                            title: 'Are you sure?',
                            text: "You won't be able to revert this!",
                            icon: 'warning',
                            showCancelButton: true,
                            confirmButtonText: 'Yes, delete it!',
                            cancelButtonText: 'No, cancel!',
                            reverseButtons: true
                        }).then((result) => {
                            if (result.isConfirmed) {
                                swalWithBootstrapButtons.fire(
                                        'Deleted!',
                                        'Your file has been deleted.',
                                        'success'
                                        );
                                $.ajax({
                                    method: "POST",
                                    url: "/HRManagement/deleteEmployee?id=" + id + "",
                                    success: function (res) {
                                        console.log(res);
                                        //remove "" from string
                                        if (res === "success") {
                                            swal.fire({
                                                title: "Success!",
                                                text: "Delete employee success!",
                                                icon: "success",
                                                button: "OK"
                                            }).then((value) => {
                                                //click oke will hide modal and reload datatable
                                                $("#mymodal").modal("hide");
                                                $('#example').DataTable().ajax.reload();
                                            });
                                        } else {
                                            swal.fire({
                                                title: "Error!",
                                                //remove "" from string
                                                text: res.replace(/"/g, ""),
                                                icon: "error",
                                                button: "OK!"
                                            });
                                        }
                                    },
                                    error: function (error) {
                                        console.log(error);
                                        sweetAlert("Oops...", "Something went wrong!", "error");
                                    }
                                });
                            } else if (
                                    /* Read more about handling dismissals below */
                                    result.dismiss === Swal.DismissReason.cancel
                                    ) {
                                swalWithBootstrapButtons.fire(
                                        'Cancelled',
                                        'Your employee is safe :)',
                                        'error'
                                        );
                            }
                        });
                    });
                });
                //selected employee
                $(document).ready(function () {
                    var table = $('#example').DataTable();

                    $('#example tbody').on('click', 'tr', function () {
                        $(this).toggleClass('selected');
                    });

                    $('#button').click(function () {
                        alert(table.rows('.selected').data().length + ' row(s) selected');
                    });
                });

                $(document).on('keydown', function (e) {
                    if (e.keyCode === 27) { // ESC
                        $("#mymodal").modal("hide");
                    }
                    if (e.key === 'Delete') {
                        var selectedRows = $('#example').DataTable().rows('.selected').data();
                        //Get id of selected employees
                        var selectedId = [];
                        for (var i = 0; i < selectedRows.length; i++) {
                            selectedId.push(selectedRows[i].UserID);
                        }
                        // console.log(selectedId);
                        if (selectedRows.length > 0) {
                            //send DELETE request to server to delete selected employees
                            const swalWithBootstrapButtons = Swal.mixin({
                                customClass: {
                                    confirmButton: 'btn btn-success',
                                    cancelButton: 'btn btn-danger'
                                },
                                buttonsStyling: false
                            });
                            swalWithBootstrapButtons.fire({
                                title: 'Are you sure?',
                                text: "You won't be able to revert this!",
                                icon: 'warning',
                                showCancelButton: true,
                                confirmButtonText: 'Yes, delete it!',
                                cancelButtonText: 'No, cancel!',
                                reverseButtons: true
                            }).then((result) => {
                                if (result.isConfirmed) {
                                    swalWithBootstrapButtons.fire(
                                            'Deleted!',
                                            'Employee has been deleted.',
                                            'success'
                                            );
                                    $.ajax({
                                        method: "DELETE",
                                        url: "/HRManagement/deleteEmployee",
                                        data: JSON.stringify(selectedId),
                                        contentType: "application/json",
                                        dataType: "json",
                                        // console: console.log(JSON.stringify(selectedId)),
                                        success: function (res) {
                                            var message = res.message;
                                            //remove "" from string
                                            message = message.replace(/"/g, "");
                                            console.log(message);
                                            //if message = "Delete successfully"
                                            if (message === "Delete successfully") {
                                                //reload datatable
                                                $('#example').DataTable().ajax.reload();
                                            }
                                        },
                                        error: function (error) {
                                            console.log(error);
                                            sweetAlert("Oops...", "Something went wrong!", "error");
                                        }
                                    });
                                } else if (
                                        /* Read more about handling dismissals below */
                                        result.dismiss === Swal.DismissReason.cancel
                                        ) {
                                    swalWithBootstrapButtons.fire(
                                            'Cancelled',
                                            'Your employee is safe :)',
                                            'error'
                                            );
                                }
                            });
                        }
                    }
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
                                    <li><a id="add" href="#">Teams</a></li>
                                </ul>
                                <a class="btn-add" onclick="$('#mymodal').modal('show')"><i data-feather="plus"></i> Add Person</a>
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
                                                    <option value="<%=team.getTeam_Name()%>"><%=team.getTeam_Name()%></option>
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
                                <label class="employee_count"> People</label>
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
                                                <th>Birthday</th>
                                                <th class="col-sm-1">Action</th>
                                            </tr>
                                        </thead>

                                        <tfoot>
                                            <tr>
                                                <th></th>
                                                <th>STT</th>
                                                <th>Name</th>
                                                <th>Phone</th>
                                                <th>Email</th>
                                                <th>Birthday</th>
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
