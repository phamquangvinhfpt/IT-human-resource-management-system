<%-- 
    Document   : report.jsp
    Created on : Jun 15, 2023, 12:07:57 AM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Report Page</title>
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
        <style>
            .limiter {
                background-color: red;
            }
            .container-login100 {
                width: 100%;
                min-height: 100vh;
                display: flex;
                flex-wrap: wrap;
                justify-content: center;
                align-items: center;
                padding: 15px;
            }
            .wrap-login100 {
                width: 100%;
                max-width: 1000px;
                background: #fff;
                border-radius: 10px;
                overflow: hidden;
                padding: 77px 55px 33px 55px;
            }
            .login100-form-title {
                display: flex;
                justify-content: center;
                align-items: center;
                margin-bottom: 55px;
            }
            .login100-form-title-1 {
                font-size: 50px;
                color: #fff;
                line-height: 1.2;
                text-align: center;
                background: #335333;
                padding: 20px 35px;
                border-radius: 10px;
            }
            .wrap-input100 {
                width: 100%;
                position: relative;
                border-bottom: 2px solid #d9d9d9;
                margin-bottom: 30px;
            }
            .label-input100 {
                font-size: 14px;
                color: #555555;
                line-height: 1.2;
                text-transform: uppercase;
            }
            .input100 {
                font-size: 16px;
                color: #333333;
                line-height: 1.2;
                display: block;
                width:100%;
                height: 50px;
                background: transparent;
                padding: 0 5px;
                border: none;
            }
            .focus-input100 {
                position: absolute;
                display: block;
                width: 100%;
                height: 100%;
                top: 0;
                left: 0;
                pointer-events: none;
                border-bottom: 2px solid #f44336;
                transition: all 0.4s;
                transform: scaleX(0);
                opacity: 0;
            }
            .input100:focus + .focus-input100 {
                transform: scaleX(1);
                opacity: 1;
            }
            .login100-form-btn {
                font-size: 16px;
                color: #fff;
                line-height: 1.2;
                text-transform: uppercase;
                width: 100%;
                height: 50px;
                border-radius: 25px;
                background: #f44336;
                display: flex;
                justify-content: center;
                align-items: center;
                padding: 0;
                border: none;
                cursor: pointer;
                transition: all 0.4s;
            }
            .login100-form-btn:hover {
                background: #333333;
            }
        </style>
    </head>
    <body>
        <div class="limiter">
            <div class="container-login100">
                <div class="wrap-login100">
                    <div class="login100-form-title" style="background-image: url(images/bg-01.jpg);">
                        <span class="login100-form-title-1">
                            Send An Application 
                        </span>
                    </div>

                    <form class="login100-form validate-form" method="GET" action="Report">
                        <div class="wrap-input100 validate-input m-b-26" data-validate="Application Type is required">
                            <span class="label-input100"> Type:</span>
                            <select class="input100" name="applicationtype">
                                <option value="">-- Select an option --</option>
                                <option value="don-xin-nghi">Đơn xin nghỉ</option>
                                <option value="don-khieu-nai">Đơn khiếu nại</option>
                                <option value="don-bao-cao-tien-do">Đơn báo cáo tiến độ</option>
                                <option value="don-gop-y">Đơn góp ý</option>
                                <option value="don-xin-chuyen-team">Đơn xin chuyển team</option>
                                <option value="don-xin-cap-quyen">Đơn xin cấp quyền</option>
                            </select>
                            <span class="focus-input100"></span>
                        </div>

                        <div class="wrap-input100 validate-input m-b-18" data-validate="Reason is required">
                            <span class="label-input100">Reason</span>
                            <textarea class="input100" name="reason" rows="8" placeholder="Enter reason"></textarea>
                            <span class="focus-input100"></span>
                        </div>

                        <div class="wrap-input100 validate-input m-b-18" data-validate="File is required">
                            <span class="label-input100">Upload File:</span>
                            <input class="input100" type="file" name="file" accept="*">
                            <span class="focus-input100"></span>
                        </div>


                        <div class="container-login100-form-btn">
                            <input type="submit" class="login100-form-btn" name="btAction" value="Send" />
                        </div>
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
