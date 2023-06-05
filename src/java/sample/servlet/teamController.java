/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "teamController", urlPatterns = {"/teamcontroller"})
public class teamController extends HttpServlet {

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
        /* TODO output your page here. You may use following sample code. */
        String action = request.getParameter("action");

        if (action == null) {
            try {
                TeamDAO team = new TeamDAO();
                List<Team> list = team.getTeam();
                request.setAttribute("list", list);
                request.getRequestDispatcher("team.jsp").forward(request, response);
            } catch (Exception ex) {

            }
        }  else if (action.equals("edit")) {
            int id = Integer.parseInt(request.getParameter("teamId"));
            TeamDAO team = new TeamDAO();      
            Team listTeam = team.getTeamById(id);         
            request.setAttribute("team", listTeam);
            request.getRequestDispatcher("Edit.jsp").forward(request, response);
        } else if (action.equals("delete")) {
            try {
                int id = Integer.parseInt(request.getParameter("teamId"));
                TeamDAO team = new TeamDAO();
                team.deleteTeam(id);
                String url = "teamcontroller";
                response.sendRedirect(url);
            } catch (Exception ex) {
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
            Logger.getLogger(teamController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(teamController.class.getName()).log(Level.SEVERE, null, ex);
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
