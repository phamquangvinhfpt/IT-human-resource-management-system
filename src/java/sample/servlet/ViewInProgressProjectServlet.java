/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.servlet;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
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
import sample.dao.TeamDAO;
import sample.dto.ProjectManageDTO;
import sample.dto.TaskDTO;
import sample.dto.TeamDTO;

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
//        String url = "error.jsp";
        try (PrintWriter out = response.getWriter()) {
            int id = Integer.parseInt(request.getParameter("id"));
//            int id = 3;
            ProjectManageDAO ProjectDao = new ProjectManageDAO();
            ProjectManageDTO dto = ProjectDao.GetProjectByID(id);
            TeamDAO teamDao = new TeamDAO();
            TaskDAO taskDAO = new TaskDAO();
            taskDAO.GetTask(id);
            TeamDAO td = new TeamDAO();
            TeamDTO t = td.GetTeamByProjectID(id);
            List<TaskDTO> tasks = taskDAO.getListTask();
            List<TaskDTO> tasksInProgress = taskDAO.getListTaskInInPro();
            int progressSize = taskDAO.getTaskSize(tasksInProgress);
            List<TaskDTO> tasksInSucc = taskDAO.getListTaskInSucc();
            int succSize = taskDAO.getTaskSize(tasksInSucc);
            response.setStatus(200);
            JsonObject jsonObject = new JsonObject();
            Gson gson = new Gson();
            jsonObject.add("project", gson.toJsonTree(dto));
            jsonObject.add("team", gson.toJsonTree(t));
            jsonObject.addProperty("tasksInProgress", progressSize);
            jsonObject.addProperty("tasksInSucc", succSize);
            jsonObject.add("task", gson.toJsonTree(tasks));
            out.println(jsonObject.toString());

        } catch (SQLException ex) {
            Logger.getLogger(ViewInProgressProjectServlet.class.getName()).log(Level.SEVERE, null, ex);
        }//            RequestDispatcher rd = request.getRequestDispatcher(url);
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
