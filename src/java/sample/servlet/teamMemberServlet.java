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
import sample.dao.memberTeamDAO;
import sample.dto.User;

/**
 *
 * @author MY MSI
 */
@WebServlet(name = "teamMemberServlet", urlPatterns = {"/memberservlet"})
public class teamMemberServlet extends HttpServlet {

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
        String action = request.getParameter("action");

        if (action == null) {

            memberTeamDAO member = new memberTeamDAO();
            int id = Integer.parseInt(request.getParameter("teamId"));
            List<User> list = member.getMemberById_Team(id);
            request.setAttribute("list", list);
            request.getRequestDispatcher("member.jsp").forward(request, response);

        } else if (action.equals("delete")) {
            try {
                int id = Integer.parseInt(request.getParameter("userid"));
                memberTeamDAO team = new memberTeamDAO();
                team.delete(id);
                String url = "memberservlet";
                response.sendRedirect(url);
            } catch (Exception ex) {
            }
        } else if (action.equals("add")) {
                        try {

            int id = Integer.parseInt(request.getParameter("teamId"));
            memberTeamDAO team = new memberTeamDAO();
            User member = new User();
            member.setUserID(1);
            member.setTeam_ID(id);
            team.addMemberTeam(member);
            response.sendRedirect("memberservlet");
                        }catch(Exception e){
                            
                        }

        } else if (action.equals("profile")) {
            try {
                int ID_User = Integer.parseInt(request.getParameter("userid"));
                memberTeamDAO team = new memberTeamDAO();
                User user = team.getMemberById_User(ID_User);
                String url = "memberservlet";
                request.setAttribute("user", user);
                request.getRequestDispatcher("member.jsp").forward(request, response);
            } catch (Exception e) {

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
            Logger.getLogger(teamMemberServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(teamMemberServlet.class.getName()).log(Level.SEVERE, null, ex);
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
