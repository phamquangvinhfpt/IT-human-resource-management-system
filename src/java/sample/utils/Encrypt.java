/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.utils;

import java.util.Base64;

/**
 *
 * @author Admin
 */
public class Encrypt {
    public static String toSHA1(String password) throws Exception {
        String salt = "hjajsfdklkjagsdhfgcxvbjkxljgafghchhvkljssv";
        String result = null;
        password = password + salt;
        try {
            byte[] bytesOfMessage = password.getBytes("UTF-8");
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("SHA-1");
            result = Base64.getEncoder().encodeToString(md.digest(bytesOfMessage));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    public static void main(String[] args) throws Exception {
        System.out.println(toSHA1("admin"));
    }
}
