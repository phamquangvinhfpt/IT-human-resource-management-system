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

/**
 *
 * @author Admin
 */
@MultipartConfig
public class EditProfileServlet extends HttpServlet {

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
            String name = request.getParameter("name");
            String phone = request.getParameter("phone");
            String email = request.getParameter("email");
            String address = request.getParameter("address");
            String birthday = request.getParameter("birthday");
            Part filePart = request.getPart("image");
            String fileName = filePart.getSubmittedFileName();
            InputStream fileContent = filePart.getInputStream();
            //call session to get user
            User user = (User) request.getSession().getAttribute("user");
            int id = user.getUserID();
            String username = user.getUsername();
            String password = user.getPassword();
            String projectName = user.getNameProject();
            String teamName = user.getTeam_Name();
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
            Gson json = new Gson();
            String message = "";
            //check validation of each field
            if (name.isEmpty() || phone.isEmpty() || address.isEmpty() || birthday.isEmpty()) {
                message = "Please fill all the fields";
                // } else if (!email.matches("^[a-zA-Z0-9]+[a-zA-Z0-9]*@[a-zA-Z0-9]+(\\.[a-zA-Z0-9]+)+$")) {
                //     message = "Invalid email";
                // 
            } else if (!phone.matches("^[0-9]{10}$")) {
                message = "Invalid phone number";
            }//else if birthday is not valid
            else if (birthdayDate == null) {
                message = "Invalid birthday";
            } else {
                String filePath = getServletContext().getRealPath("") + "images\\" + fileName;
                //get role from session
                User userSession = (User) request.getSession().getAttribute("user");
                String role = userSession.getRole();
                user = new User(id, name, fileName, phone, email, username, password, address, birthdayDate, ProjectID, TeamID, role);
                UserDAO dao = new UserDAO();
                boolean checkresult = dao.updateUser(user);
                //get user
                user = dao.getUser(username, password);
                //response a session with projectName and teamName to update user
                request.getSession().setAttribute("user", user);
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
            Logger.getLogger(EditProfileServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(EditProfileServlet.class.getName()).log(Level.SEVERE, null, ex);
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
