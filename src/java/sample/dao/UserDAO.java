/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import sample.dto.User;
import sample.utils.DBUtils;

/**
 *
 * @author Admin
 */
public class UserDAO {
    //check login by username
    public boolean checkLogin(String username, String password) throws Exception{
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        User user = null;
        try {
            cn = DBUtils.makeConnection();
            if(cn!=null){
                String sql = "select [UserID], [Name], [Image], [Phone], [Email], [Username], [Password], [Address], [Birthday], [ExperienceId], [Status] "
                        + "from [dbo].[User]"
                        + " where [Username] = ? and [Password] = ?";
                pst = cn.prepareStatement(sql);
                pst.setString(1, username);
                pst.setString(2, password);
                rs = pst.executeQuery();
                if(rs.next()){
                    user = new User(rs.getInt("UserID"), rs.getString("Name"), rs.getString("Image"), rs.getString("Phone"), rs.getString("Email"), rs.getString("Username"), rs.getString("Password"), rs.getString("Address"), rs.getDate("Birthday"), rs.getInt("ExperienceId"), rs.getBoolean("Status"));
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            if(rs!=null){
                rs.close();
            }
            if(pst!=null){
                pst.close();
            }
            if(cn!=null){
                cn.close();
            }
        }
        return false;
    }
}
