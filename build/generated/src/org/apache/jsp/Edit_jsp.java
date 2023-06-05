package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Edit_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html lang=\"en\">\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <title>Edit</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Roboto|Varela+Round\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/icon?family=Material+Icons\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js\"></script>\n");
      out.write("        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>\n");
      out.write("        <link href=\"assets/css/newcss.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <style>\n");
      out.write("            img{\n");
      out.write("                width: 200px;\n");
      out.write("                height: 120px;\n");
      out.write("            }\n");
      out.write("            .row{\n");
      out.write("                background-color: #028ee1\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"table-wrapper\">\n");
      out.write("                <div class=\"table-title\">\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div  class=\"col-sm-6\">\n");
      out.write("                            <h2>Edit <b>Product</b></h2>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-sm-6\">\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div id=\"editEmployeeModal\">\n");
      out.write("                <div class=\"modal-dialog\">\n");
      out.write("                    <div class=\"modal-content\">\n");
      out.write("                        <form class=\"myform\" action=\"editteam\">\n");
      out.write("                            <div class=\"modal-header\">\t\t\t\t\t\t\n");
      out.write("                                <h4 class=\"modal-title\">Edit Team</h4>\n");
      out.write("                                <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-hidden=\"true\">&times;</button>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"modal-body\">\t\t\t\t\t\n");
      out.write("                               \n");
      out.write("                                  <div class=\"form-group\">\n");
      out.write("                                    <label>IDTeam</label>\n");
      out.write("                                    <input value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${team.getID_Team()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" name=\"TeamName\" type=\"text\" class=\"form-control\" required>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"form-group\">\n");
      out.write("                                    <label>TeamName</label>\n");
      out.write("                                    <input value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${team.getName_Team()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" name=\"TeamName\" type=\"text\" class=\"form-control\" required>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"form-group\">\n");
      out.write("                                    <label>IDexperience</label>\n");
      out.write("                                    <input value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${team.getID_Experience()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" name=\"IDexperience\" type=\"text\" class=\"form-control\" required>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"form-group\">\n");
      out.write("                                    <label>Description</label>\n");
      out.write("                                    <input value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${team.getDecription()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" name=\"Description\" type=\"text\" class=\"form-control\" required>\n");
      out.write("                                </div>\n");
      out.write("                                  \n");
      out.write("                                </div>\n");
      out.write("\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"modal-footer\">\n");
      out.write("                                <a  class=\"btn btn-danger\" href=\"/teamcontroller\">back</a>                          \n");
      out.write("                             <input type=\"submit\" class=\"btn btn-success\" value=\"Edit\">\n");
      out.write("                            </div>\n");
      out.write("                        </form>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <script src=\"js/manager.js\" type=\"text/javascript\"></script>\n");
      out.write("    </body>\n");
      out.write("</html>");
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
