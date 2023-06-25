<%-- Document : ProgressPage Created on : Jun 12, 2023, 9:53:43 AM Author : ADMIN --%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Progress Page</title>
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
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.1/moment.min.js"></script>

        <script>
            $(document).ready(function () {
                const urlParams = new URLSearchParams(window.location.search);
                const id = urlParams.get('id');
                $.ajax({
                    method: "POST",
                    url: "/HRManagement/ViewInProgressProjectServlet",
                    data: {
                        id: id
                    },
                    success: function (res) {
                        const data = JSON.parse(res);
                        const team = data.team;
                        const tasks = data.task;
                        const project = data.project;
                        let startDate = new Date(project.startDate);
                        let formattedStartDate = startDate.getDate() + "-" + (startDate.getMonth() + 1) + "-" + startDate.getFullYear();
                        let endDate = new Date(project.endDate);
                        let formattedEndDate = endDate.getDate() + "-" + (endDate.getMonth() + 1) + "-" + endDate.getFullYear();
                        document.getElementById("TeamName").innerHTML = "Team: " + team.Team_name;
                        document.getElementById("Desc").innerHTML = "Description: " + team.decs;
                        document.getElementById("Project").innerHTML = "Project: " + project.NameProject;
                        document.getElementById("SDate").innerHTML = "Start Date: " + formattedStartDate;
                        document.getElementById("EDate").innerHTML = "End Date: " + formattedEndDate;
                        var table = $('#example').DataTable({
                            data: tasks,
                            columns: [
                                {data: null,
                                    //set identity for row
                                    render: function (data, type, row, meta) {
                                        return meta.row + meta.settings._iDisplayStart + 1;
                                    }
                                },
                                {data: 'Desc'},
                                {data: 'EndDate',
                                    render: function (data, type, row) {
                                        var momentDate = moment(data);
                                        if (momentDate.isValid()) {
                                            return momentDate.format('DD-MM-YYYY');
                                        } else {
                                            return data;
                                        }
                                    }
                                },
                                {data: 'status',
                                    render: function (data, type, row) {
                                        if (data === 2) {
                                            return '<input type="checkbox" style="text-align:center; vertical-align:middle" value="3">';
                                        } else if (data === 3) {
                                            return '<span class="tab-select success">Success <i class="fa-solid fa-check text-success"></i></span>';
                                        }
                                    },
                                    createdCell: function (td, cellData, rowData, row, col) {
                                        if (cellData === 2) {
                                            $('input', td).on('change', function () {
                                                var taskId = rowData.ID;
                                                var projectId = rowData.Project_id;
                                                var isChecked = $(this).is(':checked');
                                                $.ajax({
                                                    method: 'POST',
                                                    url: '/HRManagement/FinishTaskServlet',
                                                    data: {
                                                        taskId: taskId,
                                                        projectId: projectId,
                                                        isChecked: isChecked
                                                    },
                                                    success: function (res) {
                                                        if (res === "success") {
                                                            swal.fire({
                                                                title: "Success!",
                                                                text: "Add success!",
                                                                icon: "success",
                                                                button: "OK"
                                                            }).then((value) => {
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

                                                    }
                                                });
                                            });
                                        }
                                    }
                                },
                                {data: null,
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
                        });
                        const tasksInProgress = data.tasksInProgress;
                        const tasksInSucc = data.tasksInSucc;
                        var pieCtx = document.getElementById("invoice_chart");
                        var pieConfig = {
                            colors: ['#ffbc34', '#22cc62'],
                            series: [tasksInProgress, tasksInSucc],
                            chart: {
                                fontFamily: 'Poppins, sans-serif',
                                height: 350,
                                type: 'donut',
                            },
                            labels: ['In Progress', 'Success'],
                            legend: {show: false},
                            responsive: [{
                                    breakpoint: 480,
                                    options: {
                                        chart: {width: 200},
                                        legend: {position: 'bottom'}
                                    }
                                }]
                        };
                        var pieChart = new ApexCharts(pieCtx, pieConfig);
                        pieChart.render();
                    },
                    error: function (error) {
                        console.log(error);
                        // handle error response
                    }
                });
                $('#example tbody').on('click', '.edit-btn', function () {
                    //get data of row which is clicked
                    var data = $('#example').DataTable().row($(this).parents('tr')).data();
                    //set id for button edit
                    var id = data.ID;
                    var projectId = data.Project_id;
                    $("#editmodal").modal("show");
                    //set title for modal
                    $("#Task").val(data.Desc);
                    $("#ED").val(moment(data.EndDate).format('YYYY-MM-DD'));
                    //import a input hidden to modal
                    $("#editmodal .modal-body").append("<input type='hidden' name='id' value='" + id + "'>");
                    $("#editmodal .modal-body").append("<input type='hidden' name='ProjectId' value='" + projectId + "'>");
                    //sent all data to server
                });
            });
            $(document).ready(function () {
                $(".editform").on("submit", function (e) {
                    e.preventDefault();
                    $.ajax({
                        method: "POST",
                        url: "/HRManagement/EditTaskServlet",
                        data: new FormData(this),
                        processData: false,
                        contentType: false,
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
                                    <li class="breadcrumb-item"><a href="admin.jsp><img
                                                                   src=" assets/img/dash.png" class="mr-2"
                                                                   alt="breadcrumb" />Home</a>
                                    </li>
                                    <li class="breadcrumb-item active"> Progress</li>
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
                                                    <input type="text" class="form-control" id="Task" name="TaskDesc">
                                                </div>
                                                <div class="form-group">
                                                    <label for="Date">End Date:</label>
                                                    <input type="date" class="form-control" id="ED" name="NewEndDate">
                                                </div>
                                            </div>

                                            <div class="modal-footer">
                                                <input type="submit" value="Save" class="btn btn-warning" />
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                    <div class="row">
                        <!--                        <div class="col-xl-6 d-flex mobile-h">-->
                        <div class="card flex-fill">
                            <div class="card-header">
                                <div class="d-flex justify-content-between align-items-center">
                                    <h5 class="card-title">Projects</h5>
                                </div>
                            </div>

                            <div class="card-body">
                                <div class="row">
                                    <div class="col-sm-6" style="border-style: inset; border-radius: 10px;">
                                        <div id="TeamName" style="font-size:150%; margin-top: 10px;">
                                        </div>
                                        <div id="Desc" style="font-size:150%; margin-top: 10px;"></div>
                                        <div></div>
                                        <div id="Project" style="font-size:150%; margin-top: 20px;"></div>
                                        <div id="SDate" style="font-size:150%; margin-top: 10px;"></div>
                                        <div id="EDate" style="font-size:150%; margin-top: 10px;"></div>
                                    </div>
                                    <div class="col-sm-6" style="border-style: outset; border-radius: 10px;">
                                        <div id="invoice_chart"></div>
                                        <div class="text-center text-muted">
                                            <div class="row">
                                                <div class="col-6">
                                                    <div class="mt-4">
                                                        <p class="mb-2 text-truncate"><i
                                                                class="fas fa-circle text-warning mr-1"></i> In
                                                            Progress
                                                        </p>
                                                    </div>
                                                </div>
                                                <div class="col-6">
                                                    <div class="mt-4">
                                                        <p class="mb-2 text-truncate"><i
                                                                class="fas fa-circle text-success mr-1"></i>
                                                            Success</p>
                                                    </div>
                                                </div>

                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-xl-12 col-sm-12 col-12 mb-4">
                            <div class="card">
                                <div class="table-heading">
                                    <h2>All Task</h2>
                                </div>
                                <div class="table-responsive">
                                    <table id="example" class="display" style="width:100%">
                                        <thead>
                                            <tr>
                                                <th>STT</th>
                                                <th>Description</th>
                                                <th>End Date</th>
                                                <th>Status</th>
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
        <script src="assets/plugins/apexchart/apexcharts.min.js"></script>
        <!-- <script src="assets/plugins/apexchart/chart-data.js"></script> -->
        <script src="assets/js/script.js"></script>
    </body>

</html>