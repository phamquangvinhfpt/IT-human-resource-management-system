/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
                String sql = "SELECT * from [dbo].[User] where [Username] = ? and [Password] = ?";
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
                String sql = "SELECT [UserID],[Name], [Image], [Phone], [Email], [Username], [Password], [Address], [BirthDay], [NameProject], [Team_Name], [Role] "
                        + "from [dbo].[User], [dbo].[Projects],[dbo].[Team] "
                        + "where [Username] = ? and [Password] = ? "
                        + "and [dbo].[User].[ProjectId]=[dbo].[Projects].[Id] "
                        + "and [dbo].[User].[Team_ID]=[dbo].[Team].[Team_ID]";
                pst = cn.prepareStatement(sql);
                pst.setString(1, username);
                pst.setString(2, password);
                rs = pst.executeQuery();
                if (rs.next()) {
                    user = new User(rs.getInt("UserID"), rs.getString("Name"), rs.getString("Image"), 
                    rs.getString("Phone"), rs.getString("Email"), rs.getString("Username"), 
                    rs.getString("Password"), rs.getString("Address"), rs.getDate("Birthday"), 
                    rs.getString("NameProject"), rs.getString("Team_Name"), rs.getString("Role"));
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

    public static List<User> getUserList() throws Exception {
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<User> list = new ArrayList<>();
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "SELECT [UserID],[Name], [Image], [Phone], [Email], [Username], [Password], [Address], [BirthDay], [NameProject], [Team_Name], [Role] "
                        + "from [dbo].[User], [dbo].[Projects],[dbo].[Team] "
                        + "WHERE [dbo].[User].[ProjectId]=[dbo].[Projects].[Id] "
                        + "and [dbo].[User].[Team_ID]=[dbo].[Team].[Team_ID]";
                pst = cn.prepareStatement(sql);
                rs = pst.executeQuery();
                while (rs.next()) {
                    list.add(new User(rs.getInt("UserID"), rs.getString("Name"), rs.getString("Image"), 
                    rs.getString("Phone"), rs.getString("Email"), rs.getString("Username"), 
                    rs.getString("Password"), rs.getString("Address"), rs.getDate("Birthday"), 
                    rs.getString("NameProject"), rs.getString("Team_Name"), rs.getString("Role")));
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
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                // Insert new user into User table
                String sql = "INSERT INTO [dbo].[User]([Name], [Image], [Phone], [Email], [Username], [Password], [Address], [BirthDay], [ProjectId], [Team_ID], [Role]) "
                        + "VALUES(?,?,?,?,?,?,?,?,?,?,?)";
                pst = cn.prepareStatement(sql);
                pst.setString(1, user.getName());
                pst.setString(2, user.getImage());
                pst.setString(3, user.getPhone());
                pst.setString(4, user.getEmail());
                pst.setString(5, user.getUsername());
                pst.setString(6, user.getPassword());
                pst.setString(7, user.getAddress());
                pst.setDate(8, user.getBirthday());
                pst.setInt(9, user.getProjectId());
                pst.setInt(10, user.getTeam_ID());
                pst.setString(11, user.getRole());
                pst.executeUpdate();
                return true;
            }
            // Insert new user into Role table

        } catch (Exception e) {
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
    
    public static List<String> getImageList() throws Exception {
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<String> list = new ArrayList<>();
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "SELECT [Image] from [dbo].[User]";
                pst = cn.prepareStatement(sql);
                rs = pst.executeQuery();
                while (rs.next()) {
                    list.add(rs.getString("Image"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (cn != null) {
                cn.close();
            }
        }
        return list;
    }

    public static boolean checkUsernameExist(String username) throws Exception {
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "SELECT [Username] from [dbo].[User] where [Username] = ?";
                pst = cn.prepareStatement(sql);
                pst.setString(1, username);
                rs = pst.executeQuery();
                if (rs.next()) {
                    return true;
                }
            }
        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (cn != null) {
                cn.close();
            }
        }
        return false;
    }

    public static boolean checkEmailExist(String email) throws Exception {
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "SELECT [Email] from [dbo].[User] where [Email] = ?";
                pst = cn.prepareStatement(sql);
                pst.setString(1, email);
                rs = pst.executeQuery();
                if (rs.next()) {
                    return true;
                }
            }
        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (cn != null) {
                cn.close();
            }
        }
        return false;
    }
}
