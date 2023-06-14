/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sample.dao.ProjectManageDAO;
import sample.dto.ProjectManageDTO;
import sample.dto.inProgress;

/**
 *
 * @author ADMIN
 */
@MultipartConfig
@WebServlet(name = "ViewInProgressProjectServlet", urlPatterns = {"/ViewInProgressProjectServlet"})
public class ViewInProgressProjectServlet extends HttpServlet {

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
        String url = "error.jsp";
        try {
            /* TODO output your page here. You may use following sample code. */
            int id = Integer.parseInt(request.getParameter("ProjectId"));
            String name = request.getParameter("ProjectName");
            String SDate = request.getParameter("SDate");
            Date Sdate = Date.valueOf(SDate);
            String Edate = request.getParameter("EDate");
            Date edate = Date.valueOf(Edate);
            String Tech = request.getParameter("TStack");
            String Desc = request.getParameter("PDesc");
            ProjectManageDTO dto = new ProjectManageDTO(id, name, Sdate, edate, Tech, Desc, id, null);
            ProjectManageDAO dao = new ProjectManageDAO();
            List<inProgress> ip = dao.getProcessLine(dto);
            if (ip != null) {
                dto.setProgress(ip);
                request.setAttribute("DTOProgress", dto);
                url = "ProgressPage.jsp";
            }

        } catch (SQLException ex) {
            Logger.getLogger(ViewInProgressProjectServlet.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
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
