<%-- 
    Document   : login
    Created on : May 27, 2023, 3:19:34 PM
    Author     : Admin
--%>

<%@page import="sample.dto.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <!--===============================================================================================-->	
        <link rel="icon" type="image/png" href="assets/img/icons/favicon.ico"/>
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="assets/vendor/bootstrap/css/bootstrap.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="assets/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="assets/fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="assets/vendor/animate/animate.css">
        <!--===============================================================================================-->	
        <link rel="stylesheet" type="text/css" href="assets/vendor/css-hamburgers/hamburgers.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="assets/vendor/animsition/css/animsition.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="assets/vendor/select2/select2.min.css">
        <!--===============================================================================================-->	
        <link rel="stylesheet" type="text/css" href="assets/vendor/daterangepicker/daterangepicker.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="assets/css/util.css">
        <link rel="stylesheet" type="text/css" href="assets/css/main.css">

        <!--===============================================================================================-->
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        <script src="https://code.jquery.com/jquery-3.5.1.js"></script>

        <script>
            $(document).ready(function () {
                //add event listener for form submit
                $("form").submit(function (event) {
                    //prevent the form from submitting
                    event.preventDefault();
                    $.ajax({
                        url: "/HRManagement/loginServlet",
                        type: "GET",
                        data: {
                            username: $("input[name='username']").val(),
                            password: $("input[name='password']").val(),
                            btAction: $("input[name='btAction']").val()
                        },
                        dataType: 'json',
                        success: function (response) {
                            if (response.success) {
                                if (response.role === 'admin') {
                                    
                                    swal({
                                        title: "Login Success!",
                                        text: "Welcome!",
                                        icon: "success",
                                        button: "OK"
                                    }).then((value) => {
                                        window.location.href = 'admin.jsp';
                                    });
                                } else {
                                    swal({
                                        title: "Login Success!",
                                        text: "Welcome!",
                                        icon: "success",
                                        button: "OK"
                                    }).then((value) => {
                                        window.location.href = 'leave_request.jsp';
                                    });
                                }
                            } else {
                                swal({
                                    title: "Login Failed!",
                                    text: "Username or password is incorrect!",
                                    icon: "error",
                                    button: "OK"
                                }).then((value) => {
                                    window.location.href = 'login.jsp';
                                });
                            }
                        },
                        error: function () {
                            swal('Error!', 'An error occurred while logging in', 'error');
                        }
                    });
                });
            });
        </script>
    </head>

    <body>
        <%
            User user = (User) session.getAttribute("user");
        %>
        <%
            String error_message = (String) request.getAttribute("error");
            if (error_message == null) {
                error_message = "";
            }
        %>
        <div class="limiter">
            <div class="container-login100">
                <div class="wrap-login100">
                    <div class="login100-form-title" style="background-image: url(images/bg-01.jpg);">
                        <span class="login100-form-title-1">
                            Sign In
                        </span>
                    </div>

                    <form class="login100-form validate-form">
                        <div class="wrap-input100 validate-input m-b-26" data-validate="Username is required">
                            <span class="label-input100">Username</span>
                            <input class="input100" type="text" name="username" placeholder="Enter username or Email">
                            <span class="focus-input100"></span>
                        </div>

                        <div class="wrap-input100 validate-input m-b-18" data-validate = "Password is required">
                            <span class="label-input100">Password</span>
                            <input class="input100" type="password" name="password" placeholder="Enter password">
                            <span class="focus-input100"></span>
                        </div>

                        <div class="flex-sb-m w-full p-b-30">
                            <div class="contact100-form-checkbox">
                                <input class="input-checkbox100" id="ckb1" type="checkbox" name="remember-me">
                                <label class="label-checkbox100" for="ckb1">
                                    Remember me
                                </label>
                            </div>

                            <div>
                                <a href="#" class="txt1">
                                    Forgot Password?
                                </a>
                            </div>
                        </div>

                        <div class="container-login100-form-btn">
                            <input type="submit" class="login100-form-btn" name="btAction" value="Sign in" />
                        </div>
                        <div style="color:red;"><%= error_message%></div>
                    </form>
                </div>
            </div>
        </div>

        <!--===============================================================================================-->
        <script src="assets/vendor/jquery/jquery-3.2.1.min.js"></script>
        <!--===============================================================================================-->
        <script src="assets/vendor/animsition/js/animsition.min.js"></script>
        <!--===============================================================================================-->
        <script src="assets/vendor/bootstrap/js/popper.js"></script>
        <script src="assets/vendor/bootstrap/js/bootstrap.min.js"></script>
        <!--===============================================================================================-->
        <script src="assets/vendor/select2/select2.min.js"></script>
        <!--===============================================================================================-->
        <script src="assets/vendor/daterangepicker/moment.min.js"></script>
        <script src="assets/vendor/daterangepicker/daterangepicker.js"></script>
        <!--===============================================================================================-->
        <script src="assets/vendor/countdowntime/countdowntime.js"></script>
        <!--===============================================================================================-->
        <script src="assets/js/main.js"></script>

    </body>
</html>
