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

        <%-- <script src="https://code.jquery.com/jquery-3.7.0.min.js"
            integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
        --%>
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
                        const amountOfTasks = data.taskCount;
                        const tasksInProgress = data.tasksInProgress;
                        var pieCtx = document.getElementById("invoice_chart");
                        var pieConfig = {
                            colors: ['#ffbc34', '#22cc62', '#ef3737'],
                            series: [tasksInProgress, amountOfTasks - tasksInProgress, 0],
                            chart: {
                                fontFamily: 'Poppins, sans-serif',
                                height: 350,
                                type: 'donut',
                            },
                            labels: ['In Progress', 'Success', 'Fail'],
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
                                                                   src="assets/img/dash.png" class="mr-2"
                                                                   alt="breadcrumb" />Home</a>
                                    </li>
                                    <li class="breadcrumb-item active"> Progress</li>
                                </ul>
                            </div>
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
                                <div id="invoice_chart"></div>
                                <div class="text-center text-muted">
                                    <div class="row">
                                        <div class="col-4">
                                            <div class="mt-4">
                                                <p class="mb-2 text-truncate"><i
                                                        class="fas fa-circle text-warning mr-1"></i> In Progress
                                                </p>
                                            </div>
                                        </div>
                                        <div class="col-4">
                                            <div class="mt-4">
                                                <p class="mb-2 text-truncate"><i
                                                        class="fas fa-circle text-success mr-1"></i> Success</p>
                                            </div>
                                        </div>
                                        <div class="col-4">
                                            <div class="mt-4">
                                                <p class="mb-2 text-truncate"><i
                                                        class="fas fa-circle text-danger mr-1"></i> Fail</p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
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
        <script src="assets/plugins/apexchart/apexcharts.min.js"></script>
        <!-- <script src="assets/plugins/apexchart/chart-data.js"></script> -->
        <script src="assets/js/script.js"></script>
    </body>

</html>