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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sample.dao.TeamDAO;
import sample.dto.Team;

/**
 *
 * @author MY MSI
 */
@WebServlet(name = "addTeam", urlPatterns = {"/addteam"})
public class addTeam extends HttpServlet {

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
      String pidString = request.getParameter("TeamID");
String pname = request.getParameter("TeamName");
String pdescription = request.getParameter("Description");

// Check if any of the parameters are null or empty
if (pidString == null || pidString.trim().isEmpty() ||
    pname == null || pname.trim().isEmpty() ||
    pdescription == null || pdescription.trim().isEmpty()) {

    // Set an error message
    String message = "Error: Please fill in all the fields.";
    request.setAttribute("errorMessage", message);

    // Forward the request to the previous page
    RequestDispatcher dispatcher = request.getRequestDispatcher("/teamcontroller");
    dispatcher.forward(request, response);

} else {
    // Convert the TeamID parameter to an integer
    int pid = Integer.parseInt(pidString);

    // Create a new Team object and set its properties
    TeamDAO team = new TeamDAO();
    Team teams = new Team();
    teams.setID_Team(pid);
    teams.setName_Team(pname);
    teams.setDecription(pdescription);

    // Add the Team to the database
    team.addTeam(teams);

    // Set a success message
    String message = "Team added successfully!";
    request.setAttribute("successMessage", message);

    // Redirect the user to the team controller servlet
    response.sendRedirect("teamcontroller");
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
            Logger.getLogger(addTeam.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(addTeam.class.getName()).log(Level.SEVERE, null, ex);
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
