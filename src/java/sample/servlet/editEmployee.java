/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.servlet;

import com.google.gson.Gson;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
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
import sample.utils.Encrypt;

/**
 *
 * @author Admin
 */
@MultipartConfig
public class editEmployee extends HttpServlet {

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
            int userID = Integer.parseInt(request.getParameter("id"));
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
            UserDAO userDAO = new UserDAO();
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
            // fileName = username + fileName.substring(fileName.lastIndexOf(".")); 
            //create user
            Gson json = new Gson();
            String message = "";
            if (filePart.getSize() > 1024 * 1024 * 2) {
                message += "File size must be less than 2MB";
                out.write(json.toJson(message));
            }//check must input date
            else if (birthdayDate == null) {
                message += "Please input birthday";
                out.write(json.toJson(message));
            } else {
                //if user not change avatar then keep old avatar
                if (fileName.equals("")) {
                    User userOld = userDAO.getUserByID(userID);
                    fileName = userOld.getImage();
                } else {
                    fileName = username + fileName.substring(fileName.lastIndexOf("."));
                }
                String filePath = getServletContext().getRealPath("") + "images\\" + fileName;
                User user = new User(userID, name, fileName, phone, email, username, password, address, birthdayDate, ProjectID, TeamID, "user");
                // Call DAO to insert new user
                UserDAO dao = new UserDAO();
                boolean checkresult = dao.updateUser(user);
                if (checkresult) {
                    message += "Edit success";
                    out.write(json.toJson(message));
                    FileOutputStream outputStream = new FileOutputStream(filePath);
                    byte[] buffer = new byte[4096];
                    int bytesRead = -1;
                    while ((bytesRead = fileContent.read(buffer)) != -1) {
                        outputStream.write(buffer, 0, bytesRead);
                    }
                    fileContent.close();
                    outputStream.close();
                } else {
                    message += "Edit fail";
                    out.write(json.toJson(message));
                }
            }
//             out.println(userID);
//             out.println(name);
//             out.println(phone);
//             out.println(email);
//             out.println(username);
//             out.println(password);
//             out.println(address);
//             out.println(birthday);
//             out.println(ProjectID);
//             out.println(TeamID);
//             out.println(projectName);
//             out.println(teamName);
//             out.println(fileName);
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
            Logger.getLogger(editEmployee.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(editEmployee.class.getName()).log(Level.SEVERE, null, ex);
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
