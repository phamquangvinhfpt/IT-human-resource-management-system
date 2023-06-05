<%-- 
    Document   : sidebar
    Created on : May 27, 2023, 3:16:26 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
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
                            <a href="ProjectManageServlet"><img src="assets/img/projectManage.svg" alt="sidebar_img"><span> Projects</span></a>
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
                        <form method="POST" action="mainController">
                            <li>
                                <button type="submit" name="btAction" value="Logout"><span>Log out</span></button>
                            </li>
                        </form>
                    </ul>
                </div>
            </div>
        </div>

    </body>
</html>
