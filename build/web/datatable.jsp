
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!--CDN-->
        <link rel="stylesheet" href="https://cdn.datatables.net/1.13.4/css/jquery.dataTables.css" />
        <script src="https://cdn.datatables.net/1.13.4/js/jquery.dataTables.js"></script>
        <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
        <script src="https://cdn.datatables.net/1.13.4/js/jquery.dataTables.min.js"></script>
        <script src="https://kit.fontawesome.com/b3fa33d056.js" crossorigin="anonymous"></script>

        <link rel="stylesheet" href="assets/css/bootstrap.min.css">
        <!-- Bootstrap JavaScript library -->
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        
        <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/toastify-js/src/toastify.min.css">
        <script src="../node_modules/toastify-js/src/toastify.js"></script>
        <title>JSP Page</title>
    </head>
    <script>
        $(document).ready(function () {
            $('#example').DataTable({
                ajax: {
                    url: '/HRManagement/employee',
                    dataSrc: ''
                },
                columns: [
                    {
                        "className": 'details-control',
                        "orderable": false,
                        "data": null,
                        "defaultContent": ''
                    },
                    {data: 'UserID'},
                    {data: 'Name'},
                    {data: 'Phone'},
                    {data: 'Email'},
                    {data: 'Username'},
                    {data: 'Password'},
                    {data: 'Address'},
                    {data: 'Birthday'},
                    {data: 'ExperienceId'},
                    {data: 'Team_ID'},
                    {
                        data: null,
                        render: function (data, type, row) {
                            //set id for button = id of employee
                            return `
                        <button onclick="deleteEmployee()" style="background-color: white;box-shadow: none" class="btn"><i class="fa-solid fa-trash text-danger"></i></button>
                        <button onclick="update(this)" style="background-color: white;box-shadow: none" class="btn"><i class="fa-solid fa-pen-to-square text-primary"></i></button>
                    `;
                        }
                    }
                ],
                "order": [[1, 'asc']]
            });
            // Add event listener for opening and closing details
            $('#example tbody').on('click', 'td.details-control', function () {
                var tr = $(this).closest('tr');
                var row = $('#example').DataTable().row(tr);

                if (row.child.isShown()) {
                    // This row is already open - close it
                    row.child.hide();
                    tr.removeClass('shown');
                } else {
                    // Open this row
                    row.child(format(row.data())).show();
                    tr.addClass('shown');
                }
            });
            //format detail
            function format(d) {
                // `d` is the original data object for the row
                return '<table cellpadding="5" cellspacing="0" border="0" style="padding-left:50px;">' +
                        '<tr>' +
                        '<td>Full name:</td>' +
                        '<td>' + d.Name + '</td>' +
                        '</tr>' +
                        '<tr>' +
                        '<td>Phone:</td>' +
                        '<td>' + d.Phone + '</td>' +
                        '</tr>' +
                        '<tr>' +
                        '<td>Extra info:</td>' +
                        '<td>And any further details here (images etc)...</td>' +
                        '</tr>' +
                        '</table>';
            }
            $(document).ready(function () {
                $(".myform").on("submit", function (e) {
                    e.preventDefault();
                    $.ajax({
                        method: "POST",
                        url: "/HRManagement/addEmployee",
                        data: new FormData(this),
                        processData: false,
                        contentType: false,
                        success: function (res) {
                            console.log(res);
                            //reload datatable
                            $('#example').DataTable().ajax.reload();
                            //close modal and popup alert success
                            $('#mymodal').modal('hide');
                            alert("Add success");
                        },
                        error: function (error) {
                            console.log(error);
                        }
                    });
                });
            });
            //delete employee
            $(document).ready(function () {
                var table = $('#example').DataTable();

                $('#example tbody').on('click', 'tr', function () {
                    $(this).toggleClass('selected');
                });

                $('#button').click(function () {
                    alert(table.rows('.selected').data().length + ' row(s) selected');
                });
                
                
            });
            //toast
            function toastSuccess() {
                Toastify({
                    text: "Add success",
                    duration: 3000,
                    newWindow: true,
                    close: true,
                    gravity: "top", // `top` or `bottom`
                    position: 'right', // `left`, `center` or `right`
                    backgroundColor: "linear-gradient(to right, #00b09b, #96c93d)",
                    stopOnFocus: true, // Prevents dismissing of toast on hover
                    onClick: function () {
                    } // Callback after click
                }).showToast();
            }
        });
    </script>
    <style>
        td.details-control {
            background: url('assets/img/open.png') no-repeat center center;
            cursor: pointer;
        }
        tr.details td.details-control {
            background: url('assets/img/close.png') no-repeat center center;
        }
    </style>
    <body>
        <button class="btn-add" onclick="$('#mymodal').modal('show')" id="addRow">Add new row</button>
        <form class="myform">
            <div class="modal fade" data-backdrop='static' id="mymodal">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h3 class="modal-title">Add New Employee</h3>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>

                        <div class="modal-body">
                            <div class="form-group">
                                <label for="userID">UserID:</label>
                                <input type="text" class="form-control" id="userID" name="userID">
                            </div>
                            <div class="form-group">
                                <label for="name">Name:</label>
                                <input type="text" class="form-control" id="name" name="name">
                            </div>
                            <div class="form-group">
                                <label for="phone">Phone:</label>
                                <input type="phone" class="form-control" id="phone" name="phone">
                            </div>
                            <div class="form-group">
                                <label for="email">Email:</label>
                                <input type="email" class="form-control" id="email" name="email">
                            </div>
                            <div class="form-group">
                                <label for="username">Username:</label>
                                <input type="text" class="form-control" id="username" name="username">
                            </div>
                            <div class="form-group">
                                <label for="password">Password:</label>
                                <input type="password" class="form-control" id="password" name="password">
                            </div>
                            <div class="form-group">
                                <label for="address">Address:</label>
                                <input type="text" class="form-control" id="address" name="address">
                            </div>
                            <div class="form-group">
                                <label for="birthday">Birthday:</label>
                                <input type="date" class="form-control" id="birthday" name="birthday">
                            </div>
                            <div class="form-group">
                                <label for="experienceId">ExperienceId:</label>
                                <input type="text" class="form-control" id="experienceId" name="experienceId">
                            </div>
                            <div class="form-group">
                                <label for="teamID">Team_ID:</label>
                                <input type="text" class="form-control" id="teamID" name="teamID">
                            </div>
                        </div>

                        <div class="modal-footer">
                            <input type="submit" onclick="toastSuccess()" value="Save" class="btn btn-primary" />
                            <input type="reset" value="Reset" class="btn btn-danger" />
                        </div>

                    </div>
                </div>
            </div>
        </form>
        <table id="example" class="display" style="width:100%">
            <thead>
                <tr>
                    <th></th>
                    <th>UserID</th>
                    <th>Name</th>
                    <th>Phone</th>
                    <th>Email</th>
                    <th>Username</th>
                    <th>Password</th>
                    <th>Address</th>
                    <th>Birthday</th>
                    <th>ExperienceId</th>
                    <th>Team_ID</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
            

            <tfoot>
                <tr>
                    <th></th>
                    <th>UserID</th>
                    <th>Name</th>
                    <th>Phone</th>
                    <th>Email</th>
                    <th>Username</th>
                    <th>Password</th>
                    <th>Address</th>
                    <th>Birthday</th>
                    <th>ExperienceId</th>
                    <th>Team_ID</th>
                    <th>Action</th>
                </tr>
            </tfoot>
        </table>
        <script src="assets/js/feather.min.js"></script>
        <script src="assets/js/popper.min.js"></script>
    </body>
</html>
