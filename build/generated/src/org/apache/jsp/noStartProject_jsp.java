package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class noStartProject_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/css/bootstrap.min.css\">\n");
      out.write("\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/plugins/select2/css/select2.min.css\">\n");
      out.write("\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/plugins/fontawesome/css/fontawesome.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/plugins/fontawesome/css/all.min.css\">\n");
      out.write("\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/css/style.css\">\n");
      out.write("\n");
      out.write("        <script src=\"https://kit.fontawesome.com/b3fa33d056.js\" crossorigin=\"anonymous\"></script>\n");
      out.write("\n");
      out.write("        <!--CDN-->\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdn.datatables.net/1.13.4/css/jquery.dataTables.css\" />\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdn.datatables.net/1.13.4/css/jquery.dataTables.min.css\" />\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.5.1.js\"></script>\n");
      out.write("        <script src=\"https://cdn.datatables.net/1.13.4/js/jquery.dataTables.min.js\"></script>\n");
      out.write("        <!-- Bootstrap JavaScript library -->\n");
      out.write("        <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js\"></script>\n");
      out.write("        ");
      out.write("\n");
      out.write("        <script src=\"https://unpkg.com/sweetalert/dist/sweetalert.min.js\"></script>\n");
      out.write("\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/sweetalert2@11\"></script>\n");
      out.write("        <script>\n");
      out.write("            $(document).ready(function () {\n");
      out.write("                $('#example').DataTable({\n");
      out.write("                    ajax: {\n");
      out.write("                        url: '/HRManagement/NoStartProject',\n");
      out.write("                        dataSrc: ''\n");
      out.write("                    },\n");
      out.write("                    columns: [\n");
      out.write("                        {data: null,\n");
      out.write("                            //set identity for row\n");
      out.write("                            render: function (data, type, row, meta) {\n");
      out.write("                                return meta.row + meta.settings._iDisplayStart + 1;\n");
      out.write("                            }\n");
      out.write("                        },\n");
      out.write("                        {data: 'NameProject'},\n");
      out.write("                        {data: 'startDate'},\n");
      out.write("                        {data: 'endDate'},\n");
      out.write("                        {data: 'techStack'},\n");
      out.write("                        {data: 'decs'},\n");
      out.write("                        {\n");
      out.write("                            data: null,\n");
      out.write("                            render: function (data, type, row) {\n");
      out.write("                                //set id for button = id of employee\n");
      out.write("                                return `\n");
      out.write("                       <button class=\"btn delete-btn\" style=\"background-color: white;box-shadow: none\">\n");
      out.write("    <i class=\"fa-solid fa-trash text-danger\"></i>\n");
      out.write("</button>\n");
      out.write("                       <button class=\"btn edit-btn\" style=\"background-color: white;box-shadow: none\">\n");
      out.write("    <i class=\"fa-solid fa-pen-to-square text-primary\"></i>\n");
      out.write("</button>\n");
      out.write("                   `;\n");
      out.write("                            }\n");
      out.write("                        }\n");
      out.write("                    ],\n");
      out.write("                    \"order\": [[1, 'asc']]\n");
      out.write("                });\n");
      out.write("                $('#example tbody').on('click', '.delete-btn', function () {\n");
      out.write("                    //get data of row which is clicked\n");
      out.write("                    var data = $('#example').DataTable().row($(this).parents('tr')).data();\n");
      out.write("                    //set id for button delete\n");
      out.write("                    var id = data.ProjectID;\n");
      out.write("                    //console id of employee\n");
      out.write("                    console.log(id);\n");
      out.write("                    //use method post to send id to server\n");
      out.write("                    const swalWithBootstrapButtons = Swal.mixin({\n");
      out.write("                        customClass: {\n");
      out.write("                            confirmButton: 'btn btn-success',\n");
      out.write("                            cancelButton: 'btn btn-danger'\n");
      out.write("                        },\n");
      out.write("                        buttonsStyling: false\n");
      out.write("                    });\n");
      out.write("                    swalWithBootstrapButtons.fire({\n");
      out.write("                        title: 'Are you sure?',\n");
      out.write("                        text: \"You won't be able to revert this!\",\n");
      out.write("                        icon: 'warning',\n");
      out.write("                        showCancelButton: true,\n");
      out.write("                        confirmButtonText: 'Delete',\n");
      out.write("                        cancelButtonText: 'Cancel!',\n");
      out.write("                        reverseButtons: true\n");
      out.write("                    }).then((result) => {\n");
      out.write("                        if (result.isConfirmed) {\n");
      out.write("                            swalWithBootstrapButtons.fire(\n");
      out.write("                                    'Deleted!',\n");
      out.write("                                    'Your file has been deleted.',\n");
      out.write("                                    'success'\n");
      out.write("                                    );\n");
      out.write("                            $.ajax({\n");
      out.write("                                method: \"POST\",\n");
      out.write("                                action: \"DELETE\",\n");
      out.write("                                url: \"/HRManagement/DeleteProjectServlet?id=\" + id + \"\",\n");
      out.write("                                success: function (res) {\n");
      out.write("                                    console.log(res);\n");
      out.write("                                    //remove \"\" from string\n");
      out.write("                                    if (res === \"success\") {\n");
      out.write("                                        swal.fire({\n");
      out.write("                                            title: \"Success!\",\n");
      out.write("                                            text: \"Delete success!\",\n");
      out.write("                                            icon: \"success\",\n");
      out.write("                                            button: \"OK\"\n");
      out.write("                                        }).then((value) => {\n");
      out.write("                                            //click oke will hide modal and reload datatable\n");
      out.write("                                            $(\"#mymodal\").modal(\"hide\");\n");
      out.write("                                            $('#example').DataTable().ajax.reload();\n");
      out.write("                                        });\n");
      out.write("                                    } else {\n");
      out.write("                                        swal.fire({\n");
      out.write("                                            title: \"Error!\",\n");
      out.write("                                            //remove \"\" from string\n");
      out.write("                                            text: res.replace(/\"/g, \"\"),\n");
      out.write("                                            icon: \"error\",\n");
      out.write("                                            button: \"OK!\"\n");
      out.write("                                        });\n");
      out.write("                                    }\n");
      out.write("                                },\n");
      out.write("                                error: function (error) {\n");
      out.write("                                    console.log(error);\n");
      out.write("                                    sweetAlert(\"Oops...\", \"Something went wrong!\", \"error\");\n");
      out.write("                                }\n");
      out.write("                            });\n");
      out.write("                        } else if (result.dismiss === Swal.DismissReason.cancel) {\n");
      out.write("                            swalWithBootstrapButtons.fire(\n");
      out.write("                                    'Cancelled'\n");
      out.write("                                    );\n");
      out.write("                        }\n");
      out.write("                    });\n");
      out.write("                });\n");
      out.write("                $('#example tbody').on('click', '.edit-btn', function () {\n");
      out.write("                    //get data of row which is clicked\n");
      out.write("\n");
      out.write("                    var data = $('#example').DataTable().row($(this).parents('tr')).data();\n");
      out.write("                    //set id for button edit\n");
      out.write("                    var id = data.ProjectID;\n");
      out.write("                    var startDate = data.startDate;\n");
      out.write("                    var endDate = data.endDate;\n");
      out.write("                    $(\"#editmodal\").modal(\"show\");\n");
      out.write("                    //set title for modal\n");
      out.write("                    //import a input hidden to modal\n");
      out.write("                    $(\"#editmodal .modal-body\").append(\"<input type='hidden' name='id' value='\" + id + \"'>\");\n");
      out.write("                    $(\"#editmodal input[name='ProjectName']\").val(data.NameProject);\n");
      out.write("                    $(\"#editmodal input[name='Description']\").val(data.decs);\n");
      out.write("                    $.get(\"getTeamValid\", {startDate: startDate, endDate: endDate}, function (responseJson) {                 // Execute Ajax GET request on URL of \"someservlet\" and execute the following function with Ajax response JSON...\n");
      out.write("                        var $select = $(\"#someselect\");                           // Locate HTML DOM element with ID \"someselect\".\n");
      out.write("                        $.each(responseJson, function (key, value) {               // Iterate over the JSON object.\n");
      out.write("                            $(\"<option>\").val(key).text(value).appendTo($select); // Create HTML <option> element, set its value with currently iterated key and its text content with currently iterated item and finally append it to the <select>.\n");
      out.write("                        });\n");
      out.write("                    });\n");
      out.write("                    $(\"#editmodal input[name='EDate']\").val(data.endDate);\n");
      out.write("                    $(\"#editmodal input[name='TechS']\").val(data.techStack);\n");
      out.write("                    //sent all data to server\n");
      out.write("                });\n");
      out.write("\n");
      out.write("            });\n");
      out.write("\n");
      out.write("            $(document).ready(function () {\n");
      out.write("                $(\".myform\").on(\"submit\", function (e) {\n");
      out.write("                    e.preventDefault();\n");
      out.write("                    $.ajax({\n");
      out.write("                        method: \"POST\",\n");
      out.write("                        url: \"/HRManagement/AddProjectServlet\",\n");
      out.write("                        data: new FormData(this),\n");
      out.write("                        processData: false,\n");
      out.write("                        contentType: false,\n");
      out.write("                        success: function (res) {\n");
      out.write("                            if (res === \"success\") {\n");
      out.write("                                swal.fire({\n");
      out.write("                                    title: \"Success!\",\n");
      out.write("                                    text: \"Add success!\",\n");
      out.write("                                    icon: \"success\",\n");
      out.write("                                    button: \"OK\"\n");
      out.write("                                }).then((value) => {\n");
      out.write("                                    //click oke will hide modal and reload datatable\n");
      out.write("                                    $(\"#mymodal\").modal(\"hide\");\n");
      out.write("                                    $('#example').DataTable().ajax.reload();\n");
      out.write("                                });\n");
      out.write("                            } else {\n");
      out.write("                                swal.fire({\n");
      out.write("                                    title: \"Error!\",\n");
      out.write("                                    //remove \"\" from string\n");
      out.write("                                    text: res.replace(/\"/g, \"\"),\n");
      out.write("                                    icon: \"error\",\n");
      out.write("                                    button: \"OK!\"\n");
      out.write("                                });\n");
      out.write("                            }\n");
      out.write("                        },\n");
      out.write("                        error: function (error) {\n");
      out.write("                            sweetAlert(\"Oops...\", \"Something went wrong!\", \"error\");\n");
      out.write("                        }\n");
      out.write("                    });\n");
      out.write("                });\n");
      out.write("            });\n");
      out.write("            $(document).ready(function () {\n");
      out.write("                $(\".editform\").on(\"submit\", function (e) {\n");
      out.write("                    e.preventDefault();\n");
      out.write("                    $.ajax({\n");
      out.write("                        method: \"POST\",\n");
      out.write("                        url: \"/HRManagement/EditProjectServlet\",\n");
      out.write("                        data: new FormData(this),\n");
      out.write("                        processData: false,\n");
      out.write("                        contentType: false,\n");
      out.write("                        success: function (res) {\n");
      out.write("                            console.log(res);\n");
      out.write("                            //remove \"\" from string\n");
      out.write("                            if (res === \"success\") {\n");
      out.write("                                swal.fire({\n");
      out.write("                                    title: \"Success!\",\n");
      out.write("                                    text: \"Edit success!\",\n");
      out.write("                                    icon: \"success\",\n");
      out.write("                                    button: \"OK\"\n");
      out.write("                                }).then((value) => {\n");
      out.write("                                    //click oke will hide modal and reload datatable\n");
      out.write("                                    $(\"#editmodal\").modal(\"hide\");\n");
      out.write("                                    $('#example').DataTable().ajax.reload();\n");
      out.write("                                });\n");
      out.write("                            } else {\n");
      out.write("                                swal.fire({\n");
      out.write("                                    title: \"Error!\",\n");
      out.write("                                    //remove \"\" from string\n");
      out.write("                                    text: res.replace(/\"/g, \"\"),\n");
      out.write("                                    icon: \"error\",\n");
      out.write("                                    button: \"OK!\"\n");
      out.write("                                });\n");
      out.write("                            }\n");
      out.write("                        },\n");
      out.write("                        error: function (error) {\n");
      out.write("                            console.log(error);\n");
      out.write("                            sweetAlert(\"Oops...\", \"Something went wrong!\", \"error\");\n");
      out.write("                        }\n");
      out.write("                    });\n");
      out.write("                });\n");
      out.write("            });\n");
      out.write("            //delete employee\n");
      out.write("            $(document).ready(function () {\n");
      out.write("                var table = $('#example').DataTable();\n");
      out.write("                $('#example tbody').on('click', 'tr', function () {\n");
      out.write("                    $(this).toggleClass('selected');\n");
      out.write("                });\n");
      out.write("                $('#button').click(function () {\n");
      out.write("                    alert(table.rows('.selected').data().length + ' row(s) selected');\n");
      out.write("                });\n");
      out.write("            });\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"main-wrapper\">\n");
      out.write("\n");
      out.write("            <div class=\"header\">\n");
      out.write("                ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "common/navbar.jsp", out, false);
      out.write("  \n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("            <div class=\"sidebar\" id=\"sidebar\">\n");
      out.write("                ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "common/sidebar.jsp", out, false);
      out.write("\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"page-wrapper\">\n");
      out.write("                <div class=\"content container-fluid\">\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div class=\"col-xl-12 col-sm-12 col-12\">\n");
      out.write("                            <div class=\"breadcrumb-path mb-4\">\n");
      out.write("                                <ul class=\"breadcrumb\">\n");
      out.write("                                    <li class=\"breadcrumb-item\"><a href=\"admin.jsp\"><img src=\"assets/img/dash.png\"\n");
      out.write("                                                                                         class=\"mr-2\" alt=\"breadcrumb\" />Home</a>\n");
      out.write("                                    </li>\n");
      out.write("                                    <li class=\"breadcrumb-item active\"> Projects</li>\n");
      out.write("                                </ul>\n");
      out.write("                                <h3>Projects</h3>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-xl-12 col-sm-12 col-12 mb-4\">\n");
      out.write("                            <div class=\"head-link-set\">\n");
      out.write("                                <ul>\n");
      out.write("                                    <li><a class=\"active\" href=\"noStartProject.jsp\">Not Start</a></li>\n");
      out.write("                                    <li><a href=\"inProgressProject.jsp\">In progress</a></li>\n");
      out.write("                                    <li><a href=\"successProject.jsp\">Success</a></li>\n");
      out.write("                                    <li><a href=\"failProject.jsp\">Fail</a></li>\n");
      out.write("                                </ul>\n");
      out.write("                                <button class=\"btn-add\" onclick=\"$('#mymodal').modal('show')\"><i data-feather=\"plus\"></i> Add Project</button>\n");
      out.write("                            </div>\n");
      out.write("                            <form class=\"myform\">\n");
      out.write("                                <div class=\"modal fade\" data-backdrop='static' id=\"mymodal\">\n");
      out.write("                                    <div class=\"modal-dialog\">\n");
      out.write("                                        <div class=\"modal-content\">\n");
      out.write("                                            <div class=\"modal-header\">\n");
      out.write("                                                <h3 class=\"modal-title\">Add New Project</h3>\n");
      out.write("                                                <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\n");
      out.write("                                                    <span aria-hidden=\"true\">&times;</span>\n");
      out.write("                                                </button>\n");
      out.write("                                            </div>\n");
      out.write("\n");
      out.write("                                            <div class=\"modal-body\">\n");
      out.write("                                                <div class=\"form-group\">\n");
      out.write("                                                    <label for=\"ProjectName\">Project Name:</label>\n");
      out.write("                                                    <input type=\"text\" class=\"form-control\" id=\"ProjectName\" name=\"ProjectName\">\n");
      out.write("                                                </div>\n");
      out.write("                                                <div class=\"form-group\">\n");
      out.write("                                                    <label for=\"Description\">Description:</label>\n");
      out.write("                                                    <input type=\"text\" class=\"form-control\" id=\"Description\" name=\"Description\">\n");
      out.write("                                                </div>\n");
      out.write("                                                <div class=\"form-group\">\n");
      out.write("                                                    <label for=\"SDate\">Start Date:</label>\n");
      out.write("                                                    <input type=\"date\" class=\"form-control\" id=\"SDate\" name=\"SDate\">\n");
      out.write("                                                </div>\n");
      out.write("                                                <div class=\"form-group\">\n");
      out.write("                                                    <label for=\"EDate\">End Date</label>\n");
      out.write("                                                    <input type=\"date\" class=\"form-control\" id=\"EDate\" name=\"EDate\">\n");
      out.write("                                                </div>\n");
      out.write("                                                <div class=\"form-group\">\n");
      out.write("                                                    <label for=\"TechS\">Tech Stack</label>\n");
      out.write("                                                    <input type=\"text\" class=\"form-control\" id=\"TechS\" name=\"TechS\">\n");
      out.write("                                                </div>\n");
      out.write("                                            </div>\n");
      out.write("\n");
      out.write("                                            <div class=\"modal-footer\">\n");
      out.write("                                                <input type=\"submit\" value=\"addProject\" class=\"btn btn-warning\" name=\"btAction\" />\n");
      out.write("                                                <input type=\"reset\" value=\"Reset\" class=\"btn btn-danger\" />\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </form>\n");
      out.write("                            <form class=\"editform\">\n");
      out.write("                                <div class=\"modal fade\" data-backdrop='static' id=\"editmodal\">\n");
      out.write("                                    <div class=\"modal-dialog\">\n");
      out.write("                                        <div class=\"modal-content\">\n");
      out.write("                                            <div class=\"modal-header\">\n");
      out.write("                                                <h3 class=\"modal-title\">Edit Project</h3>\n");
      out.write("                                                <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\n");
      out.write("                                                    <span aria-hidden=\"true\">&times;</span>\n");
      out.write("                                                </button>\n");
      out.write("                                            </div>\n");
      out.write("\n");
      out.write("                                            <div class=\"modal-body\">\n");
      out.write("                                                <div class=\"form-group\">\n");
      out.write("                                                    <label for=\"ProjectName\">Project Name:</label>\n");
      out.write("                                                    <input type=\"text\" class=\"form-control\" id=\"ProjectName\" name=\"ProjectName\">\n");
      out.write("                                                </div>\n");
      out.write("                                                <div class=\"form-group\">\n");
      out.write("                                                    <label for=\"Description\">Description:</label>\n");
      out.write("                                                    <input type=\"text\" class=\"form-control\" id=\"Description\" name=\"Description\">\n");
      out.write("                                                </div>\n");
      out.write("                                                <div class=\"form-group\">\n");
      out.write("                                                    <label for=\"Team\">Team: </label>\n");
      out.write("                                                    <select id=\"someselect\" name=\"team_id\">\n");
      out.write("                                                        <option value=\"0\" selected=\"\"> </option>\n");
      out.write("                                                    </select>\n");
      out.write("                                                </div>\n");
      out.write("                                                <div class=\"form-group\">\n");
      out.write("                                                    <label for=\"EDate\">End Date</label>\n");
      out.write("                                                    <input type=\"date\" class=\"form-control\" id=\"EDate\" name=\"EDate\">\n");
      out.write("                                                </div>\n");
      out.write("                                                <div class=\"form-group\">\n");
      out.write("                                                    <label for=\"TechS\">Tech Stack</label>\n");
      out.write("                                                    <input type=\"text\" class=\"form-control\" id=\"TechS\" name=\"TechS\">\n");
      out.write("                                                </div>\n");
      out.write("                                            </div>\n");
      out.write("\n");
      out.write("                                            <div class=\"modal-footer\">\n");
      out.write("                                                <input type=\"submit\" value=\"Save\" class=\"btn btn-warning\" />\n");
      out.write("                                                <input type=\"reset\" value=\"Reset\" class=\"btn btn-danger\" />\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </form>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"col-xl-12 col-sm-12 col-12 mb-4\">\n");
      out.write("                            <div class=\"card\">\n");
      out.write("                                <div class=\"table-heading\">\n");
      out.write("                                    <h2>All Projects</h2>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"table-responsive\">\n");
      out.write("                                    <table id=\"example\" class=\"display\" style=\"width:100%\">\n");
      out.write("                                        <thead>\n");
      out.write("                                            <tr>\n");
      out.write("                                                <th>STT</th>\n");
      out.write("                                                <th>Project Name</th>\n");
      out.write("                                                <th>Start Date</th>\n");
      out.write("                                                <th>End Date</th>\n");
      out.write("                                                <th>Tech Stack</th>\n");
      out.write("                                                <th>Description</th>\n");
      out.write("                                                <th>Action</th>\n");
      out.write("                                            </tr>\n");
      out.write("                                        </thead>\n");
      out.write("                                        <tbody>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                                    </table>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <script src=\"assets/js/popper.min.js\"></script>\n");
      out.write("        <script src=\"assets/js/bootstrap.min.js\"></script>\n");
      out.write("\n");
      out.write("        <script src=\"assets/js/feather.min.js\"></script>\n");
      out.write("\n");
      out.write("        <!--<script src=\"assets/plugins/slimscroll/jquery.slimscroll.min.js\"></script>-->\n");
      out.write("\n");
      out.write("        <script src=\"assets/plugins/select2/js/select2.min.js\"></script>\n");
      out.write("        <script src=\"assets/js/script.js\"></script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
