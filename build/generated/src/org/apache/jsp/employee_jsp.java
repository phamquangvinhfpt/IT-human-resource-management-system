package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import sample.dao.TeamDAO;
import sample.dto.Team;
import sample.dto.Project;
import sample.dao.ProjectDAO;
import java.text.SimpleDateFormat;
import java.util.List;
import sample.dto.User;

public final class employee_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>Employee</title>\r\n");
      out.write("\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/css/bootstrap.min.css\">\r\n");
      out.write("\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/plugins/select2/css/select2.min.css\">\r\n");
      out.write("\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/plugins/fontawesome/css/fontawesome.min.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/plugins/fontawesome/css/all.min.css\">\r\n");
      out.write("\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/css/style.css\">\r\n");
      out.write("\r\n");
      out.write("        <script src=\"https://kit.fontawesome.com/b3fa33d056.js\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("\r\n");
      out.write("        <!--CDN-->\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdn.datatables.net/1.13.4/css/jquery.dataTables.css\" />\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdn.datatables.net/1.13.4/css/jquery.dataTables.min.css\" />\r\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.5.1.js\"></script>\r\n");
      out.write("        <script src=\"https://cdn.datatables.net/1.13.4/js/jquery.dataTables.min.js\"></script>\r\n");
      out.write("        <!-- Bootstrap JavaScript library -->\r\n");
      out.write("        <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js\"></script>\r\n");
      out.write("        ");
      out.write("\r\n");
      out.write("        <script src=\"https://unpkg.com/sweetalert/dist/sweetalert.min.js\"></script>\r\n");
      out.write("        <script>\r\n");
      out.write("            function format(d) {\r\n");
      out.write("                // `d` is the original data object for the row\r\n");
      out.write("                return (\r\n");
      out.write("                        '<table cellpadding=\"5\" cellspacing=\"0\" border=\"0\" style=\"padding-left:50px;\">' +\r\n");
      out.write("                        '<tr>' +\r\n");
      out.write("                        '<td>Image:</td>' +\r\n");
      out.write("                        '<td>' +\r\n");
      out.write("                        '<img src=\"images/' + d.Image + '\" width=\"100px\" height=\"100px\"/>' +\r\n");
      out.write("                        '</td>' +\r\n");
      out.write("                        '</tr>' +\r\n");
      out.write("                        '<tr>' +\r\n");
      out.write("                        '<td>Address:</td>' +\r\n");
      out.write("                        '<td>' +\r\n");
      out.write("                        d.Address +\r\n");
      out.write("                        '</td>' +\r\n");
      out.write("                        '</tr>' +\r\n");
      out.write("                        '<tr>' +\r\n");
      out.write("                        '<td>Project:</td>' +\r\n");
      out.write("                        '<td>'+d.NameProject+'</td>' +\r\n");
      out.write("                        '</tr>' +\r\n");
      out.write("                        '<tr>' +\r\n");
      out.write("                        '<td>Team:</td>' +\r\n");
      out.write("                        '<td>'+d.Team_Name+'</td>' +\r\n");
      out.write("                        '</tr>' +\r\n");
      out.write("                        '</table>'\r\n");
      out.write("                        );\r\n");
      out.write("            }\r\n");
      out.write("            $(document).ready(function () {\r\n");
      out.write("                //load data for datatable\r\n");
      out.write("                $('#example').DataTable({\r\n");
      out.write("\r\n");
      out.write("                    ajax: {\r\n");
      out.write("                        url: '/HRManagement/employee',\r\n");
      out.write("                        dataSrc: ''\r\n");
      out.write("                    },\r\n");
      out.write("                    //justify content table center\r\n");
      out.write("                    \"columnDefs\": [\r\n");
      out.write("                        {\"className\": \"dt-center\", \"targets\": \"_all\"}\r\n");
      out.write("                    ],\r\n");
      out.write("                    columns: [\r\n");
      out.write("                        {\r\n");
      out.write("                            className: 'dt-control',\r\n");
      out.write("                            orderable: false,\r\n");
      out.write("                            data: null,\r\n");
      out.write("                            defaultContent: ''\r\n");
      out.write("                        },\r\n");
      out.write("                        {data: null,\r\n");
      out.write("                            //set identity for row\r\n");
      out.write("                            render: function (data, type, row, meta) {\r\n");
      out.write("                                return meta.row + meta.settings._iDisplayStart + 1;\r\n");
      out.write("                            }\r\n");
      out.write("                        },\r\n");
      out.write("                        {data: 'Name'},\r\n");
      out.write("//                        {\r\n");
      out.write("//                            //get images from images folder\r\n");
      out.write("//                            data: 'Image',\r\n");
      out.write("//                            render: function (data) {\r\n");
      out.write("//                                // replace \\ to / for get image\r\n");
      out.write("//                                data = data.replace(/\\\\/g, \"/\");\r\n");
      out.write("//                                var img = '<img src=\"images/' + data + '\" width=\"100px\" height=\"100px\"/>';\r\n");
      out.write("//                                console.log(img);\r\n");
      out.write("//                                return img;\r\n");
      out.write("//                            }\r\n");
      out.write("//                        },\r\n");
      out.write("                        {data: 'Phone'},\r\n");
      out.write("                        {data: 'Email'},\r\n");
      out.write("                        {data: 'Username'},\r\n");
      out.write("                        {data: 'Password'},\r\n");
      out.write("                        {data: 'Birthday'},\r\n");
      out.write("                        {data: 'Role'},\r\n");
      out.write("                        {\r\n");
      out.write("                            data: null,\r\n");
      out.write("                            render: function (data, type, row) {\r\n");
      out.write("                                //set id for button = id of employee\r\n");
      out.write("                                return `\r\n");
      out.write("                        <button onclick=\"deleteEmployee()\" style=\"background-color: white;box-shadow: none\" class=\"btn\"><i class=\"fa-solid fa-trash text-danger\"></i></button>\r\n");
      out.write("                        <button onclick=\"update()\" style=\"background-color: white;box-shadow: none\" class=\"btn\"><i class=\"fa-solid fa-pen-to-square text-primary\"></i></button>\r\n");
      out.write("                    `;\r\n");
      out.write("                            }\r\n");
      out.write("                        }\r\n");
      out.write("                    ],\r\n");
      out.write("                    \"order\": [[0, \"asc\"]]\r\n");
      out.write("                });\r\n");
      out.write("\r\n");
      out.write("                // Add event listener for opening and closing details\r\n");
      out.write("                $('#example tbody').on('click', 'td.dt-control', function () {\r\n");
      out.write("                    var tr = $(this).closest('tr');\r\n");
      out.write("                    var row = $('#example').DataTable().row(tr);\r\n");
      out.write("\r\n");
      out.write("                    if (row.child.isShown()) {\r\n");
      out.write("                        // This row is already open - close it\r\n");
      out.write("                        row.child.hide();\r\n");
      out.write("                        tr.removeClass('shown');\r\n");
      out.write("                    } else {\r\n");
      out.write("                        // Open this row\r\n");
      out.write("                        row.child(format(row.data())).show();\r\n");
      out.write("                        tr.addClass('shown');\r\n");
      out.write("                    }\r\n");
      out.write("                });\r\n");
      out.write("\r\n");
      out.write("                $(document).ready(function () {\r\n");
      out.write("                    //add employee\r\n");
      out.write("                    $(\".myform\").on(\"submit\", function (e) {\r\n");
      out.write("                        e.preventDefault();\r\n");
      out.write("                        $.ajax({\r\n");
      out.write("                            method: \"POST\",\r\n");
      out.write("                            url: \"/HRManagement/addEmployee\",\r\n");
      out.write("                            data: new FormData(this),\r\n");
      out.write("                            processData: false,\r\n");
      out.write("                            contentType: false,\r\n");
      out.write("                            success: function (res) {\r\n");
      out.write("                                console.log(res);\r\n");
      out.write("                                //remove \"\" from string\r\n");
      out.write("                                if (res === `\"Insert success\"`) {\r\n");
      out.write("                                    swal({\r\n");
      out.write("                                        title: \"Success!\",\r\n");
      out.write("                                        text: \"Add employee success!\",\r\n");
      out.write("                                        icon: \"success\",\r\n");
      out.write("                                        button: \"OK\"\r\n");
      out.write("                                    }).then((value) => {\r\n");
      out.write("                                        //click oke will hide modal and reload datatable\r\n");
      out.write("                                        $(\"#mymodal\").modal(\"hide\");\r\n");
      out.write("                                        $('#example').DataTable().ajax.reload();\r\n");
      out.write("                                    });\r\n");
      out.write("                                } else {\r\n");
      out.write("                                    swal({\r\n");
      out.write("                                        title: \"Error!\",\r\n");
      out.write("                                        //remove \"\" from string\r\n");
      out.write("                                        text: res.replace(/\"/g, \"\"),\r\n");
      out.write("                                        icon: \"error\",\r\n");
      out.write("                                        button: \"OK!\"\r\n");
      out.write("                                    });\r\n");
      out.write("                                }\r\n");
      out.write("                            },\r\n");
      out.write("                            error: function (error) {\r\n");
      out.write("                                console.log(error);\r\n");
      out.write("                                sweetAlert(\"Oops...\", \"Something went wrong!\", \"error\");\r\n");
      out.write("                            }\r\n");
      out.write("                        });\r\n");
      out.write("                    });\r\n");
      out.write("                });\r\n");
      out.write("                //selected employee\r\n");
      out.write("                $(document).ready(function () {\r\n");
      out.write("                    var table = $('#example').DataTable();\r\n");
      out.write("\r\n");
      out.write("                    $('#example tbody').on('click', 'tr', function () {\r\n");
      out.write("                        $(this).toggleClass('selected');\r\n");
      out.write("                    });\r\n");
      out.write("\r\n");
      out.write("                    $('#button').click(function () {\r\n");
      out.write("                        alert(table.rows('.selected').data().length + ' row(s) selected');\r\n");
      out.write("                    });\r\n");
      out.write("                });\r\n");
      out.write("                \r\n");
      out.write("                $(document).on('keydown', function(e) {\r\n");
      out.write("                    if (e.keyCode === 27) { // ESC\r\n");
      out.write("                        $(\"#mymodal\").modal(\"hide\");\r\n");
      out.write("                    }\r\n");
      out.write("                    if (e.key === 'Delete') {\r\n");
      out.write("                        var selectedRows = $('#example').DataTable().rows('.selected').data();\r\n");
      out.write("                        if (selectedRows.length > 0) {\r\n");
      out.write("                            //send DELETE request to server to delete selected employees\r\n");
      out.write("                            $.ajax({\r\n");
      out.write("                                method: \"DELETE\",\r\n");
      out.write("                                url: \"/HRManagement/deleteEmployee\",\r\n");
      out.write("                                data: JSON.stringify(selectedRows),\r\n");
      out.write("                                contentType: \"application/json\",\r\n");
      out.write("                                dataType: \"json\",\r\n");
      out.write("                                console: console.log(JSON.stringify(selectedRows)),\r\n");
      out.write("                                success: function (res) {\r\n");
      out.write("                                    console.log(res);\r\n");
      out.write("                                    //remove \"\" from string\r\n");
      out.write("                                    if (res === `\"Delete success\"`) {\r\n");
      out.write("                                        swal({\r\n");
      out.write("                                            title: \"Success!\",\r\n");
      out.write("                                            text: \"Delete employee success!\",\r\n");
      out.write("                                            icon: \"success\",\r\n");
      out.write("                                            button: \"OK\",\r\n");
      out.write("                                        }).then((value) => {\r\n");
      out.write("                                            //click oke will hide modal and reload datatable\r\n");
      out.write("                                            $(\"#mymodal\").modal(\"hide\");\r\n");
      out.write("                                            $('#example').DataTable().ajax.reload();\r\n");
      out.write("                                        });\r\n");
      out.write("                                    } else {\r\n");
      out.write("                                        swal({\r\n");
      out.write("                                            title: \"Error!\",\r\n");
      out.write("                                            //remove \"\" from string\r\n");
      out.write("                                            text: res.replace(/\"/g, \"\"),\r\n");
      out.write("                                            icon: \"error\",\r\n");
      out.write("                                            button: \"OK!\",\r\n");
      out.write("                                        });\r\n");
      out.write("                                    }\r\n");
      out.write("                                },\r\n");
      out.write("                                error: function (error) {\r\n");
      out.write("                                    console.log(error);\r\n");
      out.write("                                    sweetAlert(\"Oops...\", \"Something went wrong!\", \"error\");\r\n");
      out.write("                                }\r\n");
      out.write("                            });\r\n");
      out.write("                        }\r\n");
      out.write("                    }\r\n");
      out.write("                });\r\n");
      out.write("            });\r\n");
      out.write("        </script>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        ");

            //check user login
            User user = (User) session.getAttribute("user");
            if (user == null || !user.getRole().equals("admin")) {
                response.sendRedirect("login.jsp");
            }
        
      out.write("\r\n");
      out.write("        <div class=\"main-wrapper\">\r\n");
      out.write("\r\n");
      out.write("            <div class=\"header\">\r\n");
      out.write("                ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "common/navbar.jsp", out, false);
      out.write("  \r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            <div class=\"sidebar\" id=\"sidebar\">\r\n");
      out.write("                ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "common/sidebar.jsp", out, false);
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            <div class=\"page-wrapper\">\r\n");
      out.write("                <div class=\"content container-fluid\">\r\n");
      out.write("                    <div class=\"row\">\r\n");
      out.write("                        <div class=\"col-xl-12 col-sm-12 col-12\">\r\n");
      out.write("                            <div class=\"breadcrumb-path mb-4\">\r\n");
      out.write("                                <ul class=\"breadcrumb\">\r\n");
      out.write("                                    <li class=\"breadcrumb-item\"><a href=\"index.html\"><img src=\"assets/img/dash.png\" class=\"mr-2\" alt=\"breadcrumb\" />Home</a>\r\n");
      out.write("                                    </li>\r\n");
      out.write("                                    <li class=\"breadcrumb-item active\"> Employees</li>\r\n");
      out.write("                                </ul>\r\n");
      out.write("                                <h3>Employees</h3>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"col-xl-12 col-sm-12 col-12 mb-4\">\r\n");
      out.write("                            <div class=\"head-link-set\">\r\n");
      out.write("                                <ul>\r\n");
      out.write("                                    <li><a class=\"active\" href=\"#\">All</a></li>\r\n");
      out.write("                                    <li><a id=\"add\" href=\"#\">Teams</a></li>\r\n");
      out.write("                                </ul>\r\n");
      out.write("                                <a class=\"btn-add\" onclick=\"$('#mymodal').modal('show')\"><i data-feather=\"plus\"></i> Add Person</a>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <form class=\"myform\">\r\n");
      out.write("                            <div class=\"modal fade\" data-backdrop='static' id=\"mymodal\">\r\n");
      out.write("                                <div class=\"modal-dialog\">\r\n");
      out.write("                                    <div class=\"modal-content\">\r\n");
      out.write("                                        <div class=\"modal-header\">\r\n");
      out.write("                                            <h3 class=\"modal-title\">Add New Employee</h3>\r\n");
      out.write("                                            <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\r\n");
      out.write("                                                <span aria-hidden=\"true\">&times;</span>\r\n");
      out.write("                                            </button>\r\n");
      out.write("                                        </div>\r\n");
      out.write("\r\n");
      out.write("                                        <div class=\"modal-body\">\r\n");
      out.write("                                            <div class=\"form-group\">\r\n");
      out.write("                                                <label for=\"name\">Name:</label>\r\n");
      out.write("                                                <input type=\"text\" class=\"form-control\" id=\"name\" name=\"name\">\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                            <div class=\"form-group\">\r\n");
      out.write("                                                <label for=\"name\">Image:</label>\r\n");
      out.write("                                                <input type=\"file\" class=\"form-control\" id=\"image\" name=\"image\">\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                            <div class=\"form-group\">\r\n");
      out.write("                                                <label for=\"phone\">Phone:</label>\r\n");
      out.write("                                                <input type=\"text\" class=\"form-control\" id=\"phone\" name=\"phone\">\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                            <div class=\"form-group\">\r\n");
      out.write("                                                <label for=\"email\">Email:</label>\r\n");
      out.write("                                                <input type=\"email\" class=\"form-control\" id=\"email\" name=\"email\">\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                            <div class=\"form-group\">\r\n");
      out.write("                                                <label for=\"username\">Username:</label>\r\n");
      out.write("                                                <input type=\"text\" class=\"form-control\" id=\"username\" name=\"username\">\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                            <div class=\"form-group\">\r\n");
      out.write("                                                <label for=\"password\">Password:</label>\r\n");
      out.write("                                                <input type=\"password\" class=\"form-control\" id=\"password\" name=\"password\">\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                            <div class=\"form-group\">\r\n");
      out.write("                                                <label for=\"address\">Address:</label>\r\n");
      out.write("                                                <input type=\"text\" class=\"form-control\" id=\"address\" name=\"address\">\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                            <div class=\"form-group\">\r\n");
      out.write("                                                <label for=\"birthday\">Birthday:</label>\r\n");
      out.write("                                                <input type=\"date\" class=\"form-control\" id=\"birthday\" name=\"birthday\">\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                            <div class=\"form-group\">\r\n");
      out.write("                                                <label for=\"experienceId\">ExperienceId:</label>\r\n");
      out.write("                                                ");
      out.write("\r\n");
      out.write("                                                <select class=\"form-control\" id=\"experienceId\" name=\"projectName\">\r\n");
      out.write("                                                    ");

                                                        List<Project> list = ProjectDAO.getAll();
                                                        for (Project project : list) {
                                                    
      out.write("\r\n");
      out.write("                                                    <option value=\"");
      out.print(project.getNameProject());
      out.write('"');
      out.write('>');
      out.print(project.getNameProject());
      out.write("</option>\r\n");
      out.write("                                                    ");

                                                        }
                                                    
      out.write("\r\n");
      out.write("                                                </select>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                            <div class=\"form-group\">\r\n");
      out.write("                                                <label for=\"teamID\">Team_ID:</label>\r\n");
      out.write("                                                ");
      out.write("\r\n");
      out.write("                                                <select class=\"form-control\" id=\"teamID\" name=\"teamName\">\r\n");
      out.write("                                                    ");

                                                        List<Team> listTeam = TeamDAO.getAll();
                                                        for (Team team : listTeam) {
                                                    
      out.write("\r\n");
      out.write("                                                    <option value=\"");
      out.print(team.getTeam_Name());
      out.write('"');
      out.write('>');
      out.print(team.getTeam_Name());
      out.write("</option>\r\n");
      out.write("                                                    ");

                                                        }
                                                    
      out.write("\r\n");
      out.write("                                                </select>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("\r\n");
      out.write("                                        <div class=\"modal-footer\">\r\n");
      out.write("                                            <input type=\"submit\" value=\"Save\" class=\"btn btn-primary\" />\r\n");
      out.write("                                            <input type=\"reset\" value=\"Reset\" class=\"btn btn-danger\" />\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </form>\r\n");
      out.write("\r\n");
      out.write("                        <div class=\"col-xl-12 col-sm-12 col-12 mb-4\">\r\n");
      out.write("                            <div class=\"row\">\r\n");
      out.write("                                <label class=\"employee_count\"> People</label>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"col-xl-12 col-sm-12 col-12 mb-4\">\r\n");
      out.write("                            <div class=\"card\">\r\n");
      out.write("                                <div class=\"table-heading\">\r\n");
      out.write("                                    <h2>Project Summery</h2>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"table-responsive\">\r\n");
      out.write("                                    <table id=\"example\" class=\"display\" style=\"width:100%\">\r\n");
      out.write("                                        <thead>\r\n");
      out.write("                                            <tr>\r\n");
      out.write("                                                <th></th>\r\n");
      out.write("                                                <th>STT</th>\r\n");
      out.write("                                                <th>Name</th>\r\n");
      out.write("                                                <th>Phone</th>\r\n");
      out.write("                                                <th>Email</th>\r\n");
      out.write("                                                <th>Username</th>\r\n");
      out.write("                                                <th>Password</th>\r\n");
      out.write("                                                <th>Birthday</th>\r\n");
      out.write("                                                <th>Role</th>\r\n");
      out.write("                                                <th class=\"col-sm-1\">Action</th>\r\n");
      out.write("                                            </tr>\r\n");
      out.write("                                        </thead>\r\n");
      out.write("\r\n");
      out.write("                                        <tfoot>\r\n");
      out.write("                                            <tr>\r\n");
      out.write("                                                <th></th>\r\n");
      out.write("                                                <th>STT</th>\r\n");
      out.write("                                                <th>Name</th>\r\n");
      out.write("                                                <th>Phone</th>\r\n");
      out.write("                                                <th>Email</th>\r\n");
      out.write("                                                <th>Username</th>\r\n");
      out.write("                                                <th>Password</th>\r\n");
      out.write("                                                <th>Birthday</th>\r\n");
      out.write("                                                <th>Role</th>\r\n");
      out.write("                                                <th>Action</th>\r\n");
      out.write("                                            </tr>\r\n");
      out.write("                                        </tfoot>\r\n");
      out.write("                                    </table>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <script src=\"assets/js/popper.min.js\"></script>\r\n");
      out.write("            <script src=\"assets/js/bootstrap.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("            <script src=\"assets/js/feather.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("            <!--<script src=\"assets/plugins/slimscroll/jquery.slimscroll.min.js\"></script>-->\r\n");
      out.write("\r\n");
      out.write("            <script src=\"assets/plugins/select2/js/select2.min.js\"></script>\r\n");
      out.write("            <script src=\"assets/js/script.js\"></script>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
