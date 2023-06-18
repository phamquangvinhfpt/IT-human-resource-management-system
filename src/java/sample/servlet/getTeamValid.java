/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.servlet;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sample.dao.TeamDAO;
import sample.dto.TeamDTO;

/**
 *
 * @author ADMIN
 */
@MultipartConfig
@WebServlet(name = "getTeamValid", urlPatterns = {"/getTeamValid"})
public class getTeamValid extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String sDate = request.getParameter("startDate");
            String eDate = request.getParameter("endDate");
//            Date startDate = Date.valueOf(sDate);
//            Date endDate = Date.valueOf(eDate);
            SimpleDateFormat outputFormat = new SimpleDateFormat("MMM d, yyyy");
            String start = outputFormat.format(sDate);
            String end = outputFormat.format(eDate);
            java.sql.Date start_Date = java.sql.Date.valueOf(start);
            java.sql.Date end_Date = java.sql.Date.valueOf(end);
            Map<Integer, String> options = new LinkedHashMap<>();
            TeamDAO dao = new TeamDAO();
            dao.getTeamValid();
            List<TeamDTO> list = dao.getListTeam();
//            dao.getDateValid(startDate, endDate);
            List<TeamDTO> list2 = dao.getListTeam();
            for (TeamDTO teamDTO : list) {
                options.put(teamDTO.getTeam_Id(), teamDTO.getTeam_name());
            }
            for (TeamDTO teamDTO : list2) {
                options.put(teamDTO.getTeam_Id(), teamDTO.getTeam_name());
            }
            String json = new Gson().toJson(options);
            response.setContentType("application/json");
            response.setStatus(200);
            response.getWriter().write(json);
        } catch (SQLException ex) {
            Logger.getLogger(getTeamValid.class.getName()).log(Level.SEVERE, null, ex);
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
        processRequest(request, response);
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
        processRequest(request, response);
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
