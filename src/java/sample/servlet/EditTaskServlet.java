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
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sample.dao.ProjectManageDAO;
import sample.dao.TaskDAO;
import sample.dto.ProjectManageDTO;
import sample.dto.TaskDTO;

/**
 *
 * @author ADMIN
 */
@MultipartConfig
@WebServlet(name = "EditTaskServlet", urlPatterns = {"/EditTaskServlet"})
public class EditTaskServlet extends HttpServlet {

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
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            Gson json = new Gson();
            String message = "";
            int id = Integer.parseInt(request.getParameter("id"));
            int projectId = Integer.parseInt(request.getParameter("ProjectId"));
            String decs = request.getParameter("TaskDesc");
            String EDate = request.getParameter("NewEndDate");
            Date endDate;
            if (!EDate.isEmpty()) {
                endDate = Date.valueOf(EDate);
                ProjectManageDAO dao = new ProjectManageDAO();
                ProjectManageDTO dto = dao.GetProjectByID(projectId);
                LocalDate startLocalDate = dto.getStartDate().toLocalDate();
                LocalDate endLocalDate = dto.getEndDate().toLocalDate();
                long daysBetween = ChronoUnit.DAYS.between(startLocalDate, endLocalDate);
                int daysBetweenInt = (int) daysBetween;
                int dateValid = (int) (daysBetweenInt * 0.8);
                LocalDate endDateForTask = startLocalDate.plusDays(dateValid);
                Date sqlEndDateForTask = java.sql.Date.valueOf(endDateForTask);
                if (endDate.before(sqlEndDateForTask)) {
                    TaskDAO taskDao = new TaskDAO();
                    TaskDTO task = new TaskDTO(id, decs, endDate, projectId, 2);
                    boolean update = taskDao.updateTask(task);
                    if (update) {
                        out.print("success");
                    } else {
                        out.print("Fail");
                    }
                } else {
                    message += "The endDate is not valid";
                    out.write(json.toJson(message));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(EditTaskServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(EditTaskServlet.class.getName()).log(Level.SEVERE, null, ex);
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
