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
 * @author MY MSI
 */
public class memberTeamDAO {

    public static List<User> getMemberById_Team(int ID_Team) throws Exception {
        List<User> list = new ArrayList<>();
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        User user = null;
        String sql = "select [Name] from User where Team_ID = ? ";
        try {
            cn = DBUtils.makeConnection();
            pst = cn.prepareStatement(sql);
            pst.setInt(1, ID_Team);
            rs = pst.executeQuery();
            while (rs.next()) {
                user = new User(rs.getInt("UserID"), rs.getString("Name"), rs.getString("Image"), rs.getString("Phone"), rs.getString("Email"),
                        rs.getString("Username"), rs.getString("Password"), rs.getString("Address"), rs.getDate("Birthday"), rs.getInt("ExperienceId"),
                        rs.getInt("Team_ID"), rs.getInt("Status"), rs.getInt("Role_id"));
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
        String sql = "update Team_ID = 0 FROM [User] where UserID = ?";
        PreparedStatement pst = null;
        try (Connection cn = DBUtils.makeConnection()) {
            pst = cn.prepareStatement(sql);
            pst.setInt(1, id);
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    public void addMemberTeam(User member) throws Exception{
          try (Connection conn = DBUtils.makeConnection()) {
            PreparedStatement stmt = conn.prepareStatement("update [User] (Team_ID) VALUES (?)");
            stmt.setInt(1, member.getTeam_ID());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }  
    
    

}
