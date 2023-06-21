/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import sample.dto.User;
import sample.utils.DBUtils;

/**
 *
 * @author MY MSI
 */
public class memberTeamDAO {

    public static List<User> getMemberById_Team(int ID_Team) throws Exception {
        List<User> list = new ArrayList<>();
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        User user = null;
        String sql = "select * from [User] where Team_ID = ?" ;
        try {
            cn = DBUtils.makeConnection();
            pst = cn.prepareStatement(sql);
            pst.setInt(1, ID_Team);
            rs = pst.executeQuery();
           while (rs.next()) {
                    int UserID = rs.getInt("UserID");
                    String Name = rs.getString("Name");
                    String Image = rs.getString("Image");
                    String Phone = rs.getString("Phone");
                    String Email = rs.getString("Email");
                    String Username = rs.getString("Username");
                    String Password = rs.getString("Password");
                    String Address = rs.getString("Address");
                    Date BirthDay = rs.getDate("BirthDay");
                    int ProjectId = rs.getInt("ProjectId");
                    int Team_ID = rs.getInt("Team_ID");
                    String Role = rs.getString("Role");
                    list.add(new User(UserID, Name, Image, Phone, Email, Username, Password, Address, BirthDay, ProjectId, Team_ID, Role));
                }
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
        return list;
    }

    public void delete(int id) throws Exception {
        String sql = "update  [User] set  Team_ID = 0 where UserID = ?";
        PreparedStatement pst = null;
        try (Connection cn = DBUtils.makeConnection()) {
            pst = cn.prepareStatement(sql);
            pst.setInt(1, id);
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void addMemberTeam(User member) throws Exception {
        try (Connection conn = DBUtils.makeConnection()) {
            PreparedStatement stmt = conn.prepareStatement("UPDATE  [User] set [Team_ID] = ? where UserID = ?");
            stmt.setInt(1, member.getTeam_ID());
            stmt.setInt(2, member.getUserID());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    public  User getMemberbyid(int id ) throws Exception{
       try (Connection conn = DBUtils.makeConnection()) {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM [User] WHERE [UserID] = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            User member = new User();
            if (rs.next()) {
                return member = new User();
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            return null;

        }
        return null;  
    }
    public List<User> getListMemberNoTeam() throws SQLException{
         List<User> list = new ArrayList<>();
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        User user = null;
        String sql = "select * from [User] where Team_ID = 0 " ;
        try {
            cn = DBUtils.makeConnection();
            pst = cn.prepareStatement(sql);
            rs = pst.executeQuery();
           while (rs.next()) {
                    int UserID = rs.getInt("UserID");
                    String Name = rs.getString("Name");
                    String Image = rs.getString("Image");
                    String Phone = rs.getString("Phone");
                    String Email = rs.getString("Email");
                    String Username = rs.getString("Username");
                    String Password = rs.getString("Password");
                    String Address = rs.getString("Address");
                    Date BirthDay = rs.getDate("BirthDay");
                    int ProjectId = rs.getInt("ProjectId");
                    int Team_ID = rs.getInt("Team_ID");
                    String Role = rs.getString("Role");
                    list.add(new User(UserID, Name, Image, Phone, Email, Username, Password, Address, BirthDay, ProjectId, Team_ID, Role));
                }
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
        return list;
    }
   }
