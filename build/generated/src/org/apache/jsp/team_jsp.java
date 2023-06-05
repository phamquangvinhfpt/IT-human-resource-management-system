package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class team_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_set_var_value_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_set_var_value_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
    _jspx_tagPool_c_set_var_value_nobody.release();
    _jspx_tagPool_c_if_test.release();
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
      response.setContentType("text/html; charset=UTF-8");
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("\n");
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
      out.write("        <style>\n");
      out.write("            .btn-add-e{\n");
      out.write("                color: #000;\n");
      out.write("                display: inline-block;\n");
      out.write("                margin: 15px 0;\n");
      out.write("                text-align: center;\n");
      out.write("                padding: 12px;\n");
      out.write("                font-size: 14px;\n");
      out.write("                border-radius: 10px;\n");
      out.write("                background-color: #009efb\n");
      out.write("\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"main-wrapper\">\n");
      out.write("\n");
      out.write("            <div class=\"header\">\n");
      out.write("\n");
      out.write("                <div class=\"header-left\">\n");
      out.write("                    <a href=\"index.html\" class=\"logo\">\n");
      out.write("                        <span>HR Management</span>\n");
      out.write("                    </a>\n");
      out.write("                    <a href=\"index.html\" class=\"logo logo-small\">\n");
      out.write("                        <span>HRMS</span>\n");
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
      out.write("                    <li class=\"nav-item dropdown\">\n");
      out.write("                        <a href=\"#\" class=\"dropdown-toggle nav-link pr-0\" data-toggle=\"dropdown\">\n");
      out.write("                            <i data-feather=\"bell\"></i> <span class=\"badge badge-pill\"></span>\n");
      out.write("                        </a>\n");
      out.write("                        <div class=\"dropdown-menu notifications\">\n");
      out.write("                            <div class=\"topnav-dropdown-header\">\n");
      out.write("                                <span class=\"notification-title\">Notifications</span>\n");
      out.write("                                <a href=\"javascript:void(0)\" class=\"clear-noti\"> Clear All</a>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"noti-content\">\n");
      out.write("                                <ul class=\"notification-list\">\n");
      out.write("                                    <li class=\"notification-message\">\n");
      out.write("                                        <a href=\"activities.html\">\n");
      out.write("                                            <div class=\"media\">\n");
      out.write("                                                <span class=\"avatar avatar-sm\">\n");
      out.write("                                                    <img class=\"avatar-img rounded-circle\" alt=\"\" src=\"assets/img/profiles/avatar-02.jpg\">\n");
      out.write("                                                </span>\n");
      out.write("                                                <div class=\"media-body\">\n");
      out.write("                                                    <p class=\"noti-details\"><span class=\"noti-title\">Brian Johnson</span> paid the invoice <span class=\"noti-title\">#DF65485</span></p>\n");
      out.write("                                                    <p class=\"noti-time\"><span class=\"notification-time\">4 mins ago</span></p>\n");
      out.write("                                                </div>\n");
      out.write("                                            </div>\n");
      out.write("                                        </a>\n");
      out.write("                                    </li>\n");
      out.write("                                    <li class=\"notification-message\">\n");
      out.write("                                        <a href=\"activities.html\">\n");
      out.write("                                            <div class=\"media\">\n");
      out.write("                                                <span class=\"avatar avatar-sm\">\n");
      out.write("                                                    <img class=\"avatar-img rounded-circle\" alt=\"\" src=\"assets/img/profiles/avatar-03.jpg\">\n");
      out.write("                                                </span>\n");
      out.write("                                                <div class=\"media-body\">\n");
      out.write("                                                    <p class=\"noti-details\"><span class=\"noti-title\">Marie Canales</span> has accepted your estimate <span class=\"noti-title\">#GTR458789</span></p>\n");
      out.write("                                                    <p class=\"noti-time\"><span class=\"notification-time\">6 mins ago</span></p>\n");
      out.write("                                                </div>\n");
      out.write("                                            </div>\n");
      out.write("                                        </a>\n");
      out.write("                                    </li>\n");
      out.write("                                    <li class=\"notification-message\">\n");
      out.write("                                        <a href=\"activities.html\">\n");
      out.write("                                            <div class=\"media\">\n");
      out.write("                                                <div class=\"avatar avatar-sm\">\n");
      out.write("                                                    <span class=\"avatar-title rounded-circle bg-primary-light\"><i class=\"far fa-user\"></i></span>\n");
      out.write("                                                </div>\n");
      out.write("                                                <div class=\"media-body\">\n");
      out.write("                                                    <p class=\"noti-details\"><span class=\"noti-title\">New user registered</span></p>\n");
      out.write("                                                    <p class=\"noti-time\"><span class=\"notification-time\">8 mins ago</span></p>\n");
      out.write("                                                </div>\n");
      out.write("                                            </div>\n");
      out.write("                                        </a>\n");
      out.write("                                    </li>\n");
      out.write("                                    <li class=\"notification-message\">\n");
      out.write("                                        <a href=\"activities.html\">\n");
      out.write("                                            <div class=\"media\">\n");
      out.write("                                                <span class=\"avatar avatar-sm\">\n");
      out.write("                                                    <img class=\"avatar-img rounded-circle\" alt=\"\" src=\"assets/img/profiles/avatar-04.jpg\">\n");
      out.write("                                                </span>\n");
      out.write("                                                <div class=\"media-body\">\n");
      out.write("                                                    <p class=\"noti-details\"><span class=\"noti-title\">Barbara Moore</span> declined the invoice <span class=\"noti-title\">#RDW026896</span></p>\n");
      out.write("                                                    <p class=\"noti-time\"><span class=\"notification-time\">12 mins ago</span></p>\n");
      out.write("                                                </div>\n");
      out.write("                                            </div>\n");
      out.write("                                        </a>\n");
      out.write("                                    </li>\n");
      out.write("                                    <li class=\"notification-message\">\n");
      out.write("                                        <a href=\"activities.html\">\n");
      out.write("                                            <div class=\"media\">\n");
      out.write("                                                <div class=\"avatar avatar-sm\">\n");
      out.write("                                                    <span class=\"avatar-title rounded-circle bg-info-light\"><i class=\"far fa-comment\"></i></span>\n");
      out.write("                                                </div>\n");
      out.write("                                                <div class=\"media-body\">\n");
      out.write("                                                    <p class=\"noti-details\"><span class=\"noti-title\">You have received a new message</span></p>\n");
      out.write("                                                    <p class=\"noti-time\"><span class=\"notification-time\">2 days ago</span></p>\n");
      out.write("                                                </div>\n");
      out.write("                                            </div>\n");
      out.write("                                        </a>\n");
      out.write("                                    </li>\n");
      out.write("                                </ul>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"topnav-dropdown-footer\">\n");
      out.write("                                <a href=\"activities.html\">View all Notifications</a>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </li>\n");
      out.write("\n");
      out.write("\n");
      out.write("                    <li class=\"nav-item dropdown has-arrow main-drop\">\n");
      out.write("                        <a href=\"#\" class=\"dropdown-toggle nav-link\" data-toggle=\"dropdown\">\n");
      out.write("                            <span class=\"user-img\">\n");
      out.write("                                <img src=\"assets/img/profile.jpg\" alt=\"\">\n");
      out.write("                                <span class=\"status online\"></span>\n");
      out.write("                            </span>\n");
      out.write("                            <span>VinhPQ</span>\n");
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
      out.write("                                <li>\n");
      out.write("                                    <a href=\"admin.jsp\"><img src=\"assets/img/home.svg\" alt=\"sidebar_img\"> <span>Dashboard</span></a>\n");
      out.write("                                </li>\n");
      out.write("                                <li>\n");
      out.write("                                    <a href=\"employee.jsp\"><img src=\"assets/img/employee.svg\" alt=\"sidebar_img\"><span> Employees</span></a>\n");
      out.write("                                </li>\n");
      out.write("                                <li  class=\"active\">\n");
      out.write("                                    <a href=\"teamcontroller\"><img src=\"assets/img/group.png\" alt=\"sidebar_img\"> <span> Team</span></a>\n");
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
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div class=\"col-xl-12 col-sm-12 col-12\">\n");
      out.write("                            <div class=\"breadcrumb-path mb-4\">\n");
      out.write("                                <ul class=\"breadcrumb\">\n");
      out.write("                                    <li class=\"breadcrumb-item\"><a href=\"index.html\"><img src=\"assets/img/dash.png\" class=\"mr-2\" alt=\"breadcrumb\" />Home</a>\n");
      out.write("                                    </li>\n");
      out.write("                                    <li class=\"breadcrumb-item active\"> Employees/ Teams</li>\n");
      out.write("                                </ul>\n");
      out.write("                                <h3>Team</h3>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-xl-12 col-sm-12 col-12 mb-4\">\n");
      out.write("                            <div class=\"head-link-set\">\n");
      out.write("                                <ul>\n");
      out.write("                                    <li><a href=\"#\">All</a></li>\n");
      out.write("                                    <li><a class=\"active\" href=\"employee-team.html\">Teams</a></li>\n");
      out.write("                                    <li><a href=\"employee-office.html\">Offices</a></li>\n");
      out.write("                                </ul>\n");
      out.write("                                <div>                          \n");
      out.write("                                    <button class=\"btn-add\" onclick=\"$('#mymodal').modal('show')\"><i data-feather=\"plus\"></i> Add Team </button>\n");
      out.write("\n");
      out.write("\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-xl-12 col-sm-12 col-12 mb-4\">\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-xl-12 col-sm-12 col-12 mb-4\">\n");
      out.write("                            <div class=\"card\">\n");
      out.write("                                <div class=\"table-heading\">\n");
      out.write("                                    <h2>Team List</h2>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"table-responsive\">\n");
      out.write("                                    <table class=\"table  custom-table no-footer\">\n");
      out.write("                                        <thead>\n");
      out.write("                                            <tr>\n");
      out.write("                                                <th>ID Team</th>\n");
      out.write("                                                <th>Name Team</th>\n");
      out.write("                                                <th>Description</th>\n");
      out.write("                                            </tr>\n");
      out.write("                                        </thead>\n");
      out.write("                                        <tbody>\n");
      out.write("                                            ");
      if (_jspx_meth_c_set_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                                            ");
      if (_jspx_meth_c_if_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\n");
      out.write("                                        </tbody>\n");
      out.write("                                    </table>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                                                                    <button class=\"btn btn-danger\" onclick=\"window.history.back()\">Back</button>\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <form class=\"myform\" action=\"addteam\">\n");
      out.write("            <div class=\"modal fade\" data-backdrop='static' id=\"mymodal\">\n");
      out.write("                <div class=\"modal-dialog\">\n");
      out.write("                    <div class=\"modal-content\">\n");
      out.write("                        <div class=\"modal-header\">\n");
      out.write("                            <h3 class=\"modal-title\">Add New Team</h3>\n");
      out.write("                            <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\n");
      out.write("                                <span aria-hidden=\"true\">&times;</span>\n");
      out.write("                            </button>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"modal-body\">\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"TeamID\">TeamID:</label>\n");
      out.write("                                <input type=\"number\"  id=\"TeamID\" name=\"TeamID\">\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"TeamName\">TeamName:</label>\n");
      out.write("                                <input type=\"text\"  id=\"TeamName\" name=\"TeamName\">\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"IDexp\">IDexp</label>\n");
      out.write("                                <input type=\"number\" class=\"form-control\" id=\"IDexp\" name=\"IDexp\">\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"Description\">Description</label>\n");
      out.write("                                <input type=\"text\" class=\"form-control\" id=\"Description\" name=\"Description\">\n");
      out.write("                            </div>                                          \n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"modal-footer\">\n");
      out.write("                            <input type=\"submit\" value=\"Add\" class=\"btn btn-primary\" />\n");
      out.write("                            <input type=\"reset\" value=\"Reset\" class=\"btn btn-danger\" />\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div> \n");
      out.write("            </div>\n");
      out.write("        </form>\n");
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
      out.write("        <script src=\"assets/js/script.js\"></script>\n");
      out.write("    </body>\n");
      out.write("\n");
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

  private boolean _jspx_meth_c_set_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_set_0 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _jspx_tagPool_c_set_var_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_set_0.setPageContext(_jspx_page_context);
    _jspx_th_c_set_0.setParent(null);
    _jspx_th_c_set_0.setVar("teams");
    _jspx_th_c_set_0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.list}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_set_0 = _jspx_th_c_set_0.doStartTag();
    if (_jspx_th_c_set_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_0);
      return true;
    }
    _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_0);
    return false;
  }

  private boolean _jspx_meth_c_if_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_0.setPageContext(_jspx_page_context);
    _jspx_th_c_if_0.setParent(null);
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${not empty teams}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                                                ");
        if (_jspx_meth_c_forEach_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_if_0, _jspx_page_context))
          return true;
        out.write("\n");
        out.write("                                            ");
        int evalDoAfterBody = _jspx_th_c_if_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
    return false;
  }

  private boolean _jspx_meth_c_forEach_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_0);
    _jspx_th_c_forEach_0.setVar("team");
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${teams}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                                                    <tr>\n");
          out.write("                                                        <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${team.getID_Team()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                                                        <td><label class=\"action_label\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${team.getName_Team()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</label></td>\n");
          out.write("                                                        <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${team.getDecription()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                                                        <td> \n");
          out.write("                                                            <div class=\"card-body\">\n");
          out.write("                                                                <div class=\"card_widget_header\">\n");
          out.write("                                                                    <a class=\"btn-add-e\" href=\"teamcontroller?action=edit&teamId=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${team.getID_Team()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\">Edit</a>\n");
          out.write("                                                                    <a class=\"btn-add-e\" href=\"teamcontroller?action=delete&teamId=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${team.getID_Team()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\">Delete</a>\n");
          out.write("                                                                    <a class=\"btn-add-e\" href=\"memberservlet?teamId=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${team.getID_Team()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\">View members</a>\n");
          out.write("                                                                </div>\n");
          out.write("                                                            </div>\n");
          out.write("                                                        </td>\n");
          out.write("\n");
          out.write("                                                    </tr>\n");
          out.write("                                                ");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }
}
