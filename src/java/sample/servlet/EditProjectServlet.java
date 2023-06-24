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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sample.dao.ProjectManageDAO;
import sample.dto.ProjectManageDTO;

/**
 *
 * @author ADMIN
 */
@MultipartConfig
@WebServlet(name = "EditProjectServlet", urlPatterns = {"/EditProjectServlet"})
public class EditProjectServlet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            Gson json = new Gson();
            String message = "";
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("ProjectName");
            String decs = request.getParameter("Description");
            int team_id = Integer.parseInt(request.getParameter("team_id"));
            String EDate = request.getParameter("EDate");
            Date endDate;
            String TechS = request.getParameter("TechS");
            ProjectManageDTO dto = new ProjectManageDTO(id, name, null, null, TechS, decs, 0);
            if (!EDate.isEmpty()) {
                endDate = Date.valueOf(EDate);
                long millis = System.currentTimeMillis();
                Date date = new Date(millis);
                if (endDate.after(date)) {
                    dto.setEndDate(endDate);
                    ProjectManageDAO dao = new ProjectManageDAO();
                    boolean result = dao.UpdateProject(dto, team_id);
                    if (result) {
                        out.print("success");
                    } else {
                        out.print("Fail");
                    }
                } else {
                    message += "The endDate is not valid";
                    out.write(json.toJson(message));
                }
            } else {
                if (team_id == 0) {
                    message += "No input here!!!";
                    out.write(json.toJson(message));
                } else {
                    ProjectManageDAO dao = new ProjectManageDAO();
                    boolean result = dao.UpdateProject(dto, team_id);
                    if (result) {
                        out.print("success");
                    } else {
                        out.print("Fail");
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(EditProjectServlet.class.getName()).log(Level.SEVERE, null, ex);
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
