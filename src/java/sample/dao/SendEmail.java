/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import sample.dto.Change;
import sample.dto.Reset;
import sample.dto.User;
import sample.utils.DBUtils;

/**
 *
 * @author Administrator
 */
public class SendEmail {

    public String getRandom() {
        Random rnd = new Random();
        int number = rnd.nextInt(999999);
        return String.format("%06d", number);

    }

    public boolean sendEmail(Change change) {

        String fromEmail = "tuantest123abcd@gmail.com";
        String password = "zfyrgwkbpmlqwcxq";

        // properties khai báo các thuộc tính
        Properties props = new Properties();
        props.setProperty("mail.smtp.auth", "true");
        props.setProperty("mail.smtp.starttls.enable", "true");
        props.setProperty("mail.smtp.host", "smtp.gmail.com"); // Thay thế bằng thông tin SMTP của bạn
        props.setProperty("mail.smtp.port", "465"); // Thay thế bằng thông tin cổng SMTP của bạn
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
// create athentiator
        Authenticator auth = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }

        };
        // phiên làm việc
        Session session = Session.getInstance(props, auth);
        // gửi email
        
        // gửi tin nhắn
        MimeMessage msg = new MimeMessage(session);
        try{
            // kiểu nội dung
            msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
            // người gửi
            msg.setFrom(fromEmail);
            // người nhận
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(change.getEmail(), false));
            //tiêu đề email
            msg.setSubject("Mã Token của bạn là :");
            // quy định ngày gửi
            msg.setSentDate(new Date());
            // quy định email gửi phản hồi 
            msg.setReplyTo(InternetAddress.parse(fromEmail, false));
            // quy định nội dung 
            msg.setText("Đây là verify code của bạn: " + change.getCode(), "text/html; charset=utf-8" );
            // gửi email
            Transport.send(msg);
            return true;
        }catch(Exception e) {
            e.printStackTrace();
        }
        return false;
    }

// public void SendEmail(String toEmail) throws Exception {
//        Connection cn = null;
//        PreparedStatement pst = null;
//        ResultSet rs = null;
//        User user = null;
//        try {
//            cn = DBUtils.makeConnection();
//            if (cn != null) {
//                String sql = "select email from [dbo].[User] where [Email]=?";
//                pst = cn.prepareStatement(sql);
//                pst.setString(1, toEmail);
//              
//                rs = pst.executeQuery();
//                if (rs.next()) {
//                    
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            if (rs != null) {
//                rs.close();
//            }
//            if (pst != null) {
//                pst.close();
//            }
//            if (cn != null) {
//                cn.close();
//            }
//        }
//   
//    }
}
