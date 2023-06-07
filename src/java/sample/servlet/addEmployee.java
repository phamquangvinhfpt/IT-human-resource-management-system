/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Iterator;
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
            Part filePart = request.getPart("image");
            String fileName = filePart.getSubmittedFileName();
            InputStream fileContent = filePart.getInputStream();
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
            fileName = username + fileName.substring(fileName.lastIndexOf("."));
            //create user
            //validation value of form
            if (name.isEmpty() || phone.isEmpty() || email.isEmpty() || username.isEmpty() || password.isEmpty() || address.isEmpty() || birthday.isEmpty() || projectName.isEmpty() || teamName.isEmpty()) {
                out.println("Please fill all the form");
                return;
            }
            if (filePart.getSize() > 1024 * 1024 * 2) {
                out.println("File size exceed 2MB");
                return;
            }
            if (!filePart.getContentType().equals("image/jpeg") && !filePart.getContentType().equals("image/png")) {
                out.println("File type must be jpeg or png");
                return;
            }
            //check username exist
            UserDAO userDAO = new UserDAO();
            if (userDAO.checkUsernameExist(username)) {
                out.println("Username already exist");
                return;
            }
            //check email exist
            if (userDAO.checkEmailExist(email)) {
                out.println("Email already exist");
                return;
            }
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
            out.println(fileName);
            String filePath = "E:/SWP/HRManagement/web/images/" + fileName;
            out.print("File uploaded" + filePath);
//              User user = new User(name, fileName, phone, email, username, password, address, birthdayDate, ProjectID, TeamID,"user");
//              // Call DAO to insert new user
//              UserDAO dao = new UserDAO();
//              boolean checkresult = dao.createUser(user);
//              if (checkresult) {
//                  out.println("Insert success");
//                  FileOutputStream outputStream = new FileOutputStream(filePath);
//              byte[] buffer = new byte[4096];
//              int bytesRead = -1;
//              while ((bytesRead = fileContent.read(buffer)) != -1) {
//                  outputStream.write(buffer, 0, bytesRead);
//              }
//              fileContent.close();
//              outputStream.close();
//              } else {
//                  out.println("Insert failed");
//              }
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
