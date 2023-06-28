<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Team</title>
        <link rel="shortcut icon" type="image/png" href="assets/img/group.png">

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
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

        <!-- Define the modal dialog -->
    <div id="myModal" class="modal">
        <div class="modal-content">
            <p>Product inserted successfully!</p>
        </div>
    </div>

    <!-- Add a script to handle the button click and show the modal dialog -->
    <script>
        $(document).ready(function () {
            $("#myBtn").click(function () {
                // Show the modal dialog
                $("#myModal").show();
                // Hide the modal dialog after 3 seconds
                setTimeout(function () {
                    $("#myModal").hide();
                }, 3000);
            });
        });
        // When the form is submitted and the team is successfully added
              $('#success').modal('show');
    </script>
</head>
<body>
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
                                        <c:forEach var="team" items="${teams}">    
                                            <div class="col-xl-6">
                                                <div class="card">
                                                    <div class="card-header">
                                                        <div class="employee-head">
                                                            <h2>${team.getName_Team()}</h2>
                                                            <ul>  
                                                                <li><a class="edit_employee" data-toggle="modal" data-target="#edit${team.getID_Team()}"><i data-feather="edit"></i></a></li>
                                                                <li><a class="edit_delete" data-toggle="modal" data-target="#delete${team.getID_Team()}"><i data-feather="trash-2"></i></a></li>
                                                            </ul>
                                                        </div>
                                                    </div>
                                                    <div class="card-body">
                                                        <div class="employee-content">
                                                            <div class="col-6 employee-image">
                                                                <div class="avatar-group">
                                                                    <div class="avatar-group">
                                                                        <div class="decription">
                                                                            <p>${team.getDecription()}</p>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="col-6 viewteam"> 
                                                                <a  class="btn-addmember" href="teammemberservlet?teamid=${team.getID_Team()}">view Team</a> 
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>

                                            <div class="customize_popup">
                                                <div class="modal fade" id="delete${team.getID_Team()}" tabindex="-1" aria-labelledby="staticBackdropLabels1" aria-hidden="true">
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
                                                <div class="modal fade" id="edit${team.getID_Team()}" tabindex="-1" aria-labelledby="staticBackdropLa" aria-hidden="true">
                                                    <div class="modal-dialog modal-lg modal-dialog-centered">
                                                        <div class="modal-content">
                                                            <form action="editteams" >                         

                                                                <div class="modal-header">
                                                                    <h5 class="modal-title" id="staticBackdropLa">Edit Team</h5>
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
                                                                            <input value="${team.getName_Team()}" name="TeamName" type="text" class="form-control" required placeholder="Name"  dropzone>
                                                                        </div>

                                                                        <div class=" form-popup m-0">
                                                                            <input value="${team.getDecription()}" name="Decription" type="text" class="form-control" required  placeholder="Decription">
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





                                        </c:forEach>
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
                                    <div class="col-md-12 p-0">
                                        <div class="form-popup m-0">
                                            <input type="text" id="inputEmail" placeholder="TeamID" id="TeamID" name="TeamID">
                                        </div>
                                        <div class="form-popup m-0">
                                            <input type="text" id="inputEmail" placeholder="Name" id="TeamName" name="TeamName">
                                        </div>
                                        <div class="form-popup m-0">
                                            <input type="text" id="inputEmail" placeholder="Description" id="Description" name="Description">
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
