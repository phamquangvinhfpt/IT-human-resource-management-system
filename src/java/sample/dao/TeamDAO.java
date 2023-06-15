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
import sample.dto.ProjectManageDTO;
import sample.dto.TeamDTO;
import sample.utils.DBUtils;

/**
 *
 * @author ADMIN
 */
public class TeamDAO {

    private List<TeamDTO> listTeam;

    public TeamDTO GetTeamSuccessProject(int projectID) throws SQLException {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        TeamDTO team = null;
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "select Team.Team_ID, Team.Team_Name, Team.Description "
                        + "from Team "
                        + "where Team.Project_id = ?";
                pst = con.prepareStatement(sql);
                pst.setInt(1, projectID);
                rs = pst.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("Team_ID");
                    String name = rs.getString("Team_Name");
                    String decs = rs.getString("Description");
                    team = new TeamDTO(id, name, projectID, decs);
                    if (this.listTeam == null) {
                        listTeam = new ArrayList<>();
                    }
                    this.listTeam.add(team);
                }
            }
        } catch (Exception ex) {

        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return team;
    }

    public List<TeamDTO> getListTeam() {
        return listTeam;
    }
    
    
}
