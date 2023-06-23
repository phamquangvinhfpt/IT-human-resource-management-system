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

    public User getMemberById_User(int ID_User) throws SQLException {
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        User user = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "SELECT [UserID],[Name], [Image], [Phone], [Email], [Username], [Password], [Address], [BirthDay], [NameProject], [Team_Name], [Role]\n" +
"                        from [dbo].[User], [dbo].[Projects],[dbo].[Team] \n" +
"                        where [User].[Team_ID] = ?  and [dbo].[User].[ProjectId]=[dbo].[Projects].[Id] \n" +
"                        and [dbo].[User].[Team_ID]=[dbo].[Team].[Team_ID]";
                pst = cn.prepareStatement(sql);
                pst.setInt(1, ID_User);
                rs = pst.executeQuery();
                if (rs.next()) {
                    user = new User(rs.getInt("UserID"), rs.getString("Name"), rs.getString("Image"),
                            rs.getString("Phone"), rs.getString("Email"), rs.getString("Username"),
                            rs.getString("Password"), rs.getString("Address"), rs.getDate("Birthday"),
                            rs.getString("NameProject"), rs.getString("Team_Name"), rs.getString("Role"), rs.getInt("leaveBalances"));
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

    public static List<User> getMemberById_Team(int Team_ID) throws Exception {
        List<User> list = new ArrayList<>();
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        User user = null;
        String sql = "SELECT [UserID],[Name], [Image], [Phone], [Email], [Username], [Password], [Address], [BirthDay], [NameProject], [Team_Name], [Role]\n" +
"                        from [dbo].[User], [dbo].[Projects],[dbo].[Team] \n" +
"                        where [User].[Team_ID] = ?  and [dbo].[User].[ProjectId]=[dbo].[Projects].[Id] \n" +
"                        and [dbo].[User].[Team_ID]=[dbo].[Team].[Team_ID]";
        try {
            cn = DBUtils.makeConnection();
            pst = cn.prepareStatement(sql);
            pst.setInt(1, Team_ID);
            rs = pst.executeQuery();
            while (rs.next()) {
              list.add (new User(rs.getInt("UserID"), rs.getString("Name"), rs.getString("Phone"), rs.getString("Email"), rs.getString("Address"), rs.getDate("BirthDay"),  rs.getString("Team_Name"), rs.getInt(4), rs.getString("Role")));
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

    public void delete(int id) throws Exception {
        String sql = "update [User] set Team_ID = 0 where UserID = ?";
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
            PreparedStatement stmt = conn.prepareStatement("update [User] set Team_ID = ? where UserID = ?");
            stmt.setInt(1, member.getTeam_ID());
            stmt.setInt(2, member.getUserID());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

  
}
