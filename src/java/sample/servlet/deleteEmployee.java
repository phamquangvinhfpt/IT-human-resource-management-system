/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.servlet;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import sample.dao.ProjectDAO;
import sample.dao.TeamDAO;
import sample.dao.UserDAO;
import sample.dto.User;

/**
 *
 * @author Admin
 */
@MultipartConfig

public class deleteEmployee extends HttpServlet {

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
            //get data from form delete
            int id = Integer.parseInt(request.getParameter("id"));
            //delete employee
            UserDAO dao = new UserDAO();
            boolean result = dao.deleteUser(id);
            if (result) {
                out.print("success");
            } else {
                out.print("fail");
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
            Logger.getLogger(deleteEmployee.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(deleteEmployee.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            //get json data from request selectedId array
            BufferedReader reader = request.getReader();
            Gson gson = new Gson();
            JsonParser parser = new JsonParser();
            JsonArray array = parser.parse(reader).getAsJsonArray();
            int[] selectedId = gson.fromJson(array, int[].class);
            //print selectedId array to console for testing
//            out.print(Arrays.toString(selectedId));
            // System.out.println(Arrays.toString(selectedId));//console browser
            //delete selectedId array
            UserDAO dao = new UserDAO();
            boolean result = false;
            for (int i = 0; i < selectedId.length; i++) {
                result = dao.deleteUser(selectedId[i]);
            }
            if (result) {
                // out.write(gson.toJson("Delete successfully"));
                //response to client
                JsonObject json = new JsonObject();
                json.addProperty("message", "Delete successfully");
                out.print(json.toString());
            } else {
                // out.write(gson.toJson("Delete failed"));
                //response to client
                JsonObject json = new JsonObject();
                json.addProperty("message", "Delete failed");
                out.print(json.toString());
            }
            // //response to client
            // JsonObject json = new JsonObject();
            // json.addProperty("message", "Delete successfully");
            // out.print(json.toString());
        } catch (Exception ex) {
            Logger.getLogger(deleteEmployee.class.getName()).log(Level.SEVERE, null, ex);
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
