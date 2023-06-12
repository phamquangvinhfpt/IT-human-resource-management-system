<%-- 
    Document   : profile
    Created on : Jun 12, 2023, 12:35:17 AM
    Author     : Admin
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Date"%>
<%@page import="sample.dto.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profile</title>
        <link rel="stylesheet" href="assets/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets/plugins/fontawesome/css/fontawesome.min.css">
        <link rel="stylesheet" href="assets/plugins/fontawesome/css/all.min.css">
        <link rel="stylesheet" href="assets/css/style.css">
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
        <style>
            .edit-profile-wrapper {
                position: fixed;
                bottom: 20px;
                left: 50%;
                transform: translateX(-50%);
            }
            .edit-profile-btn {
                display: block;
                margin: auto;
                background-color: #007bff;
                color: #fff;
                border-radius: 5px;
                cursor: pointer;
            }
            .edit-profile-btn:hover {
                background-color: #0069d9;
            }
            .form-edit {
                display: none;
            }
        </style>
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
                <div class="container-fluid pt-3">
                    <div class="row">
                        <div class="col-md-3">
                            <div class="card">
                                <div class="card-body">
                                    <div class="text-center">
                                        <%
                                            User user = (User) session.getAttribute("user");
                                            if (user == null) {
                                                response.sendRedirect("login.jsp");
                                                //stop executing code by return
                                                return;
                                            }
                                            //get user info
                                            String name = user.getName();
                                            String role = user.getRole();
                                            String phone = user.getPhone();
                                            String email = user.getEmail();
                                            String address = user.getAddress();
                                            Date birthday = user.getBirthday();
                                            //parse date to string
                                            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                                            String birthDay = sdf.format(birthday);
                                            String project = user.getNameProject();
                                            String team = user.getTeam_Name();
                                            String image = user.getImage();
                                        %>
                                        <img src="images/<%=image%>" class="rounded-circle" width="150">
                                        <%-- Name --%>
                                        <h4 class="mt-2"><%=name%></h4>
                                        <p class="text-muted"></p>
                                    </div>
                                </div>
                            </div>
                            <div class="card mt-3">
                                <div class="card-body">
                                    <h5>Contact Information</h5>
                                    <hr>
                                    <div class="form-group">
                                        <label>Phone:</label>
                                        <p><%=phone%></p>
                                    </div>
                                    <div class="form-group">
                                        <label>Email:</label>
                                        <p><%=email%></p>
                                    </div>
                                    <div class="form-group">
                                        <label>Address:</label>
                                        <p><%=address%></p>
                                    </div>
                                    <div class="form-group">
                                        <label>Date of Birth:</label>
                                        <p><%=birthDay%></p>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-9">
                            <div class="col">
                                <div class="card">
                                    <div class="card-body">
                                        <h5>Work Information</h5>
                                        <hr>
                                        <div class="form-group">
                                            <label>Project:</label>
                                            <p><%=project%></p>
                                        </div>
                                        <div class="form-group">
                                            <label>Team:</label>
                                            <p><%=team%></p>
                                        </div>
                                        <div class="form-group">
                                            <label>Role:</label>
                                            <p><%=role%></p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col">
                                <div class="card form-edit" >
                                    <form id="edit">
                                        <div class="card-body">

                                            <h5>Edit profile</h5>
                                            <hr>
                                            <div class="form-group">
                                                <label for="name">Name:</label>
                                                <input type="text" class="form-control" id="editname" name="name">
                                            </div>
                                            <div class="form-group">
                                                <label for="name">Image:</label>
                                                <input type="file" class="form-control" id="editimage" name="image">
                                            </div>
                                            <div class="form-group">
                                                <label for="phone">Phone:</label>
                                                <input type="text" class="form-control" id="editphone" name="phone">
                                            </div>
                                            <div class="form-group">
                                                <label for="email">Email:</label>
                                                <input type="email" class="form-control" id="editemail" name="email">
                                            </div>
                                            <div class="form-group">
                                                <label for="address">Address:</label>
                                                <input type="text" class="form-control" id="editaddress" name="address">
                                            </div>
                                            <div class="form-group">
                                                <label for="birthday">Birthday:</label>
                                                <input type="date" class="form-control" id="editbirthday" name="birthday" onchange="formatDate(this)">
                                            </div>
                                            <div class="modal-footer">
                                                <input type="submit" value="Save" class="btn btn-primary" />
                                                <input type="reset" value="Reset" class="btn btn-danger" />
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="edit-profile-wrapper">
                    <input type="button" class="edit-profile-btn" value="Edit Profile">
                </div>
            </div>
        </div>
        <script src="assets/js/jquery-3.6.0.min.js"></script>
        <script src="assets/js/popper.min.js"></script>
        <script src="assets/js/bootstrap.min.js"></script>
        <script src="assets/js/feather.min.js"></script>
        <!--<script src="assets/plugins/slimscroll/jquery.slimscroll.min.js"></script>-->
        <script src="assets/js/script.js"></script>
        <script>
            $(document).ready(function () {
                $(".edit-profile-btn").click(function () {
                    $(".form-edit").show();
                    //hide button edit
                    $(".edit-profile-btn").hide();
                });
            });
            $(document).ready(function () {
                //get value from form
                $("#edit").submit(function (e) {
                    e.preventDefault();
                    var formData = new FormData(this);
                    //console id, team, project
                    $.ajax({
                method: "POST",
                url: "/HRManagement/EditProfileServlet",
                data: new FormData(this),
                processData: false,
                contentType: false,
                success: function (res) {
                    console.log(res);
                    //remove "" from string
                    if (res === `"Edit success"`) {
                        console.log(res);
                        swal.fire({
                            title: "Success!",
                            text: "Edit employee success!",
                            icon: "success",
                            button: "OK"
                        }).then((value) => {
                            //reload session
                            location.reload();
                        });
                    } else {
                        console.log(res);
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
    </body>
</html>
