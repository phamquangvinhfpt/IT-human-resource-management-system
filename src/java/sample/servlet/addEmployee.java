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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sample.dao.UserDAO;
import sample.dto.User;

/**
 *
 * @author Admin
 */
public class addEmployee extends HttpServlet {

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
            // Get form data from request parameters
            String userID = request.getParameter("userID");
            String name = request.getParameter("name");
            String phone = request.getParameter("phone");
            String email = request.getParameter("email");
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String address = request.getParameter("address");
            String birthday = request.getParameter("birthday");
            String experienceId = request.getParameter("experienceId");
            String teamID = request.getParameter("teamID");
            // Parse integer values
            int userIDInt = 0;
            int experienceIdInt = 0;
            int teamIDInt = 0;
            try {
                userIDInt = Integer.parseInt(userID);
                experienceIdInt = Integer.parseInt(experienceId);
                teamIDInt = Integer.parseInt(teamID);
            } catch (NumberFormatException e) {
                // Redirect to error page with error message
                response.sendRedirect("error.jsp?message=Invalid input parameters");
                return;
            }
            //parse to date
            java.sql.Date birthdayDate = java.sql.Date.valueOf(birthday);
            // Create a new User object
            User user = new User(userIDInt, name, "test",phone, email, username, password, address, birthdayDate, experienceIdInt, 1, teamIDInt, 1);
            // Call DAO to insert new user
            UserDAO dao = new UserDAO();
            boolean checkresult = dao.createUser(user);
            if (checkresult) {
                out.println("Insert success");
                //redirect to view
                response.sendRedirect("employee");
            } else {
                out.println("Insert failed");
                //redirect to view
                response.sendRedirect("employee");
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
            Logger.getLogger(addEmployee.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(addEmployee.class.getName()).log(Level.SEVERE, null, ex);
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
