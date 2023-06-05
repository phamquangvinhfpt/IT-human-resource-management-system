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
import sample.dto.Team;
import sample.servlet.teamController;
import sample.utils.DBUtils;

/**
 *
 * @author MY MSI
 */
public class TeamDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<Team> getTeam() throws Exception {
        List<Team> list = new ArrayList<>();
        String sql = "select * from Team";
        try {
            conn = new DBUtils().makeConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Team(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4)));
            }
        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }

    public void deleteTeam(int id) throws Exception {
        String sql = "DELETE FROM Team WHERE Team_ID = ?";
        try {
            conn = DBUtils.makeConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void addTeam(Team team) throws Exception {
        try (Connection conn = DBUtils.makeConnection()) {
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO Team (Team_ID,Team_Name,ID_Experience,Decription) values (?, ?, ?, ?)");
            stmt.setInt(1, team.getID_Team());
            stmt.setString(2, team.getName_Team());
            stmt.setInt(3, team.getID_Experience());
            stmt.setString(4, team.getDecription());

            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public Team getTeamById(int id) throws Exception {
        try (Connection conn = DBUtils.makeConnection()) {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Team WHERE Team_ID= ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            Team team = new Team();
            if (rs.next()) {
                return team = new Team(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            return null;

        }
        return null;
    }

    public void updateTeam(Team team) throws Exception {
        List<Team> list = new ArrayList<>();
        String query = "update Team set Team_ID = ?, Team_Name =?, ID_Experience = ?,  [Decription] =? where Team_ID = ?";
        try (Connection conn = DBUtils.makeConnection()) {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(4, team.getDecription());
            stmt.setString(2, team.getName_Team());
            stmt.setInt(1, team.getID_Team());
            stmt.setInt(3, team.getID_Experience());
           stmt.setInt(5, team.getID_Team());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
