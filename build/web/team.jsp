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
        <style>
            .btn-add-e{
                color: #000;
                display: inline-block;
                margin: 15px 0;
                text-align: center;
                padding: 12px;
                font-size: 14px;
                border-radius: 10px;
                background-color: #009efb

            }
            .employee-head ul div{
                padding: 10px;
                border-radius: 6px;
                border-color: #000;
                background-color: #e3e3e3e6;
                color: #00882e;
                font-style: normal;
                text-transform: uppercase;
                border-bottom: solid;
                -webkit-text-stroke: thin;
            }
            .decription{
                -webkit-text-stroke: thin;
            }
            .viewteam{

                text-align: end;

            }
            a {
                color: #eee;
            }
            .customize_popup .close {
                margin-left: auto;
            }
        </style>
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
                                <li>
                                    <a href="employee.jsp"><img src="assets/img/employee.svg" alt="sidebar_img"><span> Employees</span></a>
                                </li>
                                <li  class="active">
                                    <a href="teamcontroller"><img src="assets/img/group.png" alt="sidebar_img"> <span> Team</span></a>
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
                                    <li><a class="active" href="teamcontroller">Teams</a></li>
                                    <li><a href="employee-office.html">Offices</a></li>
                                </ul>
                                <div>                          
                                    <a class="btn-add" data-toggle="modal" data-target="#addteam"><i data-feather="plus"></i> Add Team</a>
                                </div>
                            </div>
                        </div>

                        <div class="col-xl-12 col-sm-12 col-12 ">
                            <div class="card m-0">
                                <div class="card-body pb-0">

                                    <div class="row">
                                        <c:set var="teams" value="${requestScope.list}"/>
                                        <c:if test="${not empty teams}">
                                            <c:forEach var="team" items="${teams}">    
                                                <div class="col-xl-6">
                                                    <div class="card">
                                                        <div class="card-header">
                                                            <div class="employee-head">

                                                                <h2>${team.getName_Team()}</h2>


                                                                <ul>  
                                                                    <li><div class="edit_delete" ><c:if test= "${team.getStatus_ID() == 1}"> Processing  </c:if>
                                                                            <c:if test= "${team.getStatus_ID() == 2}"> complete  </c:if> </div>  </li>
                                                                        <li><a class="edit_employee" data-toggle="modal" data-target="#edit"><i data-feather="edit"></i></a></li>
                                                                        <li><a class="edit_delete" data-toggle="modal" data-target="#delete"><i data-feather="trash-2"></i></a></li>

                                                                    </ul>
                                                                </div>
                                                            </div>
                                                            <div  class="card-body">
                                                                <div  class="employee-content">
                                                                    <div class="col-6" class="employee-image">
                                                                        <div class="avatar-group">
                                                                            <div class="avatar-group" >
                                                                                <div class="decription" >
                                                                                    <p> ${team.getDecription()}</p>
                                                                            </div>

                                                                        </div>
                                                                    </div>
                                                                </div>

                                                                <div class="viewteam" class="col-6">
                                                                    <a class="btn-addmember" href="memberservlet?teamId=${team.getID_Team()}">view Team</a>
                                                                </div>

                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="customize_popup">
                                                        <div class="modal fade" id="delete" tabindex="-1" aria-labelledby="staticBackdropLabels1" aria-hidden="true">
                                                            <div class="modal-dialog modal-dialog-centered ">
                                                                <div class="modal-content">
                                                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                                        <span aria-hidden="true">×</span>
                                                                    </button>
                                                                    <div class="modal-header text-centers border-0">
                                                                        <h5 class="modal-title text-center" id="staticBackdropLabels1">Are You Sure Want to Delete?</h5>
                                                                    </div>
                                                                    <div class="modal-footer text-centers">
                                                                        <form action="teamcontroller?action=delete&teamId=${team.getID_Team()}" method="POST">
                                                                            <button type="submit" class="btn btn-primary"> Delete</button>
                                                                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                                                                        </form>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="customize_popup">
                                                        <div class="modal fade" id="edit" tabindex="-1" aria-labelledby="staticBackdropLa" aria-hidden="true">
                                                            <div class="modal-dialog modal-lg modal-dialog-centered">
                                                                <div class="modal-content">
                                                                    <form action="editteams" >                         

                                                                        <div class="modal-header">
                                                                            <h5 class="modal-title" id="staticBackdropLa">Edit Employee</h5>
                                                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                                                <span aria-hidden="true">×</span>
                                                                            </button>
                                                                        </div>
                                                                        <div class="modal-body">
                                                                            <div class=" col-md-12 p-0">
                                                                                <div class=" form-popup m-0">
                                                                                    <input value="${team.getID_Team()}" name="TeamID" type="hidden" class="form-control" required placeholder="ID" >
                                                                                </div>
                                                                                <div class=" form-popup m-0">
                                                                                    <input value="${team.getName_Team()}" name="TeamName" type="text" class="form-control" required placeholder="Name" readonly  >
                                                                                </div>

                                                                                <div class=" form-popup m-0">
                                                                                    <input value="${team.getDecription()}" name="Decription" type="text" class="form-control" required  placeholder="Decription">
                                                                                </div>
                                                                                <div class=" form-popup m-0">
                                                                                    <select name="statusid" class="form-control" >
                                                                                        <c:if test= "${team.getStatus_ID() == 1}"><option value="1" selected=""> Processing</option>
                                                                                            <option value="2" > Complete </option>       </c:if>
                                                                                        <c:if test= "${team.getStatus_ID() == 2}"> <option value="2" selected=""> Complete </option>
                                                                                            <option value="1" > Processing</option></c:if>
                                                                                        </select>
                                                                                    </div>
                                                                                </div>
                                                                            </div>

                                                                            <div class="modal-footer">
                                                                                <button type="submit" class="btn btn-primary">Submit</button>
                                                                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                                                                            </div>
                                                                        </form>

                                                                    </div>

                                                                </div>                            
                                                            </div>
                                                        </div>
                                                    </div>
                                            </c:forEach>
                                        </c:if>  
                                    </div>



                                </div>
                            </div>


                        </div>
                    </div>
                </div>
            </div>
        </div>


        <form class="myform" action="addteam">
            <div class="customize_popup">
                <div class="modal fade" id="addteam" tabindex="-1" aria-labelledby="staticBackdropLabela" aria-hidden="true">
                    <div class="modal-dialog modal-lg modal-dialog-centered">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="staticBackdropLabela">New Team</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">×</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                <div class=" col-md-12 p-0">
                                    <div class=" form-popup m-0">
                                        <input type="text" placeholder="TeamID" id="TeamID" name="TeamID">
                                    </div>
                                    <div class=" form-popup m-0">
                                        <input type="text" placeholder="Name" id="TeamName" name="TeamName">
                                    </div>

                                    <div class=" form-popup m-0">
                                        <input type="text"  placeholder="Description" id="Description" name="Description"  >
                                    </div>
                                    <div class=" form-popup m-0">
                                        <select name="IDstatus" >   
                                            <option  value="" disabled selected>Status</option>
                                            <option value="1">Processing</option>
                                            <option value="2">Complete</option>
                                        </select>
                                    </div>
                                </div>

                            </div>

                            <div class="modal-footer">
                                <button type="submit" class="btn btn-primary">Add</button>
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                            </div>
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
