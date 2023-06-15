/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sample.dao.UserDAO;
import sample.dto.User;
import sample.utils.Encrypt;

/**
 *
 * @author Admin
 */
@WebServlet(name = "loginServlet", urlPatterns = {"/loginServlet"})
public class loginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String save = request.getParameter("remember-me");
            password = Encrypt.toSHA1(password);
            User user = null;
            boolean validLogin = UserDAO.checkLogin(username, password);
            if (validLogin) {
                // Login is valid, create a session
                user = UserDAO.getUser(username, password);
                HttpSession session = request.getSession(true);
                session.setAttribute("user", user);
//                response.sendRedirect("login.jsp");
                if (save != null && save.equals("on")) {
                    // Set cookie to remember user
                    Cookie cookie = new Cookie("user", user.getRole());
                    cookie.setMaxAge(30 * 24 * 60 * 60); // Cookie lasts for 30 days
                    response.addCookie(cookie);
                }

                // Check if user is admin
                String role = UserDAO.getUser(username, password).getRole();

                if (role.equals("admin")) {
                    // User is authorized to access adminresources, show the admin page
//                    RequestDispatcher dispatcher = request.getRequestDispatcher("admin.jsp");
//                    dispatcher.forward(request, response);
                    response.getWriter().write("{\"success\": true, \"role\": \"admin\"}");
                } else if (role.equals("user")) {
                    // User is not authorized, show an error message or redirect to a different page
//                    RequestDispatcher dispatcher = request.getRequestDispatcher("datatable.jsp");
//                    dispatcher.forward(request, response);
                    response.getWriter().write("{\"success\": true, \"role\": \"normal\"}");
                }
            } else {
                // Invalid login, show an error message in login page
                request.setAttribute("error", "Invalid username or password");
                //sent request to login.jsp
//                RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
//                dispatcher.forward(request, response);
                response.getWriter().write("{\"success\": false}");
            }
        }
    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(loginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(loginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
