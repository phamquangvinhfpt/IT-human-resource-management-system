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

    public List<TaskDTO> getListTaskInSucc() {
        return listTaskInSucc;
    }

    public List<TaskDTO> getListTaskInInPro() {
        return listTaskInInPro;
    }

    public List<TaskDTO> getListTaskInFail() {
        return listTaskInFail;
    }

    public void GetTask(int ProjectID) throws SQLException {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        TaskDTO dto = null;
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "select Task.Task_id, Task.Description, Task.Status_id from Task "
                        + "where Task.Project_id = ?";
                pst = con.prepareStatement(sql);
                pst.setInt(1, ProjectID);
                rs = pst.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("Task_id");
                    String desc = rs.getString("Description");
                    int status = rs.getInt("Status_id");
                    dto = new TaskDTO(id, desc, ProjectID, status);
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
                    if (status == 4) {
                        if (this.listTaskInFail == null) {
                            listTaskInFail = new ArrayList<>();
                        }
                        this.listTaskInFail.add(dto);
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

                String sql = "Insert into Task (Description, Project_id, Status_id) "
                        + "values(?, ?, 2)";
                pst = con.prepareStatement(sql);
                pst.setString(1, Desc);
                pst.setInt(2, ProjectID);
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
}
