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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Employee</title>\n");
      out.write("\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/css/bootstrap.min.css\">\n");
      out.write("\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/plugins/select2/css/select2.min.css\">\n");
      out.write("\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/plugins/fontawesome/css/fontawesome.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/plugins/fontawesome/css/all.min.css\">\n");
      out.write("\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/css/style.css\">\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

        List<User> user = (List<User>)request.getAttribute("list");
        //get number of users
        int count = (user == null || user.isEmpty()) ? 0 : user.size();
        
      out.write("\n");
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
      out.write("\n");
      out.write("            <div class=\"page-wrapper\">\n");
      out.write("                <div class=\"content container-fluid\">\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div class=\"col-xl-12 col-sm-12 col-12\">\n");
      out.write("                            <div class=\"breadcrumb-path mb-4\">\n");
      out.write("                                <ul class=\"breadcrumb\">\n");
      out.write("                                    <li class=\"breadcrumb-item\"><a href=\"index.html\"><img src=\"assets/img/dash.png\" class=\"mr-2\" alt=\"breadcrumb\" />Home</a>\n");
      out.write("                                    </li>\n");
      out.write("                                    <li class=\"breadcrumb-item active\"> Employees</li>\n");
      out.write("                                </ul>\n");
      out.write("                                <h3>Employees</h3>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-xl-12 col-sm-12 col-12 mb-4\">\n");
      out.write("                            <div class=\"head-link-set\">\n");
      out.write("                                <ul>\n");
      out.write("                                    <li><a class=\"active\" href=\"#\">All</a></li>\n");
      out.write("                                    <li><a href=\"#\">Teams</a></li>\n");
      out.write("                                    <li><a href=\"#\">Offices</a></li>\n");
      out.write("                                </ul>\n");
      out.write("                                <a class=\"btn-add\" href=\"add-employee.html\"><i data-feather=\"plus\"></i> Add Person</a>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-xl-12 col-sm-12 col-12 mb-4\">\n");
      out.write("                            <div class=\"row\">\n");
      out.write("                                <div class=\"col-xl-10 col-sm-8 col-12 \">\n");
      out.write("                                    <label class=\"employee_count\">");
      out.print(count );
      out.write(" People</label>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"col-xl-1 col-sm-2 col-12 \">\n");
      out.write("                                    <a href=\"employee-grid.html\" class=\"btn-view \"><i data-feather=\"grid\"></i> </a>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"col-xl-1 col-sm-2 col-12 \">\n");
      out.write("                                    <a href=\"#\" class=\"btn-view active\"><i data-feather=\"list\"></i> </a>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-xl-12 col-sm-12 col-12 mb-4\">\n");
      out.write("                            <div class=\"card\">\n");
      out.write("                                <div class=\"table-heading\">\n");
      out.write("                                    <h2>Project Summery</h2>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"table-responsive\">\n");
      out.write("                                    <table class=\"table  custom-table no-footer\" id=\"userTable\">\n");
      out.write("                                        <thead>\n");
      out.write("                                            <tr>\n");
      out.write("                                                <th>UserID</th>\n");
      out.write("                                                <th>Name</th>\n");
      out.write("                                                <th>Phone</th>\n");
      out.write("                                                <th>Email</th>\n");
      out.write("                                                <th>Username</th>\n");
      out.write("                                                <th>Password</th>\n");
      out.write("                                                <th>Address</th>\n");
      out.write("                                                <th>Birthday</th>\n");
      out.write("                                                <th>ExperienceId</th>\n");
      out.write("                                                <th>Team_ID</th>\n");
      out.write("                                            </tr>\n");
      out.write("                                        </thead>\n");
      out.write("                                        <tbody>\n");
      out.write("                                            ");
 for (User u: user) {
      out.write("\n");
      out.write("                                            <tr>\n");
      out.write("                                                <td>");
      out.print(u.getUserID());
      out.write("</td>\n");
      out.write("                                                <td>");
      out.print(u.getName());
      out.write("</td>\n");
      out.write("                                                <td>");
      out.print(u.getPhone());
      out.write("</td>\n");
      out.write("                                                <td>");
      out.print(u.getEmail());
      out.write("</td>\n");
      out.write("                                                <td>");
      out.print(u.getUsername());
      out.write("</td>\n");
      out.write("                                                <td>");
      out.print(u.getPassword());
      out.write("</td>\n");
      out.write("                                                <td>");
      out.print(u.getAddress());
      out.write("</td>\n");
      out.write("                                                <td>");
      out.print(u.getBirthday());
      out.write("</td>\n");
      out.write("                                                <td>");
      out.print(u.getExperienceId());
      out.write("</td>\n");
      out.write("                                                <td>");
      out.print(u.getTeam_ID());
      out.write("</td>\n");
      out.write("                                            </tr>\n");
      out.write("                                            ");
}
      out.write("\n");
      out.write("                                        </tbody>\n");
      out.write("                                    </table>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <script src=\"assets/js/jquery-3.6.0.min.js\"></script>\n");
      out.write("\n");
      out.write("        <script src=\"assets/js/popper.min.js\"></script>\n");
      out.write("        <script src=\"assets/js/bootstrap.min.js\"></script>\n");
      out.write("\n");
      out.write("        <script src=\"assets/js/feather.min.js\"></script>\n");
      out.write("\n");
      out.write("        <!--<script src=\"assets/plugins/slimscroll/jquery.slimscroll.min.js\"></script>-->\n");
      out.write("\n");
      out.write("        <script src=\"assets/plugins/select2/js/select2.min.js\"></script>\n");
      out.write("\n");
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
