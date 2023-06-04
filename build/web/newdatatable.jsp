<%-- 
    Document   : newdatatable
    Created on : Jun 3, 2023, 12:00:52 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="sstylesheet" href="https://cdn.datatables.net/1.13.4/css/jquery.dataTables.min.css">
        <link rel="sstylesheet" href="https://cdn.datatables.net/buttons/2.3.6/css/buttons.dataTables.min.css">
        <link rel="sstylesheet" href="https://cdn.datatables.net/select/1.6.2/css/select.dataTables.min.css">
        <link rel="sstylesheet" href="https://cdn.datatables.net/datetime/1.4.1/css/dataTables.dateTime.min.css">
        <link rel="sstylesheet" href="https://editor.datatables.net/extensions/Editor/css/editor.dataTables.min.css">
        <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
        <script src="https://cdn.datatables.net/1.13.4/js/jquery.dataTables.min.js"></script>
        <script src="https://cdn.datatables.net/buttons/2.3.6/js/dataTables.buttons.min.js"></script>
        <script src="https://cdn.datatables.net/select/1.6.2/js/dataTables.select.min.js"></script>
        <script src="https://cdn.datatables.net/datetime/1.4.1/js/dataTables.dateTime.min.js"></script>
        <script src="https://editor.datatables.net/extensions/Editor/js/dataTables.editor.min.js"></script>
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <script src="https://cdn.datatables.net/1.11.3/js/jquery.dataTables.min.js"></script>
        <script>
            var editor;
            $(document).ready(function () {
                editor = new $.fn.dataTable.Editor({
                    ajax: "/HRManagement/employee",
                    table: "#example",
                    fields: [{
                            label: "UserID:",
                            name: "UserID"
                        }, {
                            label: "Name:",
                            name: "Name"
                        }, {
                            label: "Phone:",
                            name: "Phone"
                        }, {
                            label: "Email:",
                            name: "Email"
                        }, {
                            label: "Username:",
                            name: "Username"
                        }, {
                            label: "Password:",
                            name: "Password"
                        }, {
                            label: "Address:",
                            name: "Address"
                        }, {
                            label: "Birthday:",
                            name: "Birthday"
                        }, {
                            label: "ExperienceId:",
                            name: "ExperienceId"
                        }, {
                            label: "Team_ID:",
                            name: "Team_ID"
                        }
                    ]
                });
                $('#example').DataTable({
                    dom: "Bfrtip",
                    ajax: "/HRManagement/employee",
                    columns: [
                        {data: null, render: function (data, type, row) {
                                // Combine the first and last names into a single table field
                                return data.Name;
                            }},
                        {data: "UserID"},
                        {data: "Name"},
                        {data: "Phone"},
                        {data: "Email"},
                        {data: "Username"},
                        {data: "Password"},
                        {data: "Address"},
                        {data: "Birthday"},
                        {data: "ExperienceId"},
                        {data: "Team_ID"}
                    ],
                    select: true,
                    buttons: [
                        {extend: "create", editor: editor},
                        {extend: "edit", editor: editor},
                        {extend: "remove", editor: editor}
                    ]
                });
            });

            
        </script>
    </head>
    <body>
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
    </body>
</html>
