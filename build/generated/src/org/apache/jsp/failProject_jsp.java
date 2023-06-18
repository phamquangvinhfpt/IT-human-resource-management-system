package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class failProject_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("            function format(d) {\n");
      out.write("                return (\n");
      out.write("                        '<table cellpadding=\"5\" cellspacing=\"0\" border=\"0\" style=\"padding-left:50px;\">' +\n");
      out.write("                        '<tr>' +\n");
      out.write("                        '<td>Team: </td>' +\n");
      out.write("                        '<td>' +\n");
      out.write("                        d.team.Team_name +\n");
      out.write("                        '</td>' +\n");
      out.write("                        '</tr>' +\n");
      out.write("                        '<tr>' +\n");
      out.write("                        '<td>Description: </td>' +\n");
      out.write("                        '<td>' +\n");
      out.write("                        d.team.decs +\n");
      out.write("                        '</td>' +\n");
      out.write("//                        '</tr>' +\n");
      out.write("//                        '<tr>' +\n");
      out.write("//                        '<td>Project:</td>' +\n");
      out.write("//                        '<td>' + d.NameProject + '</td>' +\n");
      out.write("//                        '</tr>' +\n");
      out.write("//                        '<tr>' +\n");
      out.write("//                        '<td>Team:</td>' +\n");
      out.write("//                        '<td>' + d.Team_Name + '</td>' +\n");
      out.write("                        '</tr>' +\n");
      out.write("                        '</table>'\n");
      out.write("                        );\n");
      out.write("            }\n");
      out.write("            $(document).ready(function () {\n");
      out.write("\n");
      out.write("                var table = $('#example').DataTable({\n");
      out.write("                    ajax: {\n");
      out.write("                        url: '/HRManagement/FailProjectServlet',\n");
      out.write("                        dataSrc: ''\n");
      out.write("                    },\n");
      out.write("                    columns: [\n");
      out.write("                        {\n");
      out.write("                            className: 'dt-control',\n");
      out.write("                            orderable: false,\n");
      out.write("                            data: null,\n");
      out.write("                            defaultContent: ''\n");
      out.write("                        },\n");
      out.write("                        {\n");
      out.write("                            data: null,\n");
      out.write("                            //set identity for row\n");
      out.write("                            render: function (data, type, row, meta) {\n");
      out.write("                                return meta.row + meta.settings._iDisplayStart + 1;\n");
      out.write("                            }\n");
      out.write("                        },\n");
      out.write("                        {\n");
      out.write("                            data: 'project.NameProject'\n");
      out.write("                        }\n");
      out.write("                        ,\n");
      out.write("                        {\n");
      out.write("                            data: 'project.startDate'\n");
      out.write("                        }\n");
      out.write("                        ,\n");
      out.write("                        {\n");
      out.write("                            data: 'project.endDate'\n");
      out.write("                        }\n");
      out.write("                        ,\n");
      out.write("                        {\n");
      out.write("                            data: 'project.techStack'\n");
      out.write("                        }\n");
      out.write("                        ,\n");
      out.write("                        {\n");
      out.write("                            data: 'project.decs'\n");
      out.write("                        }\n");
      out.write("                    ],\n");
      out.write("                    \"order\": [[1, 'asc']]\n");
      out.write("\n");
      out.write("                });\n");
      out.write("                $('#example tbody').on('click', 'td.dt-control', function () {\n");
      out.write("                    var tr = $(this).closest('tr');\n");
      out.write("                    var row = table.row(tr);\n");
      out.write("\n");
      out.write("                    if (row.child.isShown()) {\n");
      out.write("                        // This row is already open - close it\n");
      out.write("                        row.child.hide();\n");
      out.write("                        tr.removeClass('shown');\n");
      out.write("                    } else {\n");
      out.write("                        // Open this row\n");
      out.write("                        row.child(format(row.data())).show();\n");
      out.write("                        tr.addClass('shown');\n");
      out.write("                    }\n");
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
      out.write("\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("            <div class=\"sidebar\" id=\"sidebar\">\n");
      out.write("                ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "common/sidebar.jsp", out, false);
      out.write("\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("            <div class=\"page-wrapper\">\n");
      out.write("                <div class=\"content container-fluid\">\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div class=\"col-xl-12 col-sm-12 col-12\">\n");
      out.write("                            <div class=\"breadcrumb-path mb-4\">\n");
      out.write("                                <ul class=\"breadcrumb\">\n");
      out.write("                                    <li class=\"breadcrumb-item\"><a href=\"index.html\"><img src=\"assets/img/dash.png\"\n");
      out.write("                                                                                          class=\"mr-2\" alt=\"breadcrumb\" />Home</a>\n");
      out.write("                                    </li>\n");
      out.write("                                    <li class=\"breadcrumb-item active\"> Projects</li>\n");
      out.write("                                </ul>\n");
      out.write("                                <h3>Projects</h3>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-xl-12 col-sm-12 col-12 mb-4\">\n");
      out.write("                            <div class=\"head-link-set\">\n");
      out.write("                                <ul>\n");
      out.write("                                    <li><a href=\"noStartProject.jsp\">Not Start</a></li>\n");
      out.write("                                    <li><a href=\"inProgressProject.jsp\">In progress</a></li>\n");
      out.write("                                    <li><a class=\"active\" href=\"successProject.jsp\">Success</a></li>\n");
      out.write("                                    <li><a href=\"failProject.jsp\">Fail</a></li>\n");
      out.write("                                </ul>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-xl-12 col-sm-12 col-12 mb-4\">\n");
      out.write("                            <div class=\"card\">\n");
      out.write("                                <div class=\"table-heading\">\n");
      out.write("                                    <h2>All Projects</h2>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"table-responsive\">\n");
      out.write("                                    <table id=\"example\" class=\"display\" style=\"width:100%\">\n");
      out.write("                                        <thead>\n");
      out.write("                                            <tr>\n");
      out.write("                                                <th></th>\n");
      out.write("                                                <th>STT</th>\n");
      out.write("                                                <th>Project Name</th>\n");
      out.write("                                                <th>Start Date</th>\n");
      out.write("                                                <th>End Date</th>\n");
      out.write("                                                <th>Tech Stack</th>\n");
      out.write("                                                <th>Description</th>\n");
      out.write("                                            </tr>\n");
      out.write("                                        </thead>\n");
      out.write("                                        <tbody>\n");
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
