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
import java.util.logging.Level;
import java.util.logging.Logger;
import sample.dto.ProjectManageDTO;
import sample.dto.TaskDTO;
import sample.dto.TeamDTO;
import sample.dto.successProject;
import sample.utils.DBUtils;

/**
 *
 * @author ADMIN
 */
public class ProjectManageDAO {

    private List<ProjectManageDTO> listProject;
    private List<successProject> listSuccessProject;

    public void GetFailProject() throws SQLException {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        ProjectManageDTO exp = null;
        TeamDTO team = null;
        successProject sp = null;
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "select Projects.Id, Projects.NameProject, Projects.StartDate, Projects.EndDate, Projects.TechStack, Projects.Description "
                        + "from Projects "
                        + "where Projects.Status_id = 4";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("Id");
                    String name = rs.getString("NameProject");
                    Date sd = rs.getDate("StartDate");
                    Date ed = rs.getDate("EndDate");
                    String techS = rs.getString("TechStack");
                    String decs = rs.getString("Description");
                    exp = new ProjectManageDTO(id, name, sd, ed, techS, decs, 4);
                    TeamDAO dao = new TeamDAO();
                    team = dao.GetTeamFailProject(id);
                    if (team != null) {
                        sp = new successProject(exp, team);
                        if (this.listSuccessProject == null) {
                            listSuccessProject = new ArrayList<>();
                        }
                        this.listSuccessProject.add(sp);
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

    public void GetSuccessProject() throws SQLException {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        ProjectManageDTO exp = null;
        TeamDTO team = null;
        successProject sp = null;
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "select Projects.Id, Projects.NameProject, Projects.StartDate, Projects.EndDate, Projects.TechStack, Projects.Description "
                        + "from Projects "
                        + "where Projects.Status_id = 3";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("Id");
                    String name = rs.getString("NameProject");
                    Date sd = rs.getDate("StartDate");
                    Date ed = rs.getDate("EndDate");
                    String techS = rs.getString("TechStack");
                    String decs = rs.getString("Description");
                    exp = new ProjectManageDTO(id, name, sd, ed, techS, decs, 3);
                    TeamDAO dao = new TeamDAO();
                    team = dao.GetTeamByID(id);
                    if (team != null) {
                        sp = new successProject(exp, team);
                        if (this.listSuccessProject == null) {
                            listSuccessProject = new ArrayList<>();
                        }
                        this.listSuccessProject.add(sp);
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

    public ProjectManageDTO GetProjectByID(int id) throws SQLException {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        ProjectManageDTO exp = null;
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "select Projects.NameProject, Projects.StartDate, Projects.EndDate, "
                        + "Projects.TechStack, Projects.Description, Projects.Status_id "
                        + "from Projects "
                        + "where Projects.Id = ?";
                pst = con.prepareStatement(sql);
                pst.setInt(1, id);
                rs = pst.executeQuery();
                while (rs.next()) {
                    String name = rs.getString("NameProject");
                    Date sd = rs.getDate("StartDate");
                    Date ed = rs.getDate("EndDate");
                    String techS = rs.getString("TechStack");
                    String decs = rs.getString("Description");
                    int status = rs.getInt("Status_id");
                    exp = new ProjectManageDTO(id, name, sd, ed, techS, decs, status);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(ProjectManageDAO.class.getName()).log(Level.SEVERE, null, ex);
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
        return exp;
    }

    /**
     * @return the listProject
     */
    public List<ProjectManageDTO> getListProject() {
        return listProject;
    }

    public boolean addProject(ProjectManageDTO project) throws SQLException, Exception {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        boolean result = false;
        try {
            con = DBUtils.makeConnection();
            if (con != null) {

                String sql = "Insert into [dbo].[Projects]("
                        + "[NameProject], [StartDate], [EndDate], [TechStack], [Description], [Status_id]"
                        + ") Values("
                        + "?, ?, ?, ?, ?, ?"
                        + ")";
                pst = con.prepareStatement(sql);
                pst.setString(1, project.getNameProject());
                pst.setDate(2, project.getStartDate());
                pst.setDate(3, project.getEndDate());
                pst.setString(4, project.getTechStack());
                pst.setString(5, project.getTechStack());
                pst.setInt(6, project.getStatus());
                int effectRow = pst.executeUpdate();
                if (effectRow > 0) {
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

    public void getInProgressProject() throws SQLException {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        ProjectManageDTO exp = null;
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "SELECT [dbo].[Projects].Id, [dbo].[Projects].NameProject, [dbo].[Projects].StartDate, "
                        + "[dbo].[Projects].EndDate, [dbo].[Projects].TechStack, [dbo].[Projects].Description, [dbo].[Projects].Status_id "
                        + "FROM [dbo].[Projects]";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("Id");
                    String name = rs.getString("NameProject");
                    Date sd = rs.getDate("StartDate");
                    Date ed = rs.getDate("EndDate");
                    String techS = rs.getString("TechStack");
                    String decs = rs.getString("Description");
                    int status = rs.getInt("Status_id");
                    if (this.listProject == null) {
                        listProject = new ArrayList<>();
                    }
                    if (status == 2) {
                        exp = new ProjectManageDTO(id, name, sd, ed, techS, decs, status);
                        this.listProject.add(exp);
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

    public void getNoStartProject() throws SQLException {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        ProjectManageDTO exp = null;
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "SELECT [dbo].[Projects].Id, [dbo].[Projects].NameProject, [dbo].[Projects].StartDate, "
                        + "[dbo].[Projects].EndDate, [dbo].[Projects].TechStack, [dbo].[Projects].Description, [dbo].[Projects].Status_id "
                        + "FROM [dbo].[Projects]";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("Id");
                    String name = rs.getString("NameProject");
                    Date sd = rs.getDate("StartDate");
                    Date ed = rs.getDate("EndDate");
                    String techS = rs.getString("TechStack");
                    String decs = rs.getString("Description");
                    int status = rs.getInt("Status_id");
                    if (this.listProject == null) {
                        listProject = new ArrayList<>();
                    }
                    if (status == 1) {
                        long millis = System.currentTimeMillis();
                        Date date = new Date(millis);
                        if (ed.after(date)) {
                            exp = new ProjectManageDTO(id, name, sd, ed, techS, decs, status);
                            this.listProject.add(exp);
                        }
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

    public boolean DeleteProject(int id) throws SQLException {
        Connection con = null;
        PreparedStatement pst = null;
        ProjectManageDTO exp = null;
        boolean result = false;
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "Delete from Projects "
                        + "Where Id = ?";
                pst = con.prepareStatement(sql);
                pst.setInt(1, id);
                int effect = pst.executeUpdate();
                if (effect > 0) {
                    sql = "UPDATE Team "
                            + "SET Project_id = 0 "
                            + "WHERE Project_id = ?";
                    pst = con.prepareStatement(sql);
                    pst.setInt(1, id);
                    effect = pst.executeUpdate();
                    if (effect > 0) {
                        result = true;
                    }
                }
            }
        } catch (Exception ex) {

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

    public boolean UpdateProject(ProjectManageDTO dto, int team_id) throws SQLException {
        Connection con = null;
        PreparedStatement pst = null;
        boolean result = false;
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
//                int row = 1;
                String headS = "UPDATE Projects ";
                String setBody = "SET NameProject = '" + dto.getNameProject() + "', ";
                String Edate = "EndDate = '" + dto.getEndDate() + "', ";
                String status = "Status_id = 2 ";
                String remain = "TechStack = '" + dto.getTechStack() + "', Description = '" + dto.getDecs() + "', ";
                String sql = headS + setBody;
                if (dto.getEndDate() != null) {
                    sql += Edate;
                }
                sql = sql + remain;
                if (team_id != 0) {
                    sql += status;
                }
                sql = sql + "WHERE Id = ?";
                pst = con.prepareStatement(sql);
                pst.setInt(1, dto.getProjectID());
                int effect = pst.executeUpdate();
                if (effect > 0) {
                    if (team_id != 0) {
                        sql = "UPDATE Team "
                                + "SET Project_id = ? "
                                + "WHERE Team_ID = ?";
                        pst = con.prepareStatement(sql);
                        pst.setInt(1, dto.getProjectID());
                        pst.setInt(2, team_id);
                        int e = pst.executeUpdate();
                        if (e > 0) {
                            result = true;
                        }
                    } else {
                        result = true;
                    }
                }
            }
        } catch (Exception ex) {

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

    /**
     * @return the listSuccessProject
     */
    public List<successProject> getListSuccessProject() {
        return listSuccessProject;
    }

    public boolean checkStatusProject(ProjectManageDTO dto) throws SQLException {
        Connection con = null;
        PreparedStatement pst = null;
        boolean result = false;
        try {
            String sql = "";
            con = DBUtils.makeConnection();
            long millis = System.currentTimeMillis();
            Date date = new Date(millis);
            if (dto.getEndDate().before(date) && dto.getStatus() == 1) {
                if (con != null) {
                    sql = "insert into ExperiencedProject(Project_ID, Project_Name, startDate, endDate, techStack, descript) "
                            + "values(?, ?, ?, ?, ?)";
                    pst = con.prepareStatement(sql);
                    pst.setInt(1, dto.getProjectID());
                    pst.setString(2, dto.getNameProject());
                    pst.setDate(3, dto.getStartDate());
                    pst.setDate(4, dto.getEndDate());
                    pst.setString(5, dto.getTechStack());
                    pst.setString(6, dto.getDecs());
                    int effect = pst.executeUpdate();
                    if (effect > 0) {
                        result = true;
                    }
                }
            }
            if (dto.getEndDate().before(date) && dto.getStatus() == 2) {
                TaskDAO dao = new TaskDAO();
                dao.GetTask(dto.getProjectID());
                List<TaskDTO> tasks = dao.getListTaskInInPro();
                TeamDAO teamDAO = new TeamDAO();
                TeamDTO teamDTO = teamDAO.GetTeamByID(dto.getProjectID());
                if (tasks.isEmpty()) {
                    sql = "insert into ExperiencedProject(Project_ID, Project_Name, startDate, endDate, techStack, descript, team_id, status_id) "
                            + "values(?, ?, ?, ?, ?, ?, ?, ?)";
                    pst = con.prepareStatement(sql);
                    pst.setInt(1, dto.getProjectID());
                    pst.setString(2, dto.getNameProject());
                    pst.setDate(3, dto.getStartDate());
                    pst.setDate(4, dto.getEndDate());
                    pst.setString(5, dto.getTechStack());
                    pst.setString(6, dto.getDecs());
                    pst.setInt(7, teamDTO.getTeam_Id());
                    pst.setInt(8, 3);
                    int effect = pst.executeUpdate();
                    if (effect > 0) {
                        boolean check = DeleteProject(dto.getProjectID());
                        if(check){
                            result = true;
                        }
                    }
                }else{
                    sql = "insert into ExperiencedProject(Project_ID, Project_Name, startDate, endDate, techStack, descript, team_id, status_id) "
                            + "values(?, ?, ?, ?, ?, ?, ?, ?)";
                    pst = con.prepareStatement(sql);
                    pst.setInt(1, dto.getProjectID());
                    pst.setString(2, dto.getNameProject());
                    pst.setDate(3, dto.getStartDate());
                    pst.setDate(4, dto.getEndDate());
                    pst.setString(5, dto.getTechStack());
                    pst.setString(6, dto.getDecs());
                    pst.setInt(7, teamDTO.getTeam_Id());
                    pst.setInt(8, 4);
                    int effect = pst.executeUpdate();
                    if (effect > 0) {
                        boolean check = DeleteProject(dto.getProjectID());
                        if(check){
                            result = true;
                        }
                    }
                }

            }
        } catch (Exception ex) {

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
