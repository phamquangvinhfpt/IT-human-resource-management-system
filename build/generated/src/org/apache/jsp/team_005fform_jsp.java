package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import sample.dto.User;

public final class team_005fform_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <script src=\"https://code.jquery.com/jquery-3.7.0.min.js\" integrity=\"sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://kit.fontawesome.com/b3fa33d056.js\" crossorigin=\"anonymous\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("    \n");
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
      out.write("                                    <li class=\"breadcrumb-item active\"> Team</li>\n");
      out.write("                                </ul>\n");
      out.write("                                <h3>Team</h3>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-xl-12 col-sm-12 col-12 mb-4\">\n");
      out.write("                            <div class=\"head-link-set\">\n");
      out.write("                         <form class=\"myform\">\n");
      out.write("                            <div class=\"modal-dialog\">\n");
      out.write("                                <div class=\"modal-content\">\n");
      out.write("                                    <div class=\"modal-header\">\n");
      out.write("                                        <h3 class=\"modal-title\">Add New Team</h3>\n");
      out.write("                                        <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\n");
      out.write("                                            <span aria-hidden=\"true\">&times;</span>\n");
      out.write("                                        </button>\n");
      out.write("                                    </div>\n");
      out.write("\n");
      out.write("                                    <div class=\"modal-body\">\n");
      out.write("                                        <div class=\"form-group\">\n");
      out.write("                                            <label for=\"TeamID\">TeamID:</label>\n");
      out.write("                                            <input type=\"number\"  id=\"TeamID\" name=\"TeamID\">\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"form-group\">\n");
      out.write("                                            <label for=\"TeamName\">TeamName:</label>\n");
      out.write("                                            <input type=\"text\"  id=\"TeamName\" name=\"TeamName\">\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"form-group\">\n");
      out.write("                                            <label for=\"IDexp\">IDexp</label>\n");
      out.write("                                            <input type=\"number\" class=\"form-control\" id=\"IDexp\" name=\"IDexp\">\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"form-group\">\n");
      out.write("                                            <label for=\"Description\">Description</label>\n");
      out.write("                                            <input type=\"text\" class=\"form-control\" id=\"Description\" name=\"Description\">\n");
      out.write("                                        </div>                                          \n");
      out.write("                                    </div>\n");
      out.write("\n");
      out.write("                                    <div class=\"modal-footer\">\n");
      out.write("                                        <input type=\"submit\" value=\"Add\" class=\"btn btn-primary\" />\n");
      out.write("                                        <input type=\"reset\" value=\"Reset\" class=\"btn btn-danger\" />\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div> \n");
      out.write("                            </div>\n");
      out.write("                        </form>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                       \n");
      out.write("                      \n");
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
      out.write("        <script src=\"assets/js/script.js\"></script>\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("                                    $(document).ready(function () {\n");
      out.write("                                    $(\".myform\").on(\"submit\", function (e) {\n");
      out.write("                                    e.preventDefault();\n");
      out.write("                                            $.ajax({\n");
      out.write("                                            method: \"POST\",\n");
      out.write("                                                    url: \"/HRManagement/addEmployee\",\n");
      out.write("                                                    data: new FormData(this),\n");
      out.write("                                                    processData:false,\n");
      out.write("                                                    contentType:false,\n");
      out.write("                                                    success:function(res){\n");
      out.write("                                                    console.log(res);\n");
      out.write("                                                    },\n");
      out.write("                                                    error:function(error){\n");
      out.write("                                                    console.log(error);\n");
      out.write("                                                    }\n");
      out.write("                                            });\n");
      out.write("                                    });\n");
      out.write("                                    });\n");
      out.write("        </script>\n");
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
