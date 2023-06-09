package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Admin Page</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.2.1.slim.min.js\" integrity=\"sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js\" integrity=\"sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js\" integrity=\"sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/css/bootstrap.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/plugins/fontawesome/css/fontawesome.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/plugins/fontawesome/css/all.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/css/style.css\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"main-wrapper\">\n");
      out.write("\n");
      out.write("            <div class=\"header\">\n");
      out.write("\n");
      out.write("                <div class=\"header-left\">\n");
      out.write("                    <a href=\"index.html\" class=\"logo\">\n");
      out.write("                        <img src=\"assets/img/logo.png\" alt=\"Logo\">\n");
      out.write("                    </a>\n");
      out.write("                    <a href=\"index.html\" class=\"logo logo-small\">\n");
      out.write("                        <img src=\"assets/img/logo-small.png\" alt=\"Logo\" width=\"30\" height=\"30\">\n");
      out.write("                    </a>\n");
      out.write("                    <a href=\"javascript:void(0);\" id=\"toggle_btn\">\n");
      out.write("                        <span class=\"bar-icon\">\n");
      out.write("                            <span></span>\n");
      out.write("                            <span></span>\n");
      out.write("                            <span></span>\n");
      out.write("                        </span>\n");
      out.write("                    </a>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                <div class=\"top-nav-search\">\n");
      out.write("                    <form>\n");
      out.write("                        <input type=\"text\" class=\"form-control\" placeholder=\"\">\n");
      out.write("                        <button class=\"btn\" type=\"submit\"><i class=\"fas fa-search\"></i></button>\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                <a class=\"mobile_btn\" id=\"mobile_btn\">\n");
      out.write("                    <i class=\"fas fa-bars\"></i>\n");
      out.write("                </a>\n");
      out.write("\n");
      out.write("\n");
      out.write("                <ul class=\"nav user-menu\">\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                    <li class=\"nav-item dropdown has-arrow main-drop\">\n");
      out.write("                        <a href=\"#\" class=\"dropdown-toggle nav-link\" data-toggle=\"dropdown\">\n");
      out.write("                            <span class=\"user-img\">\n");
      out.write("                                <img src=\"assets/img/profile.jpg\" alt=\"\">\n");
      out.write("                                <span class=\"status online\"></span>\n");
      out.write("                            </span>\n");
      out.write("                            <span>Admin</span>\n");
      out.write("                        </a>\n");
      out.write("                        <div class=\"dropdown-menu\">\n");
      out.write("                            <a class=\"dropdown-item\" href=\"profile.html\"><i data-feather=\"user\" class=\"mr-1\"></i> Profile</a>\n");
      out.write("                            <a class=\"dropdown-item\" href=\"settings.html\"><i data-feather=\"settings\" class=\"mr-1\"></i> Settings</a>\n");
      out.write("                            <a class=\"dropdown-item\" href=\"login.html\"><i data-feather=\"log-out\" class=\"mr-1\"></i> Logout</a>\n");
      out.write("                        </div>\n");
      out.write("                    </li>\n");
      out.write("\n");
      out.write("                </ul>\n");
      out.write("                <div class=\"dropdown mobile-user-menu show\">\n");
      out.write("                    <a href=\"#\" class=\"nav-link dropdown-toggle\" data-toggle=\"dropdown\" aria-expanded=\"false\"><i class=\"fa fa-ellipsis-v\"></i></a>\n");
      out.write("                    <div class=\"dropdown-menu dropdown-menu-right \">\n");
      out.write("                        <a class=\"dropdown-item\" href=\"profile.html\">My Profile</a>\n");
      out.write("                        <a class=\"dropdown-item\" href=\"settings.html\">Settings</a>\n");
      out.write("                        <a class=\"dropdown-item\" href=\"login.html\">Logout</a>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("            <div class=\"sidebar\" id=\"sidebar\">\n");
      out.write("                <div class=\"sidebar-inner slimscroll\">\n");
      out.write("                    <div class=\"sidebar-contents\">\n");
      out.write("                        <div id=\"sidebar-menu\" class=\"sidebar-menu\">\n");
      out.write("                            <div class=\"mobile-show\">\n");
      out.write("                                <div class=\"offcanvas-menu\">\n");
      out.write("                                    <div class=\"user-info align-center bg-theme text-center\">\n");
      out.write("                                        <span class=\"lnr lnr-cross  text-white\" id=\"mobile_btn_close\">X</span>\n");
      out.write("                                        <a href=\"javascript:void(0)\" class=\"d-block menu-style text-white\">\n");
      out.write("                                            <div class=\"user-avatar d-inline-block mr-3\">\n");
      out.write("                                                <img src=\"assets/img/profiles/avatar-18.jpg\" alt=\"user avatar\" class=\"rounded-circle\" width=\"50\">\n");
      out.write("                                            </div>\n");
      out.write("                                        </a>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"sidebar-input\">\n");
      out.write("                                    <div class=\"top-nav-search\">\n");
      out.write("                                        <form>\n");
      out.write("                                            <input type=\"text\" class=\"form-control\" placeholder=\"Search here\">\n");
      out.write("                                            <button class=\"btn\" type=\"submit\"><i class=\"fas fa-search\"></i></button>\n");
      out.write("                                        </form>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <ul>\n");
      out.write("                                <li class=\"active\">\n");
      out.write("                                    <a href=\"index.html\"><img src=\"assets/img/home.svg\" alt=\"sidebar_img\"> <span>Dashboard</span></a>\n");
      out.write("                                </li>\n");
      out.write("                                <li>\n");
      out.write("                                    <a href=\"employee.html\"><img src=\"assets/img/employee.svg\" alt=\"sidebar_img\"><span> Employees</span></a>\n");
      out.write("                                </li>\n");
      out.write("                                <li>\n");
      out.write("                                    <a href=\"company.html\"><img src=\"assets/img/company.svg\" alt=\"sidebar_img\"> <span> Company</span></a>\n");
      out.write("                                </li>\n");
      out.write("                                <li>\n");
      out.write("                                    <a href=\"calendar.html\"><img src=\"assets/img/calendar.svg\" alt=\"sidebar_img\"> <span>Calendar</span></a>\n");
      out.write("                                </li>\n");
      out.write("                                <li>\n");
      out.write("                                    <a href=\"leave.html\"><img src=\"assets/img/leave.svg\" alt=\"sidebar_img\"> <span>Leave</span></a>\n");
      out.write("                                </li>\n");
      out.write("                                <li>\n");
      out.write("                                    <a href=\"review.html\"><img src=\"assets/img/review.svg\" alt=\"sidebar_img\"><span>Review</span></a>\n");
      out.write("                                </li>\n");
      out.write("                                <li>\n");
      out.write("                                    <a href=\"report.html\"><img src=\"assets/img/report.svg\" alt=\"sidebar_img\"><span>Report</span></a>\n");
      out.write("                                </li>\n");
      out.write("                                <li>\n");
      out.write("                                    <a href=\"manage.html\"><img src=\"assets/img/manage.svg\" alt=\"sidebar_img\"> <span>Manage</span></a>\n");
      out.write("                                </li>\n");
      out.write("                                <li>\n");
      out.write("                                    <a href=\"settings.html\"><img src=\"assets/img/settings.svg\" alt=\"sidebar_img\"><span>Settings</span></a>\n");
      out.write("                                </li>\n");
      out.write("                                <li>\n");
      out.write("                                    <a href=\"profile.html\"><img src=\"assets/img/profile.svg\" alt=\"sidebar_img\"> <span>Profile</span></a>\n");
      out.write("                                </li>\n");
      out.write("                            </ul>\n");
      out.write("                            <ul class=\"logout\">\n");
      out.write("                                <li>\n");
      out.write("                                    <a href=\"profile.html\"><img src=\"assets/img/logout.svg\" alt=\"sidebar_img\"><span>Log out</span></a>\n");
      out.write("                                </li>\n");
      out.write("                            </ul>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("            <div class=\"page-wrapper\">\n");
      out.write("                <div class=\"content container-fluid\">\n");
      out.write("                    <div class=\"row mb-4\">\n");
      out.write("                        <div class=\"col-xl-3 col-sm-6 col-12\">\n");
      out.write("                            <div class=\"card board1 fill1 \">\n");
      out.write("                                <div class=\"card-body\">\n");
      out.write("                                    <div class=\"card_widget_header\">\n");
      out.write("                                        <label>Employees</label>\n");
      out.write("                                        <h4>700</h4>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"card_widget_img\">\n");
      out.write("                                        <img src=\"assets/img/dash1.png\" alt=\"card-img\" />\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-xl-3 col-sm-6 col-12\">\n");
      out.write("                            <div class=\"card board1 fill2 \">\n");
      out.write("                                <div class=\"card-body\">\n");
      out.write("                                    <div class=\"card_widget_header\">\n");
      out.write("                                        <label>Companies</label>\n");
      out.write("                                        <h4>30</h4>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"card_widget_img\">\n");
      out.write("                                        <img src=\"assets/img/dash2.png\" alt=\"card-img\" />\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-xl-3 col-sm-6 col-12\">\n");
      out.write("                            <div class=\"card board1 fill3 \">\n");
      out.write("                                <div class=\"card-body\">\n");
      out.write("                                    <div class=\"card_widget_header\">\n");
      out.write("                                        <label>Leaves</label>\n");
      out.write("                                        <h4>9</h4>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"card_widget_img\">\n");
      out.write("                                        <img src=\"assets/img/dash3.png\" alt=\"card-img\" />\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-xl-3 col-sm-6 col-12\">\n");
      out.write("                            <div class=\"card board1 fill4 \">\n");
      out.write("                                <div class=\"card-body\">\n");
      out.write("                                    <div class=\"card_widget_header\">\n");
      out.write("                                        <label>Salary</label>\n");
      out.write("                                        <h4>$5.8M</h4>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"card_widget_img\">\n");
      out.write("                                        <img src=\"assets/img/dash4.png\" alt=\"card-img\" />\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div class=\"col-xl-6 d-flex mobile-h\">\n");
      out.write("                            <div class=\"card flex-fill\">\n");
      out.write("                                <div class=\"card-header\">\n");
      out.write("                                    <div class=\"d-flex justify-content-between align-items-center\">\n");
      out.write("                                        <h5 class=\"card-title\">Total Employees</h5>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"card-body\">\n");
      out.write("                                    <div id=\"invoice_chart\"></div>\n");
      out.write("                                    <div class=\"text-center text-muted\">\n");
      out.write("                                        <div class=\"row\">\n");
      out.write("\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-xl-6 d-flex\">\n");
      out.write("                            <div class=\"card flex-fill\">\n");
      out.write("                                <div class=\"card-header\">\n");
      out.write("                                    <div class=\"d-flex justify-content-between align-items-center\">\n");
      out.write("                                        <h5 class=\"card-title\">Total Salary By Unit</h5>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"card-body\">\n");
      out.write("                                    <div id=\"sales_chart\"></div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div class=\"card-header \">\n");
      out.write("                            <h4 class=\"card-title-dash\">Today Attendance</h4>\n");
      out.write("                        </div>\n");
      out.write("                        \n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("        </div>\n");
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
