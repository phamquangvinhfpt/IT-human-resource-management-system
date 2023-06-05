package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
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
      out.write("        <script src=\"https://code.jquery.com/jquery-3.7.0.min.js\" integrity=\"sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("        <script src=\"https://kit.fontawesome.com/b3fa33d056.js\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        ");

            List<User> user = (List<User>) request.getAttribute("list");
            //get number of users
            int count = (user == null || user.isEmpty()) ? 0 : user.size();
        
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
      out.write("                                    <li><a href=\"#\">Teams</a></li>\r\n");
      out.write("                                </ul>\r\n");
      out.write("                                <button class=\"btn-add\" onclick=\"$('#mymodal').modal('show')\"><i data-feather=\"plus\"></i> Add Person</button>\r\n");
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
      out.write("                                                <label for=\"userID\">UserID:</label>\r\n");
      out.write("                                                <input type=\"text\" class=\"form-control\" id=\"userID\" name=\"userID\">\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                            <div class=\"form-group\">\r\n");
      out.write("                                                <label for=\"name\">Name:</label>\r\n");
      out.write("                                                <input type=\"text\" class=\"form-control\" id=\"name\" name=\"name\">\r\n");
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
      out.write("                                                <input type=\"text\" class=\"form-control\" id=\"experienceId\" name=\"experienceId\">\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                            <div class=\"form-group\">\r\n");
      out.write("                                                <label for=\"teamID\">Team_ID:</label>\r\n");
      out.write("                                                <input type=\"text\" class=\"form-control\" id=\"teamID\" name=\"teamID\">\r\n");
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
      out.write("                                <div class=\"col-xl-10 col-sm-8 col-12 \">\r\n");
      out.write("                                    <label class=\"employee_count\">");
      out.print(count);
      out.write(" People</label>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"col-xl-1 col-sm-2 col-12 \">\r\n");
      out.write("                                    <a href=\"employee-grid.html\" class=\"btn-view \"><i data-feather=\"grid\"></i> </a>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"col-xl-1 col-sm-2 col-12 \">\r\n");
      out.write("                                    <a href=\"#\" class=\"btn-view active\"><i data-feather=\"list\"></i> </a>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"col-xl-12 col-sm-12 col-12 mb-4\">\r\n");
      out.write("                            <div class=\"card\">\r\n");
      out.write("                                <div class=\"table-heading\">\r\n");
      out.write("                                    <h2>Project Summery</h2>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"table-responsive\">\r\n");
      out.write("                                    <table class=\"table  custom-table no-footer\" id=\"userTable\">\r\n");
      out.write("                                        <thead>\r\n");
      out.write("                                            <tr>\r\n");
      out.write("                                                <th>UserID</th>\r\n");
      out.write("                                                <th>Name</th>\r\n");
      out.write("                                                <th>Phone</th>\r\n");
      out.write("                                                <th>Email</th>\r\n");
      out.write("                                                <th>Username</th>\r\n");
      out.write("                                                <th>Password</th>\r\n");
      out.write("                                                <th>Address</th>\r\n");
      out.write("                                                <th>Birthday</th>\r\n");
      out.write("                                                <th>ExperienceId</th>\r\n");
      out.write("                                                <th>Team_ID</th>\r\n");
      out.write("                                                <th>Action</th>\r\n");
      out.write("                                            </tr>\r\n");
      out.write("                                        </thead>\r\n");
      out.write("                                        <tbody>\r\n");
      out.write("                                            ");
 for (User u : user) {
      out.write("\r\n");
      out.write("                                            <tr>\r\n");
      out.write("                                                <td>");
      out.print(u.getUserID());
      out.write("</td>\r\n");
      out.write("                                                <td>");
      out.print(u.getName());
      out.write("</td>\r\n");
      out.write("                                                <td>");
      out.print(u.getPhone());
      out.write("</td>\r\n");
      out.write("                                                <td>");
      out.print(u.getEmail());
      out.write("</td>\r\n");
      out.write("                                                <td>");
      out.print(u.getUsername());
      out.write("</td>\r\n");
      out.write("                                                <td>");
      out.print(u.getPassword());
      out.write("</td>\r\n");
      out.write("                                                <td>");
      out.print(u.getAddress());
      out.write("</td>\r\n");
      out.write("                                                <td>");
      out.print(u.getBirthday());
      out.write("</td>\r\n");
      out.write("                                                <td>");
      out.print(u.getExperienceId());
      out.write("</td>\r\n");
      out.write("                                                <td>");
      out.print(u.getTeam_ID());
      out.write("</td>\r\n");
      out.write("                                                <td>\r\n");
      out.write("                                                    <button style=\"background-color: white;box-shadow: none\" class=\"btn\"><i class=\"fa-solid fa-trash text-danger\"></i></button>\r\n");
      out.write("                                                    <button style=\"background-color: white;box-shadow: none\" class=\"btn\"><i class=\"fa-solid fa-pen-to-square text-primary\"></i></button>\r\n");
      out.write("                                                </td>\r\n");
      out.write("                                            </tr>\r\n");
      out.write("                                            ");
}
      out.write("\r\n");
      out.write("                                        </tbody>\r\n");
      out.write("                                    </table>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <script src=\"assets/js/jquery-3.6.0.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("        <script src=\"assets/js/popper.min.js\"></script>\r\n");
      out.write("        <script src=\"assets/js/bootstrap.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("        <script src=\"assets/js/feather.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("        <!--<script src=\"assets/plugins/slimscroll/jquery.slimscroll.min.js\"></script>-->\r\n");
      out.write("\r\n");
      out.write("        <script src=\"assets/plugins/select2/js/select2.min.js\"></script>\r\n");
      out.write("        <script src=\"assets/js/script.js\"></script>\r\n");
      out.write("        <script type=\"text/javascript\">\r\n");
      out.write("                                    $(document).ready(function () {\r\n");
      out.write("                                    $(\".myform\").on(\"submit\", function (e) {\r\n");
      out.write("                                    e.preventDefault();\r\n");
      out.write("                                            $.ajax({\r\n");
      out.write("                                            method: \"POST\",\r\n");
      out.write("                                                    url: \"/HRManagement/addEmployee\",\r\n");
      out.write("                                                    data: new FormData(this),\r\n");
      out.write("                                                    processData:false,\r\n");
      out.write("                                                    contentType:false,\r\n");
      out.write("                                                    success:function(res){\r\n");
      out.write("                                                    console.log(res);\r\n");
      out.write("                                                    },\r\n");
      out.write("                                                    error:function(error){\r\n");
      out.write("                                                    console.log(error);\r\n");
      out.write("                                                    }\r\n");
      out.write("                                            });\r\n");
      out.write("                                    });\r\n");
      out.write("                                    });\r\n");
      out.write("        </script>\r\n");
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
