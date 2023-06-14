/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.servlet;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sample.dao.LeaveDAO;

import sample.dto.LeaveRequest;
import sample.dto.LeaveTypes;
import sample.dto.User;

/**
 *
 * @author Admin
 */
@MultipartConfig
public class leaveServlet extends HttpServlet {

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
            String type = request.getParameter("leavetype");
            String start = request.getParameter("StartDate");
            String end = request.getParameter("EndDate");
            String reason = request.getParameter("reason");
            java.sql.Date StartDate = java.sql.Date.valueOf(start);
            java.sql.Date EndDate = java.sql.Date.valueOf(end);
            reason = new String(reason.getBytes("iso-8859-1"), "UTF-8");
            //Get date and time when leave request is sent
            java.util.Date date = new java.util.Date();
            java.sql.Timestamp sqlDate = new java.sql.Timestamp(date.getTime());
            //format date and time
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            String date1 = sdf.format(sqlDate);
            //get leave type id
            int leaveTypeId = LeaveDAO.getLeaveTypeId(type);
            //call user session to get user
            User user = (User) request.getSession().getAttribute("user");
            int userId = user.getUserID();
            LeaveRequest req = new LeaveRequest(userId, leaveTypeId, StartDate, EndDate, reason, "In process", date1);
            boolean isRequest = LeaveDAO.addLeaveRequest(req);
            Gson json = new Gson();
            String message = "";
            if (isRequest) {
                message += "success";
                out.write(json.toJson(message));
            } else {
                message += "fail";
                out.write(json.toJson(message));
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
            Logger.getLogger(leaveServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(leaveServlet.class.getName()).log(Level.SEVERE, null, ex);
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
