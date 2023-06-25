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
import sample.dto.TeamDTO;
import sample.utils.DBUtils;

/**
 *
 * @author ADMIN
 */
public class TeamDAO {

    private List<TeamDTO> listTeam;
    
    public TeamDTO GetTeamByProjectID(int projectID) throws SQLException {
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
    
    public TeamDTO GetTeamByID(int TeamID) throws SQLException {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        TeamDTO team = null;
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "select Team.Team_ID, Team.Team_Name, Project_id, Team.Description "
                        + "from Team "
                        + "where Team.Team_ID = ?";
                pst = con.prepareStatement(sql);
                pst.setInt(1, TeamID);
                rs = pst.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("Team_ID");
                    String name = rs.getString("Team_Name");
                    int project_id = rs.getInt("Project_id");
                    String decs = rs.getString("Description");
                    team = new TeamDTO(id, name, project_id, decs);
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

    public void getTeamValid() throws SQLException {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        TeamDTO team = null;
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "select Team_ID, Team_Name, Project_id from Team";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("Team_ID");
                    String name = rs.getString("Team_Name");
                    int project_id = rs.getInt("Project_id");

                    if (this.listTeam == null) {
                        listTeam = new ArrayList<>();
                    }
                    if (project_id == 0) {
                        team = new TeamDTO(id, name, 0, null);
                        this.listTeam.add(team);
                    }
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
    }

    public void getDateValid(Date StartDate, Date EndDate) throws SQLException {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        TeamDTO team = null;
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "select Team_ID, Team.Team_Name, Projects.StartDate, Projects.EndDate from Team, Projects "
                        + "where Team.Project_id = Projects.Id ";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("Team_ID");
                    String name = rs.getString("Team_Name");
                    Date SDate = rs.getDate("StartDate");
                    Date EDate = rs.getDate("EndDate");
                    boolean dateValid = (StartDate.before(EDate) && EndDate.after(EDate));
                    if (this.listTeam == null) {
                        listTeam = new ArrayList<>();
                    }
                    if (StartDate.after(EDate) || dateValid) {
                        team = new TeamDTO(id, name, 0, null);
                        this.listTeam.add(team);
                    }
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
    }

    public TeamDTO GetTeamFailProject(int projectID) throws SQLException {
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

    public boolean DeleteProjectOfTeam(int ProjectID) throws SQLException, Exception {
        Connection con = null;
        PreparedStatement pst = null;
        boolean result = false;
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "UPDATE Team "
                        + "SET Project_id = 0 "
                        + "WHERE Project_id = ?";
                pst = con.prepareStatement(sql);
                pst.setInt(1, ProjectID);
                int effect = pst.executeUpdate();
                if (effect > 0) {
                    result = true;
                }
            }
        } finally {
            if (pst != null) {
                pst.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return result;
    }
}
