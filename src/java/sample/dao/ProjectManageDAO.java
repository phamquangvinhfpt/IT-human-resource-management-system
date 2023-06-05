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
import sample.utils.DBUtils;

/**
 *
 * @author ADMIN
 */
public class ProjectManageDAO {
    private List<ProjectManageDTO> listProject;
    
    public void GetProject() throws SQLException{
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        ProjectManageDTO exp = null;
        try{
            con = DBUtils.makeConnection();
            if(con != null){
                String sql = "SELECT [dbo].[Projects].Id, [dbo].[Projects].NameProject, [dbo].[Projects].StartDate, "
                        + "[dbo].[Projects].EndDate, [dbo].[Projects].TechStack, [dbo].[Projects].Description, [dbo].[Projects].Status_id "
                        + "FROM [dbo].[Projects]";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                while(rs.next()){
                    int id = rs.getInt("Id");
                    String name = rs.getString("NameProject");
                    String sd = rs.getString("StartDate");
                    String ed = rs.getString("EndDate");
                    String techS = rs.getString("TechStack");
                    String decs = rs.getString("Description");
                    int status = rs.getInt("Status_id");
                    exp = new ProjectManageDTO(id, name, sd, ed, techS, decs, status);
                    if(this.listProject == null){
                        listProject = new ArrayList<>();
                    }
                    this.listProject.add(exp);
                }
            }
        }catch(Exception ex){
            
        }finally{
            if(rs!=null){
                rs.close();
            }
            if(pst!=null){
                pst.close();
            }
            if(con!=null){
                con.close();
            }
        }
    }

    /**
     * @return the listProject
     */
    public List<ProjectManageDTO> getListProject() {
        return listProject;
    }
    
    public boolean addProject(ProjectManageDTO project) throws SQLException, Exception{
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        boolean result = false;
        try{
            con = DBUtils.makeConnection();
            if(con != null){
//                int StatusID = 1;
//                String resultS = "Select Status_id from [Status] where Status = ?";
//                pst = con.prepareStatement(resultS);
//                pst.setString(1, project.getStatus());
//                rs = pst.executeQuery();
//                if(rs.next()){
//                    StatusID = rs.getInt("Status_id");
//                }
                String sql = "Insert into [dbo].[Projects]("
                        + "[NameProject], [StartDate], [EndDate], [TechStack], [Description], [Status_id]"
                        + ") Values("
                        + "?, ?, ?, ?, ?, ?"
                        + ")";
                pst = con.prepareStatement(sql);
                pst.setString(1, project.getNameProject());
                pst.setString(2, project.getStartDate());
                pst.setString(3, project.getEndDate());
                pst.setString(4, project.getTechStack());
                pst.setString(5, project.getTechStack());
                pst.setInt(6, project.getStatus());
                int effectRow = pst.executeUpdate();
                if(effectRow > 0 ){
                    result = true;
                }
            }
        }finally{
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
