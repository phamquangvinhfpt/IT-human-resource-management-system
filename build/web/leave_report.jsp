<%-- 
    Document   : leave_report
    Created on : Jun 14, 2023, 12:45:34 PM
    Author     : Vinh
--%>

<%@page import="sample.dto.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="assets/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets/plugins/select2/css/select2.min.css">
        <link rel="stylesheet" href="assets/plugins/fontawesome/css/fontawesome.min.css">
        <link rel="stylesheet" href="assets/plugins/fontawesome/css/all.min.css">
        <link rel="stylesheet" href="assets/css/style.css">
        <link rel="stylesheet" href="https://cdn.datatables.net/1.13.4/css/jquery.dataTables.css" />
        <link rel="stylesheet" href="https://cdn.datatables.net/1.13.4/css/jquery.dataTables.min.css" />
        <link rel="stylesheet" href="https://cdn.datatables.net/datetime/1.4.1/css/dataTables.dateTime.min.css" />
        <script src="assets/js/jquery-3.6.0.min.js"></script>
        <script src="https://cdn.datatables.net/1.13.4/js/jquery.dataTables.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.2/moment.min.js"></script>
        <script src="https://cdn.datatables.net/datetime/1.4.1/js/dataTables.dateTime.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
        <script>

            $(document).ready(function () {

                // DataTables initialisation
                var table = $('#example').DataTable({
                    "ajax": {
                        "url": "/HRManagement/leaveReport",
                        "type": "POST",
                        "dataSrc": ""
                    },
                    "columns": [
                        {data: null,
                                //set identity for row
                                render: function (data, type, row, meta) {
                                return meta.row + meta.settings._iDisplayStart + 1;
                                }
                        },
                        {"data": null
                            //get name of employee from UserID in json file
                            , render: function (data, type, row) {
                                var user_id = row.UserID;
                                //get list of employee from ajax
                                var list = $.ajax({
                                    url: "/HRManagement/employee",
                                    type: "POST",
                                    dataType: "json",
                                    async: false
                                }).responseJSON;
                                //get name of employee from list where UserID = user_id
                                var name = list.find(x => x.UserID === user_id).Name;
                                return name;
                            }
                        },
                        {"data": "LeaveTypeName"},
                        {"data": "StartDate"},
                        {"data": "EndDate"},
                        {"data": "Reason"},
                        {"data": null,
                        //create 2 button for each row if status is pending
                            render: function (data, type, row) {
                                var status = row.Status;
                                if (status === "Pending") {
                                    return '<button class="btn btn-success approve">Approve</button><button class="btn btn-danger reject">Reject</button>';
                                } else if (status === "Approved") {
                                    return '<label><a class="action_label3">Approved</a></label>';
                                } else {
                                    return '<label><a class="action_label4">Rejected</a></label>';
                                }
                            }
                        }
                    ],
                    "columnDefs": [
                        {
                           //justify content center
                            "className": "dt-center",
                            "targets": "_all"
                        },
                        {
                            //set column 0 width
                            "width": "5%",
                            "targets": 0
                        },
                        {
                            "visible": false,
                            "searchable": false
                        }
                        //set padding for each column in table
                        , {
                            "targets": "_all",
                            "createdCell": function (td, cellData, rowData, row, col) {
                                $(td).css('padding', '15px')
                            }
                        }
                    ],
                    "order": [[0, "desc"]]
                });

                //set event for button approve leave request in table
                $('#example tbody').on('click', '.approve', function () {
                    //get data of row
                    var data = table.row($(this).parents('tr')).data();
                    //get status of leave request
                    var status = data.Status;
                    var user_id = data.UserID;
                    //check status of leave request
                    if(status === "Approved"){
                        //hide button Reject and show button Approve in middle of row
                        $(this).hide();
                        $(this).next().show();
                    } else if(status === "Rejected") {
                        //hide button Approve and show button Reject in middle of row
                        $(this).hide();
                        $(this).prev().show();
                    } else {
                        //if status is pending, show alert
                        Swal.fire({
                            title: 'Are you sure?',
                            text: "You want to approve this leave request!",
                            icon: 'warning',
                            showCancelButton: true,
                            confirmButtonColor: '#3085d6',
                            cancelButtonColor: '#d33',
                            confirmButtonText: 'Approve'
                        }).then((result) => {
                            if (result.isConfirmed) {
                                //sent data to server
                                $.ajax({
                                    url: "/HRManagement/updateLeaveRequest",
                                    type: "POST",
                                    data: {
                                        "UserID": user_id,
                                        "Status": "Approved"
                                    },
                                    success: function (data) {
                                        console.log(data);
                                        //reload table
                                        table.ajax.reload();
                                        //show alert
                                        Swal.fire(
                                                'Approved!',
                                                'This leave request has been approved.',
                                                'success'
                                                )
                                    },
                                    error: function (data) {
                                        console.log(data);
                                    }
                                });
                            }
                        });
                    }
                });

                //set event for button reject leave request in table
                $('#example tbody').on('click', '.reject', function () {
                    //get data of row
                    var data = table.row($(this).parents('tr')).data();
                    //get status of leave request
                    var status = data.Status;
                    var user_id = data.UserID;
                    //check status of leave request
                    if(status === "Approved"){
                        //hide button Reject and show button Approve in middle of row
                        $(this).hide();
                        $(this).prev().show();
                    } else if(status === "Rejected") {
                        //hide button Approve and show button Reject in middle of row
                        $(this).hide();
                        $(this).next().show();
                    } else {
                        //if status is pending, show alert
                        Swal.fire({
                            title: 'Are you sure?',
                            text: "You want to reject this leave request!",
                            icon: 'warning',
                            showCancelButton: true,
                            confirmButtonColor: '#d33',
                            cancelButtonColor: '#3085d6',
                            confirmButtonText: 'Reject'
                        }).then((result) => {
                            if (result.isConfirmed) {
                                //sent data to server
                                $.ajax({
                                    url: "/HRManagement/updateLeaveRequest",
                                    type: "POST",
                                    data: {
                                        "UserID": user_id,
                                        "Status": "Rejected"
                                    },
                                    success: function (data) {
                                        console.log(data);
                                        //reload table
                                        table.ajax.reload();
                                        //show alert
                                        Swal.fire(
                                                'Rejected!',
                                                'This leave request has been rejected.',
                                                'success'
                                                )
                                    },
                                    error: function (data) {
                                        console.log(data);
                                    }
                                });
                            }
                        });
                    }
                });
            });
        </script>
    </head>
    <body>
        <%
            User user = (User) session.getAttribute("user");
            if (user == null) {
                response.sendRedirect("login.jsp");
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
                                    <li class="breadcrumb-item active">Leave Report</li>
                                </ul>
                                <h3>Report</h3>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xl-12 col-sm-12 col-12 ">
                            <div class="card ">
                                <div class="card-header">
                                    <h2 class="card-titles">Leave Report</h2>
                                </div>
                                <div class="card-body p-0">
                                    <div class="table-responsive">
                                        <table id="example" class="display nowrap" style="width:100%">
                                            <thead>
                                                <tr>
                                                    <th>STT</th>
                                                    <th>Employee</th>
                                                    <th>Leave Type</th>
                                                    <th>From</th>
                                                    <th>To</th>
                                                    <th>Notes</th>
                                                    <th>Status</th>
                                                </tr>
                                            </thead>
                                            <tbody>

                                            </tbody>
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
