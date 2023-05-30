<%-- 
    Document   : admin
    Created on : May 16, 2023, 4:49:17 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Page</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="assets/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets/plugins/fontawesome/css/fontawesome.min.css">
        <link rel="stylesheet" href="assets/plugins/fontawesome/css/all.min.css">
        <link rel="stylesheet" href="assets/css/style.css">
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
                    <div class="page-name 	mb-4">
                        <h4 class="m-0"><img src="assets/img/profile.jpg" class="mr-1" alt="profile" /> Welcome Admin</h4>
                        <label id='date-time'></label>
                    </div>
                    <div class="row mb-4">
                        <div class="col-xl-12 col-sm-12 col-12">
                            <div class="breadcrumb-path ">
                                <ul class="breadcrumb">
                                    <li class="breadcrumb-item"><a href="index.html"><img src="assets/img/dash.png" class="mr-3" alt="breadcrumb" />Home</a>
                                    </li>
                                    <li class="breadcrumb-item active">Dashboard</li>
                                </ul>
                                <h3>Admin Dashboard</h3>
                            </div>
                        </div>
                    </div>
                    <div class="row mb-4">
                        <div class="col-xl-3 col-sm-6 col-12">
                            <div class="card board1 fill1 ">
                                <div class="card-body">
                                    <div class="card_widget_header">
                                        <label>Employees</label>
                                        <h4>700</h4>
                                    </div>
                                    <div class="card_widget_img">
                                        <img src="assets/img/dash1.png" alt="card-img" />
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-xl-3 col-sm-6 col-12">
                            <div class="card board1 fill2 ">
                                <div class="card-body">
                                    <div class="card_widget_header">
                                        <label>Team</label>
                                        <h4>30</h4>
                                    </div>
                                    <div class="card_widget_img">
                                        <img src="assets/img/group.png" alt="card-img" />
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-xl-3 col-sm-6 col-12">
                            <div class="card board1 fill3 ">
                                <div class="card-body">
                                    <div class="card_widget_header">
                                        <label>Leaves</label>
                                        <h4>9</h4>
                                    </div>
                                    <div class="card_widget_img">
                                        <img src="assets/img/dash3.png" alt="card-img" />
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-xl-3 col-sm-6 col-12">
                            <div class="card board1 fill4 ">
                                <div class="card-body">
                                    <div class="card_widget_header">
                                        <label>Salary</label>
                                        <h4>$5.8M</h4>
                                    </div>
                                    <div class="card_widget_img">
                                        <img src="assets/img/dash4.png" alt="card-img" />
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xl-6 d-flex mobile-h">
                            <div class="card flex-fill">
                                <div class="card-header">
                                    <div class="d-flex justify-content-between align-items-center">
                                        <h5 class="card-title">Total Employees</h5>
                                    </div>
                                </div>
                                <div class="card-body">
                                    <div id="invoice_chart"></div>
                                    <div class="text-center text-muted">
                                        <div class="row">
                                            <div class="col-4">
                                                <div class="mt-4">
                                                    <p class="mb-2 text-truncate"><i class="fas fa-circle text-primary mr-1"></i> Business</p>
                                                </div>
                                            </div>
                                            <div class="col-4">
                                                <div class="mt-4">
                                                    <p class="mb-2 text-truncate"><i class="fas fa-circle text-success mr-1"></i> Testing</p>
                                                </div>
                                            </div>
                                            <div class="col-4">
                                                <div class="mt-4">
                                                    <p class="mb-2 text-truncate"><i class="fas fa-circle text-danger mr-1"></i> Development</p>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-xl-6 d-flex">
                            <div class="card flex-fill">
                                <div class="card-header">
                                    <div class="d-flex justify-content-between align-items-center">
                                        <h5 class="card-title">Total Salary By Unit</h5>
                                    </div>
                                </div>
                                <div class="card-body">
                                    <div id="sales_chart"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xl-6 col-sm-12 col-12 d-flex">
                            <div class="card card-list flex-fill">
                                <div class="card-header ">
                                    <h4 class="card-title">Total Salary By Unit</h4>
                                </div>
                                <div class="card-body">
                                    <div class="team-list">
                                        <div class="team-view">
                                            <div class="team-img">
                                                <img src="assets/img/profiles/avatar-03.jpg" alt="avatar" />
                                            </div>
                                            <div class="team-content">
                                                <label>Maria Cotton</label>
                                                <span>PHP</span>
                                            </div>
                                        </div>
                                        <div class="team-action">
                                            <ul>
                                                <li><a><i data-feather="trash-2"></i></a></li>
                                                <li><a><i data-feather="edit-2"></i></a></li>
                                            </ul>
                                        </div>
                                    </div>
                                    <div class="team-list">
                                        <div class="team-view">
                                            <div class="team-img">
                                                <img src="assets/img/profiles/avatar-04.jpg" alt="avatar" />
                                            </div>
                                            <div class="team-content">
                                                <label>Linda Craver</label>
                                                <span>IOS</span>
                                            </div>
                                        </div>
                                        <div class="team-action">
                                            <ul>
                                                <li><a><i data-feather="trash-2"></i></a></li>
                                                <li><a><i data-feather="edit-2"></i></a></li>
                                            </ul>
                                        </div>
                                    </div>
                                    <div class="team-list">
                                        <div class="team-view">
                                            <div class="team-img">
                                                <img src="assets/img/profiles/avatar-06.jpg" alt="avatar" />
                                            </div>
                                            <div class="team-content">
                                                <label>Jenni Sims</label>
                                                <span>Android</span>
                                            </div>
                                        </div>
                                        <div class="team-action">
                                            <ul>
                                                <li><a><i data-feather="trash-2"></i></a></li>
                                                <li><a><i data-feather="edit-2"></i></a></li>
                                            </ul>
                                        </div>
                                    </div>
                                    <div class="team-list">
                                        <div class="team-view">
                                            <div class="team-img">
                                                <img src="assets/img/profiles/avatar-11.jpg" alt="avatar" />
                                            </div>
                                            <div class="team-content">
                                                <label>Danny</label>
                                                <span>Design</span>
                                            </div>
                                        </div>
                                        <div class="team-action">
                                            <ul>
                                                <li><a><i data-feather="trash-2"></i></a></li>
                                                <li><a><i data-feather="edit-2"></i></a></li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-xl-3 col-sm-12 col-12 d-flex">
                            <div class="card card-list flex-fill">
                                <div class="card-header">
                                    <div class="">
                                        <h4 class="card-title">Recent Activities</h3>
                                    </div>
                                </div>
                                <div class="card-body dash-activity">
                                    <div class="slimscroll activity_scroll">
                                        <div class="activity-set">
                                            <div class="activity-img">
                                                <img src="assets/img/profiles/avatar-02.jpg" alt="avatar">
                                            </div>
                                            <div class="activity-content">
                                                <label>Lorem ipsum dolor sit amet,</label>
                                                <span>2 hours ago</span>
                                            </div>
                                        </div>
                                        <div class="activity-set">
                                            <div class="activity-img">
                                                <img src="assets/img/profiles/avatar-05.jpg" alt="avatar">
                                            </div>
                                            <div class="activity-content">
                                                <label>Lorem ipsum dolor sit amet,</label>
                                                <span>3 hours ago</span>
                                            </div>
                                        </div>
                                        <div class="activity-set">
                                            <div class="activity-img">
                                                <img src="assets/img/profiles/avatar-07.jpg" alt="avatar">
                                            </div>
                                            <div class="activity-content">
                                                <label>Lorem ipsum dolor sit amet,</label>
                                                <span>4 hours ago</span>
                                            </div>
                                        </div>
                                        <div class="activity-set">
                                            <div class="activity-img">
                                                <img src="assets/img/profiles/avatar-08.jpg" alt="avatar">
                                            </div>
                                            <div class="activity-content">
                                                <label>Lorem ipsum dolor sit amet,</label>
                                                <span>5 hours ago</span>
                                            </div>
                                        </div>
                                        <div class="activity-set">
                                            <div class="activity-img">
                                                <img src="assets/img/profiles/avatar-09.jpg" alt="avatar">
                                            </div>
                                            <div class="activity-content">
                                                <label>Lorem ipsum dolor sit amet,</label>
                                                <span>6 hours ago</span>
                                            </div>
                                        </div>
                                        <div class="activity-set">
                                            <div class="activity-img">
                                                <img src="assets/img/profiles/avatar-10.jpg" alt="avatar">
                                            </div>
                                            <div class="activity-content">
                                                <label>Lorem ipsum dolor sit amet,</label>
                                                <span>2 hours ago</span>
                                            </div>
                                        </div>
                                        <div class="activity-set">
                                            <div class="activity-img">
                                                <img src="assets/img/profiles/avatar-12.jpg" alt="avatar">
                                            </div>
                                            <div class="activity-content">
                                                <label>Lorem ipsum dolor sit amet,</label>
                                                <span>3 hours ago</span>
                                            </div>
                                        </div>
                                        <div class="activity-set">
                                            <div class="activity-img">
                                                <img src="assets/img/profiles/avatar-13.jpg" alt="avatar">
                                            </div>
                                            <div class="activity-content">
                                                <label>Lorem ipsum dolor sit amet,</label>
                                                <span>4 hours ago</span>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="leave-viewall activit">
                                        <a>View all <img src="assets/img/right-arrow.png" class="ml-2" alt="arrow"></a>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-xl-3 col-sm-12 col-12 d-flex">
                            <div class="card card-list flex-fill">
                                <div class="card-header ">
                                    <h4 class="card-title-dash">Your Upcoming Leave</h4>
                                    <div class="dropdown">
                                        <button class="btn btn-action " type="button" id="roomsBtn" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                            <i class="fas fa-ellipsis-h"></i>
                                        </button>
                                        <div class="dropdown-menu" aria-labelledby="roomsBtn">
                                            <a class="dropdown-item" href="#">Action</a>
                                        </div>
                                    </div>
                                </div>
                                <div class="card-body p-0">
                                    <div class="leave-set">
                                        <span class="leave-inactive">
                                            <i class="fas fa-briefcase"></i>
                                        </span>
                                        <label>Mon, 16 Dec 2021</label>
                                    </div>
                                    <div class="leave-set">
                                        <span class="leave-active">
                                            <i class="fas fa-briefcase"></i>
                                        </span>
                                        <label>Fri, 20 Dec 2021</label>
                                    </div>
                                    <div class="leave-set">
                                        <span class="leave-active">
                                            <i class="fas fa-briefcase"></i>
                                        </span>
                                        <label>Wed, 25 Dec 2021</label>
                                    </div>
                                    <div class="leave-set">
                                        <span class="leave-active">
                                            <i class="fas fa-briefcase"></i>
                                        </span>
                                        <label>Fri, 27 Dec 2021</label>
                                    </div>
                                    <div class="leave-set">
                                        <span class="leave-active">
                                            <i class="fas fa-briefcase"></i>
                                        </span>
                                        <label>Tue, 31 Dec 2021</label>
                                    </div>
                                    <div class="leave-viewall">
                                        <a href="leave.html">View all <img src="assets/img/right-arrow.png" class="ml-2" alt="arrow" /></a>
                                    </div>
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

        <script src="assets/plugins/slimscroll/jquery.slimscroll.min.js"></script>

        <script src="assets/plugins/apexchart/apexcharts.min.js"></script>
        <script src="assets/plugins/apexchart/chart-data.js"></script>

        <script src="assets/js/script.js"></script>
        <script>
            var dt = new Date();
            document.getElementById('date-time').innerHTML = dt;
        </script>
    </body>
</html>
