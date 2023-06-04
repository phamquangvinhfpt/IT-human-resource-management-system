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
import sample.dto.Project;
import sample.utils.DBUtils;

/**
 *
 * @author Admin
 */
public class ProjectDAO {
    //GetAllProject
    public static List<Project> getAll() throws Exception {
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<Project> list = new ArrayList<>();
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "SELECT * from [dbo].[Projects]";
                pst = cn.prepareStatement(sql);
                rs = pst.executeQuery();
                while (rs.next()) {
                    Project project = new Project();
                    project.setId(rs.getInt("Id"));
                    project.setNameProject(rs.getString("NameProject"));
                    project.setStartDate(rs.getDate("StartDate"));
                    project.setEndDate(rs.getDate("EndDate"));
                    project.setTechStack(rs.getString("TechStack"));
                    project.setDescription(rs.getString("Description"));
                    project.setStatus_id(rs.getInt("Status_id"));
                    list.add(project);
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

    public static int getProjectID(String projectName) throws Exception {
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        int id = 0;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "SELECT Id from [dbo].[Projects] where [NameProject] = ?";
                pst = cn.prepareStatement(sql);
                pst.setString(1, projectName);
                rs = pst.executeQuery();
                if (rs.next()) {
                    id = rs.getInt("Id");
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
        return id;
    }
}
