
import java.sql.Connection;
import sample.utils.DBUtils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Admin
 */
public class TestConnect {

    public static void main(String[] args) {
        //test connection
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            if(cn!=null){
                System.out.println("Connect successfully");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
//        long millis = System.currentTimeMillis();
//
//        // creating a new object of the class Date  
//        java.sql.Date date = new java.sql.Date(millis);
//        System.out.println(date);
    }
}
