/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.servlet;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.omg.CORBA.Context;

import sample.dao.ProjectDAO;
import sample.dao.TeamDAO;
import sample.dao.UserDAO;
import sample.dto.Project;
import sample.dto.Team;
import sample.dto.User;
import sample.utils.Encrypt;

/**
 *
 * @author Admin
 */
@MultipartConfig
public class addEmployee extends HttpServlet {

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
            // Get form data from request parameters
            String name = request.getParameter("name");
            String phone = request.getParameter("phone");
            String email = request.getParameter("email");
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String address = request.getParameter("address");
            String birthday = request.getParameter("birthday");
            String projectName = request.getParameter("projectName");
            String teamName = request.getParameter("teamName");
            //Encrypt password
            password = Encrypt.toSHA1(password);
            //get projectID
            ProjectDAO projectDAO = new ProjectDAO();
            int ProjectID = projectDAO.getProjectID(projectName);
            //get teamID
            TeamDAO teamDAO = new TeamDAO();
            int TeamID = teamDAO.getTeamID(teamName);
            //Get utf-8 string for vietnamese name and address
            name = new String(name.getBytes("iso-8859-1"), "UTF-8");
            address = new String(address.getBytes("iso-8859-1"), "UTF-8");
            //parse to date
            java.sql.Date birthdayDate = java.sql.Date.valueOf(birthday);
//            //get image
//            Part filePart = request.getPart("image");
//            String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
//            InputStream fileContent = filePart.getInputStream();
//            //save image to server
//            String path = request.getServletContext().getRealPath("");
//            path = path.substring(0, path.indexOf("build"));
//            path = path + "web\\images\\" + fileName;
//            File file = new File(path);
//            Files.copy(fileContent, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
            //save image path to database
//            String imagePath = "images/" + fileName;
            //create user
            out.println(name);
            out.println(phone);
            out.println(email);
            out.println(username);
            out.println(password);
            out.println(address);
            out.println(birthday);
            out.println(ProjectID);
            out.println(TeamID);
            out.println(projectName);
            out.println(teamName);
            

            // User user = new User(name, "test", phone, email, username, password, address, birthdayDate, ProjectID, TeamID,"user");
            // // Call DAO to insert new user
            // UserDAO dao = new UserDAO();
            // boolean checkresult = dao.createUser(user);
            // if (checkresult) {
            //     out.println("Insert success");
            // } else {
            //     out.println("Insert failed");
            // }
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
            Logger.getLogger(addEmployee.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(addEmployee.class.getName()).log(Level.SEVERE, null, ex);
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
