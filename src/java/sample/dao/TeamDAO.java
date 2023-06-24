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
import sample.dto.Team;
import sample.dto.TeamDTO;
import sample.utils.DBUtils;

/**
 *
 * @author Admin
 */
public class TeamDAO {
    private List<TeamDTO> listTeam;

    public TeamDTO GetTeamByID(int projectID) throws SQLException {
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
