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
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import sample.dto.ProjectManageDTO;
import sample.dto.TaskDTO;
import sample.utils.DBUtils;

/**
 *
 * @author ADMIN
 */
public class TaskDAO {

    private List<TaskDTO> listTaskInSucc;
    private List<TaskDTO> listTaskInInPro;
    private List<TaskDTO> listTaskInFail;
    private List<TaskDTO> listTask;

    public List<TaskDTO> getListTaskInSucc() {
        return listTaskInSucc;
    }

    public List<TaskDTO> getListTaskInInPro() {
        return listTaskInInPro;
    }

    public List<TaskDTO> getListTaskInFail() {
        return listTaskInFail;
    }

    public List<TaskDTO> getListTask() {
        return listTask;
    }

    public void GetTask(int ProjectID) throws SQLException {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        TaskDTO dto = null;
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "select Task.Task_id, Task.Description, EndDate, Task.Status_id from Task "
                        + "where Task.Project_id = ?";
                pst = con.prepareStatement(sql);
                pst.setInt(1, ProjectID);
                rs = pst.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("Task_id");
                    String desc = rs.getString("Description");
                    Date endate = rs.getDate("EndDate");
                    int status = rs.getInt("Status_id");
                    dto = new TaskDTO(id, desc, endate, ProjectID, status);
                    if (this.listTask == null) {
                        listTask = new ArrayList<>();
                    }
                    this.listTask.add(dto);
                    if (status == 3) {
                        if (this.listTaskInSucc == null) {
                            listTaskInSucc = new ArrayList<>();
                        }
                        this.listTaskInSucc.add(dto);
                    }
                    if (status == 2) {
                        if (this.listTaskInInPro == null) {
                            listTaskInInPro = new ArrayList<>();
                        }
                        this.listTaskInInPro.add(dto);
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

    public boolean addTask(int ProjectID, String Desc) throws SQLException, Exception {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        boolean result = false;
        try {
            con = DBUtils.makeConnection();
            if (con != null) {

                String sql = "Insert into Task (Description, EndDate, Project_id, Status_id) "
                        + "values(?, ?, ?, 2)";
                pst = con.prepareStatement(sql);
                pst.setString(1, Desc);
                ProjectManageDAO dao = new ProjectManageDAO();
                ProjectManageDTO dto = dao.GetProjectByID(ProjectID);
                LocalDate startLocalDate = dto.getStartDate().toLocalDate();
                LocalDate endLocalDate = dto.getEndDate().toLocalDate();
                long daysBetween = ChronoUnit.DAYS.between(startLocalDate, endLocalDate);
                int daysBetweenInt = (int) daysBetween;
                int dateValid = (int) (daysBetweenInt * 0.8);
                LocalDate endDateForTask = startLocalDate.plusDays(dateValid);
                Date sqlEndDateForTask = java.sql.Date.valueOf(endDateForTask);
                pst.setDate(2, sqlEndDateForTask);
                pst.setInt(3, ProjectID);
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

    public int getTaskSize(List<TaskDTO> dto) {
        int size = 0;
        try {
            for (TaskDTO taskDTO : dto) {
                while (taskDTO != null) {
                    size++;
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return size;
    }

    public boolean deleteTask(int taskID) throws SQLException, Exception {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        boolean result = false;
        try {
            con = DBUtils.makeConnection();
            if (con != null) {

                String sql = "Delete from Task "
                        + "where Task_id= ?";
                pst = con.prepareStatement(sql);
                pst.setInt(1, taskID);
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

    public boolean updateTask(TaskDTO dto) throws SQLException, Exception {
        Connection con = null;
        PreparedStatement pst = null;
        boolean result = false;
        try {
            con = DBUtils.makeConnection();
            if (con != null) {

                String sql = "update Task "
                        + "set Description = ?, EndDate = ?, Status_id = ? "
                        + "where Task.Task_id = ?";
                pst = con.prepareStatement(sql);
                pst.setString(1, dto.getDesc());
                pst.setDate(2, dto.getEndDate());
                pst.setInt(3, dto.getStatus());
                pst.setInt(4, dto.getID());
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

    public boolean setFinshedTask(int projectID, TaskDTO dto) throws SQLException, Exception {
        Connection con = null;
        PreparedStatement pst = null;
        boolean result = false;
        try {
            con = DBUtils.makeConnection();
            if (con != null) {

                String sql = "update Task "
                        + "set  Status_id = ? "
                        + "where Task.Task_id = ?";
                pst = con.prepareStatement(sql);
                pst.setInt(1, dto.getStatus());
                pst.setInt(2, dto.getID());
                int effectRow = pst.executeUpdate();
                if (effectRow > 0) {
                    GetTask(projectID);
                    if(getListTaskInInPro().isEmpty()){
                        ProjectManageDAO dao = new ProjectManageDAO();
                        boolean setStatusProject = dao.setProjectInSucc(projectID);
                        if(setStatusProject){
                            result = true;
                        }
                    }
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
