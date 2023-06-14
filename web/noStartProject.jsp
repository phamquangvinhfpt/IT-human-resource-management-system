<%-- 
    Document   : noStartProject
    Created on : Jun 6, 2023, 8:20:48 PM
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
            $(document).ready(function () {
                $('#example').DataTable({
                    ajax: {
                        url: '/HRManagement/NoStartProject',
                        dataSrc: ''
                    },
                    columns: [
                        {data: null,
                            //set identity for row
                            render: function (data, type, row, meta) {
                                return meta.row + meta.settings._iDisplayStart + 1;
                            }
                        },
                        {data: 'NameProject'},
                        {data: 'startDate'},
                        {data: 'endDate'},
                        {data: 'techStack'},
                        {data: 'decs'},
                        {
                            data: null,
                            render: function (data, type, row) {
                                //set id for button = id of employee
                                return `
                       <button class="btn delete-btn" style="background-color: white;box-shadow: none">
    <i class="fa-solid fa-trash text-danger"></i>
</button>
                       <button class="btn edit-btn" style="background-color: white;box-shadow: none">
    <i class="fa-solid fa-pen-to-square text-primary"></i>
</button>
                   `;
                            }
                        }
                    ],
                    "order": [[1, 'asc']]
                });
                $('#example tbody').on('click', '.delete-btn', function () {
                    //get data of row which is clicked
                    var data = $('#example').DataTable().row($(this).parents('tr')).data();
                    //set id for button delete
                    var id = data.ProjectID;
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
                        confirmButtonText: 'Delete',
                        cancelButtonText: 'Cancel!',
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
                                action: "DELETE",
                                url: "/HRManagement/DeleteProjectServlet?id=" + id + "",
                                success: function (res) {
                                    console.log(res);
                                    //remove "" from string
                                    if (res === "success") {
                                        swal.fire({
                                            title: "Success!",
                                            text: "Delete success!",
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
                        } else if (result.dismiss === Swal.DismissReason.cancel) {
                            swalWithBootstrapButtons.fire(
                                    'Cancelled'
                                    );
                        }
                    });
                });
                $('#example tbody').on('click', '.edit-btn', function () {
                    //get data of row which is clicked
                    var data = $('#example').DataTable().row($(this).parents('tr')).data();
                    //set id for button edit
                    var id = data.ProjectID;
                    //console id of employee
                    console.log(id);
                    //show modal
                    $("#editmodal").modal("show");
                    //set title for modal
                    //import a input hidden to modal
                    $("#editmodal .modal-body").append("<input type='hidden' name='id' value='" + id + "'>");
                    $("#editmodal input[name='ProjectName']").val(data.NameProject);
                    $("#editmodal input[name='Description']").val(data.decs);
                    $("#editmodal input[name='SDate']").val(data.startDate);
                    $("#editmodal input[name='EDate']").val(data.endDate);
                    $("#editmodal input[name='TechS']").val(data.techStack);
                    //sent all data to server
                });

            });

            $(document).ready(function () {
                $(".myform").on("submit", function (e) {
                    e.preventDefault();
                    $.ajax({
                        method: "POST",
                        url: "/HRManagement/AddProjectServlet",
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
                                    <li class="breadcrumb-item"><a href="index.html"><img src="assets/img/dash.png"
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
                                    <li><a href="ProjectManage.jsp" id="allPro">All</a></li>
                                    <li><a href="inProgressServlet" id="inProgressbtn" >In progress</a></li>
                                    <li><a class="active" href="noStartProject.jsp" id="noStart">Not Start</a></li>
                                </ul>
                                <button class="btn-add" onclick="$('#mymodal').modal('show')"><i data-feather="plus"></i> Add Project</button>
                            </div>
                            <form action="mainController">
                                <div class="modal fade" data-backdrop='static' id="mymodal">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <h3 class="modal-title">Add New Project</h3>
                                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                    <span aria-hidden="true">&times;</span>
                                                </button>
                                            </div>

                                            <div class="modal-body">
                                                <div class="form-group">
                                                    <label for="ProjectName">Project Name:</label>
                                                    <input type="text" class="form-control" id="ProjectName" name="ProjectName">
                                                </div>
                                                <div class="form-group">
                                                    <label for="Description">Description:</label>
                                                    <input type="text" class="form-control" id="Description" name="Description">
                                                </div>
                                                <div class="form-group">
                                                    <label for="SDate">Start Date:</label>
                                                    <input type="date" class="form-control" id="SDate" name="SDate">
                                                </div>
                                                <div class="form-group">
                                                    <label for="EDate">End Date</label>
                                                    <input type="date" class="form-control" id="EDate" name="EDate">
                                                </div>
                                                <div class="form-group">
                                                    <label for="TechS">Tech Stack</label>
                                                    <input type="text" class="form-control" id="TechS" name="TechS">
                                                </div>
                                            </div>

                                            <div class="modal-footer">
                                                <input type="submit" value="addProject" class="btn btn-warning" name="btAction" />
                                                <input type="reset" value="Reset" class="btn btn-danger" />
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
