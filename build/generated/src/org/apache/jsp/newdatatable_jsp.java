package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class newdatatable_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <link rel=\"sstylesheet\" href=\"https://cdn.datatables.net/1.13.4/css/jquery.dataTables.min.css\">\n");
      out.write("        <link rel=\"sstylesheet\" href=\"https://cdn.datatables.net/buttons/2.3.6/css/buttons.dataTables.min.css\">\n");
      out.write("        <link rel=\"sstylesheet\" href=\"https://cdn.datatables.net/select/1.6.2/css/select.dataTables.min.css\">\n");
      out.write("        <link rel=\"sstylesheet\" href=\"https://cdn.datatables.net/datetime/1.4.1/css/dataTables.dateTime.min.css\">\n");
      out.write("        <link rel=\"sstylesheet\" href=\"https://editor.datatables.net/extensions/Editor/css/editor.dataTables.min.css\">\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.5.1.js\"></script>\n");
      out.write("        <script src=\"https://cdn.datatables.net/1.13.4/js/jquery.dataTables.min.js\"></script>\n");
      out.write("        <script src=\"https://cdn.datatables.net/buttons/2.3.6/js/dataTables.buttons.min.js\"></script>\n");
      out.write("        <script src=\"https://cdn.datatables.net/select/1.6.2/js/dataTables.select.min.js\"></script>\n");
      out.write("        <script src=\"https://cdn.datatables.net/datetime/1.4.1/js/dataTables.dateTime.min.js\"></script>\n");
      out.write("        <script src=\"https://editor.datatables.net/extensions/Editor/js/dataTables.editor.min.js\"></script>\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.6.0.min.js\"></script>\n");
      out.write("        <script src=\"https://cdn.datatables.net/1.11.3/js/jquery.dataTables.min.js\"></script>\n");
      out.write("        <script>\n");
      out.write("            var editor;\n");
      out.write("            $(document).ready(function () {\n");
      out.write("                editor = new $.fn.dataTable.Editor({\n");
      out.write("                    ajax: \"/HRManagement/employee\",\n");
      out.write("                    table: \"#example\",\n");
      out.write("                    fields: [{\n");
      out.write("                            label: \"UserID:\",\n");
      out.write("                            name: \"UserID\"\n");
      out.write("                        }, {\n");
      out.write("                            label: \"Name:\",\n");
      out.write("                            name: \"Name\"\n");
      out.write("                        }, {\n");
      out.write("                            label: \"Phone:\",\n");
      out.write("                            name: \"Phone\"\n");
      out.write("                        }, {\n");
      out.write("                            label: \"Email:\",\n");
      out.write("                            name: \"Email\"\n");
      out.write("                        }, {\n");
      out.write("                            label: \"Username:\",\n");
      out.write("                            name: \"Username\"\n");
      out.write("                        }, {\n");
      out.write("                            label: \"Password:\",\n");
      out.write("                            name: \"Password\"\n");
      out.write("                        }, {\n");
      out.write("                            label: \"Address:\",\n");
      out.write("                            name: \"Address\"\n");
      out.write("                        }, {\n");
      out.write("                            label: \"Birthday:\",\n");
      out.write("                            name: \"Birthday\"\n");
      out.write("                        }, {\n");
      out.write("                            label: \"ExperienceId:\",\n");
      out.write("                            name: \"ExperienceId\"\n");
      out.write("                        }, {\n");
      out.write("                            label: \"Team_ID:\",\n");
      out.write("                            name: \"Team_ID\"\n");
      out.write("                        }\n");
      out.write("                    ]\n");
      out.write("                });\n");
      out.write("                $('#example').DataTable({\n");
      out.write("                    dom: \"Bfrtip\",\n");
      out.write("                    ajax: \"/HRManagement/employee\",\n");
      out.write("                    columns: [\n");
      out.write("                        {data: null, render: function (data, type, row) {\n");
      out.write("                                // Combine the first and last names into a single table field\n");
      out.write("                                return data.Name;\n");
      out.write("                            }},\n");
      out.write("                        {data: \"UserID\"},\n");
      out.write("                        {data: \"Name\"},\n");
      out.write("                        {data: \"Phone\"},\n");
      out.write("                        {data: \"Email\"},\n");
      out.write("                        {data: \"Username\"},\n");
      out.write("                        {data: \"Password\"},\n");
      out.write("                        {data: \"Address\"},\n");
      out.write("                        {data: \"Birthday\"},\n");
      out.write("                        {data: \"ExperienceId\"},\n");
      out.write("                        {data: \"Team_ID\"}\n");
      out.write("                    ],\n");
      out.write("                    select: true,\n");
      out.write("                    buttons: [\n");
      out.write("                        {extend: \"create\", editor: editor},\n");
      out.write("                        {extend: \"edit\", editor: editor},\n");
      out.write("                        {extend: \"remove\", editor: editor}\n");
      out.write("                    ]\n");
      out.write("                });\n");
      out.write("            });\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <table id=\"example\" class=\"display\" style=\"width:100%\">\n");
      out.write("            <thead>\n");
      out.write("                <tr>\n");
      out.write("                    <th></th>\n");
      out.write("                    <th>UserID</th>\n");
      out.write("                    <th>Name</th>\n");
      out.write("                    <th>Phone</th>\n");
      out.write("                    <th>Email</th>\n");
      out.write("                    <th>Username</th>\n");
      out.write("                    <th>Password</th>\n");
      out.write("                    <th>Address</th>\n");
      out.write("                    <th>Birthday</th>\n");
      out.write("                    <th>ExperienceId</th>\n");
      out.write("                    <th>Team_ID</th>\n");
      out.write("                    <th>Action</th>\n");
      out.write("                </tr>\n");
      out.write("            </thead>\n");
      out.write("            <tbody>\n");
      out.write("\n");
      out.write("            <tfoot>\n");
      out.write("                <tr>\n");
      out.write("                    <th></th>\n");
      out.write("                    <th>UserID</th>\n");
      out.write("                    <th>Name</th>\n");
      out.write("                    <th>Phone</th>\n");
      out.write("                    <th>Email</th>\n");
      out.write("                    <th>Username</th>\n");
      out.write("                    <th>Password</th>\n");
      out.write("                    <th>Address</th>\n");
      out.write("                    <th>Birthday</th>\n");
      out.write("                    <th>ExperienceId</th>\n");
      out.write("                    <th>Team_ID</th>\n");
      out.write("                    <th>Action</th>\n");
      out.write("                </tr>\n");
      out.write("            </tfoot>\n");
      out.write("        </table>\n");
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
