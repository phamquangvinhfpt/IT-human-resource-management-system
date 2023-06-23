/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.dto;

/**
 *
 * @author Administrator
 */
public class Reset {
    private int UserID;
    private String email;
    private String RequestTime;
    private String VerificationCode;
    private String IsVerified;

    public Reset() {
    }

    public Reset(int UserID, String email, String RequestTime, String VerificationCode, String IsVerified) {
        this.UserID = UserID;
        this.email = email;
        this.RequestTime = RequestTime;
        this.VerificationCode = VerificationCode;
        this.IsVerified = IsVerified;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRequestTime() {
        return RequestTime;
    }

    public void setRequestTime(String RequestTime) {
        this.RequestTime = RequestTime;
    }

    public String getVerificationCode() {
        return VerificationCode;
    }

    public void setVerificationCode(String VerificationCode) {
        this.VerificationCode = VerificationCode;
    }

    public String getIsVerified() {
        return IsVerified;
    }

    public void setIsVerified(String IsVerified) {
        this.IsVerified = IsVerified;
    }

}
    

    