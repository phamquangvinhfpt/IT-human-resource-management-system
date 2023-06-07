package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import sample.dto.User;

public final class admin_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Admin Page</title>\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">\r\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.2.1.slim.min.js\" integrity=\"sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js\" integrity=\"sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js\" integrity=\"sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/css/bootstrap.min.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/plugins/fontawesome/css/fontawesome.min.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/plugins/fontawesome/css/all.min.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/css/style.css\">\r\n");
      out.write("    </head>\r\n");
      out.write("    ");

        User user = (User) session.getAttribute("user");
        if (user == null) {
            response.sendRedirect("login.jsp");
        } else if (!user.getRole().equals("admin")) {
            // If user is not an admin, display an error message
            String errorMessage = "You don't have the necessary privileges to perform this action";
            request.setAttribute("errorMessage", errorMessage);
            // Forward the request to an error page to display the message
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    
      out.write("\r\n");
      out.write("    <body>\r\n");
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
      out.write("                    <div class=\"page-name \tmb-4\">\r\n");
      out.write("                        <h4 class=\"m-0\"><img src=\"assets/img/profile.jpg\" class=\"mr-1\" alt=\"profile\" /> Welcome Admin</h4>\r\n");
      out.write("                        <label id='date-time'></label>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"row mb-4\">\r\n");
      out.write("                        <div class=\"col-xl-12 col-sm-12 col-12\">\r\n");
      out.write("                            <div class=\"breadcrumb-path \">\r\n");
      out.write("                                <ul class=\"breadcrumb\">\r\n");
      out.write("                                    <li class=\"breadcrumb-item\"><a href=\"index.html\"><img src=\"assets/img/dash.png\" class=\"mr-3\" alt=\"breadcrumb\" />Home</a>\r\n");
      out.write("                                    </li>\r\n");
      out.write("                                    <li class=\"breadcrumb-item active\">Dashboard</li>\r\n");
      out.write("                                </ul>\r\n");
      out.write("                                <h3>Admin Dashboard</h3>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"row mb-4\">\r\n");
      out.write("                        <div class=\"col-xl-3 col-sm-6 col-12\">\r\n");
      out.write("                            <div class=\"card board1 fill1 \">\r\n");
      out.write("                                <div class=\"card-body\">\r\n");
      out.write("                                    <div class=\"card_widget_header\">\r\n");
      out.write("                                        <label>Employees</label>\r\n");
      out.write("                                        <h4>700</h4>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <div class=\"card_widget_img\">\r\n");
      out.write("                                        <img src=\"assets/img/dash1.png\" alt=\"card-img\" />\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"col-xl-3 col-sm-6 col-12\">\r\n");
      out.write("                            <div class=\"card board1 fill2 \">\r\n");
      out.write("                                <div class=\"card-body\">\r\n");
      out.write("                                    <div class=\"card_widget_header\">\r\n");
      out.write("                                        <label>Team</label>\r\n");
      out.write("                                        <h4>30</h4>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <div class=\"card_widget_img\">\r\n");
      out.write("                                        <img src=\"assets/img/group.png\" alt=\"card-img\" />\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"col-xl-3 col-sm-6 col-12\">\r\n");
      out.write("                            <div class=\"card board1 fill3 \">\r\n");
      out.write("                                <div class=\"card-body\">\r\n");
      out.write("                                    <div class=\"card_widget_header\">\r\n");
      out.write("                                        <label>Leaves</label>\r\n");
      out.write("                                        <h4>9</h4>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <div class=\"card_widget_img\">\r\n");
      out.write("                                        <img src=\"assets/img/dash3.png\" alt=\"card-img\" />\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"col-xl-3 col-sm-6 col-12\">\r\n");
      out.write("                            <div class=\"card board1 fill4 \">\r\n");
      out.write("                                <div class=\"card-body\">\r\n");
      out.write("                                    <div class=\"card_widget_header\">\r\n");
      out.write("                                        <label>Salary</label>\r\n");
      out.write("                                        <h4>$5.8M</h4>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <div class=\"card_widget_img\">\r\n");
      out.write("                                        <img src=\"assets/img/dash4.png\" alt=\"card-img\" />\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"row\">\r\n");
      out.write("                        <div class=\"col-xl-6 d-flex mobile-h\">\r\n");
      out.write("                            <div class=\"card flex-fill\">\r\n");
      out.write("                                <div class=\"card-header\">\r\n");
      out.write("                                    <div class=\"d-flex justify-content-between align-items-center\">\r\n");
      out.write("                                        <h5 class=\"card-title\">Total Employees</h5>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"card-body\">\r\n");
      out.write("                                    <div id=\"invoice_chart\"></div>\r\n");
      out.write("                                    <div class=\"text-center text-muted\">\r\n");
      out.write("                                        <div class=\"row\">\r\n");
      out.write("                                            <div class=\"col-4\">\r\n");
      out.write("                                                <div class=\"mt-4\">\r\n");
      out.write("                                                    <p class=\"mb-2 text-truncate\"><i class=\"fas fa-circle text-primary mr-1\"></i> Business</p>\r\n");
      out.write("                                                </div>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                            <div class=\"col-4\">\r\n");
      out.write("                                                <div class=\"mt-4\">\r\n");
      out.write("                                                    <p class=\"mb-2 text-truncate\"><i class=\"fas fa-circle text-success mr-1\"></i> Testing</p>\r\n");
      out.write("                                                </div>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                            <div class=\"col-4\">\r\n");
      out.write("                                                <div class=\"mt-4\">\r\n");
      out.write("                                                    <p class=\"mb-2 text-truncate\"><i class=\"fas fa-circle text-danger mr-1\"></i> Development</p>\r\n");
      out.write("                                                </div>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"col-xl-6 d-flex\">\r\n");
      out.write("                            <div class=\"card flex-fill\">\r\n");
      out.write("                                <div class=\"card-header\">\r\n");
      out.write("                                    <div class=\"d-flex justify-content-between align-items-center\">\r\n");
      out.write("                                        <h5 class=\"card-title\">Total Salary By Unit</h5>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"card-body\">\r\n");
      out.write("                                    <div id=\"sales_chart\"></div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            <script src=\"assets/js/jquery-3.6.0.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("            <script src=\"assets/js/popper.min.js\"></script>\r\n");
      out.write("            <script src=\"assets/js/bootstrap.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("            <script src=\"assets/js/feather.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("            <script src=\"assets/plugins/slimscroll/jquery.slimscroll.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("            <script src=\"assets/plugins/apexchart/apexcharts.min.js\"></script>\r\n");
      out.write("            <script src=\"assets/plugins/apexchart/chart-data.js\"></script>\r\n");
      out.write("\r\n");
      out.write("            <script src=\"assets/js/script.js\"></script>\r\n");
      out.write("            <script>\r\n");
      out.write("                var dt = new Date();\r\n");
      out.write("                document.getElementById('date-time').innerHTML = dt;\r\n");
      out.write("            </script>\r\n");
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
