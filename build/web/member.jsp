<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
    </head>
    <body>
        <div class="main-wrapper">

            <div class="header">

                <div class="header-left">
                    <a href="index.html" class="logo">
                        <span>HR Management</span>
                    </a>
                    <a href="index.html" class="logo logo-small">
                        <span>HRMS</span>
                    </a>
                    <a href="javascript:void(0);" id="toggle_btn">
                        <span class="bar-icon">
                            <span></span>
                            <span></span>
                            <span></span>
                        </span>
                    </a>
                </div>




                <div class="top-nav-search">
                    <form>
                        <input type="text" class="form-control" placeholder="">
                        <button class="btn" type="submit"><i class="fas fa-search"></i></button>
                    </form>
                </div>


                <a class="mobile_btn" id="mobile_btn">
                    <i class="fas fa-bars"></i>
                </a>


                <ul class="nav user-menu">

                    <li class="nav-item dropdown">
                        <a href="#" class="dropdown-toggle nav-link pr-0" data-toggle="dropdown">
                            <i data-feather="bell"></i> <span class="badge badge-pill"></span>
                        </a>
                        <div class="dropdown-menu notifications">
                            <div class="topnav-dropdown-header">
                                <span class="notification-title">Notifications</span>
                                <a href="javascript:void(0)" class="clear-noti"> Clear All</a>
                            </div>
                            <div class="noti-content">
                                <ul class="notification-list">
                                    <li class="notification-message">
                                        <a href="activities.html">
                                            <div class="media">
                                                <span class="avatar avatar-sm">
                                                    <img class="avatar-img rounded-circle" alt="" src="assets/img/profiles/avatar-02.jpg">
                                                </span>
                                                <div class="media-body">
                                                    <p class="noti-details"><span class="noti-title">Brian Johnson</span> paid the invoice <span class="noti-title">#DF65485</span></p>
                                                    <p class="noti-time"><span class="notification-time">4 mins ago</span></p>
                                                </div>
                                            </div>
                                        </a>
                                    </li>
                                    <li class="notification-message">
                                        <a href="activities.html">
                                            <div class="media">
                                                <span class="avatar avatar-sm">
                                                    <img class="avatar-img rounded-circle" alt="" src="assets/img/profiles/avatar-03.jpg">
                                                </span>
                                                <div class="media-body">
                                                    <p class="noti-details"><span class="noti-title">Marie Canales</span> has accepted your estimate <span class="noti-title">#GTR458789</span></p>
                                                    <p class="noti-time"><span class="notification-time">6 mins ago</span></p>
                                                </div>
                                            </div>
                                        </a>
                                    </li>
                                    <li class="notification-message">
                                        <a href="activities.html">
                                            <div class="media">
                                                <div class="avatar avatar-sm">
                                                    <span class="avatar-title rounded-circle bg-primary-light"><i class="far fa-user"></i></span>
                                                </div>
                                                <div class="media-body">
                                                    <p class="noti-details"><span class="noti-title">New user registered</span></p>
                                                    <p class="noti-time"><span class="notification-time">8 mins ago</span></p>
                                                </div>
                                            </div>
                                        </a>
                                    </li>
                                    <li class="notification-message">
                                        <a href="activities.html">
                                            <div class="media">
                                                <span class="avatar avatar-sm">
                                                    <img class="avatar-img rounded-circle" alt="" src="assets/img/profiles/avatar-04.jpg">
                                                </span>
                                                <div class="media-body">
                                                    <p class="noti-details"><span class="noti-title">Barbara Moore</span> declined the invoice <span class="noti-title">#RDW026896</span></p>
                                                    <p class="noti-time"><span class="notification-time">12 mins ago</span></p>
                                                </div>
                                            </div>
                                        </a>
                                    </li>
                                    <li class="notification-message">
                                        <a href="activities.html">
                                            <div class="media">
                                                <div class="avatar avatar-sm">
                                                    <span class="avatar-title rounded-circle bg-info-light"><i class="far fa-comment"></i></span>
                                                </div>
                                                <div class="media-body">
                                                    <p class="noti-details"><span class="noti-title">You have received a new message</span></p>
                                                    <p class="noti-time"><span class="notification-time">2 days ago</span></p>
                                                </div>
                                            </div>
                                        </a>
                                    </li>
                                </ul>
                            </div>
                            <div class="topnav-dropdown-footer">
                                <a href="activities.html">View all Notifications</a>
                            </div>
                        </div>
                    </li>


                    <li class="nav-item dropdown has-arrow main-drop">
                        <a href="#" class="dropdown-toggle nav-link" data-toggle="dropdown">
                            <span class="user-img">
                                <img src="assets/img/profile.jpg" alt="">
                                <span class="status online"></span>
                            </span>
                            <span>VinhPQ</span>
                        </a>
                        <div class="dropdown-menu">
                            <a class="dropdown-item" href="profile.html"><i data-feather="user" class="mr-1"></i> Profile</a>
                            <a class="dropdown-item" href="settings.html"><i data-feather="settings" class="mr-1"></i> Settings</a>
                            <a class="dropdown-item" href="login.html"><i data-feather="log-out" class="mr-1"></i> Logout</a>
                        </div>
                    </li>

                </ul>
                <div class="dropdown mobile-user-menu show">
                    <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><i class="fa fa-ellipsis-v"></i></a>
                    <div class="dropdown-menu dropdown-menu-right ">
                        <a class="dropdown-item" href="profile.html">My Profile</a>
                        <a class="dropdown-item" href="settings.html">Settings</a>
                        <a class="dropdown-item" href="login.html">Logout</a>
                    </div>
                </div>

            </div>


            <div class="sidebar" id="sidebar">
                <div class="sidebar-inner slimscroll">
                    <div class="sidebar-contents">
                        <div id="sidebar-menu" class="sidebar-menu">
                            <div class="mobile-show">
                                <div class="offcanvas-menu">
                                    <div class="user-info align-center bg-theme text-center">
                                        <span class="lnr lnr-cross  text-white" id="mobile_btn_close">X</span>
                                        <a href="javascript:void(0)" class="d-block menu-style text-white">
                                            <div class="user-avatar d-inline-block mr-3">
                                                <img src="assets/img/profiles/avatar-18.jpg" alt="user avatar" class="rounded-circle" width="50">
                                            </div>
                                        </a>
                                    </div>
                                </div>
                                <div class="sidebar-input">
                                    <div class="top-nav-search">
                                        <form>
                                            <input type="text" class="form-control" placeholder="Search here">
                                            <button class="btn" type="submit"><i class="fas fa-search"></i></button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                            <ul>
                                <li>
                                    <a href="admin.jsp"><img src="assets/img/home.svg" alt="sidebar_img"> <span>Dashboard</span></a>
                                </li>
                                <li class="active">
                                    <a href="employee.jsp"><img src="assets/img/employee.svg" alt="sidebar_img"><span> Employees</span></a>
                                </li>
                                <li>
                                    <a href="company.html"><img src="assets/img/group.png" alt="sidebar_img"> <span> Team</span></a>
                                </li>
                                <li>
                                    <a href="calendar.html"><img src="assets/img/calendar.svg" alt="sidebar_img"> <span>Calendar</span></a>
                                </li>
                                <li>
                                    <a href="leave.html"><img src="assets/img/leave.svg" alt="sidebar_img"> <span>Leave</span></a>
                                </li>
                                <li>
                                    <a href="review.html"><img src="assets/img/review.svg" alt="sidebar_img"><span>Review</span></a>
                                </li>
                                <li>
                                    <a href="report.html"><img src="assets/img/report.svg" alt="sidebar_img"><span>Report</span></a>
                                </li>
                                <li>
                                    <a href="manage.html"><img src="assets/img/manage.svg" alt="sidebar_img"> <span>Manage</span></a>
                                </li>
                                <li>
                                    <a href="settings.html"><img src="assets/img/settings.svg" alt="sidebar_img"><span>Settings</span></a>
                                </li>
                                <li>
                                    <a href="profile.html"><img src="assets/img/profile.svg" alt="sidebar_img"> <span>Profile</span></a>
                                </li>
                            </ul>
                            <ul class="logout">
                                <li>
                                    <a href="profile.html"><img src="assets/img/logout.svg" alt="sidebar_img"><span>Log out</span></a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>


            <div class="page-wrapper">
                <div class="content container-fluid">
                    <div class="row">
                        <div class="col-xl-12 col-sm-12 col-12">
                            <div class="breadcrumb-path mb-4">
                                <ul class="breadcrumb">
                                    <li class="breadcrumb-item"><a href="index.html"><img src="assets/img/dash.png" class="mr-2" alt="breadcrumb" />Home</a>
                                    </li>
                                    <li class="breadcrumb-item active"> Employees/ Teams</li>
                                </ul>
                                <h3>Team</h3>
                            </div>
                        </div>
                        <div class="col-xl-12 col-sm-12 col-12 mb-4">
                            <div class="head-link-set">
                                <ul>
                                    <li><a href="#">All</a></li>
                                    <li><a class="active" href="employee-team.html">Teams</a></li>
                                    <li><a href="employee-office.html">Offices</a></li>
                                </ul>
                                <div>                          
                                    <button class="btn-add" onclick="$('#mymodal').modal('show')"><i data-feather="plus"></i> Add Member </button>


                                </div>
                            </div>
                        </div>
                        <div class="col-xl-12 col-sm-12 col-12 mb-4">

                        </div>
                        <div class="col-xl-12 col-sm-12 col-12 mb-4">
                            <div class="card">
                                <div class="table-heading">
                                    <h2>Team List</h2>
                                </div>
                                <div class="table-responsive">
                                    <table class="table  custom-table no-footer">
                                        <thead>
                                            <tr>
                                                <th>ID Member</th>
                                                <th>Name</th>
                                                <th>NumberPhone</th>
                                                <th>Email</th>

                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:set var="members" value="${requestScope.list}"/>
                                            <c:if test="${not empty members}">
                                                <c:forEach var="member" items="${members}">
                                                    <tr>
                                                        <td>${member.getUserID()}</td>
                                                        <td><label class="action_label">${team.getName()}</label></td>
                                                        <td>${member.getPhone()}</td>
                                                        <td>${member.getEmail()}</td>

                                                        <td> 
                                                            <div class="card-body">
                                                                <div class="card_widget_header">
                                                                    <a href="teamcontroller?action=delete&teamId=${member.getUserID()}">Delete</a>
                                                                </div>
                                                            </div>
                                                        </td>

                                                    </tr>
                                                </c:forEach>
                                            </c:if>

                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                    <button class="btn btn-danger" onclick="window.history.back()">Back</button>
                </div>
            </div>
        </div>  

        <form class="myform" action="addteam">
            <div class="modal fade" data-backdrop='static' id="mymodal">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h3 class="modal-title">Add New member</h3>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>

                        <div class="modal-body">
                            <div class="form-group">
                                <label for="TeamID">ID_Member:</label>
                                <input type="number"  id="TeamID" name="TeamID">
                            </div>
                            <div class="form-group">
                                <label for="TeamName">NameMember</label>
                                <input type="text"  id="TeamName" name="TeamName">
                            </div>

                        </div>

                        <div class="modal-footer">
                            <input type="submit" value="Add" class="btn btn-primary" />
                            <input type="reset" value="Reset" class="btn btn-danger" />
                        </div>
                    </div>
                </div> 
            </div>
        </form>

        <script src="assets/js/jquery-3.6.0.min.js"></script>

        <script src="assets/js/popper.min.js"></script>
        <script src="assets/js/bootstrap.min.js"></script>

        <script src="assets/js/feather.min.js"></script>

        <!--<script src="assets/plugins/slimscroll/jquery.slimscroll.min.js"></script>-->

        <script src="assets/plugins/select2/js/select2.min.js"></script>
        <script src="assets/js/script.js"></script>
    </body>

</html>
