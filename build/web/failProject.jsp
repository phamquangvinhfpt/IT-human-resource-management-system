<%-- 
    Document   : failProject
    Created on : Jun 18, 2023, 10:46:54 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
            function format(d) {
                return (
                        '<table cellpadding="5" cellspacing="0" border="0" style="padding-left:50px;">' +
                        '<tr>' +
                        '<td>Team: </td>' +
                        '<td>' +
                        d.team.Team_name +
                        '</td>' +
                        '</tr>' +
                        '<tr>' +
                        '<td>Description: </td>' +
                        '<td>' +
                        d.team.decs +
                        '</td>' +
//                        '</tr>' +
//                        '<tr>' +
//                        '<td>Project:</td>' +
//                        '<td>' + d.NameProject + '</td>' +
//                        '</tr>' +
//                        '<tr>' +
//                        '<td>Team:</td>' +
//                        '<td>' + d.Team_Name + '</td>' +
                        '</tr>' +
                        '</table>'
                        );
            }
            $(document).ready(function () {

                var table = $('#example').DataTable({
                    ajax: {
                        url: '/HRManagement/FailProjectServlet',
                        dataSrc: ''
                    },
                    columns: [
                        {
                            className: 'dt-control',
                            orderable: false,
                            data: null,
                            defaultContent: ''
                        },
                        {
                            data: null,
                            //set identity for row
                            render: function (data, type, row, meta) {
                                return meta.row + meta.settings._iDisplayStart + 1;
                            }
                        },
                        {
                            data: 'project.NameProject'
                        }
                        ,
                        {
                            data: 'project.startDate'
                        }
                        ,
                        {
                            data: 'project.endDate'
                        }
                        ,
                        {
                            data: 'project.techStack'
                        }
                        ,
                        {
                            data: 'project.decs'
                        }
                    ],
                    "order": [[1, 'asc']]

                });
                $('#example tbody').on('click', 'td.dt-control', function () {
                    var tr = $(this).closest('tr');
                    var row = table.row(tr);

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
                                    <li><a href="inProgressProject.jsp">In progress</a></li>
                                    <li><a href="successProject.jsp">Success</a></li>
                                    <li><a class="active" href="failProject.jsp">Fail</a></li>
                                </ul>
                            </div>
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
                                                <th></th>
                                                <th>STT</th>
                                                <th>Project Name</th>
                                                <th>Start Date</th>
                                                <th>End Date</th>
                                                <th>Tech Stack</th>
                                                <th>Description</th>
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
