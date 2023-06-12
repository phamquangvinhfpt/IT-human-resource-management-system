package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.text.SimpleDateFormat;
import java.sql.Date;
import sample.dto.User;

public final class profile_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Profile</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/css/bootstrap.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/plugins/fontawesome/css/fontawesome.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/plugins/fontawesome/css/all.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/css/style.css\">\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/sweetalert2@11\"></script>\n");
      out.write("        <style>\n");
      out.write("            .edit-profile-wrapper {\n");
      out.write("                position: fixed;\n");
      out.write("                bottom: 20px;\n");
      out.write("                left: 50%;\n");
      out.write("                transform: translateX(-50%);\n");
      out.write("            }\n");
      out.write("            .edit-profile-btn {\n");
      out.write("                display: block;\n");
      out.write("                margin: auto;\n");
      out.write("                background-color: #007bff;\n");
      out.write("                color: #fff;\n");
      out.write("                border-radius: 5px;\n");
      out.write("                cursor: pointer;\n");
      out.write("            }\n");
      out.write("            .edit-profile-btn:hover {\n");
      out.write("                background-color: #0069d9;\n");
      out.write("            }\n");
      out.write("            .form-edit {\n");
      out.write("                display: none;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"main-wrapper\">\n");
      out.write("            <div class=\"header\">\n");
      out.write("                ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "common/navbar.jsp", out, false);
      out.write("  \n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"sidebar\" id=\"sidebar\">\n");
      out.write("                ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "common/sidebar.jsp", out, false);
      out.write("\n");
      out.write("            </div>\n");
      out.write("            <div class=\"page-wrapper\">\n");
      out.write("                <div class=\"container-fluid pt-3\">\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div class=\"col-md-3\">\n");
      out.write("                            <div class=\"card\">\n");
      out.write("                                <div class=\"card-body\">\n");
      out.write("                                    <div class=\"text-center\">\n");
      out.write("                                        ");

                                            User user = (User) session.getAttribute("user");
                                            if (user == null) {
                                                response.sendRedirect("login.jsp");
                                                //stop executing code by return
                                                return;
                                            }
                                            //get user info
                                            String name = user.getName();
                                            String role = user.getRole();
                                            String phone = user.getPhone();
                                            String email = user.getEmail();
                                            String address = user.getAddress();
                                            Date birthday = user.getBirthday();
                                            //parse date to string
                                            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                                            String birthDay = sdf.format(birthday);
                                            String image = user.getImage();
                                        
      out.write("\n");
      out.write("                                        <img src=\"images/");
      out.print(image);
      out.write("\" class=\"rounded-circle\" width=\"150\">\n");
      out.write("                                        ");
      out.write("\n");
      out.write("                                        <h4 class=\"mt-2\">");
      out.print(name);
      out.write("</h4>\n");
      out.write("                                        <p class=\"text-muted\"></p>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"card mt-3\">\n");
      out.write("                                <div class=\"card-body\">\n");
      out.write("                                    <h5>Contact Information</h5>\n");
      out.write("                                    <hr>\n");
      out.write("                                    <div class=\"form-group\">\n");
      out.write("                                        <label>Phone:</label>\n");
      out.write("                                        <p>");
      out.print(phone);
      out.write("</p>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"form-group\">\n");
      out.write("                                        <label>Email:</label>\n");
      out.write("                                        <p>");
      out.print(email);
      out.write("</p>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"form-group\">\n");
      out.write("                                        <label>Address:</label>\n");
      out.write("                                        <p>");
      out.print(address);
      out.write("</p>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"form-group\">\n");
      out.write("                                        <label>Date of Birth:</label>\n");
      out.write("                                        <p>");
      out.print(birthDay);
      out.write("</p>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-md-9\">\n");
      out.write("                            <div class=\"col\">\n");
      out.write("                                <div class=\"card\">\n");
      out.write("                                    <div class=\"card-body\">\n");
      out.write("                                        <h5>Work Information</h5>\n");
      out.write("                                        <hr>\n");
      out.write("                                        <div class=\"form-group\">\n");
      out.write("                                            <label>Project:</label>\n");
      out.write("                                            <p>");
      out.print(project);
      out.write("</p>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"form-group\">\n");
      out.write("                                            <label>Team:</label>\n");
      out.write("                                            <p>");
      out.print(team);
      out.write("</p>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"form-group\">\n");
      out.write("                                            <label>Role:</label>\n");
      out.write("                                            <p>");
      out.print(role);
      out.write("</p>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col\">\n");
      out.write("                                <div class=\"card form-edit\" >\n");
      out.write("                                    <form id=\"edit\">\n");
      out.write("                                        <div class=\"card-body\">\n");
      out.write("\n");
      out.write("                                            <h5>Edit profile</h5>\n");
      out.write("                                            <hr>\n");
      out.write("                                            <div class=\"form-group\">\n");
      out.write("                                                <label for=\"name\">Name:</label>\n");
      out.write("                                                <input type=\"text\" class=\"form-control\" id=\"editname\" name=\"name\">\n");
      out.write("                                            </div>\n");
      out.write("                                            <div class=\"form-group\">\n");
      out.write("                                                <label for=\"name\">Image:</label>\n");
      out.write("                                                <input type=\"file\" class=\"form-control\" id=\"editimage\" name=\"image\">\n");
      out.write("                                            </div>\n");
      out.write("                                            <div class=\"form-group\">\n");
      out.write("                                                <label for=\"phone\">Phone:</label>\n");
      out.write("                                                <input type=\"text\" class=\"form-control\" id=\"editphone\" name=\"phone\">\n");
      out.write("                                            </div>\n");
      out.write("                                            <div class=\"form-group\">\n");
      out.write("                                                <label for=\"email\">Email:</label>\n");
      out.write("                                                <input type=\"email\" class=\"form-control\" id=\"editemail\" name=\"email\">\n");
      out.write("                                            </div>\n");
      out.write("                                            <div class=\"form-group\">\n");
      out.write("                                                <label for=\"address\">Address:</label>\n");
      out.write("                                                <input type=\"text\" class=\"form-control\" id=\"editaddress\" name=\"address\">\n");
      out.write("                                            </div>\n");
      out.write("                                            <div class=\"form-group\">\n");
      out.write("                                                <label for=\"birthday\">Birthday:</label>\n");
      out.write("                                                <input type=\"date\" class=\"form-control\" id=\"editbirthday\" name=\"birthday\">\n");
      out.write("                                            </div>\n");
      out.write("                                            <div class=\"modal-footer\">\n");
      out.write("                                                <input type=\"submit\" value=\"Save\" class=\"btn btn-primary\" />\n");
      out.write("                                                <input type=\"reset\" value=\"Reset\" class=\"btn btn-danger\" />\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("                                    </form>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"edit-profile-wrapper\">\n");
      out.write("                    <input type=\"button\" class=\"edit-profile-btn\" value=\"Edit Profile\">\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <script src=\"assets/js/jquery-3.6.0.min.js\"></script>\n");
      out.write("        <script src=\"assets/js/popper.min.js\"></script>\n");
      out.write("        <script src=\"assets/js/bootstrap.min.js\"></script>\n");
      out.write("        <script src=\"assets/js/feather.min.js\"></script>\n");
      out.write("        <!--<script src=\"assets/plugins/slimscroll/jquery.slimscroll.min.js\"></script>-->\n");
      out.write("        <script src=\"assets/js/script.js\"></script>\n");
      out.write("        <script>\n");
      out.write("            $(document).ready(function () {\n");
      out.write("                $(\".edit-profile-btn\").click(function () {\n");
      out.write("                    $(\".form-edit\").show();\n");
      out.write("                    //hide button edit\n");
      out.write("                    $(\".edit-profile-btn\").hide();\n");
      out.write("                });\n");
      out.write("            });\n");
      out.write("            $(document).ready(function () {\n");
      out.write("                //get value from form\n");
      out.write("                $(\"#edit\").submit(function (e) {\n");
      out.write("                    e.preventDefault();\n");
      out.write("                    var formData = new FormData(this);\n");
      out.write("                    $.ajax({\n");
      out.write("                method: \"POST\",\n");
      out.write("                url: \"/HRManagement/EditProfileServlet\",\n");
      out.write("                data: new FormData(this),\n");
      out.write("                processData: false,\n");
      out.write("                contentType: false,\n");
      out.write("                success: function (res) {\n");
      out.write("                    console.log(res);\n");
      out.write("                    //remove \"\" from string\n");
      out.write("                    if (res === `\"Edit success\"`) {\n");
      out.write("                        console.log(res);\n");
      out.write("                        swal.fire({\n");
      out.write("                            title: \"Success!\",\n");
      out.write("                            text: \"Edit employee success!\",\n");
      out.write("                            icon: \"success\",\n");
      out.write("                            button: \"OK\"\n");
      out.write("                        }).then((value) => {\n");
      out.write("                            //click oke will hide modal and reload datatable\n");
      out.write("                            //reload page without reload page\n");
      out.write("                            location.reload();\n");
      out.write("                        });\n");
      out.write("                    } else {\n");
      out.write("                        console.log(res);\n");
      out.write("                        swal.fire({\n");
      out.write("                            title: \"Error!\",\n");
      out.write("                            //remove \"\" from string\n");
      out.write("                            text: res.replace(/\"/g, \"\"),\n");
      out.write("                            icon: \"error\",\n");
      out.write("                            button: \"OK!\"\n");
      out.write("                        });\n");
      out.write("                    }\n");
      out.write("                },\n");
      out.write("                error: function (error) {\n");
      out.write("                    console.log(error);\n");
      out.write("                    sweetAlert(\"Oops...\", \"Something went wrong!\", \"error\");\n");
      out.write("                }\n");
      out.write("            });\n");
      out.write("                });\n");
      out.write("            });\n");
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
