package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import sample.dao.LeaveDAO;
import sample.dto.LeaveTypes;
import sample.dto.User;

public final class leave_005frequest_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Leave Page</title>\n");
      out.write("        <link rel=\"shortcut icon\" href=\"assets/img/favicon.png\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/css/bootstrap.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/plugins/select2/css/select2.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/plugins/fontawesome/css/fontawesome.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/plugins/fontawesome/css/all.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/css/style.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdn.datatables.net/1.13.4/css/jquery.dataTables.css\" />\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdn.datatables.net/1.13.4/css/jquery.dataTables.min.css\" />\n");
      out.write("        <script src=\"assets/js/jquery-3.6.0.min.js\"></script>\n");
      out.write("        <script src=\"https://cdn.datatables.net/1.13.4/js/jquery.dataTables.min.js\"></script>\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/sweetalert2@11\"></script>\n");
      out.write("        <style>\n");
      out.write("            input[type=\"date\"] {\n");
      out.write("                width: 100%;\n");
      out.write("                padding: 0.375rem 0.75rem;\n");
      out.write("                font-size: 1rem;\n");
      out.write("                line-height: 1.5;\n");
      out.write("                color: #495057;\n");
      out.write("                background-color: #fff;\n");
      out.write("                background-clip: padding-box;\n");
      out.write("                border: 1px solid #ced4da;\n");
      out.write("                border-radius: 0.25rem;\n");
      out.write("                transition: border-color 0.15s ease-in-out, box-shadow 0.15s ease-in-out;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            /* Optional: Add this to center align the date input */\n");
      out.write("            input[type=\"date\"]::-webkit-inner-spin-button,\n");
      out.write("            input[type=\"date\"]::-webkit-calendar-picker-indicator {\n");
      out.write("                display: block;\n");
      out.write("                margin: 0 auto;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("        <script>\n");
      out.write("\n");
      out.write("            $(document).ready(function () {\n");
      out.write("                $('#example').DataTable();\n");
      out.write("            });\n");
      out.write("\n");
      out.write("            $(document).ready(function () {\n");
      out.write("            $(\".myform\").on(\"submit\", function (e) {\n");
      out.write("            e.preventDefault();\n");
      out.write("                    $.ajax({\n");
      out.write("                    method: \"POST\",\n");
      out.write("                            url: \"/HRManagement/leaveServlet\",\n");
      out.write("                            data: new FormData(this),\n");
      out.write("                            processData: false,\n");
      out.write("                            contentType: false,\n");
      out.write("                            success: function (res) {\n");
      out.write("                            //console res to see what the servlet sent back\n");
      out.write("                            console.log(res);\n");
      out.write("                            if (res === `\"success\"`) {\n");
      out.write("                        swal.fire({\n");
      out.write("                            title: \"Success!\",\n");
      out.write("                            text: \"Your request has been sent!\",\n");
      out.write("                            icon: \"success\",\n");
      out.write("                            button: \"OK\"\n");
      out.write("                        }).then((value) => {\n");
      out.write("                            //click oke will hide modal and reload datatable\n");
      out.write("                            $('#example').DataTable().ajax.reload();\n");
      out.write("                        });\n");
      out.write("                    } else {\n");
      out.write("                        swal.fire({\n");
      out.write("                            title: \"Error!\",\n");
      out.write("                            //remove \"\" from string\n");
      out.write("                            text: res.replace(/\"/g, \"\"),\n");
      out.write("                            icon: \"error\",\n");
      out.write("                            button: \"OK!\"\n");
      out.write("                        });\n");
      out.write("                    }\n");
      out.write("                            //reload the page\n");
      out.write("                            location.reload();\n");
      out.write("                            },\n");
      out.write("                            error: function (error) {\n");
      out.write("                            console.log(error);\n");
      out.write("                            swal.fire({\n");
      out.write("                            title: \"Error!\",\n");
      out.write("                                    text: \"Something went wrong!\",\n");
      out.write("                                    icon: \"error\",\n");
      out.write("                                    button: \"OK!\"\n");
      out.write("                            });\n");
      out.write("                            }\n");
      out.write("                    });\n");
      out.write("            });\n");
      out.write("        });\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            User user = (User) session.getAttribute("user");
            if (user == null) {
                response.sendRedirect("login.jsp");
            }
            int leave_balance = user.getLeaveBalances();
        
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
      out.write("            <div class=\"page-wrapper\">\n");
      out.write("                <div class=\"content container-fluid\">\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div class=\"col-xl-12 col-sm-12 col-12 mb-4\">\n");
      out.write("                            <div class=\"breadcrumb-path \">\n");
      out.write("                                <ul class=\"breadcrumb\">\n");
      out.write("                                    <li class=\"breadcrumb-item\"><a href=\"admin.jsp\"><img src=\"assets/img/dash.png\" class=\"mr-2\" alt=\"breadcrumb\">Home</a>\n");
      out.write("                                    </li>\n");
      out.write("                                    <li class=\"breadcrumb-item active\"> Leave</li>\n");
      out.write("                                </ul>\n");
      out.write("                                <h3>Leave</h3>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div class=\"col-xl-12 col-sm-12 col-12 \">\n");
      out.write("                            <div class=\"card\">\n");
      out.write("                                <div class=\"card-header\">\n");
      out.write("                                    <h2 class=\"card-titles\">Apply Leaves</h2>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"form-creation\">\n");
      out.write("                                    <form class=\"myform\">\n");
      out.write("                                        <div class=\"row\">\n");
      out.write("                                            <div class=\"col-xl-6 col-sm-6 col-12 \">\n");
      out.write("                                                <div class=\"form-group\">\n");
      out.write("                                                    <label>Leave Type <span class=\"mandatory\">*</span> </label>\n");
      out.write("                                                    <select class=\"select\" name=\"leavetype\">\n");
      out.write("                                                        ");

                                                            List<LeaveTypes> leaveTypes = LeaveDAO.getListLeaveType();
                                                            for (LeaveTypes leaveType : leaveTypes) {
                                                        
      out.write("\n");
      out.write("                                                        <option value=\"");
      out.print(leaveType.getLeaveTypeName());
      out.write('"');
      out.write('>');
      out.print(leaveType.getLeaveTypeName());
      out.write("</option>\n");
      out.write("                                                        ");

                                                            }
                                                        
      out.write("\n");
      out.write("                                                    </select>\n");
      out.write("                                                </div>\n");
      out.write("                                            </div>\n");
      out.write("                                            <div class=\"col-xl-6 col-sm-6 col-12 \">\n");
      out.write("                                                <div class=\"form-group\">\n");
      out.write("                                                    <label>Remaining Leaves</label>\n");
      out.write("                                                    <input type=\"text\" value=\"10\" disabled>\n");
      out.write("                                                </div>\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"row\">\n");
      out.write("                                            <div class=\"col-xl-6 col-sm-12 col-12 \">\n");
      out.write("                                                <div class=\"form-group\">\n");
      out.write("                                                    <label>From </label>\n");
      out.write("                                                    <input type=\"date\" name=\"StartDate\">\n");
      out.write("                                                </div>\n");
      out.write("                                            </div>\n");
      out.write("                                            <div class=\"col-xl-6 col-sm-12 col-12 \">\n");
      out.write("                                                <div class=\"form-group\">\n");
      out.write("                                                    <label>To</label>\n");
      out.write("                                                    <input type=\"date\" name=\"EndDate\">\n");
      out.write("                                                </div>\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("\n");
      out.write("                                        <div class=\"row\">\n");
      out.write("                                            <div class=\"col-xl-12 col-sm-12 col-12 \">\n");
      out.write("                                                <div class=\"form-group\">\n");
      out.write("                                                    <label>Reason </label>\n");
      out.write("                                                    <textarea rows=\"4\" cols=\"50\" name=\"reason\">\t</textarea>\n");
      out.write("                                                </div>\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"row\">\n");
      out.write("                                            <div class=\"col-xl-12 col-sm-12 col-12 \">\n");
      out.write("                                                <div class=\"form-btn\">\n");
      out.write("                                                    <button class=\"btn btn-apply\">Apply</button>\n");
      out.write("                                                </div>\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("                                    </form>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div class=\"col-xl-12 col-sm-12 col-12 \">\n");
      out.write("                            <div class=\"card \">\n");
      out.write("                                <div class=\"card-header\">\n");
      out.write("                                    <h2 class=\"card-titles\">Leave Details</h2>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"card-body p-0\">\n");
      out.write("                                    <div class=\"table-responsive\">\n");
      out.write("                                        <table id=\"example\" class=\"display\" style=\"width:100%\">\n");
      out.write("                                            <thead>\n");
      out.write("                                                <tr>\n");
      out.write("                                                    <th>RequestID</th>\n");
      out.write("                                                    <th>Leave Type </th>\n");
      out.write("                                                    <th>From\t</th>\n");
      out.write("                                                    <th>To</th>\n");
      out.write("                                                    <th>Days</th>\n");
      out.write("                                                    <th>Remaining Days\t</th>\n");
      out.write("                                                    <th>Notes</th>\n");
      out.write("                                                    <th>Status</th>\n");
      out.write("                                                </tr>\n");
      out.write("                                            </thead>\n");
      out.write("                                            <tbody>\n");
      out.write("\n");
      out.write("                                            </tbody>\n");
      out.write("                                            <tfoot>\n");
      out.write("                                                <tr>\n");
      out.write("                                                    <th>RequestID</th>\n");
      out.write("                                                    <th>Leave Type </th>\n");
      out.write("                                                    <th>From\t</th>\n");
      out.write("                                                    <th>To</th>\n");
      out.write("                                                    <th>Days</th>\n");
      out.write("                                                    <th>Remaining Days\t</th>\n");
      out.write("                                                    <th>Notes</th>\n");
      out.write("                                                    <th>Status</th>\n");
      out.write("                                                </tr>\n");
      out.write("                                            </tfoot>\n");
      out.write("                                        </table>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <script src=\"assets/js/popper.min.js\"></script>\n");
      out.write("        <script src=\"assets/js/bootstrap.min.js\"></script>\n");
      out.write("        <script src=\"assets/js/feather.min.js\"></script>\n");
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
