<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Member</title>
        <link rel="shortcut icon" type="image/png" href="https://img.icons8.com/android/24/remove-user-male.png">
        <!-- Add these lines to your <head> element -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="assets/css/bootstrap.min.css">

        <link rel="stylesheet" href="assets/plugins/select2/css/select2.min.css">

        <link rel="stylesheet" href="assets/plugins/fontawesome/css/fontawesome.min.css">
        <link rel="stylesheet" href="assets/plugins/fontawesome/css/all.min.css">

        <link rel="stylesheet" href="assets/css/style.css">
        <style>
            .card_widget_header{
                text-align: -webkit-right;
            }
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

        <%
            String Team_ID = request.getParameter("teamid");
            request.setAttribute("Team_ID", Team_ID);
            RequestDispatcher dispatcher = request.getRequestDispatcher("addmember");
        %>
        <div class="main-wrapper">

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
                                        <button class="btn-add" data-toggle="modal" data-target="#addteam"><i data-feather="plus"></i> Add Member </button>


                                    </div>
                                </div>
                            </div>
                            <div class="col-xl-12 col-sm-12 col-12 mb-4">

                            </div>
                            <div class="col-xl-12 col-sm-12 col-12 mb-4">
                                <div  class="card" >
                                    <div class="table-heading">
                                        <h2>Member List</h2> 

                                    </div>
                                    <div class="table-responsive">
                                        <table class="table  custom-table no-footer">
                                            <thead>

                                                <tr>
                                                    <th>STT</th>
                                                    <th></th>
                                                    <th>Name</th>
                                                    <th>Role</th>

                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:set var="members" value="${requestScope.list}"/>
                                                <c:forEach var="member" items="${members}" varStatus="i">
                                                    <tr> 
                                                        <td><span class="ordinal_number">${i.index + 1}</span></td>
                                                        <td><a class="edit_employee" data-toggle="modal" data-target="#edit${team.getUserID()}"><i data-feather="edit"></i></a></td>
                                                        <td><label class="action_label">${member.getName()}</label></td>
                                                        <td><label class="action_label" > ${member.getRole()}</label></td>

                                                        <td> 
                                                            <div class="card-body">
                                                                <div class="card_widget_header">
                                                                    <a class="edit_delete" data-toggle="modal" data-target="#delete${team.getUserID()}" ><i data-feather="trash-2"></i></a></li>
                                                                </div>
                                                            </div>
                                                        </td>

                                                    </tr>
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

                                                                    <form action="memberservlet?action=delete&userid=${member.getUserID()}" >
                                                                        <input name="teamid" value="${Team_ID}" type="hidden" >
                                                                        <button type="submit" class="btn btn-primary"> Delete</button>
                                                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                                                                    </form>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>   

                                                <div class="customize_popup">
                                                    <div class="modal" id="edit" tabindex="-1" aria-labelledby="staticBackdropLa" aria-hidden="true">
                                                        <div class="modal-dialog modal-lg ">
                                                            <div class="modal-content">
                                                                <div class="modal-header">
                                                                    <h5 class="modal-title" id="staticBackdropLa">Profile member</h5>
                                                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                                        <span aria-hidden="true">×</span>
                                                                    </button>
                                                                </div>
                                                                <div class="modal-body">
                                                                    <div class="row">
                                                                        <div class="col-md-12">
                                                                            <div class="form-group">
                                                                                <label for="teamname">Team Name</label>
                                                                                <input type="text" class="form-control" value="${member.getName()}" readonly>
                                                                            </div>
                                                                        </div>
                                                                        <div class="col-md-12">
                                                                            <div class="form-group">
                                                                                <label for="teamname">Phone</label>
                                                                                <input type="text" class="form-control" value="${member.getPhone()}" readonly>
                                                                            </div>
                                                                        </div>
                                                                        <div class="col-md-12">
                                                                            <div class="form-group">
                                                                                <label for="teamname">Email</label>
                                                                                <input type="text" class="form-control" value="${member.getEmail()}" readonly>
                                                                            </div>
                                                                        </div>

                                                                        <div class="col-md-12">
                                                                            <div class="form-group">
                                                                                <label for="teamname">Address</label>
                                                                                <input type="text" class="form-control" value="${member.getAddress()}" readonly>
                                                                            </div>
                                                                        </div>
                                                                        <div class="col-md-12">
                                                                            <div class="form-group">
                                                                                <label for="teamname">Birthday</label>
                                                                                <input type="text" class="form-control" value="${member.getBirthday()}" readonly>
                                                                            </div>
                                                                        </div>
                                                                        <div class="col-md-12">
                                                                            <div class="form-group">
                                                                                <label for="teamname">Role</label>
                                                                                <input type="text" class="form-control" value="${member.getRole()}" readonly>
                                                                            </div>
                                                                        </div>

                                                                    </div>
                                                                </div>
                                                            </div>

                                                        </div>
                                                    </div>
                                                </div>
                                            </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>

                            </div>

                        </div>
                        <button class="btn btn-danger" onclick="window.location.href = 'teamcontroller';">Back</button>
                    </div>
                </div>
            </div>  

            <c:set var="users" value="${requestScope.user}"/>
            <c:forEach var="users" items="${users}"  varStatus="i">
                <form class="myform" action="addmember">
                    <div class="customize_popup">
                        <div class="modal fade" id="addteam" tabindex="-1" aria-labelledby="staticBackdropLabela" aria-hidden="true">
                            <div class="modal-dialog modal-lg modal-dialog-centered">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="staticBackdropLabela">New Member</h5>
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                            <span aria-hidden="true">×</span>
                                        </button>
                                    </div>

                                    <div class="modal-body">

                                        <div class=" form-popup m-0" style="border: ;" >
                                            <span class="ordinal_number">${i.index + 1}</span>
                                            <input name="teamid" value="${Team_ID}" type="hidden" >
                                            <input name="userid" value="${users.getUserID()}" type="hidden">
                                            <span style="border: outset; padding: 5px;margin: 30px;">${users.getName()}</span>
                                            <button type="submit" style="float: right; color: white; background-color: transparent; border: none;">
                                                <img src="https://img.icons8.com/color/48/add-user-male--v1.png" alt="Remove Icon" style="width: 1.5rem; height: 1.5rem;">
                                            </button>                                          
                                        </div>

                                    </div>

                                </div>
                            </div> 
                        </div>
                    </div>
                </form>
            </c:forEach>
            <script src="assets/js/jquery-3.6.0.min.js"></script>

            <script src="assets/js/popper.min.js"></script>
            <script src="assets/js/bootstrap.min.js"></script>

            <script src="assets/js/feather.min.js"></script>

            <!--<script src="assets/plugins/slimscroll/jquery.slimscroll.min.js"></script>-->

            <script src="assets/plugins/select2/js/select2.min.js"></script>
            <script src="assets/js/script.js"></script>
    </body>

</html>
