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
import sample.dto.Team;
import sample.utils.DBUtils;

/**
 *
 * @author Admin
 */
public class TeamDAO {
    public static List<Team> getAll() throws Exception {
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<Team> list = new ArrayList<>();
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "SELECT * from [dbo].[Team]";
                pst = cn.prepareStatement(sql);
                rs = pst.executeQuery();
                while (rs.next()) {
                    Team team = new Team();
                    team.setTeam_ID(rs.getInt("Team_ID"));
                    team.setTeam_Name(rs.getString("Team_Name"));
                    team.setProject_id(rs.getInt("Project_id"));
                    team.setDescription(rs.getString("Description"));
                    list.add(team);
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

    public static int getTeamID(String teamName) throws Exception {
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        int teamID = 0;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "SELECT Team_ID from [dbo].[Team] where [Team_Name] = ?";
                pst = cn.prepareStatement(sql);
                pst.setString(1, teamName);
                rs = pst.executeQuery();
                if (rs.next()) {
                    teamID = rs.getInt("Team_ID");
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
        return teamID;
    }
}
