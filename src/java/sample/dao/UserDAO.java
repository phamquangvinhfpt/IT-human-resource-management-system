/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import sample.dto.User;
import sample.utils.DBUtils;

/**
 *
 * @author Admin
 */
public class UserDAO {

    //check login by username
    public static boolean checkLogin(String username, String password) throws Exception {
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        User user = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select * from [dbo].[User] where [Status] = 1 and [Username] = ? and [Password] = ?";
                pst = cn.prepareStatement(sql);
                pst.setString(1, username);
                pst.setString(2, password);
                rs = pst.executeQuery();
                if (rs.next()) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (cn != null) {
                cn.close();
            }
        }
        return false;
    }

    //GetUser by username
    public static User getUser(String username, String password) throws Exception {
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        User user = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "SELECT [dbo].[User].[UserID], [Name], [Image], [Phone], [Email], [Username], [Password], "
                        + "[Address], [Birthday], [ExperienceId], [Team_ID], [Status], [Role_id] "
                        + "FROM [dbo].[User]\n"
                        + "INNER JOIN [dbo].[Role] ON [dbo].[User].[UserID] = [dbo].[Role].[UserID]\n"
                        + "where [Status] = 1 and [Username] = ? and [Password] = ?";
                pst = cn.prepareStatement(sql);
                pst.setString(1, username);
                pst.setString(2, password);
                rs = pst.executeQuery();
                if (rs.next()) {
                    user = new User(rs.getInt("UserID"), rs.getString("Name"), rs.getString("Image"), rs.getString("Phone"), rs.getString("Email"),
                            rs.getString("Username"), rs.getString("Password"), rs.getString("Address"), rs.getDate("Birthday"), rs.getInt("ExperienceId"),
                            rs.getInt("Team_ID"), rs.getInt("Status"), rs.getInt("Role_id"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (cn != null) {
                cn.close();
            }
        }
        return user;
    }
<<<<<<< Updated upstream

    public static List<User> getUserList() throws Exception {
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<User> list = new ArrayList<>();
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "SELECT [dbo].[User].[UserID], [Name], [Image], [Phone], [Email], [Username], [Password], "
                        + "[Address], [Birthday], [ExperienceId], [Team_ID], [Status], [Role_id] "
                        + "FROM [dbo].[User]\n"
                        + "INNER JOIN [dbo].[Role] ON [dbo].[User].[UserID] = [dbo].[Role].[UserID]\n"
                        + "where [Status] = 1";
                pst = cn.prepareStatement(sql);
                rs = pst.executeQuery();
                while (rs.next()) {
                    list.add(new User(rs.getInt("UserID"), rs.getString("Name"), rs.getString("Image"), rs.getString("Phone"), rs.getString("Email"),
                            rs.getString("Username"), rs.getString("Password"), rs.getString("Address"), rs.getDate("Birthday"), rs.getInt("ExperienceId"),
                            rs.getInt("Team_ID"), rs.getInt("Status"), rs.getInt("Role_id")));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (cn != null) {
                cn.close();
            }
        }
        return list;
    }

    public static boolean createUser(User user) throws Exception {
        Connection cn = null;
        PreparedStatement pst1 = null;
        PreparedStatement pst2 = null;
        ResultSet rs = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                // Insert new user into User table
                String sql1 = "INSERT INTO [dbo].[User] ([UserID], [Name], [Image], [Phone], [Email], [Username], [Password], [Address], [Birthday], [ExperienceId], [Team_ID], [Status]) "
                        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                pst1 = cn.prepareStatement(sql1, PreparedStatement.RETURN_GENERATED_KEYS);
                pst1.setInt(1, user.getUserID());
                pst1.setString(2, user.getName());
                pst1.setString(3, user.getImage());
                pst1.setString(4, user.getPhone());
                pst1.setString(5, user.getEmail());
                pst1.setString(6, user.getUsername());
                pst1.setString(7, user.getPassword());
                pst1.setString(8, user.getAddress());
                pst1.setDate(9, new java.sql.Date(user.getBirthday().getTime()));
                pst1.setInt(10, user.getExperienceId());
                pst1.setInt(11, user.getTeam_ID());
                pst1.setInt(12, user.getStatus());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst1 != null) {
                pst1.close();
            }
            if (pst2 != null) {
                pst2.close();
            }
            if (cn != null) {
                cn.close();
            }
        }
        return false;
    }
=======
    
>>>>>>> Stashed changes
}
