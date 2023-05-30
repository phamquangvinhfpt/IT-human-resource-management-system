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
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import sample.dto.ExperienceDTO;
import sample.utils.DBUtils;

/**
 *
 * @author ADMIN
 */
public class ExperienceDAO {
    private List<ExperienceDTO> listProject;
    
    public void GetProject() throws SQLException{
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        ExperienceDTO exp = null;
        try{
            con = DBUtils.makeConnection();
            if(con != null){
                String sql = "select [Id], [NameProject], [StartDate], [EndDate], [TechStack]"
                        + "from [dbo].[Experience]";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                if(rs.next()){
                    int id = rs.getInt("Id");
                    String name = rs.getString("NameProject");
                    Date sd = rs.getDate("StartDate");
                    Date ed = rs.getDate("EndDate");
                    String techS = rs.getString("TechStack");
                    exp = new ExperienceDTO(id, name, sd, ed, techS);
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
    public List<ExperienceDTO> getListProject() {
        return listProject;
    }
}
