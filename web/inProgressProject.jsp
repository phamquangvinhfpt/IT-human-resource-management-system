<%-- 
    Document   : inProgressProject
    Created on : Jun 6, 2023, 8:14:07 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="assets/css/bootstrap.min.css">

        <link rel="stylesheet" href="assets/plugins/select2/css/select2.min.css">

        <link rel="stylesheet" href="assets/plugins/fontawesome/css/fontawesome.min.css">
        <link rel="stylesheet" href="assets/plugins/fontawesome/css/all.min.css">

        <link rel="stylesheet" href="assets/css/style.css">

        <%-- <script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script> --%>
        <script src="https://kit.fontawesome.com/b3fa33d056.js" crossorigin="anonymous"></script>

        <!--CDN-->
        <link rel="stylesheet" href="https://cdn.datatables.net/1.13.4/css/jquery.dataTables.css" />
        <link rel="stylesheet" href="https://cdn.datatables.net/1.13.4/css/jquery.dataTables.min.css" />
        <script src="assets/js/jquery-3.6.0.min.js"></script>
        <script src="https://cdn.datatables.net/1.13.4/js/jquery.dataTables.min.js"></script>
        <!-- Bootstrap JavaScript library -->
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>
        <script>
            $(document).ready(function () {
                $('#example').DataTable({
                    ajax: {
                        url: '/HRManagement/inProgressServlet',
                        dataSrc: ''
                    },
                    columns: [
                        {data: null,
                            //set identity for row
                            render: function (data, type, row, meta) {
                                return meta.row + meta.settings._iDisplayStart + 1;
                            }
                        },
                        {data: 'NameProject'
                        }
                        ,
                        {
                            data: 'startDate'
                        }
                        ,
                        {
                            data: 'endDate'
                        }
                        ,
                        {
                            data: 'techStack'
                        }
                        ,
                        {
                            data: 'decs'
                        }
                        ,
                        {
                            data: null,
                            render: function (data, type, row) {
                                //set id for button = id of employee
                                return `
        <button class="btn edit-btn" style="background-color: white;box-shadow: none">
 <i class="fa-solid fa-pen-to-square text-primary"></i>
</button>
                   `;
                            }
                        }
                    ],
                    "order": [[1, 'asc']]

                });
                $('#example tbody').on('click', '.edit-btn', function () {
                    //get data of row which is clicked
                    var data = $('#example').DataTable().row($(this).parents('tr')).data();
                    //set id for button edit
                    var id = data.ProjectID;
                    $("#editmodal").modal("show");
                    //set title for modal
                    //import a input hidden to modal
                    $("#editmodal .modal-body").append("<input type='hidden' name='id' value='" + id + "'>");
                    //sent all data to server
                });
            });
            $(document).ready(function () {
                // Counter to keep track of the number of task description input fields
                var numTasks = 1;

                // Event listener for the "More" button that appends a new task description input field
                $('#more').click(function (e) {
                    e.preventDefault();
                    numTasks++;
                    var newTask = $('<div class="form-group"><label for="Task">Task Description:</label><input type="text" class="form-control" id="Task' + numTasks + '" name="TaskDesc' + numTasks + '"></div>');
                    $('#task-container').append(newTask);
                });

                // Event listener for the form submission
                $(".editform").on("submit", function (e) {
                    e.preventDefault();

                    // Get the project ID and create a FormData object to hold the form data
                    var id = $('#example').DataTable().row({selected: true}).data().ProjectID;
                    var formData = new FormData();

                    // Append the project ID to the form data
                    formData.append('ProjectID', id);

                    // Loop through the task description input fields and append their values to the form data
                    for (var i = 1; i <= numTasks; i++) {
                        var taskValue = $('#Task' + i).val();
                        formData.append('descriptions[]', taskValue);
                    }

                    // Send the form data to the server using an AJAX request
                    $.ajax({
                        method: "POST",
                        url: "/HRManagement/AddTaskServlet",
                        data: formData,
                        contentType: false,
                        processData: false,
                        success: function (res) {
                            console.log(res);
                            //remove "" from string
                            if (res === "success") {
                                swal.fire({
                                    title: "Success!",
                                    text: "Edit success!",
                                    icon: "success",
                                    button: "OK"
                                }).then((value) => {
                                    //click oke will hide modal and reload datatable
                                    $("#editmodal").modal("hide");
                                    $('#example').DataTable().ajax.reload();
                                });
                            } else {
                                console.log(res);
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
            });
        </script>
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
                                    <li class="breadcrumb-item"><a href="admin.jsp"><img src="assets/img/dash.png"
                                                                                          class="mr-2" alt="breadcrumb" />Home</a>
                                    </li>
                                    <li class="breadcrumb-item active"> Projects</li>
                                </ul>
                                <h3>Projects</h3>
                            </div>
                        </div>
                        <div class="col-xl-12 col-sm-12 col-12 mb-4">
                            <div class="head-link-set">
                                <ul>
                                    <li><a href="noStartProject.jsp">Not Start</a></li>
                                    <li><a class="active" href="inProgressProject.jsp">In progress</a></li>
                                    <li><a href="successProject.jsp">Success</a></li>
                                    <li><a href="failProject.jsp">Fail</a></li>
                                </ul>
                            </div>
                            <form class="editform">
                                <div class="modal fade" data-backdrop='static' id="editmodal">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <h3 class="modal-title">Add Task</h3>
                                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                    <span aria-hidden="true">&times;</span>
                                                </button>
                                            </div>

                                            <div class="modal-body">
                                                <div class="form-group">
                                                    <label for="Task">Task Description:</label>
                                                    <input type="text" class="form-control" id="Task1" name="TaskDesc1">
                                                </div>
                                                <div id="task-container"></div>
                                            </div>

                                            <div class="modal-footer">
                                                <input type="submit" value="Save" class="btn btn-warning" />
                                                <input type="reset" value="More" id="more" class="btn btn-danger"/>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div>
                        <div class="col-xl-12 col-sm-12 col-12 mb-4">
                            <div class="card">
                                <div class="table-heading">
                                    <h2>All Projects</h2>
                                </div>
                                <div class="table-responsive">
                                    <table id="example" class="display" style="width:100%">
                                        <thead>
                                            <tr>
                                                <th>STT</th>
                                                <th>Project Name</th>
                                                <th>Start Date</th>
                                                <th>End Date</th>
                                                <th>Tech Stack</th>
                                                <th>Description</th>
                                                <th>Action</th>
                                            </tr>
                                        </thead>
                                        <tbody>

                                    </table>
                                </div>
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