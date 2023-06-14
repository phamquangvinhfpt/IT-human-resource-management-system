<%-- 
    Document   : leave_request
    Created on : Jun 13, 2023, 3:08:47 PM
    Author     : Admin
--%>

<%@page import="java.util.List"%>
<%@page import="sample.dao.LeaveDAO"%>
<%@page import="sample.dto.LeaveTypes"%>
<%@page import="sample.dto.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Leave Page</title>
        <link rel="shortcut icon" href="assets/img/favicon.png">
        <link rel="stylesheet" href="assets/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets/plugins/select2/css/select2.min.css">
        <link rel="stylesheet" href="assets/plugins/fontawesome/css/fontawesome.min.css">
        <link rel="stylesheet" href="assets/plugins/fontawesome/css/all.min.css">
        <link rel="stylesheet" href="assets/css/style.css">
        <link rel="stylesheet" href="https://cdn.datatables.net/1.13.4/css/jquery.dataTables.css" />
        <link rel="stylesheet" href="https://cdn.datatables.net/1.13.4/css/jquery.dataTables.min.css" />
        <script src="assets/js/jquery-3.6.0.min.js"></script>
        <script src="https://cdn.datatables.net/1.13.4/js/jquery.dataTables.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
        <style>
            input[type="date"] {
                width: 100%;
                padding: 0.375rem 0.75rem;
                font-size: 1rem;
                line-height: 1.5;
                color: #495057;
                background-color: #fff;
                background-clip: padding-box;
                border: 1px solid #ced4da;
                border-radius: 0.25rem;
                transition: border-color 0.15s ease-in-out, box-shadow 0.15s ease-in-out;
            }

            /* Optional: Add this to center align the date input */
            input[type="date"]::-webkit-inner-spin-button,
            input[type="date"]::-webkit-calendar-picker-indicator {
                display: block;
                margin: 0 auto;
            }
        </style>
        <script>

            $(document).ready(function () {
                $('#example').DataTable({
                ajax: {
                url: '/HRManagement/leaveRequestPage',
                        dataSrc: ''
                },
                        "columnDefs": [
                        {"className": "dt-center", "targets": "_all"}
                        ],
                        columns: [
                        {data: null,
                                //set identity for row
                                render: function (data, type, row, meta) {
                                return meta.row + meta.settings._iDisplayStart + 1;
                                }
                        },
                        {data: 'LeaveTypeName'},
                        {data: 'StartDate'},
                        {data: 'EndDate'},
                        {data: 'time_req'},
                        {data: 'Reason'},
                        {data: 'Status'}
                        ],
                        "order": [[0, "asc"]]
                        });
                    });

                    $(document).ready(function () {
                        $(".myform").on("submit", function (e) {
                            e.preventDefault();
                            $.ajax({
                                method: "POST",
                                url: "/HRManagement/leaveServlet",
                                data: new FormData(this),
                                processData: false,
                                contentType: false,
                                success: function (res) {
                                    //console res to see what the servlet sent back
                                    console.log(res);
                                    if (res === `"success"`) {
                                        swal.fire({
                                            title: "Success!",
                                            text: "Your request has been sent!",
                                            icon: "success",
                                            button: "OK"
                                        }).then((value) => {
                                            //click oke will hide modal and reload datatable
                                            $('#example').DataTable().ajax.reload();
                                        });
                                    } else {
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
                                    swal.fire({
                                        title: "Error!",
                                        text: "Something went wrong!",
                                        icon: "error",
                                        button: "OK!"
                                    });
                                }
                            });
                        });
                    });
        </script>
    </head>
    <body>
        <%
            User user = (User) session.getAttribute("user");
            int leave_balance = 0;
            if (user == null) {
                response.sendRedirect("login.jsp");
            } else {
                leave_balance = user.getLeaveBalances();
            }
        %>
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
                        <div class="col-xl-12 col-sm-12 col-12 mb-4">
                            <div class="breadcrumb-path ">
                                <ul class="breadcrumb">
                                    <li class="breadcrumb-item"><a href="admin.jsp"><img src="assets/img/dash.png" class="mr-2" alt="breadcrumb">Home</a>
                                    </li>
                                    <li class="breadcrumb-item active"> Leave</li>
                                </ul>
                                <h3>Leave</h3>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-xl-12 col-sm-12 col-12 ">
                            <div class="card">
                                <div class="card-header">
                                    <h2 class="card-titles">Apply Leaves</h2>
                                </div>
                                <div class="form-creation">
                                    <form class="myform">
                                        <div class="row">
                                            <div class="col-xl-6 col-sm-6 col-12 ">
                                                <div class="form-group">
                                                    <label>Leave Type <span class="mandatory">*</span> </label>
                                                    <select class="select" name="leavetype">
                                                        <%
                                                            List<LeaveTypes> leaveTypes = LeaveDAO.getListLeaveType();
                                                            for (LeaveTypes leaveType : leaveTypes) {
                                                        %>
                                                        <option value="<%=leaveType.getLeaveTypeName()%>"><%=leaveType.getLeaveTypeName()%></option>
                                                        <%
                                                            }
                                                        %>
                                                    </select>
                                                </div>
                                            </div>
                                            <div class="col-xl-6 col-sm-6 col-12 ">
                                                <div class="form-group">
                                                    <label>Remaining Leaves</label>
                                                    <input type="text" value="<%= leave_balance%>" disabled>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-xl-6 col-sm-12 col-12 ">
                                                <div class="form-group">
                                                    <label>From </label>
                                                    <input type="date" name="StartDate">
                                                </div>
                                            </div>
                                            <div class="col-xl-6 col-sm-12 col-12 ">
                                                <div class="form-group">
                                                    <label>To</label>
                                                    <input type="date" name="EndDate">
                                                </div>
                                            </div>
                                        </div>

                                        <div class="row">
                                            <div class="col-xl-12 col-sm-12 col-12 ">
                                                <div class="form-group">
                                                    <label>Reason </label>
                                                    <textarea rows="4" cols="50" name="reason">	</textarea>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-xl-12 col-sm-12 col-12 ">
                                                <div class="form-btn">
                                                    <button class="btn btn-apply">Apply</button>
                                                </div>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-xl-12 col-sm-12 col-12 ">
                            <div class="card ">
                                <div class="card-header">
                                    <h2 class="card-titles">Leave Details</h2>
                                </div>
                                <div class="card-body p-0">
                                    <div class="table-responsive">
                                        <table id="example" class="display" style="width:100%">
                                            <thead>
                                                <tr>
                                                    <th>STT</th>
                                                    <th>Leave Type</th>
                                                    <th>From</th>
                                                    <th>To</th>
                                                    <th>Days</th>
                                                    <th>Notes</th>
                                                    <th>Status</th>
                                                </tr>
                                            </thead>
                                            <tbody>

                                            </tbody>
<!--                                            <tfoot>
                                                <tr>
                                                    <th>STT</th>
                                                    <th>Leave Type</th>
                                                    <th>From</th>
                                                    <th>To</th>
                                                    <th>Days</th>
                                                    <th>Notes</th>
                                                    <th>Status</th>
                                                </tr>
                                            </tfoot>-->
                                        </table>
                                    </div>
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
        <script src="assets/plugins/select2/js/select2.min.js"></script>
        <script src="assets/js/script.js"></script>
    </body>
</html>
