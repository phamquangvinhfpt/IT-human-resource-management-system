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
@WebServlet(name = "AddProjectServlet", urlPatterns = {"/AddProjectServlet"})
public class AddProjectServlet extends HttpServlet {

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
//        String Result = "error.jsp";
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String name = request.getParameter("ProjectName");
            String decs = request.getParameter("Description");
            String SDate = request.getParameter("SDate");
            Date startDate = Date.valueOf(SDate);
            String EDate = request.getParameter("EDate");
            Date endDate = Date.valueOf(EDate);
            String TechS = request.getParameter("TechS");
            ProjectManageDAO dao = new ProjectManageDAO();
            int status = 1;
            Gson json = new Gson();
            String message = "";
            long millis = System.currentTimeMillis();
            Date date = new Date(millis);
            if (name.isEmpty() || decs.isEmpty() || SDate.isEmpty() || EDate.isEmpty() || endDate.before(date) || endDate.before(startDate) || TechS.isEmpty()) {
                if (name.isEmpty()) {
                    message += "Name is empty";
                }
                if (decs.isEmpty()) {
                    message += "Description is empty";
                }
                if (SDate.isEmpty()) {
                    message += "Start date is empty";
                }
                if (EDate.isEmpty()) {
                    message += "End date is empty";
                }
                if (endDate.before(date)) {
                    message += "end date is not valid";
                }
                if (endDate.before(startDate)) {
                    message += "end date is not valid";
                }
                if (TechS.isEmpty()) {
                    message += "Tech Stack is empty";
                }
                //response to ajax using Gson
                out.write(json.toJson(message));
            } else {
                ProjectManageDTO project = new ProjectManageDTO(0, name, startDate, endDate, TechS, decs, status);
                boolean result = dao.addProject(project);
                if (result) {
                    message += "success";
                    out.write(json.toJson(message));
                } else {
                    message += "fail";
                    out.write(json.toJson(message));
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(AddProjectServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
//            if(result){
//                Result = "ProjectManage.jsp";
//            }
//        }finally{
//            RequestDispatcher rd = request.getRequestDispatcher(Result);
//            rd.forward(request, response);
//        }
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
