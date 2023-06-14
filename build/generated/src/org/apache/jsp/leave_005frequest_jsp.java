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
      out.write("        <title>Leave Page</title>\r\n");
      out.write("        <link rel=\"shortcut icon\" href=\"assets/img/favicon.png\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/css/bootstrap.min.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/plugins/select2/css/select2.min.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/plugins/fontawesome/css/fontawesome.min.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/plugins/fontawesome/css/all.min.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/css/style.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdn.datatables.net/1.13.4/css/jquery.dataTables.css\" />\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdn.datatables.net/1.13.4/css/jquery.dataTables.min.css\" />\r\n");
      out.write("        <script src=\"assets/js/jquery-3.6.0.min.js\"></script>\r\n");
      out.write("        <script src=\"https://cdn.datatables.net/1.13.4/js/jquery.dataTables.min.js\"></script>\r\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/sweetalert2@11\"></script>\r\n");
      out.write("        <style>\r\n");
      out.write("            input[type=\"date\"] {\r\n");
      out.write("                width: 100%;\r\n");
      out.write("                padding: 0.375rem 0.75rem;\r\n");
      out.write("                font-size: 1rem;\r\n");
      out.write("                line-height: 1.5;\r\n");
      out.write("                color: #495057;\r\n");
      out.write("                background-color: #fff;\r\n");
      out.write("                background-clip: padding-box;\r\n");
      out.write("                border: 1px solid #ced4da;\r\n");
      out.write("                border-radius: 0.25rem;\r\n");
      out.write("                transition: border-color 0.15s ease-in-out, box-shadow 0.15s ease-in-out;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            /* Optional: Add this to center align the date input */\r\n");
      out.write("            input[type=\"date\"]::-webkit-inner-spin-button,\r\n");
      out.write("            input[type=\"date\"]::-webkit-calendar-picker-indicator {\r\n");
      out.write("                display: block;\r\n");
      out.write("                margin: 0 auto;\r\n");
      out.write("            }\r\n");
      out.write("        </style>\r\n");
      out.write("        <script>\r\n");
      out.write("\r\n");
      out.write("            $(document).ready(function () {\r\n");
      out.write("                $('#example').DataTable({\r\n");
      out.write("                ajax: {\r\n");
      out.write("                url: '/HRManagement/leaveRequestPage',\r\n");
      out.write("                        dataSrc: ''\r\n");
      out.write("                },\r\n");
      out.write("                        \"columnDefs\": [\r\n");
      out.write("                        {\"className\": \"dt-center\", \"targets\": \"_all\"}\r\n");
      out.write("                        ],\r\n");
      out.write("                        columns: [\r\n");
      out.write("                        {data: null,\r\n");
      out.write("                                //set identity for row\r\n");
      out.write("                                render: function (data, type, row, meta) {\r\n");
      out.write("                                return meta.row + meta.settings._iDisplayStart + 1;\r\n");
      out.write("                                }\r\n");
      out.write("                        },\r\n");
      out.write("                        {data: 'LeaveTypeName'},\r\n");
      out.write("                        {data: 'StartDate'},\r\n");
      out.write("                        {data: 'EndDate'},\r\n");
      out.write("                        {data: 'time_req'},\r\n");
      out.write("                        {data: 'Reason'},\r\n");
      out.write("                        {data: 'Status'}\r\n");
      out.write("                        ],\r\n");
      out.write("                        \"order\": [[0, \"asc\"]]\r\n");
      out.write("                        });\r\n");
      out.write("                    });\r\n");
      out.write("\r\n");
      out.write("                    $(document).ready(function () {\r\n");
      out.write("                        $(\".myform\").on(\"submit\", function (e) {\r\n");
      out.write("                            e.preventDefault();\r\n");
      out.write("                            $.ajax({\r\n");
      out.write("                                method: \"POST\",\r\n");
      out.write("                                url: \"/HRManagement/leaveServlet\",\r\n");
      out.write("                                data: new FormData(this),\r\n");
      out.write("                                processData: false,\r\n");
      out.write("                                contentType: false,\r\n");
      out.write("                                success: function (res) {\r\n");
      out.write("                                    //console res to see what the servlet sent back\r\n");
      out.write("                                    console.log(res);\r\n");
      out.write("                                    if (res === `\"success\"`) {\r\n");
      out.write("                                        swal.fire({\r\n");
      out.write("                                            title: \"Success!\",\r\n");
      out.write("                                            text: \"Your request has been sent!\",\r\n");
      out.write("                                            icon: \"success\",\r\n");
      out.write("                                            button: \"OK\"\r\n");
      out.write("                                        }).then((value) => {\r\n");
      out.write("                                            //click oke will hide modal and reload datatable\r\n");
      out.write("                                            $('#example').DataTable().ajax.reload();\r\n");
      out.write("                                        });\r\n");
      out.write("                                    } else {\r\n");
      out.write("                                        swal.fire({\r\n");
      out.write("                                            title: \"Error!\",\r\n");
      out.write("                                            //remove \"\" from string\r\n");
      out.write("                                            text: res.replace(/\"/g, \"\"),\r\n");
      out.write("                                            icon: \"error\",\r\n");
      out.write("                                            button: \"OK!\"\r\n");
      out.write("                                        });\r\n");
      out.write("                                    }\r\n");
      out.write("                                },\r\n");
      out.write("                                error: function (error) {\r\n");
      out.write("                                    console.log(error);\r\n");
      out.write("                                    swal.fire({\r\n");
      out.write("                                        title: \"Error!\",\r\n");
      out.write("                                        text: \"Something went wrong!\",\r\n");
      out.write("                                        icon: \"error\",\r\n");
      out.write("                                        button: \"OK!\"\r\n");
      out.write("                                    });\r\n");
      out.write("                                }\r\n");
      out.write("                            });\r\n");
      out.write("                        });\r\n");
      out.write("                    });\r\n");
      out.write("        </script>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        ");

            User user = (User) session.getAttribute("user");
            if (user == null) {
                response.sendRedirect("login.jsp");
            } else {
                int leave_balance = user.getLeaveBalances();
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
      out.write("            <div class=\"page-wrapper\">\r\n");
      out.write("                <div class=\"content container-fluid\">\r\n");
      out.write("                    <div class=\"row\">\r\n");
      out.write("                        <div class=\"col-xl-12 col-sm-12 col-12 mb-4\">\r\n");
      out.write("                            <div class=\"breadcrumb-path \">\r\n");
      out.write("                                <ul class=\"breadcrumb\">\r\n");
      out.write("                                    <li class=\"breadcrumb-item\"><a href=\"admin.jsp\"><img src=\"assets/img/dash.png\" class=\"mr-2\" alt=\"breadcrumb\">Home</a>\r\n");
      out.write("                                    </li>\r\n");
      out.write("                                    <li class=\"breadcrumb-item active\"> Leave</li>\r\n");
      out.write("                                </ul>\r\n");
      out.write("                                <h3>Leave</h3>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("                    <div class=\"row\">\r\n");
      out.write("                        <div class=\"col-xl-12 col-sm-12 col-12 \">\r\n");
      out.write("                            <div class=\"card\">\r\n");
      out.write("                                <div class=\"card-header\">\r\n");
      out.write("                                    <h2 class=\"card-titles\">Apply Leaves</h2>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"form-creation\">\r\n");
      out.write("                                    <form class=\"myform\">\r\n");
      out.write("                                        <div class=\"row\">\r\n");
      out.write("                                            <div class=\"col-xl-6 col-sm-6 col-12 \">\r\n");
      out.write("                                                <div class=\"form-group\">\r\n");
      out.write("                                                    <label>Leave Type <span class=\"mandatory\">*</span> </label>\r\n");
      out.write("                                                    <select class=\"select\" name=\"leavetype\">\r\n");
      out.write("                                                        ");

                                                            List<LeaveTypes> leaveTypes = LeaveDAO.getListLeaveType();
                                                            for (LeaveTypes leaveType : leaveTypes) {
                                                        
      out.write("\r\n");
      out.write("                                                        <option value=\"");
      out.print(leaveType.getLeaveTypeName());
      out.write('"');
      out.write('>');
      out.print(leaveType.getLeaveTypeName());
      out.write("</option>\r\n");
      out.write("                                                        ");

                                                            }
                                                        
      out.write("\r\n");
      out.write("                                                    </select>\r\n");
      out.write("                                                </div>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                            <div class=\"col-xl-6 col-sm-6 col-12 \">\r\n");
      out.write("                                                <div class=\"form-group\">\r\n");
      out.write("                                                    <label>Remaining Leaves</label>\r\n");
      out.write("                                                    <input type=\"text\" value=\"10\" disabled>\r\n");
      out.write("                                                </div>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"row\">\r\n");
      out.write("                                            <div class=\"col-xl-6 col-sm-12 col-12 \">\r\n");
      out.write("                                                <div class=\"form-group\">\r\n");
      out.write("                                                    <label>From </label>\r\n");
      out.write("                                                    <input type=\"date\" name=\"StartDate\">\r\n");
      out.write("                                                </div>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                            <div class=\"col-xl-6 col-sm-12 col-12 \">\r\n");
      out.write("                                                <div class=\"form-group\">\r\n");
      out.write("                                                    <label>To</label>\r\n");
      out.write("                                                    <input type=\"date\" name=\"EndDate\">\r\n");
      out.write("                                                </div>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("\r\n");
      out.write("                                        <div class=\"row\">\r\n");
      out.write("                                            <div class=\"col-xl-12 col-sm-12 col-12 \">\r\n");
      out.write("                                                <div class=\"form-group\">\r\n");
      out.write("                                                    <label>Reason </label>\r\n");
      out.write("                                                    <textarea rows=\"4\" cols=\"50\" name=\"reason\">\t</textarea>\r\n");
      out.write("                                                </div>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"row\">\r\n");
      out.write("                                            <div class=\"col-xl-12 col-sm-12 col-12 \">\r\n");
      out.write("                                                <div class=\"form-btn\">\r\n");
      out.write("                                                    <button class=\"btn btn-apply\">Apply</button>\r\n");
      out.write("                                                </div>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </form>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("                    <div class=\"row\">\r\n");
      out.write("                        <div class=\"col-xl-12 col-sm-12 col-12 \">\r\n");
      out.write("                            <div class=\"card \">\r\n");
      out.write("                                <div class=\"card-header\">\r\n");
      out.write("                                    <h2 class=\"card-titles\">Leave Details</h2>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"card-body p-0\">\r\n");
      out.write("                                    <div class=\"table-responsive\">\r\n");
      out.write("                                        <table id=\"example\" class=\"display\" style=\"width:100%\">\r\n");
      out.write("                                            <thead>\r\n");
      out.write("                                                <tr>\r\n");
      out.write("                                                    <th>STT</th>\r\n");
      out.write("                                                    <th>Leave Type</th>\r\n");
      out.write("                                                    <th>From</th>\r\n");
      out.write("                                                    <th>To</th>\r\n");
      out.write("                                                    <th>Days</th>\r\n");
      out.write("                                                    <th>Notes</th>\r\n");
      out.write("                                                    <th>Status</th>\r\n");
      out.write("                                                </tr>\r\n");
      out.write("                                            </thead>\r\n");
      out.write("                                            <tbody>\r\n");
      out.write("\r\n");
      out.write("                                            </tbody>\r\n");
      out.write("<!--                                            <tfoot>\r\n");
      out.write("                                                <tr>\r\n");
      out.write("                                                    <th>STT</th>\r\n");
      out.write("                                                    <th>Leave Type</th>\r\n");
      out.write("                                                    <th>From</th>\r\n");
      out.write("                                                    <th>To</th>\r\n");
      out.write("                                                    <th>Days</th>\r\n");
      out.write("                                                    <th>Notes</th>\r\n");
      out.write("                                                    <th>Status</th>\r\n");
      out.write("                                                </tr>\r\n");
      out.write("                                            </tfoot>-->\r\n");
      out.write("                                        </table>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <script src=\"assets/js/popper.min.js\"></script>\r\n");
      out.write("        <script src=\"assets/js/bootstrap.min.js\"></script>\r\n");
      out.write("        <script src=\"assets/js/feather.min.js\"></script>\r\n");
      out.write("        <script src=\"assets/plugins/select2/js/select2.min.js\"></script>\r\n");
      out.write("        <script src=\"assets/js/script.js\"></script>\r\n");
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
